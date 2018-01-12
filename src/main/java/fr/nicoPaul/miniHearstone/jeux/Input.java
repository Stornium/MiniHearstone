package fr.nicoPaul.miniHearstone.jeux;

import java.util.Scanner;

/**
 * @author nicolas paul
 * @version 1
 * @since 1
 */
public class Input {

    private static Scanner sc = new Scanner(System.in);

    /**
     * @param s affichage
     *
     * @return int input
     */
    public static int getIntInput(String s) {
        System.out.print(s.equals("") ?
                "-> " :
                s + " -> ");
        String s1 = sc.nextLine();
        try {
            return Integer.parseInt(s1);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * @param s affichage
     *
     * @return string input
     */
    public static String getStringInput(String s) {
        System.out.print(s.equals("") ?
                "-> " :
                s + " -> ");
        return sc.nextLine();
    }
}
