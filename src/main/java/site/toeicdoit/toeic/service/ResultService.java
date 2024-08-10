package site.toeicdoit.toeic.service;

import site.toeicdoit.toeic.domain.dto.ResultDto;
import site.toeicdoit.toeic.domain.dto.ToeicDto;
import site.toeicdoit.toeic.domain.model.mysql.ResultModel;
import site.toeicdoit.toeic.domain.vo.Messenger;

import java.util.stream.Collectors;

public interface ResultService extends QueryService<ResultDto>, CommandService<ResultDto> {

    default ResultModel dtoToEntity(ResultDto dto) {
        // List<ResultDataDto>를 원하는 형식으로 변환
        String formattedUserAnswer = dto.getData().stream()
                .map(ResultDto.ResultDataDto::toString) // toString()을 사용하여 형식화
                .collect(Collectors.joining(", ")); // 구분자로 ", " 사용

        return ResultModel.builder()
                .id(dto.getId())
                .timeElapsed(dto.getTimeElapsed())
                .score(dto.getScore())
                .rcScore(dto.getRcScore())
                .lcScore(dto.getLcScore())
                .userAnswer(formattedUserAnswer) // 변환된 문자열 저장
                .build();
    }

    default ResultDto entityToDto(ResultModel entity) {
        // Implement the conversion logic here
        return ResultDto.builder()
                .id(entity.getId())
                .score(entity.getScore())
                .rcScore(entity.getRcScore())
                .lcScore(entity.getLcScore())
                .timeElapsed(entity.getTimeElapsed())
                .userAnswer(entity.getUserAnswer())
                .build();
    }

    Messenger saveFromJson(String jsonData); // 추가된 메소드


    // Ensure ResultDto save method is defined here
    Messenger save(ResultDto dto);


    Messenger evaluateAndSave(ResultDto resultDto);

}
