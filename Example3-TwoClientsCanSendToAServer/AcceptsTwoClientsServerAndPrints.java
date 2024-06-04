import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
 
public class AcceptsTwoClientsServerAndPrints {
    public static void main(String[] args) throws IOException {
         
        if (args.length != 1) {
            System.err.println("Usage: java ReadAndPrintMsgServer <port number>");
            System.exit(1);
        }
         
        int portNumber = Integer.parseInt(args[0]);
        ServerSocket serverSocket = new ServerSocket(Integer.parseInt(args[0]));
        System.out.println("Server started.");
        //This is the part that will need to use threads
        while (true)
        {
            Socket clientSocket = serverSocket.accept(); 
            System.out.println("Socket accepted..."); 
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;
            System.out.println("Client connected.  Waiting for message");
            inputLine = in.readLine();
            System.out.println("Got client message: "+inputLine);
        }
    }
}
