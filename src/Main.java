
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceAutumnLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceChallengerDeepLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceGeminiLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceGraphiteAquaLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceGraphiteGlassLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceGraphiteLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceOfficeBlue2007LookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceTwilightLookAndFeel;

import utils.JDBC_SqlServer;
import frame.*;

public class Main {

	public static void main(String[] args) {
		//2016-10-04 connect sqlserver and FilteredRowSet 
//		JDBC_SqlServer sqlserverTest = new JDBC_SqlServer(); 
//		sqlserverTest.ConnectSqlServer();
		
		//2016-10-05 send message in LAN By Socket
//		try { 
////		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		    UIManager.setLookAndFeel(new SubstanceOfficeBlue2007LookAndFeel());
//		    JFrame.setDefaultLookAndFeelDecorated(true);
//		    SubstanceLookAndFeel.setSkin("org.pushingpixels.substance.api.skin.DustSkin");
//		} catch (Exception e) {
//		    e.printStackTrace();
//		}
		
		JFrame.setDefaultLookAndFeelDecorated(true);
	    SwingUtilities.invokeLater(new Runnable() {
	      public void run() {
	        try {
	          UIManager.setLookAndFeel(new SubstanceGeminiLookAndFeel());
	        } catch (Exception e) {
	          System.out.println("Substance Graphite failed to initialize");
	        }
//	        SendMessage Frame_send_message = new SendMessage();
	        FrameMain main = new FrameMain();
	      }
	    });
	    
//		SendMessage Frame_send_message = new SendMessage();
		
		//test git
	}
	
}
