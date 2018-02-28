import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

class ClientThreading extends Thread{
	private Socket socket;
	
	//Constructor to obtain the socket connection from clients
	public ClientThreading(Socket socket) {
		this.socket = socket;
		
	}

	public void run() {
		try {
			
			//Creating the input stream object and output stream object
			DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
			DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
			
			//Creating obj to access Calc_Server methods and variables
			Calc_Server obj = new Calc_Server();

			//While connection is not closed
			while (!this.socket.isClosed())
			{
				//Obtain client message
				String input = dataInputStream.readUTF();

				//Case if user entered exit
				if(input.equalsIgnoreCase("exit")) {
					
					//Subtract the user from global static variables 
					Calc_Server.clients--;
					
					//Send client message that it received and exited socket
					dataOutputStream.writeUTF("(515OK): Exited");
					dataOutputStream.flush();
					socket.close(); // Close socket
				}
				//Case if user enter count
				else if(input.equals("count")) {
					//Get count
					int clients = Calc_Server.clients;
					
					//Send count to client
					dataOutputStream.writeUTF("(515OK): Count = " + Integer.toString(clients) + "\n");
				}
				//Case if user entered yes to being a new user
				else if(input.equalsIgnoreCase("yes")) {
					//Add one to global static variables
					Calc_Server.clients++;
					
					//Print to user confirmation message
					dataOutputStream.writeUTF("(515OK): Added user\n");
					dataOutputStream.flush();
				}
				else { //Math operation
				
					//Server record equations received
				System.out.println("Equation received: " + input);
				
				//Declaring variable for result
				int result;

				// Use StringTokenizer split operation and operand
				StringTokenizer st = new StringTokenizer(input);

				int operand1 = Integer.parseInt(st.nextToken());
				String operation = st.nextToken();
				int operand2 = Integer.parseInt(st.nextToken());

				//String of cases to process each operation
				if (operation.equals("+"))
				{
					result = operand1 + operand2;
				}

				else if (operation.equals("-"))
				{
					result = operand1 - operand2;
				}
				else if (operation.equals("*"))
				{
					result = operand1 * operand2;
				}
				else
				{
					result = operand1 / operand2;
				}
				System.out.println("Sending the result...");

				//Send result back to Client
				dataOutputStream.writeUTF("(515OK): Equation received = " + input + "\nAnswer =  " + Integer.toString(result) + "\n");
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}