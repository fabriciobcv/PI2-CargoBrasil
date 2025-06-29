import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
    stages: [
        { duration: '10s', target: 10 },
        { duration: '20s', target: 20 },
        { duration: '10s', target: 0 },
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