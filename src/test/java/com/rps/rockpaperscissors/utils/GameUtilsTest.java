package com.rps.rockpaperscissors.utils;

import com.rps.rockpaperscissors.bean.GameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;


class GameUtilsTest {

    GameUtils gameUtils = new GameUtils();
    @Test
    @DisplayName("Test Player shape")
    public void testPlayerShape() {
        assertThat(gameUtils.generateResult("S").getPlayerShape()).isEqualTo("scissors");
        assertThat(gameUtils.generateResult("R").getPlayerShape()).isEqualTo("rock");
        assertThat(gameUtils.generateResult("P").getPlayerShape()).isEqualTo("paper");
    }

    @Test
    @DisplayName("Test Results")
    public void testResult() {
        GameResult gameResult = gameUtils.generateResult("S");
        if(gameResult.getApplicationShape().equals("scissors")) {
            assertThat(gameResult.getResult()).isEqualTo("It is a tie.");
        } else if(gameResult.getApplicationShape().equals("rock")) {
            assertThat(gameResult.getResult()).isEqualTo("Player lose.");
        } else if(gameResult.getApplicationShape().equals("paper")) {
            assertThat(gameResult.getResult()).isEqualTo("Player win.");
        }

    }
}