package site.toeicdoit.toeic.model;

import jakarta.persistence.*;
import lombok.*;
import site.toeicdoit.toeic.common.model.BaseEntity;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity(name = "toeics")
@ToString(exclude = {"id"})
public class ToeicModel extends BaseEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long level;
    private String question;
    private String answer;
    private String description;
    private String image; //문제 이미지
    private String sound; // 음원
    private String script; // 정답 음원
    private String title; // 기출제목
    private boolean take; // 사용자가 풀었는지 여부






}
