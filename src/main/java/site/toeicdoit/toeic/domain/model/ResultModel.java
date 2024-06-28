package site.toeicdoit.toeic.domain.model;


import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity(name = "results")
@ToString(exclude = {"id"})
public class ResultModel extends BaseModel {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userAnswer;
    private boolean isCorrect;


}
