package com.qa.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.domain.Comment;
import com.qa.repo.CommentRepository;
import com.qa.service.CommentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceIntegrationTest {

    @Autowired
    private CommentService service;

    @Autowired
    private CommentRepository repo;

    private Comment testComment;

    @Before
    public void init() {
        this.testComment = new Comment("Tester One", 3L, "It was alright");
        this.repo.deleteAll();
        this.testComment = this.repo.save(this.testComment);
    }

    @Test
    public void testCreateComment() {
        assertEquals(this.testComment, this.service.createComment(testComment));
    }

    @Test
    public void testDeleteComment() {
        assertThat(this.service.deleteComment(this.testComment.getId())).isFalse();
    }

    @Test
    public void testFindCommentByID() {
        assertThat(this.service.findCommentById(this.testComment.getId())).isEqualTo(this.testComment);
    }

    @Test
    public void testReadComments() {
        assertThat(this.service.readComments()).isEqualTo(Stream.of(testComment).collect(Collectors.toList()));
    }

    @Test
    public void testUpdateComment() {
        Comment newComment = new Comment(testComment.getId(),"Tester Two", 2L, "It was worse than he said");

        assertThat(this.service.updateComment(this.testComment.getId(), newComment)).isEqualTo((newComment));
    }

}