package com.example.BlogAppli.service;

import com.example.BlogAppli.model.Article;

import com.example.BlogAppli.model.Comment;

import java.util.List;


public interface BlogService {

    Article AddArticle(Article article);
    Comment AddComment(Comment comment) throws IllegalAccessException;
    List<Article> GetAllArticle();
    Article DeleteArticle(Long id);
    Article UpdateArticle(Long id, Article upArticle);
}
