
function deleteOdontologist(id) {
    const settings = {
        method: "DELETE"
    };

    fetch(`http://localhost:8080/odontologos/${id}`, settings)
    .then(()=> Swal.fire(
        'Odontologo eliminado!',
        'Correctamente',
        'success'
      ))
    .finally(()=>location.reload());
}