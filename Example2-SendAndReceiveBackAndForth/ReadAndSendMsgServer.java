import java.net.*;
import java.io.*;
import java.util.*;
 
public class ReadAndSendMsgServer {
    public static void main(String[] args) throws IOException {
         
        if (args.length != 1) {
            System.err.println("Usage: java ReadAndSendMsgServer <port number>");
            System.exit(1);
        }
         
        int portNumber = Integer.parseInt(args[0]);
        //Creates a socket for transfering data
        ServerSocket serverSocket = new ServerSocket(Integer.parseInt(args[0]));
        //Accepts the request from the client
        Socket clientSocket = serverSocket.accept(); 
        //"in" is the stream where the information comes in 
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        //"out" is the stream for writing out the message
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        String inputLine;
        inputLine = in.readLine();
        System.out.println("Got message: "+inputLine);
        Scanner s = new Scanner(System.in);
        System.out.print("Type a response: ");
        String outMsg = s.nextLine();
        out.println(outMsg);
    }
}
