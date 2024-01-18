from flask import Flask, jsonify
import requests

app = Flask(__name__)

@app.route('/getDollarRate', methods=['GET'])
def get_dollar_rate():
    # Lógica para buscar a cotação do dólar do site e retornar os dados solicitados
    dollar_data = fetch_dollar_rate()
    return jsonify(dollar_data)

def fetch_dollar_rate():
    url = "https://economia.awesomeapi.com.br/last/USD-BRL"
    response = requests.get(url)
    data = response.json()

    # Extrai os dados desejados
    dollar_data = {
        "valor_compra": data["USDBRL"]["bid"],
        "valor_venda": data["USDBRL"]["ask"],
        "alta": data["USDBRL"]["high"],
        "baixa": data["USDBRL"]["low"],
        "data": data["USDBRL"]["create_date"]
    }

    return dollar_data

if __name__ == '__main__':
    # Roda o servidor Flask na porta 5000
    app.run(port=5000)