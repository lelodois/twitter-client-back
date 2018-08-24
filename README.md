## Serviço Rest client que consome api do twitter para buscar hashtags
### (twitter-client-back)

### Build docker
- mvn install
- docker build -t twcli-back-docker .
- docker run --net mynet123 --ip 172.18.0.24 -d -p 8094:8094 {tag}

### Tecnologias

- Java 8 (rest)
- Maven
- Spring boot
- Swagger

Em desenvolvimento...

Autor
Leo costa - Initial work - GitUsersFriends
