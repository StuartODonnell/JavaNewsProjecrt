package models;

import javax.persistence.*;

@Entity
@Table(name="editors")

public class Editor extends Journalist {
    private int id;

    public Editor() {
    }

    public Editor(String username) {
        super(username);
    }

    //TO DO WRITE EDITOR AUTHORISATION OF ENUM IN THIS CLASS

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
