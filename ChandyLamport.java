import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

class Node {
	boolean storedState;
	int localState;
	int channel1;
	int channel2;
	public int port1;
	public int port2;
	//construction
	
	public Node(int port1,int port2){
		this.port1 = port1;
		this.port2 = port2;
		
	}
	
	public void sendMessage(String str){
		try{
			Socket socket = new Socket(InetAddress.getLocalHost(),port1);
			//String str = "1";
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF(str);
			socket.close();
		}catch(IOException e){}
	}
	public void receiveMessage(){
		try{
			ServerSocket serversocket = new ServerSocket(port2);
			Socket socket = serversocket.accept(); //listen port 40000 for node q
			DataInputStream in = new DataInputStream(socket.getInputStream());
			String message = in.readUTF();
			if(message.equalsIgnoreCase("marker")){
				//do chandy lamport algorithm
				System.out.println("This is a marker!");
				if(!this.storedState){
					channel1 = 0;
					this.storedState = true;
					this.sendMessage("marker");
				}
				else{
					//channel1 += 1;
				}
			}
			else{
				System.out.println("This is not a marker!");
				if(this.storedState){
					channel1 += 1;
					System.out.println("channel state is :"+channel1);
				}
				else{
					this.localState +=1;
					System.out.println("local state is:"+localState);
				}
			}
			serversocket.close();
		}catch(IOException e){}
		
		
	}
}
/*
class Nodep extends Node{
	
	
}
*/
class NodepSend extends Thread{
	Node nodep;
	public NodepSend(Node nodep){
		this.nodep = nodep;
	}
	
	public void run(){
		nodep.sendMessage("1");
		if(nodep.localState == 101){
			nodep.sendMessage("marker");
		}
		
	}
}
class NodepReceive extends Thread{
	Node nodep;
	public NodepReceive(Node nodep){
		this.nodep = nodep;
	}
	//Node nodep = new Node();
	public void run(){
		nodep.receiveMessage();
		
	}
}


class NodeqSend extends Thread{
	Node nodeq;
	public NodeqSend(Node nodeq){
		this.nodeq = nodeq;
	}
	public void run(){
		nodeq.sendMessage("1");	
	}
}
class NodeqReceive extends Thread{
	//Node nodeq = new Node();
	Node nodeq;
	public NodeqReceive(Node nodeq){
		this.nodeq = nodeq;
	}
	public void run(){
		nodeq.receiveMessage();
		
	}
}

	
	

public class ChandyLamport {
	static public void main(String[] args){
		Node p = new Node(30000,40000);
		Node q = new Node(40000,30000);
		NodepSend ps = new NodepSend(p);
		NodeqSend qs = new NodeqSend(q);
		NodepReceive pr = new NodepReceive(p);
		NodeqReceive qr = new NodeqReceive(q);
		synchronized (test2.class) {
			ps.start();
			qr.start();
			qs.start();
			pr.start();
		}
	}

}
