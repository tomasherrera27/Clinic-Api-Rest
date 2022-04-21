window.onload = () => {
  fetch("http://localhost:8080/odontologos")
    .then((response) => response.json())
    .then((data) => cargarInformacionOdontologos(data));
};

function cargarInformacionOdontologos(odontologist) {
  const tablaOdontologos = document
    .getElementById("tablaOdontologos")
    .getElementsByTagName("tbody")[0];

  odontologist.map((odontologo) => {
    tablaOdontologos.innerHTML += `
                                                                      <tr >
                                                                          <th>${odontologo.id}</th>
                                                                          <td>${odontologo.name}</td>
                                                                          <td>${odontologo.lastname}</td>
                                                                          <td>${odontologo.licence}</td>
                                                                          <td><button class="btn btn-circle" onClick="deleteOdontologist(${odontologo.id})">
                                                                          <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12" /></svg>
                                                                          </button></td>
                                                                          <td><a href="/Update.html"><button class="btn btn-warning">editar</button></a></td>
                                                                      </tr>
                                  `;
  })

}