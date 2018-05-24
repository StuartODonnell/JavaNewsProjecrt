package models;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name="journalists")

public class Journalist extends User {
    private int id;
    private Set<Article> articles;

    public Journalist(String username) {
        super(username);
    }

    public Journalist(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "article_journalist",
            inverseJoinColumns = {@JoinColumn(name = "journalist_id", nullable = false, updatable = false)},
            joinColumns = {@JoinColumn (name ="article_id", nullable = false, updatable = false)}
    )
    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }
}
