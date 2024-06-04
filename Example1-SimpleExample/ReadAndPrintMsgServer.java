import java.net.*;
import java.io.*;
 
public class ReadAndPrintMsgServer {
    public static void main(String[] args) throws IOException {
         
        if (args.length != 1) {
            System.err.println("Usage: java ReadAndPrintMsgServer <port number>");
            System.exit(1);
        }
         
        int portNumber = Integer.parseInt(args[0]);
        ServerSocket serverSocket = new ServerSocket(Integer.parseInt(args[0]));
        System.out.println("Server started.");
        Socket clientSocket = serverSocket.accept(); 
        System.out.println("Socket accepted..."); 
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine;
        System.out.println("Client connected.  Waiting for message");
        inputLine = in.readLine();
        System.out.println("Got client message: "+inputLine);
    }
}
