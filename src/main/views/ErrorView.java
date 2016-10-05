package main.views;

import main.utils.IO;

public class ErrorView {

    private static ErrorView errorView;

    public static ErrorView instance() {
        if ( errorView == null ) {
            errorView = new ErrorView();
        }
        return errorView;
    }

    private ErrorView() {
    }

    public void writeError(String message) {
        IO.instance().writeln("ERROR!: " + message);
    }

}
