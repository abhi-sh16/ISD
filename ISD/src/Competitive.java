

import java.awt.event.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;
public class Competitive {
String s1,s2,s3,s4,s5;
JFrame f=new JFrame("Competitive");

		public static void main(boolean x) 
				{
				
					Competitive c =new Competitive(x);
				}



public Competitive(boolean x) {

f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//String s1,s2,s3,s4;

JLabel l = new JLabel("Comp. Name : ");
JLabel l1 = new JLabel("Level : ");
JLabel l2 = new JLabel("Start_date : ");
JLabel l3 = new JLabel("End_date : ");
JLabel l4 = new JLabel("Roll_No : ");
JLabel l5 = new JLabel(" Out member : ");
JLabel la = new JLabel("Achievements : ");
JLabel lp = new JLabel("Position : ");
JLabel lid = new JLabel("Clg team-id : ");
JLabel lor = new JLabel("OR : ");
JButton b= new JButton("Done");
JButton b1= new JButton("Submit");
JButton b2= new JButton("Add More");
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
t1=new JTextField();
t2=new JTextField();
t3=new JTextField();
t4=new JTextField();
t5=new JTextField();
t6=new JTextField();
t7=new JTextField();
t8=new JTextField();
t9=new JTextField();

s1 = t2.getText();
s2 = t3.getText();
s3 = t4.getText();
s4 = t5.getText();
s5 = t6.getText();

l4.setBounds(50,40,200,30);
l.setBounds(50,80,200,30);
l1.setBounds(50,120,200,30);
l2.setBounds(50,160,200,30);
l3.setBounds(50,200,200,30);
l5.setBounds(50,240,200,30);
la.setBounds(50,280,200,30);
lor.setBounds(50,320,200,20);
lp.setBounds(50,350,200,30);
lid.setBounds(50,390,200,30);


t1.setBounds(160,40,300,30);
t2.setBounds(160,80, 300, 30);
t3.setBounds(160,120,300,30);
t4.setBounds(160,160, 300, 30);
t5.setBounds(160,200,300,30);
t6.setBounds(160,240,100,30);
t7.setBounds(160,280,300,30);
t8.setBounds(160,350,300,30);
t9.setBounds(160,390,300,30);

b.setBounds(180,430,80,40);
b1.setBounds(280,240,100,30);
b2.setBounds(400,240,120,30);
f.add(l);
f.add(l1);
f.add(l2);
f.add(l3);
f.add(l4);
f.add(l5);
f.add(lp);
f.add(la);
f.add(lor);
f.add(lid);

f.add(t1);
f.add(t2);
f.add(t3);
f.add(t4);
f.add(t5);
f.add(t6);
f.add(t7);
f.add(t8);
f.add(t9);
f.add(b);


f.add(b2);
f.add(b1);
f.setSize(800,800);
f.setLayout(null);
f.setVisible(true);

b.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae1) {
try {
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  

		Statement stmti=con.createStatement();
		String qi = "select *from competitive";
					
		ResultSet rsi = stmti.executeQuery(qi);
	
		
		int count =0;
		while (rsi.next()) {
			count++;
			System.out.print(count);
		}
		rsi.absolute(count);
		
		//System.out.print(rsi.getInt(2));
		
		Statement stmt1=con.createStatement();
		
							Statement stmtf0=con.createStatement();
							String f0 ="SET FOREIGN_KEY_CHECKS=0";
							stmtf0.execute(f0);
							
		String q1 ="update competitive set"
							+"comp_name='"+s1+"',level='"+s2+"',start_date='"+s3+"',end_date='"+s3+"'"
							+ "where cact_id = '"+rsi.getInt(1)+"'";
						stmt1.executeUpdate(q1);
						
							Statement stmtf1=con.createStatement();
		    				String f1 ="SET FOREIGN_KEY_CHECKS=1";
		    				stmtf1.execute(f1);				
						
						b1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent ae2) {
								try {
									Class.forName("com.mysql.jdbc.Driver"); 
									Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  
									Statement stmtmem=con.createStatement();	
									String mem = "insert into mem_out (m_name,app_id,resp_id) values"
											+ "('"+t6.getText()+"','"+rsi.getInt(6)+"','"+rsi.getInt(7)+"')";									
									stmtmem.executeUpdate(mem);
								}catch(Exception e1) {System.out.println(e1);}
								
							}});
						
						
						if(t7.getText()!=null ||t8.getText() ==null )
						{
							Statement pre =con.createStatement();
							String prep ="update participation set achievement='"+t7.getText()+"',clg_team_id='"+t9.getText()+"'"
									+ "where app_id='"+rsi.getInt(6)+"'";
							pre.executeUpdate(prep);
						}	
						else if(t7.getText()==null ||t8.getText() !=null )
						{
							Statement pre =con.createStatement();
							String prep ="update responsibility set position='"+t8.getText()+"',clg_team_id='"+t9.getText()+"'"
									+ " where resp_id = '"+rsi.getInt(7)+"'";
							pre.executeUpdate(prep);
						}
						else 
						{
							JOptionPane.showMessageDialog(null,"Choose only one ");
						}
						
						}catch(Exception e1) {System.out.println(e1);}
						JOptionPane.showMessageDialog(null,"Successfully updated");
						f.dispose();
						

						

						}
						});



						
}
//edit activity

