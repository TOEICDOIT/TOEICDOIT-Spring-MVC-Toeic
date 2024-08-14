package site.toeicdoit.toeic.domain.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class ToeicDto {

    private Long id;
    private Long level;
    private String part;
    private String question;
    private String answer;
    private String description;
    private String image;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private long toeicCategoryId;

}