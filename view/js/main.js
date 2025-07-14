async function login(){
    let cpf = document.getElementById("cpfInput").value;
    let senha = document.getElementById("passwordInput").value;

    console.log(cpf, senha);

    const response = await fetch("http://localhost:8080/usuario/login", {
        method: "POST",
        headers: new Headers({
            "Content-Type": "application/json; charset=utf8",
            Accept: "application/json",
        }),
        body: JSON.stringify({
            cpf: cpf,
            senha: senha,
        }),
    });

    const usuario = await response.json();
    console.log(usuario)
    window.localStorage.setItem("tipo", usuario.tipo);
    window.localStorage.setItem("usuarioId", usuario.id);
  


    if (response.ok) {
        window.location.href = "listagem.html";
    }
}

async function criarCadastro(){
    let nome = document.getElementById("nameInput").value;
    let email = document.getElementById("emailInput").value;
    let senha = document.getElementById("passwordInput").value;
    let cpf = document.getElementById("cpfInput").value;
    let telefone = document.getElementById("numberInput").value;
    let tipo = "CLIENTE"

    console.log(nome, email, senha, cpf, telefone);

    const response = await fetch("http://localhost:8080/usuario", {
        method: "POST",
        headers: new Headers({
            "Content-Type": "application/json; charset=utf8",

            Accept: "application/json",
        }),
        body: JSON.stringify({
            nome: nome,
            email: email,
            senha: senha,
            cpf: cpf,
            telefone: telefone,
            tipo: tipo
        }),
    });

    if (response.ok) {
        window.location.href = "index.html";
    }
}