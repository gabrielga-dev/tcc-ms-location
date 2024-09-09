![campus-formiga.jpg](doc/images/campus-formiga.jpg)

Olá! Este é o microsserviço "ms-location", ele compõe o TCC: "APLICAÇÃO DE UMA ARQUITETURA DE MICROSSERVIÇOS EM UM
SISTEMA WEB PARA CONECTAR PRODUTORES DE EVENTOS E PRESTADORES DE SERVIÇOS".

**Atenção:** É importante a leitura de como executar o "ms-mailer" antes de qualquer outro microsserviço. Caso você 
ainda não tenha lido, acesse o repositório por <a href="https://github.com/gabrielga-dev/tcc-ms-mailer">aqui</a>.

Sua principal função é fornecer informações de estados e cidades, além de verificá-las quando necessário.

Para executar o microsserviço, basta rodar o seguinte comando:
```
mvn spring-boot:run
```
ou simplesmente importando o projeto em sua IDE de preferência e executando através dela.

Além disso, é preciso criar uma cópia do arquivo
[application.properties.example](src/main/resources/application.properties.example), removendo o final ".example", e
alterando o placeholder "<YOUR_KEY_HERE>" pela API Key gerado para usuários da
<a href="https://countrystatecity.in/">Country State City API</a>.