package com.qa.service;

import com.qa.domain.Comment;
import com.qa.exceptions.CommentNotFoundException;
import com.qa.repo.CommentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository repo;

    private final ModelMapper mapper;

    @Autowired
    public CommentService(CommentRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    private Comment mapTo(Comment comment
    ){
        return this.mapper.map(comment
                , Comment.class);
    }


    public List<Comment> readComments(){
        return this.repo.findAll().stream().map(this::mapTo).collect(Collectors.toList());
    }

    public Comment createComment(Comment comment
    ){
        Comment tempComment = this.repo.save(comment
        );
        return this.mapTo(tempComment);
    }

    public Comment findCommentById(Long id){
        return this.mapTo(this.repo.findById(id)
                .orElseThrow(CommentNotFoundException::new));
    }

    public Comment updateComment(Long id, Comment comment
    ){
        Comment update = this.repo.findById(id).orElseThrow(CommentNotFoundException::new);
        update.setUserName(comment
                .getUserName());
        update.setComment(comment
                .getComment());
        update.setRating(comment
                .getRating());
        Comment tempComment = this.repo.save(comment
        );
        return this.mapTo(tempComment);
    }

    public boolean deleteComment(Long id){
        if(!this.repo.existsById(id)){
            throw new CommentNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }


}
