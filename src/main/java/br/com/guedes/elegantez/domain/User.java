package br.com.guedes.elegantez.domain;

import br.com.guedes.elegantez.domain.enums.Profile;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@Document(collection = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    private String nickname;
    private String email;
    private String password;
    private String age;
    private String genre;
    private List<ElegantMail> listElegantMail;
    private Set<Integer> profiles = new HashSet<>();

    public User() {
        addProfile(Profile.USER);
    }

    public User(String id, String name, String nickname, String email, String password, String age, String genre) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.age = age;
        this.genre = genre;
        this.listElegantMail = new ArrayList<>();
        addProfile(Profile.USER);
    }

    public List<ElegantMail> getListElegantMail() {
        return Collections.unmodifiableList(listElegantMail);
    }

    public void addingElegantMail(ElegantMail elegantMail) {
        this.listElegantMail.add(elegantMail);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Set<Profile> getProfiles() {
        return profiles.stream().map(x -> Profile.toEnum(x)).collect(Collectors.toSet());
    }

    public void addProfile(Profile profile) {
        profiles.add(profile.getCod());
    }

    public void setProfiles(Set<Integer> profiles) {
        this.profiles = profiles;
    }
}