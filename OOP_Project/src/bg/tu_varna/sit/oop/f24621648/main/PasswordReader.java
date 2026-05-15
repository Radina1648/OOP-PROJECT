package bg.tu_varna.sit.oop.f24621648.main;

import java.io.IOException;

public class PasswordReader {

    public static String readPassword() {

        StringBuilder password = new StringBuilder();

        try {

            while (true) {

                int ch = System.in.read();

                if (ch == '\r' || ch == '\n') {
                    System.out.println();
                    break;
                }

                password.append((char) ch);

                System.out.print("*");
            }

        } catch (IOException e) {

            System.out.println("Error reading password.");
        }

        return password.toString();
    }
}