// SPINNER
function mostrarCarga() {
    document.getElementById("loading-overlay").classList.add("active");
}

function ocultarCarga() {
    document.getElementById("loading-overlay").classList.remove("active");
}

// SWEET ALERT
function alertaExito(msg) {
    Swal.fire("Éxito", msg, "success");
}

function alertaError(msg) {
    Swal.fire("Error", msg, "error");
}

// CONFIRMAR ELIMINAR
function confirmarEliminacion(event, url) {
    event.preventDefault();

    Swal.fire({
        title: "¿Eliminar?",
        text: "No se puede revertir",
        icon: "warning",
        showCancelButton: true
    }).then((result) => {
        if (result.isConfirmed) {
            mostrarCarga();
            window.location.href = url;
        }
    });
}

// VALIDAR FORM
function validarYEnviar(form) {
    let valido = true;

    form.querySelectorAll("input, select").forEach(input => {
        if (!input.value) {
            input.style.border = "2px solid red";
            valido = false;
        }
    });

    if (!valido) {
        alertaError("Completa todos los campos");
        return false;
    }

    mostrarCarga();
    return true;
}