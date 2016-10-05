package main.controllers;

import main.views.OptionView;
import main.views.RangeView;

public class OptionBuilder {

    private OptionEnum[] options;

    private RangeView rangeView;

    private OptionView optionView;

    public OptionBuilder() {
        options = OptionEnum.values();
        rangeView = new RangeView();
        optionView = new OptionView();
    }

    public OperationController getOptionController() {
        optionView.writeOptions(options);
        int index = rangeView.askForRange(0, options.length, "Opcion?");
        return options[index].getOperationController();
    }
}
