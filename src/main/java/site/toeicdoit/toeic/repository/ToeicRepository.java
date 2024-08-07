package site.toeicdoit.toeic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import site.toeicdoit.toeic.domain.model.mysql.ToeicCategoryModel;
import site.toeicdoit.toeic.domain.model.mysql.ToeicModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface ToeicRepository extends JpaRepository<ToeicCategoryModel, Long> {



    @Query("select tcm FROM ToeicCategoryModel tcm where tcm.testType= 'exam'")
    List<ToeicCategoryModel> findAllToeicCategory();

    @Query("select tcm FROM ToeicCategoryModel tcm where tcm.testType= 'level'")
    List<ToeicCategoryModel> findAllToeicCategoryByLevel();

    @Query("select tcm FROM ToeicCategoryModel tcm where tcm.testType= 'test'")
    List<ToeicCategoryModel> findAllToeicCategoryByTest();
}

