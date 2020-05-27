package com.qa.controller;

import com.qa.domain.Comment;
import com.qa.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Comment>> getAllComments(){
        return ResponseEntity.ok(this.service.readComments());
    }

    @PostMapping("/createComment")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment){
        return new ResponseEntity<Comment>(this.service.createComment(comment), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteComment/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Long id){
        return this.service.deleteComment(id)
            ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
            : ResponseEntity.noContent().build();
    }

    @GetMapping("/getCommentById/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id){
        return ResponseEntity.ok(this.service.findCommentById(id));
    }

    @PutMapping("/updateComment/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody Comment comment){
        return ResponseEntity.ok(this.service.updateComment(id, comment));
    }

}
