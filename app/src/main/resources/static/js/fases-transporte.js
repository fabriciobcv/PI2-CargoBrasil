async function getServico(servicoId) {
    const servicoRequest = await fetch(`http://localhost:8080/servico/${servicoId}`);

    if (servicoRequest.ok) {
        return await servicoRequest.json();
    } else {
        alert("Serviço não encontrado!");
        return null;
    }
}

function updateProgressBar(status) {
    const progressBarContainer = document.getElementById('progress-bar-container');
    progressBarContainer.innerHTML = '';

    const fases = [
        'AGUARDANDO_ORCAMENTO',
        'AGUARDANDO',
        'APROVADO',
        'REJEITADO_NA_COLETA',
        'REJEITADO'
    ];

    const statusIndex = fases.indexOf(status);

    let progressBar = '';
    if (status === 'REJEITADO') {
        progressBar = `<div class="progress-bar bg-danger" role="progressbar" style="width: 100%;" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100">Rejeitado</div>`;
    } else if (status === 'REJEITADO_NA_COLETA') {
        progressBar = `<div class="progress-bar bg-warning" role="progressbar" style="width: 100%;" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100">Rejeitado na Coleta</div>`;
    } else {
        const percentage = ((statusIndex + 1) / (fases.length - 2)) * 100;
        progressBar = `<div class="progress-bar" role="progressbar" style="width: ${percentage}%" aria-valuenow="${percentage}" aria-valuemin="0" aria-valuemax="100">${status.replace('_', ' ')}</div>`;
    }

    progressBarContainer.innerHTML = progressBar;
}

async function consultarFases() {
    const servicoId = document.getElementById('servicoIdInput').value;
    if (!servicoId) {
        alert("Por favor, digite o ID do serviço.");
        return;
    }

    const servico = await getServico(servicoId);

    if (servico) {
        document.getElementById('fases-container').style.display = 'block';

        const statusContainer = document.getElementById("servico_status");
        statusContainer.innerHTML = `<ul class="list-group">
                                        <li class="list-group-item"> ${servico.status.replace('_', ' ')}</li>
                                     </ul>`;

        updateProgressBar(servico.status);
    }
}