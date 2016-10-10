package utils;

import java.io.BufferedOutputStream;
import java.net.Socket;

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
}
