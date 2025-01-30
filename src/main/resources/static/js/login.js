document.getElementById("loginButton").addEventListener("click", async (event) => {
    event.preventDefault(); // Evita que el formulario recargue la página

    let username = document.getElementById("usernameField").value.trim();
    let email = document.getElementById("emailField").value.trim();
    let password = document.getElementById("passwordField").value.trim();

    if (!username || !email || !password) {
        alert("⚠️ Todos los campos son obligatorios.");
        return;
    }

    let body = JSON.stringify({ username, email, password });

    try {
        let response = await fetch("http://localhost:8080/buscahipotecas/v1/auth/login", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: body
        });

        if (!response.ok) {
            let errorData = await response.json();
            alert("⚠️ Error: " + (errorData.message || "Credenciales incorrectas"));
            return;
        }

        let data = await response.json();
        localStorage.setItem("token", data.token || ""); // Guarda el token JWT
        window.location.href = "/comparador"; // Redirige al Comparador
    } catch (error) {
        alert("❌ Error en la conexión: " + error.message);
    }
});
