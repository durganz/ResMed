package com.rps.rockpaperscissors;


import com.rps.rockpaperscissors.bean.GameResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameResultsRepository extends JpaRepository<GameResult, Integer> {

    GameResult findById(int gameId);
    List<GameResult> findByPlayerName(String playerName);
}