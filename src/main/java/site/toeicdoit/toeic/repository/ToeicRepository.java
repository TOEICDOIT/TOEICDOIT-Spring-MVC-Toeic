package site.toeicdoit.toeic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import site.toeicdoit.toeic.domain.model.mysql.ToeicCategoryModel;
import site.toeicdoit.toeic.domain.model.mysql.ToeicModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface ToeicRepository extends JpaRepository<ToeicCategoryModel, Long> {


///find-all-by-XXX
    @Query("select tcm FROM ToeicCategoryModel tcm where tcm.testType= 'exam'")
    List<ToeicCategoryModel> findAllByExam();


    @Query("select tcm FROM ToeicCategoryModel tcm where tcm.testType= 'test'")
    List<ToeicCategoryModel> findAllByTest();

    @Query("SELECT tcm FROM ToeicCategoryModel tcm JOIN FETCH tcm.toeicIds tm WHERE tcm.testType = 'level' AND tm.level = :level")
    List<ToeicCategoryModel> findAllByLevel(@Param("level") Long level);

    @Query("SELECT tcm FROM ToeicCategoryModel tcm JOIN FETCH tcm.toeicIds tm WHERE tcm.testType = 'part' AND tm.part = :part")
    List<ToeicCategoryModel> findAllByPart(@Param("part") String part);





}

