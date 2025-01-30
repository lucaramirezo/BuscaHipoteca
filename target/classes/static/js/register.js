document.getElementById("registerButton").addEventListener("click", async (event) => {
    event.preventDefault(); // Evita que la página se recargue

    let email = document.getElementById("emailField").value.trim();
    let password = document.getElementById("passwordField").value.trim();

    if (!email || !password) {
        alert("⚠️ Todos los campos son obligatorios.");
        return;
    }

    let body = JSON.stringify({ email, password });

    try {
        let response = await fetch("http://localhost:8080/buscahipotecas/v1/auth/register", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: body
        });

        if (!response.ok) {
            let errorData = await response.json();
            alert("⚠️ Error: " + (errorData.message || "No se pudo registrar."));
            return;
        }

        alert("✅ Registro exitoso. Ahora puedes iniciar sesión.");
        window.location.href = "/login";
    } catch (error) {
        alert("❌ Error en la conexión: " + error.message);
    }
});
