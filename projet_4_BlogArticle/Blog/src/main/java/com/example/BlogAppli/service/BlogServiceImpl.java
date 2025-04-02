package com.example.BlogAppli.service;

import com.example.BlogAppli.model.Article;
import com.example.BlogAppli.model.Comment;
import com.example.BlogAppli.repository.ArticleRepository;
import com.example.BlogAppli.repository.CommentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class BlogServiceImpl implements BlogService {

    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;


    @Autowired
    public BlogServiceImpl(ArticleRepository articleRepository, CommentRepository commentRepository, CommentRepository commentRepository1) {
        this.articleRepository = articleRepository;
        this.commentRepository = commentRepository1;
    }


    @Override
    public Article AddArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Comment AddComment(Comment comment) {
        // Vérifiez que l'article associé n'est pas null
        if (comment.getArticle() == null || comment.getArticle().getId() == null) {
            throw new IllegalArgumentException("L'article associé au commentaire ne peut pas être null");
        }

        // Récupérez l'article depuis la base de données
        Article article = articleRepository.findById(comment.getArticle().getId())
                .orElseThrow(() -> new EntityNotFoundException("L'article associé au commentaire n'existe pas"));

        // Associez le commentaire à l'article
        comment.setArticle(article);
        article.getComments().add(comment);

        // Sauvegardez le commentaire
        return commentRepository.save(comment);
    }

    @Override
    public List<Article> GetAllArticle() {
        return this.articleRepository.findAll();
    }

    @Override
    public Article DeleteArticle(Long id) {
        Article article = (Article)this.articleRepository.findById(id).orElseThrow(() -> new RuntimeException("Article not found"));
        this.articleRepository.deleteById(id);
        return article;
    }

    @Override
    public Article UpdateArticle(Long id, Article upArticle) {
        Article articleExisting = articleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Article non trouvé avec l'ID : " + id));
        articleExisting.setTitle(upArticle.getTitle());
        articleExisting.setContent(upArticle.getContent());
        articleExisting.setAuthor(upArticle.getAuthor());
        return articleRepository.save(articleExisting);

    }





}