public  Competitive(JTextField v) {
	JFrame f1 = new JFrame();
	f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	//String s1,s2,s3,s4;

	JLabel l = new JLabel("Comp. Name : ");
	JLabel l1 = new JLabel("Level : ");
	JLabel l2 = new JLabel("Start_date : ");
	JLabel l3 = new JLabel("End_date : ");
	JLabel l4 = new JLabel("Roll_No : ");
	JLabel l5 = new JLabel("Members : ");
	JButton b= new JButton("Done");
	JButton b1= new JButton("Submit");
	JButton b2= new JButton("Add More");
	JTextField t1,t2,t3,t4,t5,t6;
	t1=new JTextField();
	t2=new JTextField();
	t3=new JTextField();
	t4=new JTextField();
	t5=new JTextField();
	t6=new JTextField();

	s1 = t2.getText();
	s2 = t3.getText();
	s3 = t4.getText();
	s4 = t5.getText();
	s5 = t6.getText();

	l4.setBounds(50,40,200,30);
	l.setBounds(50,80,200,30);
	l1.setBounds(50,120,200,30);
	l2.setBounds(50,160,200,30);
	l3.setBounds(50,200,200,30);
	l5.setBounds(50,240,200,30);


	t1.setBounds(160,40,300,30);
	t2.setBounds(160,80, 300, 30);
	t3.setBounds(160,120,300,30);
	t4.setBounds(160,160, 300, 30);
	t5.setBounds(160,200,300,30);
	t6.setBounds(160,240,100,30);

	b.setBounds(180,280,80,40);
	b1.setBounds(280,240,100,30);
	b2.setBounds(400,240,120,30);
	f1.add(l);
	f1.add(l1);
	f1.add(l2);
	f1.add(l3);
	f1.add(l4);
	f1.add(l5);

	f1.add(t1);
	f1.add(t2);
	f1.add(t3);
	f1.add(t4);
	f1.add(t5);
	f1.add(t6);

	f1.add(b);


	f1.add(b2);
	f1.add(b1);
	f1.setSize(600,600);
	f1.setLayout(null);
	f1.setVisible(true);

	b.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent ae1) {
	try {
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  
			
			
			
			Statement stmt1=con.createStatement();
			String q1;
		 
				q1 ="update competitive set"
						+"comp_name='"+s1+"',level='"+s2+"',start_date='"+s3+"',end_date='"+s3+"'"
								+ "where cact_id = '"+v.getText()+"'";
						
								
			stmt1.executeUpdate(q1);
			
			
			
			
				


							}catch(Exception e1) {System.out.println(e1);}
							JOptionPane.showMessageDialog(null,"Successfully updated");
							f1.dispose();
							}
							});
	
}



}
