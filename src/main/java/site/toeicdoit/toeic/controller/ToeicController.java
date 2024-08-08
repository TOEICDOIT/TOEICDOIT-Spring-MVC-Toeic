package site.toeicdoit.toeic.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import site.toeicdoit.toeic.domain.model.mysql.ToeicCategoryModel;
import site.toeicdoit.toeic.domain.model.mysql.ToeicModel;
import site.toeicdoit.toeic.service.ToeicServiceImp;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RequestMapping(path = "/api/toeic")
@Log4j2
@RestController
public class ToeicController {

    private final ToeicServiceImp toeicService;



    @GetMapping("/exam")
    public List<ToeicCategoryModel> getAllToeicCategory() {
        return toeicService.getAllToeicCategory();
    }
    @GetMapping("/test")
    public List<ToeicCategoryModel> getAllToeicCategoryByTest() {
        return toeicService.getAllToeicCategoryByTest();
    }

    @GetMapping("/level/{level}")
    public List<ToeicCategoryModel> findByLevel(@PathVariable Long level) {
        return toeicService.findByLevel(level);
    }
    @GetMapping("/part/{part}")
    public List<ToeicCategoryModel> findByPart(@PathVariable String part) {
        return toeicService.findByPart(part);
    }
}
