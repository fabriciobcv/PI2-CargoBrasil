function show(servicos) {
    let line = "";
    let i = 1;

    let cargo = window.localStorage.getItem('tipo');

    servicos.forEach(servico => {

        if(cargo == "ORCAMENTO" ){
            line += `
            <tr>
                <th scope="row">${i}</th>
                <td scope="row">${servico.id}</td>
                <td scope="row">${servico.status}</td>
                <td scope ="row" class="expandirInformacoes">
                    <button class="btn btn-info btn-sm" type="button" data-toggle="tooltip" data-placement="top" title="Info" onclick="openInfo(${servico.id})">
                        Info
                    </button>
                </td>
                <td scope ="row">
                <div class="registrarOrcamento">   
                    <button class="btn btn-info btn-sm" type="button" data-toggle="tooltip" data-placement="top" title="Info" onclick="openOrcamento(${servico.id})">
                        Orçamento
                    </button>
                </div>
                </td>
            </tr>
        `;
        }else{
            line += `
            <tr>
                <th scope="row">${i}</th>
                <td scope="row">${servico.id}</td>
                <td scope="row">${servico.status}</td>
                <td scope ="row" class="expandirInformacoes">
                    <button class="btn btn-info btn-sm" type="button" data-toggle="tooltip" data-placement="top" title="Info" onclick="openInfo(${servico.id})">
                        Info
                    </button>
                </td>
            </tr>
        `;
        }

        
        i++;
        
    });
    
    document.getElementById("servicos").innerHTML = line;
}

function showHeaders(){
    let line = "";
    let cargo = window.localStorage.getItem('tipo');

    if(cargo == "ORCAMENTO"){
        line = `
        <tr>
            <th scope="col">#</th>
            <th scope="col">ID</th>
            <th scope="col">Status</th>
            <th scope="col">Informações</th>
            <th scope="col">Orçamento</th>
        </tr>`
    }else{
        line = `
        <tr>
            <th scope="col">#</th>
            <th scope="col">ID</th>
            <th scope="col">Status</th>
            <th scope="col">Informações</th>
        </tr>`
    }

    document.getElementById("servicosCabecalho").innerHTML = line;
}

async function getServicos() {
    let cargo = localStorage.getItem('tipo');
    let usuarioId = localStorage.getItem('usuarioId');

    let url = cargo == "ORCAMENTO" ? "http://localhost:8080/servico/list" : `http://localhost:8080/servico/remetente/${usuarioId}`

    const servicosRequest = await fetch(url, {
        method: "GET"
    });
    let data = await servicosRequest.json();
    console.log(data);
    showHeaders();
    show(data);
}

document.addEventListener("DOMContentLoaded", function (event) {
    if (!localStorage.getItem("tipo"))
        window.location.href = "index.html";;
});

getServicos();

function openInfo (servicoId){
    window.localStorage.setItem('servicoId', servicoId)
    window.location.href = "info.html";
    
}

function openOrcamento(servicoId){
    window.localStorage.setItem('servicoId', servicoId)
    window.location.href = "orcamentoPedido.html";
}