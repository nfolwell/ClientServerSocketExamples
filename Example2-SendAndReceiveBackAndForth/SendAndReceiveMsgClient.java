import java.io.*;
import java.net.*;
import java.util.*;
 
public class SendAndReceiveMsgClient {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println(
                "Usage: java SendAndReceiveMsgClient <host name> <port number>");
            System.exit(1);
        }
 
        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);
        Socket svrSocket = new Socket(hostName, portNumber);
        PrintWriter out = new PrintWriter(svrSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(svrSocket.getInputStream()));
        Scanner s = new Scanner(System.in);
        String userInput;
        System.out.print("Scanner will read your message:");
        userInput = s.nextLine();
        out.println(userInput);
        String serverInput = in.readLine();
        System.out.println("Message from server: "+serverInput);  
    }
}
