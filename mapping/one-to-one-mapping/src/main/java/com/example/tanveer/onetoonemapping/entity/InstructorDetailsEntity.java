package com.example.tanveer.onetoonemapping.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "instructor_detail")
public class InstructorDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;

}
