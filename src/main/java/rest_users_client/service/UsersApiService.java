package rest_users_client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import rest_users_client.dto.User;

import java.util.List;
import java.util.Objects;

@Component
public class UsersApiService {
    private final WebClient webClient;

    public static final String URL = "http://localhost:8080/api/v1/";

    @Autowired
    public UsersApiService(WebClient webClient) {
        this.webClient = webClient;
    }

    public User getUserById(int id) {

//        User user = webClient.get().accept(MediaType.APPLICATION_JSON);

        Mono<ResponseEntity<User>> entityMono = webClient.get()
                .uri(URL + "/user/" + id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(User.class);

        return Objects.requireNonNull(entityMono.block()).getBody();
    }

    public User getUserByName(String name) {
        Mono<ResponseEntity<User>> entityMono = webClient.get()
                .uri(URL + "/user/" + name)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(User.class);


        return Objects.requireNonNull(entityMono.block()).getBody();
    }

    public List<User> getAllUsers() {
        Mono<ResponseEntity<List<User>>> entityMono = webClient.get()
                .uri(URL + "/users")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<>() {});

        return Objects.requireNonNull(entityMono.block()).getBody();
    }

    public List<User> getAllUsersByName(String name) {
        Mono<ResponseEntity<List<User>>> entityMono = webClient.get()
                .uri(URL + "/users/" + name)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<>() {});

        return Objects.requireNonNull(entityMono.block()).getBody();
    }

    public User saveUser(User user) {
        Mono<ResponseEntity<User>> entityMono = webClient.post()
                .uri(URL + "/user")
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(user)
                .retrieve()
                .toEntity(User.class);

        return Objects.requireNonNull(entityMono.block()).getBody();
    }

    public User updateUser(User user) {
        Mono<ResponseEntity<User>> entityMono = webClient.put()
                .uri(URL + "/user")
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(user)
                .retrieve()
                .toEntity(User.class);

        return Objects.requireNonNull(entityMono.block()).getBody();
    }

    public User deleteUserById(int id) {
        Mono<ResponseEntity<User>> entityMono = webClient.delete()
                .uri(URL + "/user/" + id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(User.class);

        return Objects.requireNonNull(entityMono.block()).getBody();
    }

    public User deleteUserByName(String name) {
        Mono<ResponseEntity<User>> entityMono = webClient.delete()
                .uri(URL + "/user/" + name)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(User.class);

        return Objects.requireNonNull(entityMono.block()).getBody();
    }
}
