package edu.cecar.configuraciones;


import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfig {


 

  @Bean
  public OpenAPI myOpenAPI() {

    Server prodServer = new Server();
    prodServer.setUrl("http://localhot:8080/swagger-ui/index.html");
    prodServer.setDescription("Servidor Produccion CECAR");

    Contact contact = new Contact();
    contact.setEmail("jhon.mendez@cecar.edu.co");
    contact.setName("Jhon Mendez");
    contact.setUrl("https://github.com/jhonmendez");
    
    Info info = new Info()
        .title("Tutorial  API")
        .version("1.0")
        .contact(contact)
        .description("EndPoint API CalcularEstadisticas");

    return new OpenAPI().info(info).servers(List.of(prodServer));
  }
}
