package com.qa.rest;

import com.qa.domain.Comments;
import com.qa.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CommentController {
    private final CommentService service;

    @Autowired
    public CommentController(CommentService service) {
        this.service = service;
    }

    @GetMapping("/getAllComments")
    public List<Comments> getAllComments(){
        return this.service.readAllComments();
    }

    @PostMapping("/createComment")
    public Comments createComment(@RequestBody Comments comment){
        return this.service.createComment(comment);
    }

    @DeleteMapping("/deleteComment/{id}")
    public boolean deleteComment(@PathVariable Long id){
        return this.service.deleteComment(id);
    }

    @GetMapping("/getCommentBy/{id}")
    public Comments getCommentById(@PathVariable Long id){
        return this.service.findCommentById(id);
    }

    @PutMapping("/updateComment/{id}")
    public Comments updateNote(@PathVariable Long id, @RequestBody Comments comment){
        return this.service.updateComment(id, comment);
    }

}
