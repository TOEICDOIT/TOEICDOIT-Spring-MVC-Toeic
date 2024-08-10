package site.toeicdoit.toeic.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.toeicdoit.toeic.domain.dto.ResultDto;
import site.toeicdoit.toeic.domain.dto.ToeicDto;
import site.toeicdoit.toeic.domain.model.mysql.ResultModel;
import site.toeicdoit.toeic.domain.model.mysql.ToeicModel;
import site.toeicdoit.toeic.domain.vo.Messenger;
import site.toeicdoit.toeic.repository.ResultRepository;
import site.toeicdoit.toeic.repository.ToeicRepository;
import site.toeicdoit.toeic.service.ResultService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class ResultServiceImpl implements ResultService {

    private final ResultRepository resultRepository;
    private final ObjectMapper objectMapper;
    private final ToeicRepository toeicRepository;




    @Override
    public Messenger deleteById(Long id) {
        return null;
    }

    @Override
    public Messenger modify(ResultDto resultDto) {
        return null;
    }

    @Override
    public List<ResultDto> findAll() {
        return List.of();
    }

    @Override
    public Optional<ResultDto> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Boolean existsById(Long id) {
        return null;
    }

    @Override
    public Messenger saveFromJson(String jsonData) {
        try {
            // JSON 문자열을 ResultDto로 변환
            ResultDto resultDto = objectMapper.readValue(jsonData, ResultDto.class);

            // ResultDto를 ResultModel로 변환
            ResultModel entity = dtoToEntity(resultDto);
            resultRepository.save(entity);

            return Messenger.builder()
                    .message("Result saved successfully")
                    .data(entityToDto(entity))
                    .build();
        } catch (IOException e) {
            log.error("Error parsing JSON data", e);
            return Messenger.builder()
                    .message("Error saving result")
                    .build();
        }
    }

    @Override
    public Messenger save(ResultDto dto) {
        ResultModel entity = dtoToEntity(dto);
        resultRepository.save(entity);
        return Messenger.builder()
                .message("Result saved successfully")
                .data(entityToDto(entity))
                .build();
    }
//    public List<ToeicModel> getCorrectAnswers(List<Long> toeicIds) {
//        // toeicIds를 이용하여 DB에서 정답 목록을 조회
//        return toeicRepository.findById(toeicIds);
//    }

    @Override
    public Messenger evaluateAndSave(ResultDto resultDto) {
//        // 사용자 답변에서 toeicId 리스트 추출
//        List<Long> toeicIds = resultDto.getData().stream()
//                .map(ResultDto.ResultDataDto::getToeicId)
//                .collect(Collectors.toList());
//
//        // DB에서 정답 가져오기
//        List<ToeicModel> correctAnswers = getCorrectAnswers(toeicIds);
//
//        // 3. 정답 비교
//        int score = 0;
//        for (ResultDto.ResultDataDto userAnswer : resultDto.getData()) {
//            Long toeicId = userAnswer.getToeicId();
//            String userAnswerValue = userAnswer.getAnswer();
//
//            // 정답을 찾고 비교
//            Optional<ToeicModel> correctAnswer = correctAnswers.stream()
//                    .filter(answer -> answer.getId().equals(toeicId))
//                    .findFirst();
//
//            if (correctAnswer.isPresent() && correctAnswer.get().getAnswer().equals(userAnswerValue)) {
//                score++;
//            }
//        }
//
//        // 4. 결과 저장
//        resultDto.setScore(score);
//        return resultDto;
        return null;
    }

}
