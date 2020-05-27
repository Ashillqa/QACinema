package com.qa.test.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.qa.domain.Comment;
import com.qa.repo.CommentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CommentControllerIntegrationTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private CommentRepository repo;

    private long id;

    private Comment testComment;

    private Comment testCommentWithID;


    @Before
    public void init() {
        this.repo.deleteAll();
        this.testComment = new Comment("Tester One", 3L, "It was alright");
        this.testCommentWithID = this.repo.save(this.testComment);
        this.id = this.testCommentWithID.getId();
    }

    @Test
    public void testCreateComment() throws Exception {
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/createComment");
        mockRequest.contentType(MediaType.APPLICATION_JSON);
        mockRequest.content(testCommentWithID.toString());
        mockRequest.accept(MediaType.APPLICATION_JSON);
        ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();
        ResultMatcher matchContent = MockMvcResultMatchers.content().json(testCommentWithID.toString());
        this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
    }

    @Test
    public void testDeleteComment() throws Exception {
        this.mock.perform(request(HttpMethod.DELETE, "/deleteComment/" + this.id)).andExpect(status().isNoContent());
    }

    @Test
    public void testGetAllComments() throws Exception {
        List<Comment> commentList = new ArrayList<>();
        commentList.add(this.testCommentWithID);

        String content = this.mock.perform(request(HttpMethod.GET, "/getAllComments").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertEquals(testCommentWithID.listToJsonString(commentList), content);
    }

    @Test
    public void testUpdateComment() throws Exception {
        Comment newComment = new Comment("Tester Two", 2L, "It was worse than he said");
        newComment.setId(testCommentWithID.getId());
        Comment updatedComment = new Comment(newComment.getId(), newComment.getUserName(), newComment.getRating(), newComment.getComment());

        String result = this.mock
                .perform(request(HttpMethod.PUT, "/updateComment/" + this.id).accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON).content(newComment.toString()))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertEquals(updatedComment.toString(), result);
    }

}