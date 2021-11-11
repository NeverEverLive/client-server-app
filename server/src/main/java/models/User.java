package models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="user")
public class User {
    private int id;
    private String login;
    private String password;
    public User(){}

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public int getId() { return id; }

    public String getLogin() { return login; }

    public String getPassword() { return password; }

    @XmlAttribute
    public void setId(int id) { this.id = id; }

    @XmlElement
    public void setLogin(String login) { this.login = login; }

    @XmlElement
    public void setPassword(String password) { this.password = password; }

}
