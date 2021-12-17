package main.api.Bean;


import org.apache.catalina.User;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "GEM_adherent")
public class AdherentBean {

    //BEAN

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    @Column(unique=true)
    private String login;

    private String password;
    private String date_created;
    private String last_login;
    private String email;
    

    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public String getDate_created() {
        return date_created;
    }
    public String getLast_login() {
        return last_login;
    }


    public AdherentBean setLogin(String login) {
        this.login = login;
        return this;
    }

    public AdherentBean setPassword(String password) {
        this.password = password;
        return this;
    }

    public AdherentBean setEmail(String email) {
        this.email = email;
        return this;
    }


    public AdherentBean setDate_created(String date_created) {
        this.date_created = date_created;
        return this;
    }


    public AdherentBean setLast_login(String last_login) {
        this.last_login = last_login;
        return this;
    }
}
