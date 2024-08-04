package com.techlabs.app.service;

import com.techlabs.app.dto.BlogRequestDTO;
import com.techlabs.app.dto.BlogResponseDTO;
import com.techlabs.app.dto.CommentDTO;
import com.techlabs.app.entity.Blog;
import com.techlabs.app.util.PagedResponse;

public interface BlogService {
    PagedResponse<BlogResponseDTO> getAllBlogs(int pageNumber, int size, String sortBy, String direction);

    BlogResponseDTO getBlogById(int id);

    BlogResponseDTO createNewBlog(BlogRequestDTO blogRequestDTO);

    BlogResponseDTO updateBlog(BlogRequestDTO blogRequestDTO);

    void deleteBlog(int id);

    Blog blogRequestDTOtoBlog(BlogRequestDTO blogRequestDTO);

    BlogResponseDTO blogToBlogResponse(Blog blog);

    BlogResponseDTO createNewComment(CommentDTO commentDTO, int id);

    BlogResponseDTO updateComment(CommentDTO commentDTO, int id);

    void deleteComment(int cid, int id);

    void deleteBlogByCommentId(int id);
}
