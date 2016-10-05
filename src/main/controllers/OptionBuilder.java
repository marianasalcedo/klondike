package main.controllers;

import main.views.OptionView;

public class OptionBuilder {

    private OptionEnum[] options;

    private OptionView optionView;

    public OptionBuilder() {
        options = OptionEnum.values();
        optionView = new OptionView();
    }

    public OperationController getOptionController() {
        return optionView.askForOption(options);
    }
}
