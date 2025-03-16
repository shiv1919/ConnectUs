package com.example.ConnectUs.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post_images")
public class PostImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String imagename;

    @Column(name = "type")
    private String imagetype;

    @Lob
    @Column(name = "data", columnDefinition = "LONGBLOB")
    private byte[] imagedata;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "post_id")
    Post post;
}
