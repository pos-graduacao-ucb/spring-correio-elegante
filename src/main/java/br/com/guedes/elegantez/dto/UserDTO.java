package br.com.guedes.elegantez.dto;

import br.com.guedes.elegantez.domain.User;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String nickname;
    private String email;
    private String password;
    private String age;
    private String genre;

    public UserDTO() {}

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.nickname = user.getNickname();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.age = user.getAge();
        this.genre = user.getGenre();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAge() {
        return age;
    }

    public String getGenre() {
        return genre;
    }
}
