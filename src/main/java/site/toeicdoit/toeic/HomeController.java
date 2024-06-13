package site.toeicdoit.toeic;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

import static java.time.format.DateTimeFormatter.ofPattern;

@RestController
public class HomeController {


    @GetMapping("/")
    public String home() {



        return "안녕하세요. Welcome to Toeic Level Test "+new SimpleDateFormat("yyyy년 MM월 dd일 h시 m분").format(new Date());

    }
}
