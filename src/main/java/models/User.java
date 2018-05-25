package models;

import javax.persistence.*;

@Entity
@Table(name = "users")

public class User {
    private String username;
    private int id;

    public User(String username) {
        this.username = username;
    }

    public User() {
    }


    @Column(name="username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
