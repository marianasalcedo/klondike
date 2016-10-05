package main.views;

import main.controllers.OptionEnum;
import main.utils.IO;

public class OptionView {

    public void writeOptions(OptionEnum[] options) {
        for(OptionEnum option: options) {
            IO.instance().writeln(option.getValue() + ". " + option.getOption());
        }
    }
}
