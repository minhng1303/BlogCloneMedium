package com.hanu.mediumclone.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

import java.time.Instant;

@Entity
@Table(name = "post")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    @NotEmpty(message = "Title can not be empty")
    @Max(value = 50, message = "Exceed title limit (50 characters)")
    private String title;

    @Column(nullable = false)
    @NotEmpty(message = "Content can not be empty")
    private String content;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    @NotEmpty(message = "Author can not be empty")
    private Author author;

    @Column(name = "created_at",nullable = false)
    private Instant createdAt;

}

