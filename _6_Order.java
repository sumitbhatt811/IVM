package Mini;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class _6_Order {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	_6_Order()
	{
		JFrame j3=new JFrame();
		j3.getContentPane().setBackground(new Color(47,79,79));
		DefaultTableModel model4 = new DefaultTableModel();
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/aman","root","password");
			

			PreparedStatement ps = con.prepareStatement("select * from v23");
			ResultSet rs=ps.executeQuery();
			String pname1="";
			String quantity="";
			String[] columnnames= {"P_Name","Qty"};
			
			model4.setColumnIdentifiers(columnnames);
			while(rs.next()) {
				pname1=rs.getString("P_Name");
				quantity=rs.getString("Qty");
				model4.addRow(new Object[]{pname1,quantity});
			}
		}
		catch(Exception e){ System.out.println(e);}

			j3.setExtendedState(JFrame.MAXIMIZED_BOTH);
			j3.setUndecorated(true);
			j3.getContentPane().setLayout(null);
			
			JTable table4 = new JTable();
			table4.setBounds(188, 156, 400, 400);
			table4.setModel(model4);
			table4.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			table4.setFillsViewportHeight(true);
			j3.getContentPane().add(table4);
			
			JTextField textField = new JTextField();
			textField.setBounds(772,250,86,20);
			j3.getContentPane().add(textField);
			textField.setColumns(10);
			
			JTextField textField_1 = new JTextField();
			textField_1.setBounds(772,300,86,20);
			j3.getContentPane().add(textField_1);
			textField_1.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("Product Name");
			lblNewLabel.setBounds(652,250,90,14);
			lblNewLabel.setForeground(new Color(255,255,255));
			lblNewLabel.setFont(new Font("Helvetica",Font.PLAIN,14));
			j3.getContentPane().add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Quantity");
			lblNewLabel_1.setBounds(652,300,66,14);
			lblNewLabel_1.setForeground(new Color(255,255,255));
			lblNewLabel_1.setFont(new Font("Helvetica",Font.PLAIN,14));
			j3.getContentPane().add(lblNewLabel_1);
			
			JLabel lblNewLabel_3 = new JLabel("Quantity");
			lblNewLabel_3.setBounds(390,131,66,16);
			lblNewLabel_3.setForeground(new Color(255,255,255));
			lblNewLabel_3.setFont(new Font("Helvetica",Font.PLAIN,14));
			j3.getContentPane().add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("Product");
			lblNewLabel_4.setBounds(190,131,66,14);
			lblNewLabel_4.setForeground(new Color(255,255,255));
			lblNewLabel_4.setFont(new Font("Helvetica",Font.PLAIN,14));
			j3.getContentPane().add(lblNewLabel_4);
			
//			String prod="";
//			prod=textField.getText();
//			
//			String text=textField_1.getText();
//			int q=Integer.parseInt(text);
			
			JButton b1=new JButton("ADD");
			b1.setBounds(772,350,75,30);
			b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Class.forName("com.mysql.jdbc.Driver");  
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aman","root","password");
						

						PreparedStatement ps = con.prepareStatement("update product set qty = (qty +?) where p_name = ?");
						ps.setInt(1, Integer.parseInt(textField_1.getText()));
						ps.setString(2, textField.getText());
						ps.executeUpdate();
						
					}
					catch(ClassNotFoundException ea){
						System.out.println(ea);
					}
					catch(SQLException ea) {
						System.out.println(ea);
					}
				}
			});
			j3.getContentPane().add(b1);
			j3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			j3.setVisible(true);
			
		}
				
	public static void main (String[] args)
	{
		_6_Order obj2=new _6_Order();
	}
}
