import java.net.Socket;
import java.io.*;
public class client{
	public static void main(String args[])throws Exception
	{
		Socket s=new Socket("localhost",8000);
		System.out.println("enter filename:");
		
		BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
		String str=b.readLine();
		System.out.println("send file"+ str);
		
		OutputStream otstream=s.getOutputStream();
		PrintWriter pwc=new PrintWriter(otstream,true);
		System.out.println("send file to server");
		
		pwc.println(str);
		InputStream iname=s.getInputStream();
		BufferedReader a=new BufferedReader(new InputStreamReader(iname));
		
		
		String sdr;
		while((sdr=a.readLine())!=null)
			System.out.println(sdr);
		s.close();
		b.close();
		pwc.close();
		a.close();
	}
}
		
		
