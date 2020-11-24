
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	private Socket socket;
	public Cliente(Socket socket){
		this.socket=socket;
	}
public static void main(String[]args) throws UnknownHostException, IOException{

    Socket s = new Socket("localhost",9999);
    Scanner sc = new Scanner(System.in);
    String frase;
    HiloSocket hilo= new HiloSocket(s);
    hilo.start();
    while(true){
        System.out.println("Escribe:");
        frase= sc.nextLine();
        hilo.enviarMsg(frase);
    }
}
}
