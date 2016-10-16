package utils;

import java.io.BufferedOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class SocketCommu {

	public static boolean SendMessage(String ip, String msg) {
		try {
            Socket s = new Socket(ip, 8091);

            BufferedOutputStream out = new BufferedOutputStream(s.getOutputStream(), 85);
            out.write(msg.getBytes("utf-8").length);
            out.write(msg.getBytes("utf-8"));
            out.close();
            s.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
	}
	
	public static boolean SendMessageByUDP(String ip, String msg) {
		DatagramSocket connectUDP = null;
		DatagramPacket messageUDP = null;
		try {
			connectUDP = new DatagramSocket();
			byte[] data = new byte[msg.getBytes("utf-8").length + 1];
			data[0] = (byte)msg.getBytes("utf-8").length;
			System.arraycopy(msg.getBytes("utf-8"), 0, data, 1, msg.getBytes("utf-8").length);
			messageUDP = new DatagramPacket(data, data.length, new InetSocketAddress(ip, 8091));
			connectUDP.send(messageUDP);
			connectUDP.close();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
            return false;
		}
	}
}
