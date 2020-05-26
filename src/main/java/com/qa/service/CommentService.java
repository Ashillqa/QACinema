package com.qa.service;

import com.qa.domain.Comments;
import com.qa.exception.CommentNotFoundException;
import com.qa.repo.commentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final commentRepository repo;

    @Autowired
    public CommentService(commentRepository repo) {
        this.repo = repo;
    }

    public List<Comments> readAllComments(){
        return this.repo.findAll();
    }

    public Comments createComment(Comments comment){
        return this.repo.save(comment);
    }

    public Comments findCommentById(Long id){
        return this.repo.findById(id).orElseThrow(CommentNotFoundException::new);
    }

    public Comments updateComment(Long id, Comments comment){
        Comments update = findCommentById(id);
        update.setRating(comment.getRating());
        update.setComment(comment.getComment());
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
