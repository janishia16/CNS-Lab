import java.net.*;
import java.io.*;
 public class client
 {
 	public static void main(String args[]) throws IOException,SocketException
 	{
 		byte[] sendData=new byte[1024];
 		byte[] receiveData=new byte[1024];
 		DatagramSocket mySocket=new DatagramSocket();
 		System.out.println("Enter the number:");
 		
 		BufferedReader informUser=new BufferedReader(new InputStreamReader(System.in));
 		InetAddress myIP=InetAddress.getByName("localhost");
 		
 		String Data=informUser.readLine();
 		sendData=Data.getBytes();
 		
 		DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,myIP,8000);
 		mySocket.send(sendPacket);
 		
 		DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);
 		mySocket.receive(receivePacket);
 		
 		String datatodisplay=new String(receivePacket.getData());
 		System.out.println(datatodisplay);
 		mySocket.close();
 	}
 } 
