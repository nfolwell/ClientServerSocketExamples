import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
 
public class TwoClientsThreadedServerAndPrints {
    public static void main(String[] args) throws IOException {
         
        if (args.length != 1) {
            System.err.println("Usage: java ReadAndPrintMsgServer <port number>");
            System.exit(1);
        }
         
        int portNumber = Integer.parseInt(args[0]);
        ServerSocket serverSocket = new ServerSocket(Integer.parseInt(args[0]));
        System.out.println("Server started.");
         
        //This is the part that will need to use threads
       /* while (true)
        {
            Socket clientSocket = serverSocket.accept(); 
            System.out.println("Socket accepted..."); 
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;
            System.out.println("Client connected.  Waiting for message");
            inputLine = in.readLine();
            System.out.println("Got client message: "+inputLine);
        }*/
        ServerThread serverThread1 = new ServerThread(serverSocket);
        serverThread1.start();
        System.out.println("Thread 1 Started");

        ServerThread serverThread2 = new ServerThread(serverSocket);
        serverThread2.start();
        System.out.println("Thread 2 Started");
    }
}

class ServerThread extends Thread
{
    private ServerSocket serverSocket; 
    public ServerThread(ServerSocket serverSocket)
    {
        this.serverSocket = serverSocket;

    }
    @Override
    public void run() {
        while (true)
        {
            try {
            Socket clientSocket = serverSocket.accept(); 
            System.out.println("Socket accepted..."); 
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;
            System.out.println("Client connected.  Waiting for message");
            while ((inputLine = in.readLine())!=null)
               System.out.println("Got client message: "+inputLine);
            } catch (Exception e) { System.out.println("Error in the thread!");}
        }
    }

}
