package com.techlabs.app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BlogRequestDTO {
    private int id;

    @NotBlank(message = "Title Cannot be blank")
    @Size(min = 2,max = 50, message = "Title should have at least 2 to 50 characters")
    private String title;

    @NotBlank
    private String category;

    @NotBlank
    private String data;

    private LocalDateTime publishedDate;

    @NotNull
    private boolean published;

    private List<CommentDTO> commentDTOList;

    @Override
    public String toString() {
        return "BlogRequestDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", data='" + data + '\'' +
                ", publishedDate=" + publishedDate +
                ", published=" + published +
                ", commentDTOList=" + commentDTOList +
                '}';
    }
}
