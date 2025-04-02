package com.example.BlogAppli.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "article")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private String title;

    @NotNull
    @Column
    private String content;

    @NotNull
    @Column
    private LocalDateTime datePublication = LocalDateTime.now();

    // Constructeur par défaut
    public Article() {
        this.datePublication = LocalDateTime.now(); // Initialisation de la date/heure actuelle
    }

    @Column
    private String author;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Comment> comments;

    public Article(List<Comment> comment) {
        this.comments = comment;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public void setContent(String contenu) {
        this.content = contenu;
    }
    public String getContent() {
        return content;
    }
    public void setDatePublication(LocalDateTime datePublication) {
        this.datePublication = datePublication;
    }
    public LocalDateTime getDatePublication() {
        return datePublication;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getAuthor() {
        return author;
    }

    public List<Comment> getComments() {
        return comments;
    }

}
