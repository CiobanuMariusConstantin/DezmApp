package dezmembrari.audi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Cursor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class MainWindow {

	public JFrame frame1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {	
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame1 = new JFrame();
		frame1.getContentPane().setBackground(SystemColor.activeCaption);
		frame1.setBackground(new Color(245, 245, 220));
		frame1.setForeground(new Color(245, 245, 220));
		frame1.setBounds(100, 100, 600, 300);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame1.setIconImage(logo.getImage());
		
		JButton btnSearchPart = new JButton("Search Part");
		btnSearchPart.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnSearchPart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearchPart.setBackground(SystemColor.activeCaption);
		btnSearchPart.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		btnSearchPart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnSearchPart) {
					SearchWindow frame2 = new SearchWindow();
					frame2.frame2.setVisible(true);
					frame1.setVisible(false);
				} 
			}
		});
		
		JButton btnAddPart = new JButton("Add Part");
		btnAddPart.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnAddPart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddPart.setBackground(SystemColor.activeCaption);
		btnAddPart.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		btnAddPart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnAddPart){
					AddPartWindow frame3 = new AddPartWindow();
					frame3.frame3.setVisible(true);
					frame1.setVisible(false);
					}				
			}
		});
		
		textField = new JTextField();
		textField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField.setBackground(SystemColor.activeCaption);
		textField.setColumns(10);
		
		GroupLayout groupLayout = new GroupLayout(frame1.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnAddPart, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
						.addComponent(btnSearchPart, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
					.addGap(44)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSearchPart, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
					.addGap(32)
					.addComponent(btnAddPart, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
					.addGap(71))
		);
		frame1.getContentPane().setLayout(groupLayout);
	}
	
//	ImageIcon logo = new ImageIcon (getClass().getClassLoader().getResource("logo.png"));
}
