package main.views;
import main.controllers.OperationController;
import main.controllers.OptionEnum;
import main.utils.ClosedInterval;
import main.utils.IO;

public class OptionView {

    private static final int MIN_OPTIONS = 1;

    public OperationController askForOption(OptionEnum[] options) {
        int selectedOption = 0;
        ClosedInterval validInterval = new ClosedInterval(MIN_OPTIONS, options.length);

        for(OptionEnum option: options) {
            IO.instance().writeln(option.getValue() + ". " + option.getOption());
        }

        do {
            selectedOption = IO.instance().readInt("Opcion? [" + MIN_OPTIONS + "," + options.length + "]:");

        } while (!validInterval.includes(selectedOption));
        return options[selectedOption - 1].getOperationController();
    }
}
