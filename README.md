# consultando-a-api-do-via-cep-master
 
uma API REST de consulta de endereço e cálculo de frete para um determinado CEP.

url: POST v1/consulta-endereco

REQUEST

{

"cep": "01001000"

}

RESPONSE HTTP 200
}

"cep": "01001-000",

"rua": "Praça da Sé" ,

"complemento": "lado ímpar",

"bairro": "Sé",

"cidade": "São Paulo",

"estado": "SP",

"frete": 7.85

{

a documentação é gerada ao subir o projeto, por padrão, o mesmo utiliza a porta 8080:

url da documentação: http://localhost:8080/swagger-ui/index.html
