package com.rps.rockpaperscissors;

import com.rps.rockpaperscissors.bean.GameReport;
import com.rps.rockpaperscissors.bean.GameResult;
import com.rps.rockpaperscissors.exception.ShapeNotFoundException;
import com.rps.rockpaperscissors.utils.GameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    private GameResultsRepository gameResultsRepository;


    @GetMapping("/rps/{playerName}/{shape}")
    public GameReport round(@PathVariable("playerName") String playerName, @PathVariable("shape") String shape) {
        if(playerName == null || shape == null){
            throw new ShapeNotFoundException("Invalid Shape or Player Name");
        }
        GameUtils gameUtils = new GameUtils();
        GameResult gameResult = gameUtils.generateResult(shape);
        gameResult.setPlayerName(playerName);
        GameReport report = new GameReport();
        report.setGameResult(gameResult);
        List<GameResult> results = gameResultsRepository.findByPlayerName(playerName);
        report.setReport(results);
        gameResultsRepository.save(gameResult);
        return report;
    }
}
