package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import utils.SocketCommu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameMain frame = new FrameMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSendMessage = new JButton("Send Message");
		btnSendMessage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SendMessage Frame_send_message = new SendMessage();
			}
		});
	
		btnSendMessage.setBounds(23, 10, 105, 23);
		contentPane.add(btnSendMessage);
		
		JButton btnDownload = new JButton("Download Pic");
		btnDownload.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//download picture
				String baseUrl = "https://web-ace.jp/img/youngaceup/contents/1000010/comic/";
				String picPre = "YAUP_emiyasan_";
				String picApp = "comp.jpg";
				for(int i = 1; i < 10; i++) {
//				int i = 1;
					for(int j = 1; j <= 15; j++) {
						try {
							String url = baseUrl + picPre + SocketCommu.GetThreeString(i) 
									+ "_" + SocketCommu.GetThreeString(j) + picApp;
//							SocketCommu.DownloadPicture(url);
							SocketCommu.DownloadPictureByFileUtils(url);
						} catch(Exception ex) {
							ex.printStackTrace();
						}
					}
				}
			}
		});

		
		btnDownload.setBounds(23, 43, 105, 23);
		contentPane.add(btnDownload);
		setVisible(true);
	}
}
