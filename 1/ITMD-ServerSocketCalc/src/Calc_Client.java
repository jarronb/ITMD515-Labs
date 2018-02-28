// Java program to illustrate Client Side Programming
// for Simple Calculator using TCP
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Calc_Client
{
	public static void main(String[] args) throws IOException
	{
		//Get Host name
		InetAddress ip = InetAddress.getLocalHost();
		
		//Creating a constant variable for the port number
		final int PORT = 4444;
		
		//Scanner to obtain keyboard input
		Scanner scanner = new Scanner(System.in);

		// Creating a new Socket
		Socket socket = new Socket(ip, PORT);

		//Creating the input stream object and output stream object
		DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
		DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
		
		//When socket gets connection run intro prompt
		if(socket.isConnected()) {
			System.out.println("Connected to server!");
			System.out.println("New? yes or no");
			String inp = scanner.nextLine();
			
			//If user is new send input sever to be processed
			if (inp.equalsIgnoreCase("yes")) {
				dataOutputStream.writeUTF(inp);
				dataOutputStream.flush();
			}
			
			
		}

		//While connection is still open run while loop to obtain server message and prompt user for command
		while (!socket.isClosed())
		{
			//Obtain and print server message
			String answer = dataInputStream.readUTF();
			System.out.println(answer);
			
			//If user typed exit, the server returns a string which is processed in this loop
			if (answer.equalsIgnoreCase("(515OK): Exited")) {
				socket.close();
			}
			//Prompt user to enter the equation
			//In form num1 operator num2
			if (!socket.isClosed()) {
			System.out.print("Enter the equation in the form: ");
			System.out.println("'num1 operator num2'\nOr \n'exit' \nOr\n'count' ");

			//Scanner object to obtain user's equation
			String input = scanner.nextLine();
			
			//Send the equation to server
			dataOutputStream.writeUTF(input);

			}
		}
	}
}
