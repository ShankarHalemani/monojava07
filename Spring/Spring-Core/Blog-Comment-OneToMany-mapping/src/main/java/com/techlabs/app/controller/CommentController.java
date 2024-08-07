package com.techlabs.app.controller;

import com.techlabs.app.dto.BlogResponseDTO;
import com.techlabs.app.dto.CommentDTO;
import com.techlabs.app.service.BlogService;
import com.techlabs.app.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private BlogService blogService;
    private CommentService commentService;

    @Autowired
    public CommentController(BlogService blogService, CommentService commentService) {
        this.blogService = blogService;
        this.commentService = commentService;
    }

    @Operation(summary = "Add comment to Blog by Blog ID")
    @PostMapping("/add/blogId/{id}")
    public ResponseEntity<BlogResponseDTO> addNewComment(@Valid @RequestBody CommentDTO commentDTO,
                                                         @Valid @PathVariable(name = "id") int id) {
        BlogResponseDTO blogResponseDTO = blogService.createNewComment(commentDTO, id);
        return new ResponseEntity<>(blogResponseDTO, HttpStatus.CREATED);
    }

    @Operation(summary = "Update comment for particular Blog by Blog ID")
    @PutMapping("/update/blogId/{id}")
    public ResponseEntity<BlogResponseDTO> updateComment(@Valid @RequestBody CommentDTO commentDTO,
                                                         @Valid @PathVariable(name = "id") int id) {
        BlogResponseDTO blogResponseDTO = blogService.updateComment(commentDTO, id);
        return new ResponseEntity<>(blogResponseDTO, HttpStatus.OK);
    }

    @Operation(summary = "Delete particular comment for particular blog")
    @DeleteMapping("/delete/commentId/{cid}/blogId/{id}")
    public ResponseEntity<Object> deleteComment(@Valid @PathVariable(name = "cid") int cid,
                                                @Valid @PathVariable(name = "id") int id) {
        blogService.deleteComment(cid, id);
        return ResponseEntity.status(HttpStatus.OK).body("Comment with comment Id : " + cid +
                " from Blog with blog Id : " + id + " deleted successfully");
    }


}
