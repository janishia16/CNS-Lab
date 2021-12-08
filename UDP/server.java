import java.net.*;
import java.io.*;
import java.util.Scanner;
 public class server
 {
 	public static void main(String args[]) throws IOException,SocketException
 	{
 		byte[] sendData=new byte[1024];
 		byte[] receiveData=new byte[1024];
 		DatagramSocket mySocket =new DatagramSocket(8000);
 		while(true)
 		{
 			DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);
 			mySocket.receive(receivePacket);
 			
 			String Data=new String(receivePacket.getData());
 			
 			System.out.println("clientdata"+Data);
 			
 			InetAddress myIP=receivePacket.getAddress();
 			int Port=receivePacket.getPort();
 			
 			System.out.println("Enter data to send to client:");
 			Scanner sc=new Scanner(System.in);
 			
 			String dataSend=sc.next();
 			sendData=dataSend.getBytes();
 			
 			DatagramPacket senddataclient=new DatagramPacket(sendData,sendData.length,myIP,Port);
 			mySocket.send(senddataclient);
 		}
 	}
 } 
 			
