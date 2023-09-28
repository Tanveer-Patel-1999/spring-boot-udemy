package com.tanveer.quizapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Question_Table")
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String questionTitle;
    private String options1;
    private String options2;
    private String options3;
    private String options4;
    private String rightAnswer;
    private String difficultyLevel;

    private String category;
}
