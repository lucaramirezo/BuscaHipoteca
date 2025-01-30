document.addEventListener("DOMContentLoaded", async () => {
    let token = localStorage.getItem("token");
    if (!token) {
        alert("⚠️ Debes iniciar sesión para acceder al comparador.");
        window.location.href = "/login";
        return;
    }

    document.getElementById("compararButton").addEventListener("click", () => fetchHipotecas(false));
    document.getElementById("verTodasButton").addEventListener("click", () => fetchHipotecas(true));
});

async function fetchHipotecas(mostrarTodas) {
    let token = localStorage.getItem("token");
    let url = "http://localhost:8081/buscahipotecas/v1/hipotecas";

    if (!mostrarTodas) {
        let importeInicial = document.getElementById("importeInicial").value;
        let tipoHipoteca = document.getElementById("tipoHipoteca").value;
        let finalidad = document.getElementById("finalidad").value;

        let queryParams = [];
        if (importeInicial) queryParams.push(`importeInicial=${importeInicial}`);
        if (tipoHipoteca) queryParams.push(`tipoHipoteca=${tipoHipoteca}`);
        if (finalidad) queryParams.push(`finalidad=${finalidad}`);

        if (queryParams.length) url += "?" + queryParams.join("&");
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
        mostrarResultados(hipotecas);
    } catch (error) {
        alert("❌ Error en la conexión: " + error.message);
    }
}

function mostrarResultados(hipotecas) {
    let resultados = document.getElementById("resultados");
    resultados.innerHTML = "";

    if (hipotecas.length === 0) {
        resultados.innerHTML = "<p>No se encontraron hipotecas.</p>";
        return;
    }

    hipotecas.forEach(hipoteca => {
        let card = document.createElement("div");
        card.classList.add("hipoteca-card");
        card.innerHTML = `
            <h3>${hipoteca.banco}</h3>
            <p><strong>Interés:</strong> ${hipoteca.interes}%</p>
            <p><strong>Plazo:</strong> ${hipoteca.plazo} años</p>
            <p><strong>Cuota Mensual:</strong> ${hipoteca.cuotaMensual} €</p>
            <button class="seleccionar-btn" data-id="${hipoteca.id}">Seleccionar</button>
        `;
        resultados.appendChild(card);
    });

    document.querySelectorAll(".seleccionar-btn").forEach(button => {
        button.addEventListener("click", () => {
            alert(`Has seleccionado la hipoteca ID: ${button.dataset.id}`);
        });
    });
}
