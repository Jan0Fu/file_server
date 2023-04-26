package client;

import server.FileManager;

import java.util.Scanner;

public class ClientUserInterface {

    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        boolean running = true;
        while (running) {
            System.out.print("Enter action (1 - get a file, 2 - create a file, 3 - delete a file): ");
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                running = false;
            } else if (input.matches("[123]")) {

            } else {
                System.out.println("Wrong input");
            }
        }
    }
}
