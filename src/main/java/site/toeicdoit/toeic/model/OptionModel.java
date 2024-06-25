package site.toeicdoit.toeic.model;

import jakarta.persistence.*;
import lombok.*;
import site.toeicdoit.toeic.common.model.BaseEntity;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity(name = "options")
@ToString(exclude = {"id"})
public class OptionModel extends BaseEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;



}
