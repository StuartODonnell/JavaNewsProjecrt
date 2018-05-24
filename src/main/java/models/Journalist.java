package models;

import java.util.Set;

public class Journalist extends User {
    private int id;
    private Set<Article> articles;

    public Journalist(String username) {
        super(username);
    }

    public Journalist(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }
}
