## Proximos passos
1. **Faltou configurar o banco.** O `application.properties` só tem o nome da aplicação, então a API não sobe. Veja "Como subir com H2" abaixo.
2. **Valor em dinheiro:** use `BigDecimal` em vez de `double`/`Double`, para evitar erros de arredondamento.
3. **Data como `String`:** o `@Pattern` aceita `2026-99-99`. Prefira `LocalDate`.
4. **Rota com typo:** `/aprove` deveria ser `/approve`.
5. **Tratamento de erros:** crie um `@ControllerAdvice` para devolver mensagens de erro padronizadas.
6. **Limpeza:** remova as tags vazias do `pom.xml` (`<license/>`, `<developer/>` etc.). Corrija o `toString` da entidade, que imprime "Despesas".

## Como subir com H2

**1. Adicione no `pom.xml`:**
```xml
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```

**2. Configure o `application.properties`:**
```properties
spring.application.name=backend

spring.datasource.url=jdbc:h2:mem:juliusdb;DB_CLOSE_DELAY=-1
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

**3. Rode:**
```
cd backend
.\mvnw spring-boot:run
```

- Swagger: http://localhost:8080/swagger-ui.html
- Console H2: http://localhost:8080/h2-console (JDBC URL `jdbc:h2:mem:juliusdb`, usuário `sa`, senha vazia)
- Se o console H2 der 404 no Spring Boot 4.x, adicione a dependência `spring-boot-h2console`.

## Testando com curl
Base: `http://localhost:8080/api/finance`. No PowerShell use `curl.exe`. Adicione `-i` para ver o status HTTP.

```bash
# criar
curl -X POST http://localhost:8080/api/finance -H "Content-Type: application/json" \
  -d '{"description":"Conta de luz","value":111.11,"category":"Moradia","date":"2026-09-17"}'

# listar
curl http://localhost:8080/api/finance

# buscar por id
curl http://localhost:8080/api/finance/1

# atualizar
curl -X PUT http://localhost:8080/api/finance/1 -H "Content-Type: application/json" \
  -d '{"description":"Conta de água","value":80.5,"category":"Moradia","date":"2026-09-20"}'

# marcar como paga
curl -X PATCH http://localhost:8080/api/finance/1/aprove

# deletar
curl -X DELETE http://localhost:8080/api/finance/1
```

**Casos de erro para conferir:**
```bash
# 400: descrição vazia e valor negativo
curl -X POST http://localhost:8080/api/finance -H "Content-Type: application/json" \
  -d '{"description":"","value":-5}'

# 404: id inexistente
curl -i http://localhost:8080/api/finance/999
```
