package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.UIManager;

import org.pushingpixels.substance.api.SubstanceLookAndFeel;

import utils.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;

public class SendMessage extends JFrame {

	private JPanel contentPane;
	private JTextField Input_ip;
	
	private ServerSocket serverS;
    private int REC_PORT = 8091;
    private JTextField Input_message;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SendMessage frame = new SendMessage();
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
	public SendMessage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel Panel_ip = new JPanel();
		contentPane.add(Panel_ip, BorderLayout.NORTH);
		FlowLayout fl_Panel_ip = new FlowLayout();
		fl_Panel_ip.setVgap(30);
		Panel_ip.setLayout(fl_Panel_ip);
		
		JLabel Label_ip = new JLabel("Ip");
		Panel_ip.add(Label_ip);
		Label_ip.setBounds(10,10,20,40);
		
		Input_ip = new JTextField();
		Panel_ip.add(Input_ip);
		Input_ip.setColumns(20);
		Input_ip.setText("192.168.1.100");
		
		JButton Button_send = new JButton("send");
		Button_send.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SocketCommu.SendMessage(Input_ip.getText(), Input_message.getText());
			}
		});
		Panel_ip.add(Button_send);
		
		JPanel Panel_message = new JPanel();
		contentPane.add(Panel_message, BorderLayout.CENTER);
		
		JLabel Label_message = new JLabel("Message ");
		Panel_message.add(Label_message);
		
		Input_message = new JTextField();
		Panel_message.add(Input_message);
		Input_message.setColumns(40);
		setVisible(true);
		
		//set icon
		BufferedImage icon = null;
		try {
			System.out.println(new File("../../file.txt").getAbsolutePath());
			System.out.println(new File("file.txt").getPath());
			System.out.println(this.getClass().getPackage().toString());
			if(new File("../source/rei.jpg").exists()) 
			{
				System.out.println("tag: exists");
			}
			else 
			{
				System.out.println("tag: not exists");
			}
			icon = ImageIO.read(this.getClass().getResource("source/rei.jpg"));
//			icon = ImageIO.read(new File(new File("").getParent() + "/"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		setIconImage(icon);
	}

}