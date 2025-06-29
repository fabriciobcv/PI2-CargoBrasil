import http from 'k6/http';
import { sleep, check } from 'k6';
// import { htmlReport } from "https://raw.githubusercontent.com/benc-uk/k6-reporter/main/dist/bundle.js";

export const options = {
    stages: [
        { duration: '10s', target: 10 },
        { duration: '20s', target: 20 },
        { duration: '10s', target: 0 },
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

// export function handleSummary(data) {
//     return {
//         "summary.html": htmlReport(data),
//     };
// }