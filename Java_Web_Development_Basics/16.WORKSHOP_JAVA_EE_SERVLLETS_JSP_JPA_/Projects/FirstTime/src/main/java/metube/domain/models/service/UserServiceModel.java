package metube.domain.models.service;

import java.util.List;

public class UserServiceModel {
    private String id;
    private String userName;
    private String email;
    private String password;
    private List<TubeServiceModel> tubes;

    public UserServiceModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public List<TubeServiceModel> getTubes() {
        return tubes;
    }

    public void setTubes(List<TubeServiceModel> tubes) {
        this.tubes = tubes;
    }
}
