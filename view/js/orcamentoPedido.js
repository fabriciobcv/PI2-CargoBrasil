async function getServicoId(){
    document.addEventListener('DOMContentLoaded', function() {
        const servicoId = localStorage.getItem('servicoId');
        const inputServico = document.getElementById('servico');
        inputServico.value = servicoId;
    });
}

async function putServico(servicoId, status){
    const destino = await fetch(`http://localhost:8080/servico/${servicoId}/avaliar-orcamento?status=${status}`, {
        method: "PUT"
    });
    
    if (destino.ok){
        window.location.href = "listagem.html";
    }
}

async function registrarOrcamento(){
    let funcionarioOrcamentoId = window.localStorage.getItem('usuarioId');
    custoEmbalagem = document.getElementById('custoEmbalagem').value
    taxaDesistencia = document.getElementById('taxaDesistencia').value
    valor = document.getElementById('valor').value
    prazo = document.getElementById('prazo').value
    servicoId = document.getElementById('servico').value

    const response = await fetch("http://localhost:8080/orcamento", {
        method: "POST",
        headers: new Headers({
            "Content-Type": "application/json; charset=utf8",
            Accept: "application/json"
        }),
        body: JSON.stringify({
            custoEmbalagem: custoEmbalagem,
            taxaDesistencia: taxaDesistencia,
            valor: valor,
            prazo: prazo,
            servicoId: servicoId,
            funcionarioOrcamentoId: funcionarioOrcamentoId
        }),
    });

    if(response.ok){
        putServico(servicoId, 'AGUARDANDO')
    }
}


document.addEventListener("DOMContentLoaded", function (event) {
    if (!localStorage.getItem("Cargo").includes("ORCAMENTO"))
        window.location.href = "listagem.html";
});

getServicoId();