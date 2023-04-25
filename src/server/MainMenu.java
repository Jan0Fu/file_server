package server;

import java.util.Scanner;

public class MainMenu {

    private final Scanner scanner = new Scanner(System.in);
    private final FileManager fileManager = new FileManager();

    public void start() {
        boolean running = true;
        while (running) {
            String[] inputs = scanner.nextLine().split(" ");
            switch (inputs[0]) {
                case "exit" -> running = false;
                case "add" -> fileManager.addFile(inputs[1]);
                case "get" -> fileManager.getFile(inputs[1]);
                case "delete" -> fileManager.deleteFile(inputs[1]);
            }
        }
    }
}
