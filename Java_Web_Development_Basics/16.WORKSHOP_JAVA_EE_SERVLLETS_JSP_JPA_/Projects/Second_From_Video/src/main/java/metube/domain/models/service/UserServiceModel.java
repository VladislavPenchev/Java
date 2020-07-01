package metube.domain.models.service;

import java.util.List;

public class UserServiceModel {
    private String id;
    private String username;
    private String password;
    private String email;
    private List<TubeServiceModel> tubes;

    public UserServiceModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}