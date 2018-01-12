package fr.nicoPaul.miniHearstone.jeux;

import java.util.Scanner;

/**
 * @author nicolas paul
 * @since 1
 * @version 1
 */
public class Input {

    private static Scanner sc = new Scanner(System.in);

    public static int getIntInput(String s){
        System.out.print(s.equals("")?
                "-> ":
                s+" -> ");
        String s1 = sc.nextLine();
        try {
            return Integer.parseInt(s1);
        }catch (NumberFormatException e){
            return -1;
        }
    }

    public static String getStringInput(String s){
        System.out.print(s.equals("")?
                "-> ":
                s+" -> ");
        return sc.nextLine();
    }
}
