package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="journalists")


public class Journalist {
    private String name;
    private String username;
    private int id;
    private Set<Article> articles;

    public Journalist(String name, String username) {
        this.username = username;
        this.name = name;
        this.articles = new HashSet<>();
    }

    public Journalist(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @OneToMany(mappedBy = "journalist")
    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    @Column(name="username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "names")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //adds article object to articles hash
    public void addArticle(Article article){
        this.articles.add(article);
    }
    //approves article
    public void changeStatusofArticletoApproved(Article article){
        article.setApproval(Approval.APPROVED);
    }

    //denies article
    public void changeStatusofArticletoDenies(Article article){
        article.setApproval(Approval.DENIED);
    }

}
