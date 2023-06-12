package rest_users_client.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@ComponentScan("rest_users_client")
public class AppConfiguration {
    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }
}
