package rest_users_client.dto;

import lombok.Data;

@Data
public class User {
    private Integer id;

    private String name;

    private Integer age;

    private String email;

    public User() {
    }

    public User(Integer id, String name, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
