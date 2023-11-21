package com.education.projectteam.Dto;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;

    private int views;
    @NotEmpty
    private String image;
}
