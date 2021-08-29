package dezmembrari.audi;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import dezmembrari.audi.SearchWindow;
import dezmembrari.audi.AddPart;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;

public class AddPartWindow {

	public JFrame frame3;
	private JTextField partName;
	private JTextField oemCode;
	private JTextField price;
	private JTextField origin;
	private JTextField condition;
	private JTable table;
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
				
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPartWindow window = new AddPartWindow();
					window.frame3.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddPartWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame3 = new JFrame();
		frame3.getContentPane().setBackground(SystemColor.activeCaption);
		frame3.setBounds(100, 100, 750, 610);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("OEM code");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 16));
		
		JLabel lblNewLabel_1 = new JLabel("Part name");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 16));
		
		JLabel lblPret = new JLabel("Price");
		lblPret.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 16));
		
		JLabel lblProvenienta = new JLabel("Origin");
		lblProvenienta.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 16));
		
		JLabel lblStare = new JLabel("Condition");
		lblStare.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 16));
		
		partName = new JTextField();
		partName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		partName.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
		partName.setColumns(10);
		
		
		oemCode = new JTextField();
		oemCode.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
		oemCode.setColumns(10);
		
		price = new JTextField();
		price.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
		price.setColumns(10);
		
		origin = new JTextField();
		origin.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
		origin.setColumns(10);
		
		condition = new JTextField();
		condition.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
		condition.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Add part");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (partName.getText().isEmpty() || oemCode.getText().isEmpty() || price.getText().isEmpty() || origin.getText().isEmpty() || condition.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(btnNewButton, "Please complete the required information");
				}
				
				
				try {
					con = DriverManager.getConnection("jdbc:sqlite:dezmembrari.db");
					PreparedStatement add = con.prepareStatement("Insert into table values(?,?,?,?,?)");
					add.setString(1, partName.getText());
					add.setInt(2, Integer.valueOf(oemCode.getText()));
					add.setInt(3, Integer.valueOf(price.getText()));
					add.setString(4, origin.getText());
					add.setString(5, condition.getText());
					int row = add.executeUpdate();
					JOptionPane.showConfirmDialog(btnNewButton, "Part added successfully");
					con.close();
					
				} catch (Exception err){
					err.printStackTrace();
				}
				
			}
		});
		
		
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		
		JButton btnAdaugaPoze = new JButton("Add photo");
		btnAdaugaPoze.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnBack){
					MainWindow frame1 = new MainWindow();
					frame1.frame1.setVisible(true);
					frame3.setVisible(false);
					}				
			}
		});
				
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		
		JLabel lblNewLabel_2 = new JLabel("Part name");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 13));
		
		JLabel lblNewLabel_2_1 = new JLabel("OEM code");
		lblNewLabel_2_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 13));
		
		JLabel lblNewLabel_2_2 = new JLabel("Price");
		lblNewLabel_2_2.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 13));
		
		JLabel lblNewLabel_2_3 = new JLabel("Origin");
		lblNewLabel_2_3.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 13));
		
		JLabel lblNewLabel_2_4 = new JLabel("Condition");
		lblNewLabel_2_4.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 13));
		GroupLayout groupLayout = new GroupLayout(frame3.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(7)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
									.addGap(26)
									.addComponent(btnAdaugaPoze, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
									.addGap(27))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(642)
									.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addContainerGap())))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(partName, GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(oemCode, GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblPret, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
									.addGap(29)
									.addComponent(price, GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblProvenienta, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblStare, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
											.addGap(17)))
									.addGap(12)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(origin, GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
										.addComponent(condition, GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE))))
							.addGap(27))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(table, GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
							.addGap(28))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 51, Short.MAX_VALUE)
							.addGap(73)
							.addComponent(lblNewLabel_2_1, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
							.addGap(45)
							.addComponent(lblNewLabel_2_2, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
							.addGap(73)
							.addComponent(lblNewLabel_2_3, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
							.addGap(81)
							.addComponent(lblNewLabel_2_4, GroupLayout.PREFERRED_SIZE, 51, Short.MAX_VALUE)
							.addGap(98))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(btnAdaugaPoze, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(partName)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(oemCode, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPret, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(price, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProvenienta, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(origin, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStare, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(condition, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)))
					.addGap(4)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2_2, GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_2_3, GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
							.addComponent(lblNewLabel_2_4, GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
						.addComponent(lblNewLabel_2_1, GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBack)
					.addGap(3))
		);
		frame3.getContentPane().setLayout(groupLayout);
	}
}