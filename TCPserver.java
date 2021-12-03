import java.net.ServerSocket;
import java.io.*;
import java.net.Socket;
public class server{
	public static void main(String args[])throws Exception
	{
		ServerSocket sc=new ServerSocket(8000);
		System.out.println("server is ready for connection");
		Socket s=sc.accept();
		System.out.println("connection with "+s.getInetAddress().toString());
		InputStream istream=s.getInputStream();
		
		BufferedReader b=new BufferedReader(new InputStreamReader(istream));
		String str=b.readLine();
		System.out.println(str);
		
		BufferedReader a=new BufferedReader(new FileReader(str));
		 
		OutputStream ostream=s.getOutputStream();
		PrintWriter pw=new PrintWriter(ostream,true);
		
	    
		String sdr;
		while((sdr=a.readLine())!=null)
			pw.println(sdr);
		s.close();
		b.close();
		sc.close();
		pw.close();
		a.close();
	}
}
