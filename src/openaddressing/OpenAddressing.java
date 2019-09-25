/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openaddressing;

import java.util.Scanner;

/**
 *
 * @author MScIT19
 */
public class OpenAddressing {

    /**
     * @param args the command line arguments
     */
    static int Hashmap[] = new int[10];

    public static void main(String[] args) {
        // TODO code application logic here

        for (int i = 0; i < 10; i++) {
            Hashmap[i] = 0;
        }
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the number you want to store in the map");
            for (int j = 0; j < 10; j++) {
                int Number = input.nextInt();
                int UniCode = Number % 10;

                if (Hashmap[UniCode] == 0) {
                    Hashmap[UniCode] = Number;
                } else {
                    while (Hashmap[UniCode] != 0) {
                        UniCode++;
                        if (UniCode > 9) {
                            UniCode = 0;
                        }
                    }
                    Hashmap[UniCode] = Number;
                }
            }
            System.out.println("Enter the number you want to crosscheck");
            int SearchNumber = input.nextInt();
            int SearchMatch = Search(SearchNumber, Hashmap);

            System.out.println("Enter the number you want to delete");
            int DeleteNumber = input.nextInt();
            SearchMatch = Search(DeleteNumber, Hashmap);
            Hashmap[SearchMatch] = 0;

            System.out.println("The numbers Stored are");
            for (int i = 0; i < 10; i++) {
                System.out.println(+Hashmap[i]);
            }

        } catch (NullPointerException e) {
            System.out.println(" map");
        }
    }

    public static int Search(int SearchNumber, int Hashmap[]) {
        boolean Stop = false;
        int KeyCode = SearchNumber % 10;
        int NoNumber = KeyCode;
        if (Hashmap[KeyCode] == SearchNumber) {
            System.out.println("The number is stored at " + KeyCode + " index");
        } else {
            while (Hashmap[KeyCode] != SearchNumber && !Stop) {

                KeyCode++;
                if (KeyCode > 9) {
                    KeyCode = 0;
                } else if (NoNumber == KeyCode) {
                    Stop = true;
                }
            }
            if (Stop == true) {
                System.out.println("The number " + SearchNumber + " doesn't exist");
            } else {
                System.out.println("The number is stored at " + KeyCode + " index");
                return KeyCode;
            }

        }
        return KeyCode;
    }

}
