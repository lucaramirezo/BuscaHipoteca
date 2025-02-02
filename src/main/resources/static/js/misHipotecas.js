document.addEventListener("DOMContentLoaded", async () => {
    let token = localStorage.getItem("token");
    if (!token) {
        alert("⚠️ Debes iniciar sesión para ver tus hipotecas guardadas.");
        window.location.href = "/login";
        return;
    }

    try {
        let response = await fetch("http://localhost:8080/buscahipotecas/v1/hipotecas/saved", {
            method: "GET",
            headers: { "Authorization": "Bearer " + token }
        });

        let hipotecas = await response.json();
        mostrarHipotecasGuardadas(hipotecas);
    } catch (error) {
        alert("❌ Error en la conexión: " + error.message);
    }
});

function mostrarHipotecasGuardadas(hipotecas) {
    let contenedor = document.getElementById("hipotecasGuardadas");
    contenedor.innerHTML = "";

    if (hipotecas.length === 0) {
        contenedor.innerHTML = "<p>No tienes hipotecas guardadas.</p>";
        return;
    }

    hipotecas.forEach(hipoteca => {
        let card = document.createElement("div");
        card.classList.add("col-md-4");
        card.innerHTML = `
            <div class="hipoteca-card p-3">
                <h5 class="fw-bold">${hipoteca.nombre_hipoteca}</h5>
                <p class="fs-3"><strong>€${hipoteca.mensualidad}</strong> / mes</p>
                <p><strong>Importe Inicial:</strong> €${hipoteca.importe_inicial}</p>
                <p><strong>Tipo:</strong> ${hipoteca.tipo_hipoteca}</p>
                <p><strong>Finalidad:</strong> ${hipoteca.finalidad}</p>
                <button class="btn btn-danger w-100 eliminar-btn" data-id="${hipoteca.id_hipoteca}">
                    Eliminar
                </button>
            </div>
        `;
        contenedor.appendChild(card);
    });
}
