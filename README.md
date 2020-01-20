# Consumidor-2

### Objetivo
- Consumidor de dados do arquivo do bolsa família. 
Essa aplicação é responsável por receber os registros de um topic que recebe informações de um producer responsável por parsear o arquivo. 
Essa aplicação mostrar os dados do beneficiário que tem a maior parcela até o momento

   *[maior valor da parcela]*

### Tecnologias
- Java
- Maven
- Spring boot
- Kafka
- Docker

### Como executar

- Para executar o sistema recomendamos utilizar o docker e o arquivo docker-compose.yml presente no projeto, nesse arquivo além de ter o start dassa aplicação, também inícia o produtor e outros dois consumidores.

#### Configurações dos Consumidores
- Para os consumidores devem ser editadas as seguintes variáveis: 
    - KAFKA_HOST: Host onde está disponível o serviço do kafka, incluindo a porta. Por default o arquivo está configurado para acessar a imagem que também será instânciada pelo arquivo docker-compose.yml
    - KAFKA_GROUP_ID: group id para acessar o topic do kafka. Deve ser diferente em cada um dos consumers para que todos recebam todas as mensagens.
    - TOPIC_BOLSA: Nome do topic de onde serão consumidas as mensagens. Por default vem com o nome BOLSA_FAMILIA. Deve seguir o mesmo nome que está definido na variavel KAFKA_CREATE_TOPICS da definição da container do kafka.

### Executar na IDE

- Alterar o arquivo application.properties substituindo as mesmas variáveis que estão definidas no docker-compose.yml que foram mencionadas acima. 
