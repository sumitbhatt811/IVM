package Mini;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;
import java.util.ArrayList;
import java.awt.event.*;


public class _2_Product extends JFrame {

	static _2_Product frame;
	private JPanel contentPane;
	private JTable table;


    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new _2_Product();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public _2_Product() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1292, 951);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] columnName = {"Id","Name","Price","Qty","Image","Description","Category"};
		String[][] dat = null;
		 table = new JTable( dat , columnName);
		 table.setBounds(355,46,881,20);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnInsert.setForeground(Color.WHITE);
		btnInsert.setBackground(new Color(102, 204, 102));
		btnInsert.setBounds(50, 274, 245, 47);
		btnInsert.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				_3_AddProduct.main(null);
				frame.dispose();
			}
		});
		contentPane.add(btnInsert);
		
		JButton btnRemove = new JButton("REMOVE");
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRemove.setForeground(Color.WHITE);
		btnRemove.setBackground(new Color(255, 0, 51));
		btnRemove.setBounds(50, 423, 245, 47);
		contentPane.add(btnRemove);
	
		initComponents();
        populateJTable();
        
	}
    private void initComponents() {

       // jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4","Title 5","Title 6","Title 7"
            }
        ));
//        jScrollPane1.setViewportView(jTable1);
//        contentPane.add(jScrollPane1);
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//                .addContainerGap()
//                .addComponent(jScrollPane1)
//                .addContainerGap())
//            .addGroup(layout.createSequentialGroup()
//                .addGap(248, 248, 248)
//                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addContainerGap(261, Short.MAX_VALUE))
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addContainerGap()
//                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addGap(18, 18, 18)
//                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
//                .addContainerGap())
//        );

      //pack();
    }// </editor-fold>                                                            

    
    public void populateJTable(){
        MyQuery mq = new MyQuery();
        ArrayList<Product2> list = mq.BindTable();
        String[] columnName = {"Id","Name","Price","Qty","Image","Description","Category"};
        Object[][] rows = new Object[list.size()][7];
//        rows[0][0] = "ID";
//        rows[0][1] = "Name";
//        rows[0][2] = "Price";
//        rows[0][3] = "Qty";
//        rows[0][4] = "Image";
//        rows[0][5] = "Desc";
//        rows[0][6] = "Category";
        
        for(int i = 0; i < list.size(); i++){
        
        	rows[i][0] = list.get(i).getID();
            rows[i][1] = list.get(i).getName();
            rows[i][3] = list.get(i).getQte();
            rows[i][2] = list.get(i).getPrice();
            
            if(list.get(i).getMyImage() != null){
                
             ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getMyImage()).getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH) );   
             rows[i][4] = image;
             
            }
            else{
                rows[i][4] = null;
            }
            rows[i][5] = list.get(i).getDesc();
            rows[i][6] = list.get(i).getCatID();
        }
        
        TheModel model = new TheModel(rows, columnName);
        jTable1.setModel(model);
        jTable1.setRowHeight(120);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTable1.setBounds(355, 66, 881, 813);
        contentPane.add(jTable1);
    }
    
}
