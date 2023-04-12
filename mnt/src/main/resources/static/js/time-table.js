// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarDatos();
  $('#dataTable').DataTable();
});

async function cargarDatos(){
      const rawResponse = await fetch('/', {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({a: 1, b: 'Textual content'})
      });
      const content = await rawResponse.json();

      console.log(content);
    }
}