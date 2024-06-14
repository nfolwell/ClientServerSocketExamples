import java.io.*;
import java.net.*;
import java.util.*;
 
public class SendMsgClient {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println(
                "Usage: java SendMsgClient <host name> <port number>");
            System.exit(1);
        }
        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);
        //Create Socket using the hostName of the Server (that should be running)
        Socket echoSocket = new Socket(hostName, portNumber);
        //Create a PrintWriter that we will use to send our message
        PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
        //Create a System.in Scanner so we can type in a message to send.
        Scanner s = new Scanner(System.in);
        String userInput;

        System.out.print("Scanner will read your message:");
        while ((userInput = s.nextLine())!= null)
        {
          //"out" is where the message gets passed and gets sent to the server.
          out.println(userInput);
          System.out.print("Scanner will read your message:");
        }
    }
}
