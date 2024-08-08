package site.toeicdoit.toeic.domain.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class ResultDto {

    private Long id;
    private String userAnswer;
    private String isCorrect;
    private String timeElapsed;
    private String score;
    private String lsScore;
    private String rcScore;

    private String createdAt;
    private String updatedAt;
}