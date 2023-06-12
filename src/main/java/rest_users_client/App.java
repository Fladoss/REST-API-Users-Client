package rest_users_client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rest_users_client.configuration.AppConfiguration;
import rest_users_client.dto.User;
import rest_users_client.service.UsersApiService;

public class App {
    static UsersApiService apiService;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        apiService = context.getBean(UsersApiService.class);

        User user = new User();
        user.setName("Johnny Gat");
        user.setEmail("johnnygat@saints.gang");
        user.setAge(28);

        User savedUser = apiService.saveUser(user);

        System.out.println(savedUser);
    }
}
