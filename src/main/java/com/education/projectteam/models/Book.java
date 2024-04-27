package com.education.projectteam.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String Author;

    @Column
    private String description;

    @Column
    private int views;

//    @Lob
//    private byte[] image;

    @Lob
    private String image;
}
