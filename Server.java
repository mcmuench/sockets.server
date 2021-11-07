package sockets.server;

import java.io.*; 
import java.net.*;
import java.util.regex.*;

public class Server {
	
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private PrintWriter out;
    private BufferedReader in;
    private Protocol protocol;
    
    public Server() {
    	super();
    	protocol = new Protocol();
    }
    
    public static void main(String[] args) throws IOException {
		Server server=new Server();
        server.start(4999);
	}
	
	public void start(int port) throws IOException {
		
		serverSocket = new ServerSocket(port);
		clientSocket = serverSocket.accept();
		// When the server code encounters the accept method, it blocks until a client makes a connection request to it.
		
		// Wir holen outputkanal vom client:
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		// Inputkanal vom client:
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		String inputLine;
		
		while ((inputLine = in.readLine()) != null) {
			
			System.out.println(inputLine);
			
			inputLine = protocol.process(inputLine);
			
			if(inputLine == null || inputLine == "") {
				out.println("Diese Zeile kenne ich nicht - good bye!");
				break;
			}
			out.println(inputLine);
			
//			if ("Ich geh mit meiner Laterne".equals(inputLine)) {
//				out.println(", und meine Laterne mit mir!");
//			}
//			else if ("Dort oben, da leuchten die Sterne".equals(inputLine)) {
//				out.println(", hier unten da leuchten wir!");
//			}
//			else if ("hello".equals(inputLine)) {
//				out.println("world");
//			}
//			else {
//				out.println("Diese Zeile kenne ich nicht - good bye!");
//				break;
//			}
		}
		stop();	
	}
	
	public void stop() throws IOException {
		in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
	}
	
	

}
