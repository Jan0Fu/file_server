package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.exit;

public class Server {

    private static final FileManager fileManager = new FileManager();
    private static final int PORT = 34522;

    public static void serverRun() {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started!");
            while (true) {
                try (
                        Socket socket = server.accept();
                        DataInputStream input = new DataInputStream(socket.getInputStream());
                        DataOutputStream output = new DataOutputStream(socket.getOutputStream())
                ) {
                    String receivedMsg = input.readUTF();
                    System.out.println("Received: " + receivedMsg);
                    String responseMsg = "All files were sent!";
                    output.writeUTF(responseMsg);
                    System.out.println("Sent: " + responseMsg);
                    exit(0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
