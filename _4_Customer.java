package Mini;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Dimension;

public class _4_Customer extends JFrame {

	static _4_Customer frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;
//	private JTextField textField_6;
//	private JTextField textField_7;
//	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new _4_Customer();
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
	public _4_Customer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1263, 784);
//		Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
//		setSize((int) d.getWidth(), (int) d.getHeight());
//		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblId.setBounds(61, 91, 124, 39);
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel("Name  :");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(61, 176, 124, 39);
		contentPane.add(lblName);
		
		JLabel lblMobileNo = new JLabel("Mobile No.  :");
		lblMobileNo.setForeground(Color.WHITE);
		lblMobileNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMobileNo.setBounds(61, 358, 124, 39);
		contentPane.add(lblMobileNo);
		
		JLabel lblEmail = new JLabel("E-Mail :");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(61, 450, 124, 39);
		contentPane.add(lblEmail);
		
		JLabel lblProductName = new JLabel("Product Name :");
		lblProductName.setForeground(Color.WHITE);
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProductName.setBounds(61, 531, 124, 39);
		contentPane.add(lblProductName);
		
		JLabel lblQty = new JLabel("Qty :");
		lblQty.setForeground(Color.WHITE);
		lblQty.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblQty.setBounds(61, 620, 124, 39);
		contentPane.add(lblQty);
		
		textField = new JTextField();
		textField.setBounds(298, 93, 177, 39);
		textField.setEditable(false);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(298, 178, 177, 39);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(298, 265, 177, 39);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(298, 360, 177, 39);
		contentPane.add(textField_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(298, 622, 177, 39);
		contentPane.add(textField_5);
		
		String pNames[] = new String[100];
		int i=0;
		int j=1;
		try{
			Connection con = null;
			//com.mysql.jdbc.Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost/aman?useSSL=false","root","password");
			
			PreparedStatement ps = con.prepareStatement("select P_Name from Product",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()){
				j++;
				pNames[i] = rs.getString(1);
				i++;
			}	
			con.close();
		}
		catch(ClassNotFoundException e){
			System.out.println("Class not found : "+e);
			
		}
		catch(SQLException e){
			System.out.println("SQLEXception : "+e);
			e.printStackTrace();
		}
		

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(298, 452, 177, 39);
		contentPane.add(textField_4);
		
		final JComboBox comboBoxProd = new JComboBox(pNames);
		comboBoxProd.setBounds(298,533,177,39);
		contentPane.add(comboBoxProd);
		
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBackground(new Color(255, 0, 0));
		btnDelete.setBounds(49, 685, 177, 39);
		contentPane.add(btnDelete);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.setBackground(new Color(0, 255, 127));
		btnInsert.setBounds(298, 685, 177, 39);
		btnInsert.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int PID=0;
				
				try{
					Connection con = null;
					//com.mysql.jdbc.Driver
					Class.forName("com.mysql.jdbc.Driver");
									
					con = DriverManager.getConnection("jdbc:mysql://localhost/aman?useSSL=false","root","password");
							
					

					String queryGetPID = "" + comboBoxProd.getSelectedItem() ;
					
					PreparedStatement ps = con.prepareStatement("select * from Product where P_Name = ? ");
					ps.setString(1,queryGetPID);
					
					ResultSet rs = ps.executeQuery();

					
					System.out.println(queryGetPID);
					
					rs.next();
					int strID = rs.getInt("P_ID");
					
					System.out.println("ID  :  "+strID);
					
					PID = strID;
					
					con.close();
				}
				catch(ClassNotFoundException e3){
					System.out.println("Class not found for PID : "+e3);
				}
				catch(SQLException e3){
					System.out.println("SQLEXception for PID : "+e3);	
					//e3.printStackTrace();
				}
				
				
				
/*========================================================================================================================================*/
				
				//NOW try catch for finding if Aadhar-No. is already present : 
				
				boolean ifPresent = false ;
				
				int pres = 0;
				
				//long aadhar = Long.parseLong(textField_2.getText()); ;
				
				String aadhar = textField_2.getText();
				
				int C_ID=0;
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = null;
					con = DriverManager.getConnection("jdbc:mysql://localhost/aman?useSSL=false","root","password");
					
//					PreparedStatement ps = con.prepareStatement("SELECT * FROM Customer where AadharNo = ?");
//					ps.setLong(1,aadhar);
//					ResultSet rs = ps.executeQuery();
//					rs.next();
					
					PreparedStatement ps = con.prepareStatement("SELECT C_ID,count(AadharNo) FROM Customer where AadharNo = ?");
					ps.setString(1,aadhar);
					ResultSet rs = ps.executeQuery();
					
					rs.next();
					System.out.println("\n\nAadhar count is :\n\n");
					System.out.println(rs.getString("count(AadharNo)"));
					
					int cnt = Integer.parseInt(rs.getString("count(AadharNo)"));
					
					if(cnt>0){
						ifPresent = true;
						System.out.println("ID is : " + rs.getString("C_ID"));
						C_ID = Integer.parseInt(rs.getString("C_ID"));
					}
					
					
				}
				catch(ClassNotFoundException e1){
					System.out.println("Find CID exc "+e1);
					//e1.printStackTrace();
				}
				catch(SQLException e1){
					System.out.println("Find CID exc "+e1);
					//e1.printStackTrace();
				}
				
