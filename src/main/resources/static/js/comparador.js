document.addEventListener("DOMContentLoaded", async () => {
    let token = localStorage.getItem("token");
    if (!token) {
        alert("⚠️ Debes iniciar sesión para acceder al comparador.");
        window.location.href = "/login";
        return;
    }

    await cargarBancos(); // Cargar bancos antes de las hipotecas

    document.getElementById("compararButton").addEventListener("click", () => fetchHipotecas(false));
    document.getElementById("verTodasButton").addEventListener("click", () => fetchHipotecas(true));
    document.getElementById("verHipotecasGuardadas").addEventListener("click", () => {
        window.location.href = "/hipotecas-guardadas";
    });
});

// Diccionario para almacenar los bancos { nombre_banco: nombre_banco }
let listaBancos = [];

async function cargarBancos() {
    try {
        let response = await fetch("http://localhost:8080/buscahipotecas/v1/banco/all", {
            method: "GET",
            headers: { "Authorization": "Bearer " + localStorage.getItem("token") }
        });

        if (!response.ok) {
            console.error("⚠️ Error al cargar bancos.");
            return;
        }

        let bancos = await response.json();
        console.log("📌 Bancos obtenidos:", bancos); // 🟢 DEBUG

        let bancoSelect = document.getElementById("banco");

        bancos.forEach(banco => {
            listaBancos.push(banco.nombre_banco); // Guardamos solo los nombres

            // Agregar bancos al filtro de selección en el HTML
            let option = document.createElement("option");
            option.value = banco.nombre_banco; // Guardar el nombre del banco
            option.textContent = banco.nombre_banco;
            bancoSelect.appendChild(option);
        });

    } catch (error) {
        console.error("❌ Error en la conexión al obtener bancos: ", error);
    }
}

async function fetchHipotecas(mostrarTodas) {
    let token = localStorage.getItem("token");
    let url = "http://localhost:8080/buscahipotecas/v1/hipoteca/all";

    let bancoSeleccionado = document.getElementById("banco").value.trim();

    if (!mostrarTodas) {
        let importeInicial = document.getElementById("importeInicial").value.trim();
        let tipoHipoteca = document.getElementById("tipoHipoteca").value.trim();
        let finalidad = document.getElementById("finalidad").value.trim();

        let queryParams = [];

        if (importeInicial && !isNaN(importeInicial)) queryParams.push(`importeInicial=${importeInicial}`);
        if (tipoHipoteca) queryParams.push(`tipoHipoteca=${tipoHipoteca}`);
        if (finalidad) queryParams.push(`finalidad=${finalidad}`);
        if (bancoSeleccionado) queryParams.push(`banco=${encodeURIComponent(bancoSeleccionado)}`);

        if (queryParams.length) {
            url += "?" + queryParams.join("&");
        }
    }

    try {
        let response = await fetch(url, {
            method: "GET",
            headers: {
                "Authorization": "Bearer " + token,
                "Content-Type": "application/json"
            }
        });

        if (!response.ok) {
            alert("⚠️ Error al obtener las hipotecas.");
            return;
        }

        let hipotecas = await response.json();
        console.log("📌 Hipotecas obtenidas:", hipotecas); // 🟢 DEBUG

        // Aplicamos filtro en frontend si la API no lo está haciendo bien
        if (!mostrarTodas && bancoSeleccionado) {
            hipotecas = hipotecas.filter(hipoteca => extraerBancoDesdeNombre(hipoteca) === bancoSeleccionado);
            console.log("📌 Hipotecas filtradas por banco:", hipotecas);
        }

        mostrarResultados(hipotecas);
    } catch (error) {
        alert("❌ Error en la conexión: " + error.message);
    }
}

function extraerBancoDesdeNombre(hipoteca) {
    let nombreBancoEncontrado = "No especificado";

    // Buscar si algún banco conocido está en el nombre de la hipoteca
    listaBancos.forEach(banco => {
        if (hipoteca.nombre_hipoteca.toLowerCase().includes(banco.toLowerCase())) {
            nombreBancoEncontrado = banco;
        }
    });

    return nombreBancoEncontrado;
}

function mostrarResultados(hipotecas) {
    let resultados = document.getElementById("resultados");
    resultados.innerHTML = "";

    if (hipotecas.length === 0) {
        resultados.innerHTML = "<p>No se encontraron hipotecas con esos filtros.</p>";
        return;
    }

    hipotecas.forEach(hipoteca => {
        console.log("📌 Procesando hipoteca:", hipoteca); // 🟢 DEBUG

        let nombreBanco = extraerBancoDesdeNombre(hipoteca);

        console.log(`📌 Hipoteca: ${hipoteca.nombre_hipoteca}, Banco Detectado: ${nombreBanco}`); // 🟢 DEBUG

        let card = document.createElement("div");
        card.classList.add("col-md-4");
        card.innerHTML = `
            <div class="hipoteca-card p-3">
                <h5 class="fw-bold">${hipoteca.nombre_hipoteca}</h5>
                <p class="fs-3"><strong>€${hipoteca.mensualidad}</strong> / mes</p>
                <p><strong>Importe Inicial:</strong> €${hipoteca.importe_inicial}</p>
                <p><strong>Tipo:</strong> ${hipoteca.tipo_hipoteca}</p>
                <p><strong>Finalidad:</strong> ${hipoteca.finalidad}</p>
                <p><strong>Banco:</strong> ${nombreBanco}</p>
                <button class="btn btn-primary w-100 seleccionar-btn" data-id="${hipoteca.id_hipoteca}">
                    Seleccionar
                </button>
                <button class="btn btn-outline-success w-100 mt-2 guardar-btn" data-id="${hipoteca.id_hipoteca}">
                    Guardar
                </button>
            </div>
        `;
        resultados.appendChild(card);
    });

    document.querySelectorAll(".guardar-btn").forEach(button => {
        button.addEventListener("click", (event) => {
            let hipotecaId = event.target.dataset.id;
            alert(`✅ Hipoteca ID ${hipotecaId} guardada (simulación).`);
        });
    });
}
