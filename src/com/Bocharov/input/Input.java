package com.Bocharov.input;

import java.util.Scanner;

/**
 * Created by Nodyke on 24.03.2016.
 */
public class Input {
    public String getFilename() //Что надо ввести?
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter filename: ");
        return in.nextLine();
    }

    public int getLength() {
        Scanner in = new Scanner(System.in);
        int length;
        while (true) {
            try {
                System.out.println("Введите длину слов:");
                length = in.nextInt();
                if (length >= 0) return length;
                System.err.println("Введено отрицательное число!");
            }
            catch (Exception a) {
                System.err.println("Неправильно введено число!");
                in.next();
            }
        }
    }

}
