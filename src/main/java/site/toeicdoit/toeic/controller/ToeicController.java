package site.toeicdoit.toeic.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.toeicdoit.toeic.domain.dto.ResultDto;
import site.toeicdoit.toeic.domain.model.mysql.ToeicCategoryModel;
import site.toeicdoit.toeic.domain.vo.Messenger;
import site.toeicdoit.toeic.service.ResultService;
import site.toeicdoit.toeic.service.ToeicCategoryService;
import site.toeicdoit.toeic.service.ToeicService;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RequestMapping(path = "/api/toeic")
@Log4j2
@RestController
public class ToeicController {

    private final ToeicCategoryService toeicCategoryService;
    private final ResultService resultService;
    private final ToeicService toeicService;

    @GetMapping("/exam")
    public ResponseEntity<List<ToeicCategoryModel>> getAllToeicCategoryByExam() {
        List<ToeicCategoryModel> categories = toeicCategoryService.findAllByExam();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/test")
    public ResponseEntity<List<ToeicCategoryModel>> getAllToeicCategoryByTest() {
        List<ToeicCategoryModel> categories = toeicCategoryService.findAllByTest();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/level/{level}")
    public ResponseEntity<List<ToeicCategoryModel>> findByLevel(@PathVariable Long level) {
        List<ToeicCategoryModel> categories = toeicCategoryService.findAllByLevel(level);
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/part/{part}")
    public ResponseEntity<List<ToeicCategoryModel>> findByPart(@PathVariable String part) {
        List<ToeicCategoryModel> categories = toeicCategoryService.findAllByPart(part);
        return ResponseEntity.ok(categories);
    }

    @PostMapping("/exam/save")
    public ResponseEntity<Messenger> saveResult(@RequestBody ResultDto resultDto) {
        Messenger response = resultService.save(resultDto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/exam/uploadChunk")
    public ResponseEntity<Messenger> uploadChunk(@RequestBody String jsonData, @RequestParam int chunkIndex, @RequestParam int totalChunks) {
        Messenger response = resultService.saveChunk(jsonData, chunkIndex, totalChunks);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/exam/user/{userId}")
    public ResponseEntity<List<ResultDto>> findAllByUserId(@PathVariable Long userId) {
        List<ResultDto> results = resultService.findByUserId(userId);
        return ResponseEntity.ok(results);
    }

    @GetMapping("/exam/user/score/{userId}")
    public ResponseEntity<List<Object[]>> findScoreByUserId(@PathVariable Long userId) {
        List<Object[]> scores = resultService.findScoreByUserId(userId);
        return ResponseEntity.ok(scores);
    }

    @GetMapping("/recent/{userId}")
    public ResponseEntity<Messenger> getRecentResults(@PathVariable Long userId) {
        Messenger response = resultService.getRecentResults(userId);
        return ResponseEntity.ok(response);
    }
}
