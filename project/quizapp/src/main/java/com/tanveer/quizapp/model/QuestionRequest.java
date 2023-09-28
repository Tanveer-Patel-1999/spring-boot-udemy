package com.tanveer.quizapp.model;

import lombok.Data;

@Data
public class QuestionRequest extends QuestionResponse {
    private String questionTitle;
    private String options1;
    private String options2;
    private String options3;
    private String options4;
    private String rightAnswer;
    private String difficultyLevel;
    private String category;

}
