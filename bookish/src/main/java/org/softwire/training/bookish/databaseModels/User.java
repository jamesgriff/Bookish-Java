package org.softwire.training.bookish.databaseModels;

//import javax.persistence.*;

//@Entity
//@Table(name = "users")
public class User {
    private String username;
    private String password;
    private Boolean enabled;

//    @Id
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    @Column(nullable = false)
    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
