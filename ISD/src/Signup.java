

import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
public class Signup {
	private JButton b= new JButton("Signup");
	private JButton b1= new JButton("or Login ");
	private JFrame f1=new JFrame("Signup");
 String s1,s2,s3,s4;
 public static void  main(String args[]) {
	 
		new Signup();
	}
	public  Signup() {
		
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setSize(300,300);
		f1.setVisible(true);
	
	
		

		
		JLabel l = new JLabel("Roll no ");
		JLabel l1 = new JLabel("Email : ");
		JLabel l2 = new JLabel("Contact no. : ");
		JLabel l3 = new JLabel("Password : ");
		
		JTextField t1,t2,t3,t4;
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		
		l.setBounds(50,40,200,30);
		l1.setBounds(50,80,200,30);
		l2.setBounds(50,120,200,30);
		l3.setBounds(50,160,200,30);
		t1.setBounds(150,40, 200, 30);
		t2.setBounds(150,80,200,30);
		t3.setBounds(150,120, 200, 30);
		t4.setBounds(150,160,200,30);
		b.setBounds(180,200,150,40);
		b1.setBounds(180,260,150,40);
		f1.add(l);
		f1.add(l1);
		f1.add(l2);
		f1.add(l3);
		f1.add(t1);
		f1.add(t2);
		f1.add(t3);
		f1.add(t4);
		f1.add(b);
		f1.add(b1);
		f1.setSize(400,400);
		f1.setLayout(null);
		f1.setVisible(true);
		
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae1) {
				try {
					Class.forName("com.mysql.jdbc.Driver"); 
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  
					Statement stmt1=con.createStatement();
					String q1 ="insert into student"
							+"(roll_no,mob_no,email_id)"
							+"values('"+t1.getText()+"','"+t3.getText()+"','"+t2.getText()+"')";
				
				Statement stmtp = con.createStatement();
				String pass = "insert into cr"
						+"(u,p)"
						+"values('"+t1.getText()+"','"+t4.getText()+"')";
				stmtp.executeUpdate(pass);
				stmt1.executeUpdate(q1);
				
				String q2="select * from signup";
				Statement stmt2=con.createStatement();
				ResultSet rs1 = stmt2.executeQuery(q2);
				
				
					
				Student a =  new Student(s1);
				 
			 a.setStudent(s1, s2, s3);
					
				}catch(Exception e1) {System.out.println(e1);}
				JOptionPane.showMessageDialog(null,"SIGNUP Successfull");
				//System.exit(1);
			
			}
		});
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae1) 
			{
		login();
				
			}
		});
		
	
	}
	
	
	
	
	
	public void login(){
		 JFrame f= new JFrame("Login Page");
		JButton b1= new JButton("Signup");
		f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		f.getContentPane().add(b1);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
				new Signup();
			}
		});
		
		
		JLabel l = new JLabel("Login");
		
		JButton b= new JButton("Login");
		
		JTextField t1;
		JPasswordField t2;
		JButton b2= new JButton("Forgot Password");
		JLabel l1=new JLabel("Username : ");
		JLabel l2=new JLabel("Password : ");
		t1=new JTextField();
		t2=new JPasswordField();
		l.setBounds(200,20,200,30);
		l1.setBounds(70,70,200,30);
		l2.setBounds(70,120,200,30);
		t1.setBounds(150,70, 200, 30);
		t2.setBounds(150,120,200,30);
		b.setBounds(70,170,150,40);
		b1.setBounds(70,240,150,40);
		b2.setBounds(250,170,200,20);
		
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae1) 
			{
				JOptionPane.showMessageDialog(null,"Contact Your IT Administration Office  Room No- 1041");
				System.exit(1);
				
			}
		});
		
		
		b.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae1) {
				
						try{  
					
					Class.forName("com.mysql.jdbc.Driver"); 
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  
					Statement stmt=con.createStatement();  
					String sql= ("select u,p from cr where u='"+t1.getText()+"'and p='"+t2.getText()+"'");
					
					
					ResultSet rs=stmt.executeQuery(sql); 
							
					
					
					if(rs.next()) {
						
							JOptionPane.showMessageDialog(null,"Login Successfully");
							
								f.dispose();
								f1.dispose();
								Student a = new Student(rs.getString(1));
								
							}
						
						else
						JOptionPane.showMessageDialog(null,"Check Username and Password");
					
					
					con.close();
				
						}
								catch(Exception e) 
						{System.out.print(e);}
						}	
						});

			
			  
		s1 = t1.getText();
		s2 = t2.getText();
		f.add(l);
		f.add(l1);
		f.add(l2);
		f.add(t1);
		f.add(t2);
		f.add(b);
		f.add(b1);
		f.add(b2);
		f.setSize(500,500);
		f.setLayout(null);
		f.setVisible(true);
		
	}

}
