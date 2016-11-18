import java.awt.EventQueue;

import javax.swing.JFrame;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class FtpServer {

	private JFrame frame;
	static InputStream in ;
	static OutputStream out;
	static ServerSocket serverSocket;
	static JLabel lblNewLabel_3;
	static JLabel lblNewLabel_4;
	static JLabel lblNewLabel_5;
	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FtpServer window = new FtpServer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
 
		serverSocket = new ServerSocket(4000);
		 
		Socket socket = serverSocket.accept();
		lblNewLabel_4.setText("new Client accepted");
		lblNewLabel_4.setForeground(new Color(111, 220, 111));
		in = socket.getInputStream();
		
		long t = new Date().getTime();
		//File f = File.createTempFile("usr-", ".txt");
		
		out = new FileOutputStream(t + "");
		
		byte [] b = new byte[16*1024];
		
		int count ;
		while ((count = in.read(b)) > 0) {
			out.write(b, 0, count);
			lblNewLabel_5.setText("new file recieved !");
			lblNewLabel_5.setForeground(new Color (111, 220, 111));
		}
		
	}

	/**
	 * Create the application.
	 */
	public FtpServer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 128, 128));
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 527, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblServer = new JLabel("Server");
		lblServer.setForeground(new Color(255, 255, 255));
		lblServer.setFont(new Font("Khmer OS Content", Font.BOLD, 50));
		lblServer.setBounds(186, 10, 192, 98);
		frame.getContentPane().add(lblServer);
		
		JLabel lblNewLabel = new JLabel("Status : ");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(34, 111, 94, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Client connection : ");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblNewLabel_1.setBounds(30, 157, 208, 39);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Recieved files : ");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblNewLabel_2.setBounds(30, 208, 192, 33);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Running");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_3.setForeground(new Color(111, 220, 111));
		lblNewLabel_3.setBounds(129, 120, 249, 22);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("no new Clients");
		
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_4.setBounds(224, 157, 249, 39);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("no file recieved");
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 18));
		
		lblNewLabel_5.setBounds(224, 208, 221, 33);
		frame.getContentPane().add(lblNewLabel_5);
	}

}
