package site.toeicdoit.toeic.model;


import jakarta.persistence.*;
import lombok.*;
import site.toeicdoit.toeic.common.model.BaseEntity;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity(name = "results")
@ToString(exclude = {"id"})
public class ResultModel extends BaseEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userAnswer;
    private boolean isCorrect;


}
