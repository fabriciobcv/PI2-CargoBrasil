async function rastrearEncomenda() {
    const trackingId = document.getElementById('trackingIdInput').value;
    if (!trackingId) {
        alert('Por favor, insira um código de rastreio.');
        return;
    }

    const response = await fetch(`http://localhost:8080/servico/${trackingId}`);

    const resultadoContainer = document.getElementById('resultado-rastreio');
    const detalhesContainer = document.getElementById('detalhes-pedido');

    if (response.ok) {
        const servico = await response.json();

        const detalhesHtml = `
            <ul class="list-group">
                <li class="list-group-item"><strong>Status:</strong> ${servico.status.replace('_', ' ')}</li>
                <li class="list-group-item"><strong>ID do Serviço:</strong> ${servico.id}</li>
                <li class="list-group-item"><strong>Pagamento:</strong> ${servico.pagamento}</li>
            </ul>`;

        detalhesContainer.innerHTML = detalhesHtml;
        resultadoContainer.style.display = 'block';
    } else {
        detalhesContainer.innerHTML = '<p class="text-danger">Encomenda não encontrada.</p>';
        resultadoContainer.style.display = 'block';
    }
}