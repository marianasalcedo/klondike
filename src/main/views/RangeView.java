package main.views;

import main.utils.ClosedInterval;
import main.utils.IO;

public class RangeView {

    public final static int MIN_RANGE = 1;

    public int askForRange(int min, int max, String message) {
        if (min < MIN_RANGE) {
            min = MIN_RANGE;
        }
        ClosedInterval validInterval = new ClosedInterval(min, max);

        int selectedOption = 0;
        Boolean error = false;
        do {
            if ( error ) {
                ErrorView.instance().writeError("El rango es entre " + min + " y " + max + " (inclusives)");
            }
            selectedOption = IO.instance().readInt(message + " [" + min + "," + max + "]:");
            error = true;
        } while (!validInterval.includes(selectedOption));
        return (selectedOption - 1);
    }
}
