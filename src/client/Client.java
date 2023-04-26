package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    private static final ClientUserInterface ui = new ClientUserInterface();

    public static void runClient() {

        final String ADDRESS = "127.0.0.1";
        final int PORT = 34522;

        try (Socket socket = new Socket(InetAddress.getByName(ADDRESS), PORT);
             DataInputStream input = new DataInputStream(socket.getInputStream());
             DataOutputStream output = new DataOutputStream(socket.getOutputStream())) {

            System.out.println("Client started!");
            ui.start();
            String sentMessage = "Give me everything you have!";
            output.writeUTF(sentMessage);
            System.out.println("Sent: " + sentMessage);
            String receivedMsg = input.readUTF();
            System.out.println("Received: " + receivedMsg);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
