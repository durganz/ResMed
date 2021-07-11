package com.rps.rockpaperscissors.utils;


import com.rps.rockpaperscissors.bean.GameResult;
import com.rps.rockpaperscissors.exception.ShapeNotFoundException;

import java.util.Random;

public class GameUtils {
    enum PlayerOptions
    {
        rock(0),
        paper(1),
        scissors(2);

        private int type;
        PlayerOptions(int type) {
            this.type = type;
        }

        public int getType(){ return type; }
    }

    public GameResult generateResult(String shape) {
        GameResult gameResult = new GameResult();
        PlayerOptions playerSelection = getPlayerSelection(shape);
        final int computerDraw = getComputerDraw();
        gameResult.setApplicationShape(PlayerOptions.values()[computerDraw].name());
        if(playerSelection != null) {
            gameResult.setPlayerShape(playerSelection.name());
            String result = checkResult(computerDraw, playerSelection.getType());
            gameResult.setResult(result);
        } else {
            throw new ShapeNotFoundException("Invalid Shape");
        }
        return gameResult;
    }

    public static int getComputerDraw() {
        final Random random = new Random();
        return random.nextInt(3);
    }

    private static PlayerOptions getPlayerSelection(String shape) {
        PlayerOptions playerSelection = null;
        if (shape.equalsIgnoreCase("S")) {
            playerSelection = PlayerOptions.scissors;
        } else if (shape.equalsIgnoreCase("R")) {
            playerSelection = PlayerOptions.rock;
        } else if (shape.equalsIgnoreCase("P")) {
            playerSelection = PlayerOptions.paper;
        }
        return playerSelection;
    }
    private static String checkResult(int computerDraw, int playerDraw) {
        String result = null;
        if(computerDraw == playerDraw){
            result = "It is a tie.";
        } else if (computerDraw > playerDraw) {
            if(computerDraw - playerDraw == 1) {
                result = "Player lose.";
            } else {
                result = "Player win.";
            }
        }
        else if (computerDraw < playerDraw) {
            if((playerDraw - computerDraw) == 1) {
                result = "Player win.";
            } else {
                result = "Player lose.";
            }
        }
        return result;
    }
}
