package main.controllers;


public enum OptionEnum {
    PLAY_DECK_TO_PILE(1, "Mover de baraja a descarte", new PlayDeckToPileController()),
    PILE_TO_PLAY_DECK(2, "Mover de descarte a baraja", new ExitController()),
    PILE_TO_SUIT(3, "Mover de descarte a palo", new ExitController()),
    PILE_TO_LADDER(4, "Mover de descarte a baraja", new ExitController()),
    LADDER_TO_FOUNDATION(5, "Mover de escalera a palo", new ExitController()),
    LADDER_TO_LADDER(6, "Mover de escalera a escalera", new ExitController()),
    FOUNDATION_TO_LADDER(7, "Mover de descarte a baraja", new ExitController()),
    TURN_INTO_LADDER(8, "Voltear en escalera", new ExitController()),
    EXIT(9, "Salir", new ExitController());

    private int value;
    private String option;
    private OperationController operationController;

    OptionEnum(int value, String option, OperationController operationController) {
        this.option = option;
        this.value = value;
        this.operationController = operationController;
    }

    public int getValue() {
        return value;
    }

    public String getOption() {
        return option;
    }

    public OperationController getOperationController() {
        return operationController;
    }
}
