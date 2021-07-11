package com.rps.rockpaperscissors.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@ApiModel(description="This is the description about BookInfo")
public class GameResult {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private Integer gameId;

    @ApiModelProperty(notes="Result")
    private String result;

    @ApiModelProperty(notes="Players Shape")
    private String playerShape;

    @ApiModelProperty(notes="Application Shape")
    private String applicationShape;

    @ApiModelProperty(notes="Player Name")
    private String playerName;

    public GameResult() {
        super();
    }

    public GameResult(String playerShape, String applicationShape, String result) {
        super();
        this.playerShape = playerShape;
        this.applicationShape = applicationShape;
        this.result = result;
    }
    public Integer getGameId() {
        return gameId;
    }
    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public String getPlayerShape() {
        return playerShape;
    }
    public void setPlayerShape(String playerShape) {
        this.playerShape = playerShape;
    }
    public String getApplicationShape() {
        return applicationShape;
    }
    public void setApplicationShape(String applicationShape) {
        this.applicationShape = applicationShape;
    }
    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
