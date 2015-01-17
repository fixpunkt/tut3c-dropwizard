package com.example.helloworld;

import com.google.common.base.Joiner;

/**
 * Created by msteiger on 17.01.2015.
 */
public class GamePrinter {

    public static String toString(Game game) {
        StringBuilder sb = new StringBuilder();

        sb.append("+---+---+---+\n");
        for (int y = 0; y < 3; y++) {

            sb.append("|");
            for (int x = 0; x < 3; x++) {
                sb.append(" " + game.getCell(y, x) + " |");
            }
            sb.append("\n+---+---+---+\n");
        }

        return sb.toString();
    }
}
