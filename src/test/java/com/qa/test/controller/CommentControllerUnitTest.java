package com.qa.test.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qa.domain.Comment;
import com.qa.controller.CommentController;
import com.qa.service.CommentService;

@RunWith(MockitoJUnitRunner.class)
public class CommentControllerUnitTest {

    @InjectMocks
    private CommentController controller;

    @Mock
    private CommentService service;

    private List<Comment> commentList;

    private Comment testComment;

    private Comment testCommentWithID;


    final long id = 1L;


    @Before
    public void init() {
        this.commentList = new ArrayList<>();
        this.testComment = new Comment("Test Commenter", 3L, "Was alright");
        this.commentList.add(testComment);
        this.testCommentWithID = new Comment(testComment.getUserName(), testComment.getRating(), testComment.getComment());
        this.testCommentWithID.setId(id);
    }

    @Test
    public void createCommentTest() {
        when(this.service.createComment(testComment)).thenReturn(this.testCommentWithID);

        assertEquals(new ResponseEntity<Comment>(this.testCommentWithID, HttpStatus.CREATED), this.controller.createComment(testComment));

        verify(this.service, times(1)).createComment(this.testComment);
    }

    @Test
    public void deleteCommentTest() {
        this.controller.deleteComment(id);

        verify(this.service, times(1)).deleteComment(id);
    }

    @Test
    public void findCommentByIDTest() {
        when(this.service.findCommentById(this.id)).thenReturn(this.testCommentWithID);

        assertEquals(new ResponseEntity<Comment>(this.testCommentWithID, HttpStatus.OK), this.controller.getCommentById(this.id));

        verify(this.service, times(1)).findCommentById(this.id);
    }

    @Test
    public void getAllCommentsTest() {

        when(service.readComments()).thenReturn(this.commentList);

        assertFalse("Controller has found no comments", Objects.requireNonNull(this.controller.getAllComments().getBody()).isEmpty());

        verify(service, times(1)).readComments();
    }

    @Test
    public void updateCommentsTest() {
        // given
        Comment newComment = new Comment("Tester Two", 1L, "I disliked it");
        Comment updatedComment = new Comment(newComment.getUserName(), newComment.getRating(), newComment.getComment());
        updatedComment.setId(this.id);

        when(this.service.updateComment(this.id, newComment)).thenReturn(updatedComment);

        assertEquals(new ResponseEntity<Comment>(updatedComment, HttpStatus.OK), this.controller.updateComment(this.id, newComment));

        verify(this.service, times(1)).updateComment(this.id, newComment);
    }

}