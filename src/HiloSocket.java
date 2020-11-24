import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class HiloSocket extends Thread {
	 Socket s;
	 BufferedWriter bw;
	 BufferedReader bf;
	public HiloSocket(Socket s) throws IOException{
		this.s=s;
		try{
			bw= new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			bf=new BufferedReader(new InputStreamReader(s.getInputStream()));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void enviarMsg(String str) throws IOException{
		bw.write(str);
		bw.newLine();
		bw.flush();
	}
	@Override
	public void run(){
		String linea;
		try {
			while((linea=bf.readLine())!=null){
				System.out.println(linea);
				Servidor.broadcast(this,linea);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
