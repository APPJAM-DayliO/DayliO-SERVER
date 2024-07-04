package muhatno.daylio.answer.presentation;

import lombok.Data;

@Data
public class AnswerCreateRequestDto {
    private String content;
    private String keyword;
    private String expression;
    private int dopaminePercentage;
    private String recommendation;
}
