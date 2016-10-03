package main.enums;


import main.utils.ClosedInterval;

import java.util.Scanner;

public enum Option {
    PLAY_DECK_TO_PILE("Mover de baraja a descarte", 1),
    PILE_TO_PLAY_DECK("Mover de descarte a baraja", 2),
    PILE_TO_SUIT("Mover de descarte a palo", 3),
    PILE_TO_LADDER("Mover de descarte a baraja", 4),
    LADDER_TO_FOUNDATION("Mover de escalera a palo", 5),
    LADDER_TO_LADDER("Mover de escalera a escalera", 6),
    FOUNDATION_TO_LADDER("Mover de descarte a baraja", 7),
    TURN_INTO_LADDER("Voltear en escalera", 8),
    EXIT("Salir", 9);


    private static final int MAX_OPTIONS = 9;
    private static final int MIN_OPTIONS = 1;
    private static ClosedInterval interval = new ClosedInterval(MIN_OPTIONS, MAX_OPTIONS);

    private String option;
    private int value;

    Option(String option, int value) {
        this.option = option;
        this.value = value;
    }

    private static void printAllOptions(){
        System.out.println(PLAY_DECK_TO_PILE.value + ". " + PLAY_DECK_TO_PILE.option);
        System.out.println(PILE_TO_PLAY_DECK.value + ". " + PILE_TO_PLAY_DECK.option);
        System.out.println(PILE_TO_SUIT.value + ". " + PILE_TO_SUIT.option);
        System.out.println(PILE_TO_LADDER.value + ". " + PILE_TO_LADDER.option);
        System.out.println(LADDER_TO_FOUNDATION.value + ". " + LADDER_TO_FOUNDATION.option);
        System.out.println(LADDER_TO_LADDER.value + ". " + LADDER_TO_LADDER.option);
        System.out.println(FOUNDATION_TO_LADDER.value + ". " + FOUNDATION_TO_LADDER.option);
        System.out.println(TURN_INTO_LADDER.value + ". " + TURN_INTO_LADDER.option);
        System.out.println(EXIT.value + ". " + EXIT.option);
        System.out.println("Opción?: [1-9]");
    }

    public static int getOption(){
        printAllOptions();
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        while (!interval.includes(option)) {
            System.out.println("La opción debe ser entre 1 y 9 inclusives.");
            option = scanner.nextInt();
        }
        return option;
    }
}
