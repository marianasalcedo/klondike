package main.controllers;

import main.models.Game;

public abstract class OperationController {

    protected Game game;

    public abstract void execute();

    public void setGame(Game game) {
        this.game = game;
    }
}
