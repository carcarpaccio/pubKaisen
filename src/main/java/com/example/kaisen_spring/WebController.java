package com.example.kaisen_spring;
import com.example.kaisen_spring.Service.GameService;
import com.example.kaisen_spring.Service.ResultService;
import com.example.kaisen_spring.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class WebController {
    @Autowired
    GameService gameService;
    @Autowired
    ResultService resultService;

    @GetMapping("Menu")
    public String get(Model model){
        return "menu.html";
    }
    @PostMapping("Menu")
    public String post(Model model,int width,int length){
        gameService.settingGame(width,length);

        model.addAttribute("player", gameService.getMyField());
        model.addAttribute("cpu", gameService.getEnemyField());

        return "game.html";
    }
    @PostMapping("Game")
    public String game(Model model,int width,int length){

        String page= gameService.update(width,length);

        model.addAttribute("player", gameService.getMyField());
        model.addAttribute("cpu", gameService.getEnemyField());

        return page;
    }
    @PostMapping("Result")
    public String result(Model model){
        List<Result> previousResults=resultService.findAll();
        model.addAttribute("previousResults",previousResults);
        resultService.register(gameService.getResult(),gameService.getTurn());
        model.addAttribute("result",gameService.getResult().toString()+":"+gameService.getTurn()+"手目");

        return "result";
    }
}
