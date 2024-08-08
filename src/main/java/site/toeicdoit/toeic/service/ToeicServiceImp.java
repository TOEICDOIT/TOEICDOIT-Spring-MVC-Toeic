package site.toeicdoit.toeic.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import site.toeicdoit.toeic.domain.model.mysql.ToeicCategoryModel;
import site.toeicdoit.toeic.domain.model.mysql.ToeicModel;
import site.toeicdoit.toeic.repository.ToeicRepository;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class ToeicServiceImp implements ToeicService{


    private final ToeicRepository toeicRepository;


    public List<ToeicCategoryModel> getAllToeicCategory() {
        return toeicRepository.findAllByExam();
    }


    public List<ToeicCategoryModel> getAllToeicCategoryByTest() {
        return toeicRepository.findAllByTest();
    }

    public List<ToeicCategoryModel> findByLevel(Long level) {
        return toeicRepository.findAllByLevel(level);
    }

    public List<ToeicCategoryModel> findByPart(String part) {
        return toeicRepository.findAllByPart(part);
    }
}


