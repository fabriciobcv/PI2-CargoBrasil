async function registrarOrigem(){

    let estadoOrigem = document.getElementById('estadoOrigem').value;
    let municipioOrigem = document.getElementById('municipioOrigem').value;
    let bairroOrigem = document.getElementById('bairroOrigem').value;
    let ruaOrigem = document.getElementById('ruaOrigem').value;
    let numeroOrigem = document.getElementById('numeroOrigem').value;
    let complementoOrigem = document.getElementById('complementoOrigem').value;
    let cepOrigem = document.getElementById('cepOrigem').value;

    const origem = await fetch("http://localhost:8080/endereco", {
        method: "POST",
        headers: new Headers({
            "Content-Type": "application/json; charset=utf8",
            Accept: "application/json"
        }),
        body: JSON.stringify({
            estado: estadoOrigem,
            municipio: municipioOrigem,
            bairro: bairroOrigem,
            rua: ruaOrigem,
            numero: parseInt(numeroOrigem),
            complemento: complementoOrigem,
            cep: cepOrigem
        }),
    });

    const origemData = await origem.json();

    console.log('Origem ' + origemData.id);
    window.localStorage.setItem('Origem',origemData.id);
}

async function registrarEndereco(){

    let estadoDestino = document.getElementById('estadoDestino').value;
    let municipioDestino = document.getElementById('municipioDestino').value;
    let bairroDestino = document.getElementById('bairroDestino').value;
    let ruaDestino = document.getElementById('ruaDestino').value;
    let numeroDestino = document.getElementById('numeroDestino').value;
    let complementoDestino = document.getElementById('complementoDestino').value;
    let cepDestino = document.getElementById('cepDestino').value;

    const destino = await fetch("http://localhost:8080/endereco", {
        method: "POST",
        headers: new Headers({
            "Content-Type": "application/json; charset=utf8",
            Accept: "application/json"
        }),
        body: JSON.stringify({
            estado: estadoDestino,
            municipio: municipioDestino,
            bairro: bairroDestino,
            rua: ruaDestino,
            numero: parseInt(numeroDestino),
            complemento: complementoDestino,
            cep: cepDestino
        }),
    });

    const destinoData = await destino.json();

    console.log('destino ' + destinoData.id);
    window.localStorage.setItem('Destino',destinoData.id);
}

async function registrarProduto(){
    let largura = document.getElementById('largura').value;
    let altura = document.getElementById('altura').value;
    let comprimento = document.getElementById('comprimento').value;
    let peso = document.getElementById('peso').value;
    let descricao = document.getElementById('descricao').value;

    const response = await fetch("http://localhost:8080/produto", {
        method: "POST",
        headers: new Headers({
            "Content-Type": "application/json; charset=utf8",
            Accept: "application/json"
        }),
        body: JSON.stringify({
            largura: parseInt(largura),
            altura: parseInt(altura),
            comprimento: parseInt(comprimento),
            peso: parseFloat(peso),
            descricao: descricao,
            numero: parseInt(Math.floor(Math.random() * 9999))
        })
    })

    const produtoData = await response.json();

    console.log('produto ' + produtoData.id);
    window.localStorage.setItem('Produto', produtoData.id);
}

async function registrarDestinatario(){
    let auth = window.localStorage.getItem('Authorization');
    let nome = document.getElementById('nomeDestinatario').value;
    let email = document.getElementById('emailDestinatario').value;
    let telefone = document.getElementById('telefoneDestinatario').value;
    let cpf = document.getElementById('cpfDestinatario').value;
    let tipo = "DESTINATARIO"


    const reponse = await fetch("http://localhost:8080/usuario", {
        method: "POST",
        headers: new Headers({
            "Content-Type": "application/json; charset=utf8",
            Accept: "application/json",
            Authorization: auth
        }),
        body: JSON.stringify({
            nome: nome,
            email: email,
            telefone: telefone,
            cpf: cpf,
            tipo: tipo
        })
    });

    const destinatarioData = await reponse.json();
    console.log('destinatario ' + destinatarioData.id);
    window.localStorage.setItem('Destinatario', destinatarioData.id);
}

async function registrarServico(){
    let origem = window.localStorage.getItem('Origem');
    let destino = window.localStorage.getItem('Destino');
    let produto = window.localStorage.getItem('Produto');
    let destinatario = window.localStorage.getItem('Destinatario');
    let pagamento = document.getElementById('pagamento').value;
    let rementente = window.localStorage.getItem('usuarioId');

    const response = await fetch("http://localhost:8080/servico", {
        method: "POST",
        headers: new Headers({
            "Content-Type": "application/json; charset=utf8",
            Accept: "application/json"
        }),
        body: JSON.stringify({
            produtoId: produto,
            pagamento: pagamento,
            remetenteId: parseInt(rementente),
            destinatarioId: parseInt(destinatario),
            enderecoBuscaId: origem,
            enderecoEntregaId: destino
        }),
    });

    if(response.ok){
        window.location.href = "listagem.html";
    }
}

async function fazerPedido(){
    await registrarOrigem();
    await registrarEndereco();
    await registrarProduto();
    await registrarDestinatario();
    await registrarServico();
}