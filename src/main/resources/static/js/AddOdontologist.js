window.onload = () => {
  const formulario = document.getElementById("nuevoOdontologo");


   formulario.addEventListener("submit", event => {
   event.preventDefault();
           agregarOdontologo();
       });
       }

function agregarOdontologo() {
     const nombre= document.getElementById("nombre");
     const apellido= document.getElementById("apellido");
     const matricula= document.getElementById("matricula");

    const formData = {
      name: nombre.value,
      lastname: apellido.value,
      licence:matricula.value,
    };

    const url = "http://localhost:8080/odontologos/registrarOdontologo";
    const settings = {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(formData),
    };
    fetch(url, settings)
      .then((response) => response.json())
      .then(()=> Swal.fire(
              'Odontologo creado!',
              'Correctamente',
              'success'
            ))
      .finally(() => {
                nombre.value = "";
                apellido.value = "";
                matricula.value = "";
            })
            }