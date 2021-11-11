package models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@XmlRootElement(name="users")
public class Users {
    private List<User> users;

    public Users(){}

    public Users(List<User> users){ this.users = users; }

    public List<User> getUsers() { return users; }

    public void addUser(User new_user) { users.add(new_user); }

    @XmlElement(name="user")
    public void setUsers(List<User> users) { this.users = users; }

    public boolean contains(User new_user) {
        for (User user : this.users){
            if (user.getLogin().equals(new_user.getLogin()) &&
                    user.getPassword().equals(new_user.getPassword())){
                return true;
            }
        }
        return false;

    }

    @Override
    public String toString() { return "Users [ users =" + users + "]"; }

}
