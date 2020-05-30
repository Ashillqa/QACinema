package com.qa.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.domain.Comment;
import com.qa.repo.CommentRepository;
import com.qa.service.CommentService;

@RunWith(SpringRunner.class)
public class CommentServiceUnitTest {

    @InjectMocks
    private CommentService service;

    @Mock
    private CommentRepository repo;

    private List<Comment> commentList;

    private Comment testComment;

    private Comment testCommentWithID;

    private final long id = 1L;

    @Before
    public void init() {
        this.commentList = new ArrayList<>();
        this.commentList.add(testComment);
        this.testComment = new Comment("FilmOne","Tester One", 3L, "It was alright");
        this.testCommentWithID = new Comment(this.id,"FilmOne","Tester One", 3L, "It was alright");
    }

    @Test
    public void createCommentTest() {
        when(this.repo.save(testComment)).thenReturn(testCommentWithID);
        assertEquals(testCommentWithID, this.service.createComment(testComment));
        verify(this.repo, times(1)).save(this.testComment);
    }

    @Test
    public void deleteCommentTest() {
        when(this.repo.existsById(id)).thenReturn(true, false);
        this.service.deleteComment(id);
        verify(this.repo, times(1)).deleteById(id);
        verify(this.repo, times(2)).existsById(id);
    }


    @Test
    public void findCommentByIDTest() {
        when(this.repo.findById(this.id)).thenReturn(Optional.of(this.testCommentWithID));
        assertEquals(testCommentWithID, this.service.findCommentById(this.id));
        verify(this.repo, times(1)).findById(this.id);
    }

    @Test
    public void readCommentsTest() {
        when(repo.findAll()).thenReturn(this.commentList);
        assertFalse("Controller has found no comments", this.service.readComments().isEmpty());
        verify(repo, times(1)).findAll();
    }

    @Test
    public void updateCommentsTest() {
        Comment newComment = new Comment("BadFilm","Updated Commenter", 1L, "I disliked it");
        Comment updatedComment = new Comment(newComment.getMovieTitle(), newComment.getUserName(), newComment.getRating(), newComment.getComment());
        updatedComment.setId(this.id);
        when(this.repo.findById(this.id)).thenReturn(Optional.of(this.testCommentWithID));
        when(this.repo.save(updatedComment)).thenReturn(updatedComment);
        assertEquals(updatedComment, this.service.updateComment(this.id, newComment));
        verify(this.repo, times(1)).findById(1L);
        verify(this.repo, times(1)).save(updatedComment);
    }

}