/*========================================================================================================================================*/
				//NOW ifPresent then insert with that value of C_ID if not then find the biggest value of C_ID and add 1 to it.
				
				if(ifPresent)
				{
					try{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = null;
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aman","root","password");
						
						PreparedStatement ps = con.prepareStatement("insert into customer( C_ID , C_Name , AadharNo , MobileNo , Email ,P_ID , Qty ) values(?,?,?,?,?,?,?)");
						
						
						System.out.println(C_ID);
						System.out.println(""+textField_1.getText());
						System.out.println(""+textField_2.getText());
						System.out.println(Integer.parseInt(""+textField_3.getText()));
						System.out.println(""+textField_4.getText());
						System.out.println(PID);
						System.out.println(Integer.parseInt(""+textField_5.getText()));
						
						ps.setInt(1,C_ID);
						ps.setString(2, textField_1.getText());  //cname
						ps.setString(3, textField_2.getText());
						ps.setInt(4,Integer.parseInt(textField_3.getText()));
						ps.setString(5, textField_4.getText() );
						ps.setInt(6, PID );
						ps.setInt(7, Integer.parseInt(textField_5.getText()) );
						
						ps.executeUpdate();
						
						con.close();
						
						JOptionPane.showMessageDialog(null, "Thanks for placing order of "+textField_1.getText()+" again ");
						frame.dispose();
						_4_Customer.main(null);
					}
					catch(ClassNotFoundException ex){
						System.out.println("Exception in IF insert"+ex);
						//ex.printStackTrace();
					}
					catch(SQLException ex){
						System.out.println("Exception in IF insert"+ex);
						//ex.printStackTrace();
					}
				}
				else
				{
					int newCID = 0;
					int maxID[] = new int[100];
					int i=0;
					
					try{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = null;
						con = DriverManager.getConnection("jdbc:mysql://localhost/aman?useSSL=false","root","password");
						
						PreparedStatement ps = con.prepareStatement("SELECT * FROM Customer");
						ResultSet rs = ps.executeQuery();
						System.out.println("\n\n\n");
						while(rs.next()){
							System.out.println(rs.getString("C_ID"));
							maxID[i] = Integer.parseInt(rs.getString("C_ID"));
							i++;
						}
						
					}
					catch(ClassNotFoundException e2){
						e2.printStackTrace();
					}
					catch(SQLException e2){
						e2.printStackTrace();
					}
					
					//NOW finding max value of C_ID in table : 
					newCID = maxID[0];
					
					for(int j = 1 ; j < i ; j++){
						if(newCID < maxID[j]){
							newCID = maxID[j];
						}
					}
					
					System.out.println("\n\n\nnewCID id : "+newCID);
					
					C_ID = newCID+1;
					
					
					
					try{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = null;
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aman","root","");
						
						PreparedStatement ps = con.prepareStatement("insert into customer( C_ID , C_Name , AadharNo , MobileNo , Email ,P_ID , Qty ) values(?,?,?,?,?,?,?)");
						
						ps.setInt(1,C_ID);
						ps.setString(2, textField_1.getText());  //cname
						ps.setString(3,textField_2.getText());
						ps.setInt(4,Integer.parseInt(textField_3.getText()));
						ps.setString(5, textField_4.getText());
						ps.setInt(6, PID );
						ps.setInt(7, Integer.parseInt(textField_5.getText()) );
						
						ps.executeUpdate();
						
						con.close();
						
						JOptionPane.showMessageDialog(null, "New ID has been alotted to NEW CUSTOMER");
						frame.dispose();
						_4_Customer.main(null);
					}
					catch(ClassNotFoundException ex){
						System.out.println("Exception in else insert"+ex);
						//ex.printStackTrace();
					}
					catch(SQLException ex){
						System.out.println("Exception in else insert"+ex);
						//ex.printStackTrace();
					}
					
					
				}
				
			}
		});
		contentPane.add(btnInsert);
		
		
		
		String data[][] = null;
		String column[] = null;
		
		//connect.getTableInfo();
		
		try{
			Connection con = null;
			//com.mysql.jdbc.Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aman","root","password");
			
			PreparedStatement ps = con.prepareStatement("select * from Customer",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = ps.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			
			int col = rsmd.getColumnCount();
			System.out.println(col);
			column = new String[col];
			
			//
			
			rs.last();
			int row = rs.getRow();
			
			rs.beforeFirst();
			
			data = new String[row+1][col+1];
			int count =1;
			
			
			String name[]= new String[col];
			
			for(int k=1; k<=col ; k++){
				data[0][k-1] = rsmd.getColumnName(k);
				column[k-1] = rsmd.getColumnName(k);
				name[k-1] = rsmd.getColumnName(k);
				//System.out.println(rsmd.getColumnName(i));
				System.out.println(name[k-1]);
			}
			
			while(rs.next()){
				for(int k=1; k<=col ; k++){
					data[count][k-1] = rs.getString(k);
				}
				count++;
			}
			
			con.close();
		}
		catch(ClassNotFoundException e){
			System.out.println("Class not found : "+e);
		}
		catch(SQLException e){
			System.out.println("SQLEXception : "+e);
		}
		
		
		
		
		table = new JTable(data,column);
		table.setBounds(534, 55, 699, 669);
		contentPane.add(table);
		
		JLabel lblAadharno = new JLabel("AadharNo.  :");
		lblAadharno.setForeground(Color.WHITE);
		lblAadharno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAadharno.setBounds(61, 263, 124, 39);
		contentPane.add(lblAadharno);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
