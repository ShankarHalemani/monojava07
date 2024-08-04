package com.techlabs.app.service;

import com.techlabs.app.dto.CommentDTO;
import com.techlabs.app.entity.Blog;
import com.techlabs.app.entity.Comment;

public interface CommentService {
    Comment commentDTOToComment(CommentDTO commentDTO, Blog blog);

    CommentDTO commentToCommentDTO(Comment comment);
}
