async function showServico(servico){
    let destinatario = await getDestinatario(servico.destinatarioId);
    let enderecoBusca = await getEndereco(servico.enderecoBuscaId);
    let enderecoEntrega = await getEndereco(servico.enderecoEntregaId);
    let produto = await getProduto(servico.produtoId);

  let lines = `<ul class="list-group">
                <li class="list-group-item">Estado: ${enderecoBusca.estado}</li>
                <li class="list-group-item">Município: ${enderecoBusca.municipio}</li>
                <li class="list-group-item">Bairro: ${enderecoBusca.bairro}</li>
                <li class="list-group-item">Rua: ${enderecoBusca.rua}</li>
                <li class="list-group-item">Número: ${enderecoBusca.numero}</li>
                <li class="list-group-item">Complemento: ${enderecoBusca.complemento}</li>
                <li class="list-group-item">CEP: ${enderecoBusca.cep}</li>
                </ul>`

  document.getElementById("enderecoOrigem").innerHTML = lines;

    lines = `<ul class="list-group">
                <li class="list-group-item">Estado: ${enderecoEntrega.estado}</li>
                <li class="list-group-item">Município: ${enderecoEntrega.municipio}</li>
                <li class="list-group-item">Bairro: ${enderecoEntrega.bairro}</li>
                <li class="list-group-item">Rua: ${enderecoEntrega.rua}</li>
                <li class="list-group-item">Número: ${enderecoEntrega.numero}</li>
                <li class="list-group-item">Complemento: ${enderecoEntrega.complemento}</li>
                <li class="list-group-item">CEP: ${enderecoEntrega.cep}</li>
                </ul>`

  document.getElementById("enderecoDestino").innerHTML = lines;

    lines = `<ul class="list-group">
                    <li class="list-group-item">Largura (cm): ${produto.largura}</li>
                    <li class="list-group-item">Altura (cm): ${produto.altura}</li>
                    <li class="list-group-item">Comprimento (cm): ${produto.comprimento}</li>
                    <li class="list-group-item">Peso (kg): ${produto.peso}</li>
                    </ul>`

  document.getElementById("produto").innerHTML = lines;

    lines = `<ul class="list-group">
                        <li class="list-group-item">Método: ${servico.pagamento}</li>
                        </ul>`

  document.getElementById("pagamento").innerHTML = lines;

    lines = `<ul class="list-group">
                        <li class="list-group-item">Nome: ${destinatario.nome}</li>
                        <li class="list-group-item">Email: ${destinatario.email}</li>
                        <li class="list-group-item">Telefone: ${destinatario.telefone}</li>
                        </ul>`

  document.getElementById("destinatario").innerHTML = lines;

    lines = `<ul class="list-group">
                            <li class="list-group-item">Descrição: ${produto.descricao}</li>
                            </ul>`

  document.getElementById("servico_descricao").innerHTML = lines;

    lines = `<ul class="list-group">
                            <li class="list-group-item"> ${servico.status}</li>
                            </ul>`

  document.getElementById("servico_status").innerHTML = lines;

  if(servico.status === 'AGUARDANDO'){
  
    let opcoes = `
        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <button type="button" class="btn btn-success" onclick="putServico(${servico.id}, 'APROVADO')">Aceitar</button>
        <button type="button" class="btn btn-danger" onclick="putServico(${servico.id}, 'REJEITADO')">Rejeitar</button>
        </div>
    `

    document.getElementById("aprovacao").innerHTML = opcoes;
  }

  if(servico.status === 'APROVADO'){
    let lines = `<ul class="list-group">
    <li class="list-group-item">${servico.codigoRastreio}</li>
    </ul>`

    document.getElementById("codigoRastreio").innerHTML = lines;
  }

}

async function showOrcamento(orcamento){
    let lines = `<ul class="list-group">
    <li class="list-group-item">Custo da Embalagem: ${orcamento.custoEmbalagem}</li>
    <li class="list-group-item">Taxa de Desistência: ${orcamento.taxaDesistencia}</li>
    <li class="list-group-item">Valor do Orçamento: ${orcamento.valor}</li>
    <li class="list-group-item">Prazo de Entrega (dias): ${orcamento.prazo}</li>
    </ul>`

    document.getElementById("orcamento").innerHTML = lines;
}

async function getServico(servicoId){
    let auth = localStorage.getItem('Authorization');
    const servicoRequest =  await fetch("http://localhost:8080/servico/" + servicoId, {
        method: "GET"
    });

    let data = await servicoRequest.json();;
    showServico(data);
}

async function getDestinatario(destinatarioId){
    let auth = localStorage.getItem('Authorization');
    const destinarioRequest = await fetch("http://localhost:8080/usuario/" + destinatarioId, {
        method: "GET"
    });

    let data = await destinarioRequest.json();
    return data;
}

async function getOrcamento(servicoId){
    let auth = localStorage.getItem('Authorization');
    const orcamentoRequest =  await fetch("http://localhost:8080/orcamento/" + servicoId, {
        method: "GET"
    });

    let data = await orcamentoRequest.json();
    await showOrcamento(data);
}

async function getEndereco(enderecoId) {
    let auth = localStorage.getItem('Authorization');
    const enderecoRequest = await fetch("http://localhost:8080/endereco/" + enderecoId, {
        method: "GET"
    });

    let data = await enderecoRequest.json();
    return data;
}

async function getProduto(produtoId){
    let auth = localStorage.getItem('Authorization');
    const produtoRequest = await fetch("http://localhost:8080/produto/" + produtoId, {
        method: "GET"
    });

    let data = await produtoRequest.json();

    return data;
}

async function putServico(servicoId, status){
    let auth = localStorage.getItem('Authorization');
    const destino = await fetch(`http://localhost:8080/servico/${servicoId}/avaliar-orcamento?status=${status}`, {
        method: "PUT"
    });
    
    if (destino.ok){
        window.location.href = "listagem.html";
    }
}

let servicoId = window.localStorage.getItem('servicoId')
getServico(servicoId);
getOrcamento(servicoId);