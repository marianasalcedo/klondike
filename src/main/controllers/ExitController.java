package main.controllers;

import main.models.enums.State;
import main.views.ExitStateView;

public class ExitController extends OperationController {

    @Override
    public void execute() {
        ExitStateView exitStateView = new ExitStateView();
        exitStateView.writeExit();
        game.setState(State.EXIT);
    }
}
