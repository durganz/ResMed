package com.rps.rockpaperscissors.bean;

import java.util.List;

public class GameReport {
    private GameResult gameResult;

    public GameResult getGameResult() {
        return gameResult;
    }

    public void setGameResult(GameResult gameResult) {
        this.gameResult = gameResult;
    }

    public List<GameResult> getReport() {
        return report;
    }

    public void setReport(List<GameResult> report) {
        this.report = report;
    }

    private List<GameResult> report;

}
