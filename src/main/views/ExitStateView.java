package main.views;

import main.utils.IO;

public class ExitStateView {

    public void writeExit() {
        IO.instance().writeln("Finalizado!");
    }
}
