package Mini;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.image.*;
import java.awt.Image;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


public class _3_AddProduct extends JFrame {

	static _3_AddProduct frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	String s;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new _3_AddProduct();
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
	public _3_AddProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 820);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 0, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCategory = new JLabel("Category    :");
		lblCategory.setForeground(Color.WHITE);
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCategory.setBounds(28, 75, 140, 41);
		contentPane.add(lblCategory);
		
		JLabel lblName = new JLabel("Name        :");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(28, 149, 140, 41);
		contentPane.add(lblName);
		
		JLabel lblQuantitiy = new JLabel("Quantitiy    :");
		lblQuantitiy.setForeground(Color.WHITE);
		lblQuantitiy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblQuantitiy.setBounds(28, 221, 140, 41);
		contentPane.add(lblQuantitiy);
		
		JLabel lblPrice = new JLabel("Price          :");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrice.setBounds(28, 298, 140, 41);
		contentPane.add(lblPrice);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setForeground(Color.WHITE);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDescription.setBounds(28, 377, 134, 41);
		contentPane.add(lblDescription);
		
		JLabel lblPicture = new JLabel("Picture       :");
		lblPicture.setForeground(Color.WHITE);
		lblPicture.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPicture.setBounds(28, 459, 134, 41);
		contentPane.add(lblPicture);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(193, 459, 268, 151);
		contentPane.add(lblNewLabel);
		
		
		
		textField = new JTextField();
		textField.setBounds(193, 155, 206, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(193, 304, 206, 32);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(193, 227, 206, 32);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(193, 388, 206, 32);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(193, 81, 206, 32);
		contentPane.add(textField_4);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBackground(new Color(220, 20, 60));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				_2_Product.main(null);
			}
		});
		btnCancel.setBounds(55, 708, 181, 41);
		contentPane.add(btnCancel);
		
		
		JButton btnChoosePicture = new JButton("Choose Picture");
		btnChoosePicture.setForeground(Color.WHITE);
		btnChoosePicture.setBackground(new Color(205, 133, 63));
		btnChoosePicture.setBounds(193, 628, 268, 25);
		btnChoosePicture.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e){
	            JFileChooser fileChooser = new JFileChooser();
	            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
	            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
	            fileChooser.addChoosableFileFilter(filter);
	            int result = fileChooser.showSaveDialog(null);
	            if(result == JFileChooser.APPROVE_OPTION){
	                File selectedFile = fileChooser.getSelectedFile();
	                String path = selectedFile.getAbsolutePath();
	                s = path;
	                ImageIcon MyImage = new ImageIcon(s);
	                Image img = MyImage.getImage();
	                Image newImage = img.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(),Image.SCALE_SMOOTH);
	                ImageIcon image1 = new ImageIcon(newImage);
	                
	                lblNewLabel.setIcon(image1);
	            }
	            else if(result == JFileChooser.CANCEL_OPTION){
	                System.out.println("No Data");
	            }
	        }
	       });
		contentPane.add(btnChoosePicture);
		

		JButton btnInsert = new JButton("INSERT");
		btnInsert.setForeground(Color.WHITE);
		btnInsert.setBackground(new Color(0, 255, 102));
		btnInsert.setBounds(302, 708, 181, 41);
		btnInsert.addActionListener(new ActionListener(){
		    
		       @Override
		       public void actionPerformed(ActionEvent e){
		           try{
		               Connection con = DriverManager.getConnection("jdbc:mysql://localhost/aman?useSSL=false","root","");
		               PreparedStatement ps = con.prepareStatement("insert into Product(P_Name,Price,Qty ,P_Image ,Description , Category) values(?,?,?,?,?,?)");
		               InputStream is = new FileInputStream(new File(s));
		               
//		               ps.setInt(1, 1);
		               ps.setString(1, textField.getText());
		               ps.setDouble(2, Double.parseDouble(textField_1.getText()));
		               ps.setInt(3,Integer.parseInt(textField_2.getText()));
		               ps.setBlob(4, is);
		               ps.setString(5, textField_3.getText());    //tf3 = description
		               ps.setInt(6,Integer.parseInt(textField_4.getText()));
		               ps.executeUpdate();
		               JOptionPane.showMessageDialog(null, "Data Inserted");
		           }catch(Exception ex){
		               ex.printStackTrace();
		           }
		           frame.dispose();
		           _2_Product.main(null); 
		       }
		    });
		contentPane.add(btnInsert);
	}
}
