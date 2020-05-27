package com.qa.service;

import com.qa.domain.Comment;
import com.qa.exceptions.CommentNotFoundException;
import com.qa.repo.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository repo;

    @Autowired
    public CommentService(CommentRepository repo) {
        this.repo = repo;
    }

    public List<Comment> readComments(){
        return this.repo.findAll();
    }

    public Comment createComment(Comment comment
    ){
        return this.repo.save(comment);
    }

    public Comment findCommentById(Long id){
        return this.repo.findById(id).orElseThrow(CommentNotFoundException::new);
    }

    public Comment updateComment(Long id, Comment comment){
        Comment update = this.repo.findById(id).orElseThrow(CommentNotFoundException::new);

        update.setUserName(comment.getUserName());
        update.setComment(comment.getComment());
        update.setRating(comment.getRating());

        return this.repo.save(update);
    }

    public boolean deleteComment(Long id){
        if(!this.repo.existsById(id)){
            throw new CommentNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }


}
