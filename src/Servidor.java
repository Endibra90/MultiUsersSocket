import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Servidor {
	static ArrayList<HiloSocket> clientes = new ArrayList<HiloSocket>();
	public static void broadcast(HiloSocket cliente,String msg) throws IOException{
		for(HiloSocket ss: clientes){
			if(ss!=cliente)
			ss.enviarMsg(msg);
		}
	}
public static void main(String[]args){
		try{

		ServerSocket serverSocket= new ServerSocket(9999);
		System.out.print("Servidor escuchando\n");
		/*Scanner sc = new Scanner(System.in);
		System.out.print("Escribe:");
		String frase= sc.nextLine();*/
		while(true){
			Socket s = serverSocket.accept();

			HiloSocket hilo2=new HiloSocket(s);
			clientes.add(hilo2);
			hilo2.start();
			//hilo2.enviarMsg(frase);
			/*HiloEscucha hilo= new HiloEscucha(s);
			hilo.start();*/
			/*BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			System.out.println("Escribe:");
			frase= sc.nextLine()+"\n";
			bw.write(frase);
			bw.flush();*/



		}
	}catch(Exception e){
		System.out.println(e);
	}
}
}
