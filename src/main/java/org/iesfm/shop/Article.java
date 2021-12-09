package org.iesfm.shop;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
// @Table(name = "Article")
public class Article {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private double price;
    @ElementCollection
    @CollectionTable(
            name = "Tag",
            joinColumns = @JoinColumn(name = "article_id", referencedColumnName = "id")
    )
    @Column(name = "name")
    private Set<String> tags;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return id == article.id && Double.compare(article.price, price) == 0 && Objects.equals(name, article.name) && Objects.equals(tags, article.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, tags);
    }
}
