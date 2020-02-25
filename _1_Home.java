package Mini;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.util.*;
import java.sql.*;
public class _1_Home {
public static void main (String[] args)
{
	try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/aman","root","password");  
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from product");
			_5_Category obj=new _5_Category();
			JFrame f=new JFrame();
			JButton p=new JButton("Product");
			p.setFont(new Font("Helvetica",Font.PLAIN,18));
			p.setBounds(260,109,100,45);
			p.setBackground(Color.DARK_GRAY);
			p.setOpaque(true);
			p.setContentAreaFilled(true);
			p.setBorderPainted(false);
			p.setForeground(new Color(255,255,255));
			p.addActionListener(new ActionListener(){  
				 public void actionPerformed(ActionEvent e){  
					 		_2_Product.main(null);
					 		f.dispose();
				         }  
				     });  

			ImageIcon img=new ImageIcon("C:\\Users\\Sumit\\Desktop\\images\\mobileswithlaptop.jpeg");
			int offset = p.getInsets().left;
			p.setIcon(resizeIcon(img, p.getWidth() - offset, p.getHeight() - offset));
			JButton ca=new JButton("Category");
			ca.setBounds(460,109,130,45);
			ca.setBackground(Color.DARK_GRAY);
			ca.setFont(new Font("Helvetica",Font.PLAIN,18));
			ca.setOpaque(true);
			ca.setContentAreaFilled(true);
			ca.setBorderPainted(false);
			ca.setForeground(new Color(255,255,255));
			ca.addActionListener(new ActionListener(){  
				 public void actionPerformed(ActionEvent e){  
					 		_5_Category.main(null);
					 		f.dispose();
				         }  
				     });  
			JButton cu=new JButton("Customer");
			cu.setBounds(928,109,130,45);
			cu.setBackground(Color.DARK_GRAY);
			cu.setFont(new Font("Helvetica",Font.PLAIN,18));
			cu.setOpaque(true);
			cu.setContentAreaFilled(true);
			cu.setBorderPainted(false);
			cu.setForeground(new Color(255,255,255));
			cu.addActionListener(new ActionListener(){  
				 public void actionPerformed(ActionEvent e){  
					 		_4_Customer.main(null);
					 		f.dispose();
				         }  
				     });  

			JButton or=new JButton("Order");
			or.setBounds(728,109,100,45);
			or.setBackground(Color.DARK_GRAY);
			or.setFont(new Font("Helvetica",Font.PLAIN,18));
			or.setOpaque(true);
			or.setContentAreaFilled(true);
			or.setBorderPainted(false);
			or.setForeground(new Color(255,255,255));
			or.addActionListener(new ActionListener(){  
				 public void actionPerformed(ActionEvent e){  
					 		_6_Order.main(null);
					 		f.dispose();
				         }  
				     });  

			JLabel l1=new JLabel("My store");
			l1.setText("My Store");
			l1.setBackground(Color.RED);
			l1.setFont(new Font("Serif",Font.BOLD,30));
			//l1.setFont(new Font("Serif", Font.ITALIC,Font.CENTER_BASELINE));
			l1.setOpaque(false);
			l1.setForeground(new Color(0,0,0));
			l1.setBounds(618,39,120,50);
		//	l1.setHorizontalAlignment(JLabel.CENTER);
		//	l1.setVerticalAlignment(JLabel.CENTER);
			f.getContentPane().add(l1);
			f.getContentPane().add(or);
			f.getContentPane().add(cu);
			f.getContentPane().add(ca);
			f.getContentPane().add(p);
//			BufferedImage img2= null;
//			try {
//			    img2 = ImageIO.read(new File("C:\\\\Users\\\\Sumit\\\\Desktop\\\\images\\\\storeminipro.jpeg"));
//			} catch (IOException e) {
//			    e.printStackTrace();
//			}
//			BufferedImage img2=null;
//			img2=ImageIO.read(new File("C:\\Users\\Sumit\\Desktop\\images\\storeminipro.jpeg"));
			//JLabel background = new JLabel(new ImageIcon(img2));
			//f.add(background);
			//f.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Sumit\\Desktop\\images\\storeminipro.jpeg")));
			f.setExtendedState(JFrame.MAXIMIZED_BOTH);
			f.setUndecorated(true);
			f.getContentPane().setLayout(null);
			
			JLabel l2 = new JLabel();
			l2.setBounds(0, 0, 1366, 767);
			ImageIcon img2=new ImageIcon("C:\\Users\\Sumit\\Desktop\\images\\storeminipro.jpg");
			Image img3=img2.getImage();
			Image img4=img3.getScaledInstance(l2.getWidth(),l2.getHeight(),Image.SCALE_SMOOTH);
			ImageIcon image=new ImageIcon(img4);
			l2.setIcon(image);
//			l1.setIcon(new ImageIcon("C:\\Users\\Sumit\\Desktop\\images\\storeminipro.jpg"));
			f.getContentPane().add(l2);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
	}
	catch(Exception e){ System.out.println(e);}  
}

private static Icon resizeIcon(ImageIcon img, int i, int j) {
	// TODO Auto-generated method stub
	return null;
}
}
