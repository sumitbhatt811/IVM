package Mini;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Graphics;

public class _5_Category {
	//private static final String[][] JTable = null;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private final JButton btnEnter = new JButton("Enter");
	private final JTable table_1 = new JTable();
	private JTable table_2;
	_5_Category(){
		JFrame j1=new JFrame();
		DefaultTableModel model = new DefaultTableModel();
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/project","root","password");  
			PreparedStatement ps = con.prepareStatement("select * from category");
			ResultSet rs=ps.executeQuery();
			String cid="";
			String cname="";
			String[] columnnames= {"Ct_ID","Ct_Name"};
			
			model.setColumnIdentifiers(columnnames);
			while(rs.next()) {
				cid=rs.getString("Ct_ID");
				cname=rs.getString("Ct_Name");
				model.addRow(new Object[]{cid, cname});
			}
		}
		catch(Exception e){ System.out.println(e);}  
			
			JTable table = new JTable();
			table.setBounds(268, 168, 200, 200);
			table.setModel(model);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			table.setBounds(325,80,400,400);
			table.setShowGrid(true);
			table.setFillsViewportHeight(true);
			
			
			//table_2.setModel(model3);
			//j1.getContentPane().add(table_2);
//			JScrollPane scroll = new JScrollPane(table);
//			scroll.setHorizontalScrollBarPolicy(
//			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//			scroll.setVerticalScrollBarPolicy(
//			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//			
			JLabel l3=new JLabel("ID :");
			l3.setBounds(83,92,39,24);
			l3.setForeground(new Color(255,255,255));
			l3.setFont(new Font("Helvetica",Font.PLAIN,14));
			JTextField tf1=new JTextField();
			tf1.setBounds(80,30,100,45);
			j1.getContentPane().add(l3);
			j1.setExtendedState(JFrame.MAXIMIZED_BOTH);
			j1.setUndecorated(true);
			j1.getContentPane().setLayout(null);
			
			//j1.getContentPane().add(tf3);
			
			textField = new JTextField();
			textField.setBounds(139, 92, 86, 24);
			j1.getContentPane().add(textField);
			textField.setColumns(10);
			
			JLabel lblName = new JLabel("Name :");
			lblName.setBounds(59, 150, 45, 24);
			lblName.setForeground(new Color(255,255,255));
			lblName.setFont(new Font("Helvetica",Font.PLAIN,14));
			j1.getContentPane().add(lblName);
			
			textField_1 = new JTextField();
			textField_1.setBounds(139, 150, 86, 24);
			j1.getContentPane().add(textField_1);
			textField_1.setColumns(10);
			
			JButton btnAddNew_5_Category = new JButton("Add new Category");
			btnAddNew_5_Category.setBounds(83, 193, 199, 30);
			btnAddNew_5_Category.setBackground(Color.DARK_GRAY);
			btnAddNew_5_Category.setFont(new Font("Helvetica",Font.PLAIN,18));
			btnAddNew_5_Category.setOpaque(true);
			btnAddNew_5_Category.setForeground(new Color(255,255,255));
			j1.getContentPane().add(btnAddNew_5_Category);
			
			JButton btnDelete = new JButton("Delete");
			btnDelete.setBounds(136, 234, 89, 23);
			btnDelete.setBackground(Color.DARK_GRAY);
			btnDelete.setFont(new Font("Helvetica",Font.PLAIN,18));
			btnDelete.setOpaque(true);
			btnDelete.setForeground(new Color(255,255,255));
			j1.getContentPane().add(btnDelete);
			
			JLabel lblNewLabel = new JLabel("Type Category Name:");
			lblNewLabel.setBounds(809, 130, 170, 24);
			lblNewLabel.setForeground(new Color(255,255,255));
			lblNewLabel.setFont(new Font("Helvetica",Font.PLAIN,14));
			j1.getContentPane().add(lblNewLabel);
			JButton btnEnter=new JButton("Enter");
			btnEnter.setBounds(950,165,100,30);
			btnEnter.setBackground(Color.DARK_GRAY);
			btnEnter.setFont(new Font("Helvetica",Font.PLAIN,18));
			btnEnter.setOpaque(true);
			btnEnter.setForeground(new Color(255,255,255));
			j1.getContentPane().add(btnEnter);
			JTextField tf6=new JTextField();
			tf6.setBounds(950,130,100,30);
			j1.getContentPane().add(tf6);
			String text1=tf6.getText();
			String data[][] = new String[100][1];
			String column[] = new String[1];
			column[0] = "p_name";
			btnEnter.addActionListener(new ActionListener(){  
				 public void actionPerformed(ActionEvent e){  
					 try {	
						 Class.forName("com.mysql.jdbc.Driver");  
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","password"); 
							String query2="SELECT * FROM product WHERE Category=?";
							PreparedStatement ps7=con.prepareStatement(query2);
							ps7.setString(1, tf6.getText());
							ResultSet rs3=ps7.executeQuery();
							String pname2="";
							int i=0;
							while(rs3.next()) {
								pname2=rs3.getString("P_Name");
								data[i][0] = pname2;
								i++;
								System.out.println(pname2);
							}
						//	j=i;
					      }
					 catch(ClassNotFoundException em)
					 { 
						 System.out.println("Class not found"+em); 
				     }
					 catch(SQLException ex) {
						 System.out.println("SQLException"+ex);
					 } 
				 }
		    });  
			
			JTable table_2 = new JTable(data,column);
			table_2.setBounds(830, 241, 250, 200);
			j1.getContentPane().add(table_2);
		//	j1.getContentPane().add(table_2);
			
			j1.getContentPane().setBackground(new Color(47,79,79));
			j1.getContentPane().add(table);
			
			JLabel lblNewLabel_1 = new JLabel("Category_ID");
			lblNewLabel_1.setBounds(325, 55, 84, 30);
			lblNewLabel_1.setForeground(new Color(255,255,255));
			lblNewLabel_1.setFont(new Font("Helvetica",Font.PLAIN,14));
			j1.getContentPane().add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Category_Name");
			lblNewLabel_2.setBounds(574, 55, 156, 26);
			lblNewLabel_2.setForeground(new Color(255,255,255));
			lblNewLabel_2.setFont(new Font("Helvetica",Font.PLAIN,14));
			j1.getContentPane().add(lblNewLabel_2);
			j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			j1.setVisible(true);
		}
		public static void main(String[] args)
		{
		_5_Category Obj=new _5_Category();
		
		}
}
