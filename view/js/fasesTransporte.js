async function getServico() {
    let codigoRastreio = document.getElementById('trackingIdInput').value;
    const servicoRequest = await fetch(`http://localhost:8080/servico/rastreio/${codigoRastreio}`);
    let data = await servicoRequest.json();
    console.log(data)
    if (await servicoRequest.ok) {
        
        window.localStorage.setItem("servicoRastreado", data.id);
        window.location.href = "faseTransporte.html"
    } else {
        alert("Serviço não encontrado!");
        return null;
    }
}

async function consultarFases() {
    let servicoRastreado = localStorage.getItem('servicoRastreado');
    const servicoRequest = await fetch(`http://localhost:8080/faseTransporte/${servicoRastreado}`);
    let fasesTransporte = await servicoRequest.json()

    const container = document.getElementById("linha-do-tempo");

    
    fasesTransporte.sort((a, b) => a.faseNumero - b.faseNumero);

    
    fasesTransporte.forEach(fase => {
      const div = document.createElement("div");
      div.className = "fase";

      div.innerHTML = `
       <p><strong>${fase.enderecoOrigem.local} --> ${fase.enderecoDestino.local}</strong></p>
        <p><strong>${fase.status}</strong></p>
        <p>${fase.meioTransporte}</p>
        <p>${fase.data}</p>
      `;

      container.appendChild(div);
    });
}

document.addEventListener("DOMContentLoaded", function () {
    if (window.location.pathname.includes("faseTransporte.html")) {
        consultarFases();
    }
});