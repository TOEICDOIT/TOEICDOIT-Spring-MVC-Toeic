package site.toeicdoit.toeic.domain.model;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity(name = "options")
@ToString(exclude = {"id"})
public class OptionModel extends BaseModel {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;



}
