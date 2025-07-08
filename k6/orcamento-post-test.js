import http from 'k6/http';
import { sleep, check } from 'k6';

export const options = {
    stages: [
        // Fase 1 - Leve (aquecimento)
        { duration: '30s', target: 20 },
        { duration: '30s', target: 50 },

        // Fase 2 - Média (uso realista)
        { duration: '30s', target: 100 },
        { duration: '45s', target: 200 },

        // Fase 3 - Alta (teste de estresse)
        { duration: '1m', target: 400 },
        { duration: '1m', target: 600 },

        // Fase final - redução progressiva
        { duration: '45s', target: 200 },
        { duration: '30s', target: 50 },
        { duration: '30s', target: 0 }
    ],
};

export default function () {
    const payload = JSON.stringify({
        custoEmbalagem: 5.40,
        taxaDesistencia: 15.10,
        valor: 30.20,
        prazo: 10,
        servicoId: 1,
        funcionarioOrcamentoId: 1,
    });

    const params = {
        headers: {
            'Content-Type': 'application/json',
        },
    };

    const res = http.post('http://localhost:8080/orcamento', payload, params);

    check(res, {
        'status 201 ou 200': (r) => r.status === 201 || r.status === 200,
    });

    sleep(1);
}