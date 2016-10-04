package main.enums;


import main.utils.ClosedInterval;

import java.util.Scanner;

public enum OptionEnum {
    PLAY_DECK_TO_PILE(1, "Mover de baraja a descarte"),
    PILE_TO_PLAY_DECK(2, "Mover de descarte a baraja"),
    PILE_TO_SUIT(3, "Mover de descarte a palo"),
    PILE_TO_LADDER(4, "Mover de descarte a baraja"),
    LADDER_TO_FOUNDATION(5, "Mover de escalera a palo"),
    LADDER_TO_LADDER(6, "Mover de escalera a escalera"),
    FOUNDATION_TO_LADDER(7, "Mover de descarte a baraja"),
    TURN_INTO_LADDER(8, "Voltear en escalera"),
    EXIT(9, "Salir");


    private static final int MIN_OPTIONS = 1;
    private static final int MAX_OPTIONS = 9;
    private static ClosedInterval interval = new ClosedInterval(MIN_OPTIONS, MAX_OPTIONS);

    private int value;
    private String option;

    OptionEnum(int value, String option) {
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

    public static OptionEnum getOption(){
        printAllOptions();
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        while (!interval.includes(option)) {
            System.out.println("La opción debe ser entre 1 y 9 inclusives.");
            option = scanner.nextInt();
        }
        return OptionEnum.values()[option];
    }
}
