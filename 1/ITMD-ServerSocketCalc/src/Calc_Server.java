// Java program to illustrate Server Side Programming
// for Simple Calculator using TCP
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class Calc_Server
{
	//Initializing number of clients to 0
	public static int clients =0;
	public static void main(String args[]) throws IOException
	{

		//Instantiating a Socket Server for the socket connection on port 4444
		ServerSocket socketServer = new ServerSocket(4444);
		System.out.println("Server waiting for connections... ");
		
		//Infinite loop to continue to accept new connection and start a new thread
		while(true) {
		Socket socket = socketServer.accept();
		new ClientThreading(socket).start();
		}
	}
}
