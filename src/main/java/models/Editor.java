package models;

import javax.persistence.*;

@Entity
@Table(name="editors")

public class Editor extends Journalist {


    public Editor() {
    }

    public Editor(String username) {
        super(username);
    }




}
