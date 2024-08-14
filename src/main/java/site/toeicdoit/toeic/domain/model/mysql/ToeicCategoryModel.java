package site.toeicdoit.toeic.domain.model.mysql;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
@ToString(exclude = {"id"})
public class ToeicCategoryModel extends BaseModel {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String sound;
    private String testType;
    private boolean take;

    @OneToMany(mappedBy = "toeicCategoryId", fetch = FetchType.LAZY)
    private List<ToeicModel> toeicIds;

    @OneToMany(mappedBy = "toeicCategoryId", fetch = FetchType.LAZY,cascade =  CascadeType.ALL, orphanRemoval = true)
    private List<ResultModel> resultIds;



}