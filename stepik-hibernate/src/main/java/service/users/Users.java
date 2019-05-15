package service.users;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class Users implements Serializable {

    private static final long serialVersionUID = -8706689714326132798L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login", unique = true)
    @NotNull
    private String login;

    @Column(name = "pass")
    @NotNull
    private String pass;


    public Users() {
    }


    public Users(long id, String login, String pass) {
        this.setId(id);
        this.setLogin(login);
        this.setPass(pass);
    }

    public Users(String login, String pass) {
        this.setId(-1);
        this.setLogin(login);
        this.setPass(pass);
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Users { id = " + id + ", login = " + login + ", pass = " + pass + "}";
    }

}
