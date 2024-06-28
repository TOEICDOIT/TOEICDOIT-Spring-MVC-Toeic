package site.toeicdoit.toeic.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import site.toeicdoit.toeic.domain.model.ToeicModel;
import site.toeicdoit.toeic.repository.ResultRepository;
import site.toeicdoit.toeic.repository.ToeicRepository;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class ToeicServiceImp implements ToeicService{

    private final ToeicRepository toeicRepository;

    public ToeicModel getRandomQuiz() {
        List<ToeicModel> quizzes  = toeicRepository.findRandomQuiz();
        return quizzes.isEmpty() ? null : quizzes.get(0);
    }


}
