import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
    stages: [
        // Fase 1 - Leve (aquecimento)
        { duration: '10s', target: 10 },
        { duration: '10s', target: 25 },

        // Fase 2 - Média (uso realista)
        { duration: '15s', target: 50 },
        { duration: '20s', target: 100 },

        // Fase 3 - Alta (teste de estresse)
        { duration: '45s', target: 200 },
        { duration: '45s', target: 400 },

        // Fase final - redução progressiva
        { duration: '45s', target: 200 },
        { duration: '30s', target: 50 },
        { duration: '30s', target: 0 }
    ],
};

export default function () {
    const res = http.get('http://localhost:8080/orcamento');

    check(res, {
        'status é 200': (r) => r.status === 200,
        'resposta é um array': (r) => {
            try {
                const data = JSON.parse(r.body);
                return Array.isArray(data);
            } catch (e) {
                return false;
            }
        },
    });

    sleep(1);
}