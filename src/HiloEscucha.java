import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class HiloEscucha extends Thread {
private BufferedReader bf;

public HiloEscucha(Socket socket) throws IOException{
	this.bf=new BufferedReader(new InputStreamReader(socket.getInputStream()));
}

@Override
public void run(){
	String linea;
	try {
		while((linea=bf.readLine())!=null){
			System.out.print(linea);
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
