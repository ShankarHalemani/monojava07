package com.techlabs.app.service;

import com.techlabs.app.dto.BlogRequestDTO;
import com.techlabs.app.dto.BlogResponseDTO;
import com.techlabs.app.dto.CommentDTO;
import com.techlabs.app.entity.Blog;
import com.techlabs.app.entity.Comment;
import com.techlabs.app.exception.BlogNotFoundException;
import com.techlabs.app.exception.CommentNotFoundException;
import com.techlabs.app.repository.BlogRepository;
import com.techlabs.app.repository.CommentRepository;
import com.techlabs.app.util.PagedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;
    private final CommentRepository commentRepository;
    private final CommentService commentService;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository, CommentRepository commentRepository, CommentService commentService) {
        this.blogRepository = blogRepository;
        this.commentRepository = commentRepository;
        this.commentService = commentService;
    }

    @Override
    public Blog blogRequestDTOtoBlog(BlogRequestDTO blogRequestDTO) {
        Blog blog = new Blog();
        blog.setId(blogRequestDTO.getId());
        blog.setTitle(blogRequestDTO.getTitle());
        blog.setCategory(blogRequestDTO.getCategory());
        blog.setData(blogRequestDTO.getData());
        blog.setPublishedDate(blogRequestDTO.getPublishedDate());
        blog.setPublished(blogRequestDTO.isPublished());
        List<Comment> commentList = null;
        if (blogRequestDTO.getCommentDTOList() != null) {
            commentList =
                    blogRequestDTO.getCommentDTOList()
                            .stream()
                            .map(commentDTO -> commentService
                                    .commentDTOToComment(commentDTO, blog)).toList();
        }
        blog.setComments(commentList);

        return blog;
    }

    @Override
    public BlogResponseDTO blogToBlogResponse(Blog blog) {
        BlogResponseDTO blogResponseDTO = new BlogResponseDTO();
        blogResponseDTO.setId(blog.getId());
        blogResponseDTO.setTitle(blog.getTitle());
        blogResponseDTO.setCategory(blog.getCategory());
        blogResponseDTO.setData(blog.getData());
        blogResponseDTO.setPublishedDate(blog.getPublishedDate());
        List<CommentDTO> commentDTOList = null;
        if (blog.getComments() != null) {
            commentDTOList =
                    blog.getComments()
                            .stream()
                            .map(comment -> commentService
                                    .commentToCommentDTO(comment)).toList();
        }

        blogResponseDTO.setCommentDTOList(commentDTOList);

        return blogResponseDTO;
    }

    public List<BlogResponseDTO> getResponseList(List<Blog> blogs) {
        List<BlogResponseDTO> blogResponseDTOS = new ArrayList<>();
        for (Blog blog : blogs) {
            blogResponseDTOS.add(blogToBlogResponse(blog));
        }

        return blogResponseDTOS;
    }


    @Override
    public PagedResponse<BlogResponseDTO> getAllBlogs(int pageNumber, int size, String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase(Sort.Direction.DESC.name()) ?
                Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(pageNumber, size, sort);
        Page<Blog> blogPage = blogRepository.findAll(pageable);
        List<Blog> blogList = blogPage.getContent();
        List<BlogResponseDTO> responseDTOList = getResponseList(blogList);
        return new PagedResponse<>(responseDTOList, blogPage.getNumber(), blogPage.getSize(),
                blogPage.getTotalElements(), blogPage.getTotalPages(), blogPage.isLast());
    }

    @Override
    public BlogResponseDTO getBlogById(int id) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() ->
                        new BlogNotFoundException("Bog with ID : " + id + " not found"));

        return blogToBlogResponse(blog);
    }

    @Override
    public BlogResponseDTO createNewBlog(BlogRequestDTO blogRequestDTO) {
        Blog blog = blogRepository.save(blogRequestDTOtoBlog(blogRequestDTO));
        return blogToBlogResponse(blog);
    }

    @Override
    public BlogResponseDTO updateBlog(BlogRequestDTO blogRequestDTO) {
        blogRepository.findById(blogRequestDTO.getId())
                .orElseThrow(() ->
                        new BlogNotFoundException("Bog with ID : " + blogRequestDTO.getId() + " not found"));

        Blog blog = blogRepository.save(blogRequestDTOtoBlog(blogRequestDTO));
        return blogToBlogResponse(blog);
    }

    @Override
    public void deleteBlog(int id) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() ->
                        new BlogNotFoundException("Bog with ID : " + id + " not found"));

        if (blog != null) {
            blogRepository.delete(blog);
        }
    }

    @Override
    public BlogResponseDTO createNewComment(CommentDTO commentDTO, int id) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() ->
                        new BlogNotFoundException("Blog with ID : " + id + " not found"));

        Comment comment = commentRepository.save(commentService.commentDTOToComment(commentDTO, blog));
        blog.getComments().add(comment);
        BlogResponseDTO blogResponseDTO = blogToBlogResponse(blogRepository.save(blog));

        return blogResponseDTO;
    }

    @Override
    public BlogResponseDTO updateComment(CommentDTO commentDTO, int id) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() ->
                        new BlogNotFoundException("Blog with ID : " + id + " not found"));

        commentRepository.findById(commentDTO.getId()).orElseThrow(() ->
                new CommentNotFoundException("Comment with Id : " + commentDTO.getId() + " not found"));

        Comment comment = commentRepository.save(commentService.commentDTOToComment(commentDTO, blog));
        blog.getComments().add(comment);
        BlogResponseDTO blogResponseDTO = blogToBlogResponse(blogRepository.save(blog));

        return blogResponseDTO;
    }

    @Override
    public void deleteComment(int cid, int id) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() ->
                        new BlogNotFoundException("Blog with ID : " + id + " not found"));

        Comment comment = commentRepository.findById(cid).orElseThrow(() ->
                new CommentNotFoundException("Comment with Id : " + cid + " not found"));

        blog.getComments().remove(comment);
        commentRepository.delete(comment);
        blogRepository.save(blog);

    }

    @Override
    public void deleteBlogByCommentId(int id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() ->
                new CommentNotFoundException("Comment with Id : " + id + " not found"));
        Blog blog = comment.getBlog();
        blogRepository.delete(blog);
    }
}
