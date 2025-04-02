package com.example.BlogAppli.controller;

import com.example.BlogAppli.model.Article;
import com.example.BlogAppli.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.BlogAppli.model.Comment;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    private final BlogService blogService;

   @Autowired
   public BlogController(BlogService blogService) {
       this.blogService = blogService;
   }

   @PostMapping("/addArticle")
    public String addArticle(@RequestBody Article article) {
       blogService.AddArticle(article);
       return "success add article";
   }

    @PostMapping("/addComment")
    public ResponseEntity<?> addComment(@RequestBody Comment comment) throws IllegalAccessException {
        if (comment.getArticle() == null || comment.getArticle().getId() == null) {
            return ResponseEntity.badRequest().body("L'article associé au commentaire ne peut pas être null");
        }
        Comment savedComment = blogService.AddComment(comment);
        return ResponseEntity.ok(savedComment);
    }

   @GetMapping("/getAllArticles")
    public List<Article> getAllArticle() {
       return this.blogService.GetAllArticle();
   }

   @DeleteMapping("/deleteOneArticle/{id}")
    public ResponseEntity<Article> deleteArticle(@PathVariable Long id){
       Article deletedArticle = this.blogService.DeleteArticle(id);
               return  ResponseEntity.ok(deletedArticle);
   }

   @PutMapping("/updateOneArticle/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody Article upArticle){
       Article updatedArticle = this.blogService.UpdateArticle(id, upArticle);
       return  ResponseEntity.ok(updatedArticle);
   }

}