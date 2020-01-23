
import javax.swing.*;
import javax.xml.transform.Source;

import net.proteanit.sql.DbUtils;

import java.awt.event.*;
import java.awt.*;


import java.sql.*;

public class Student{
 String s1,s2,s3,s4,s5,s6,s7,s8,s9;
private JFrame f=new JFrame("Edit Student Info");
private JFrame f1=new JFrame("Student Profile");

//private JFrame fa = new JFrame("Application"); 
   
private JButton b= new JButton("Done");
private JButton b1= new JButton("Edit Profile");
private JButton b2= new JButton("Activities");

private JButton b3= new JButton("SignOut");



			public static void main(String s) 
			{
			
				new Student(s);
				
				
					
			}

public String setStudent(String x,String y,String z) 
{
		this.s1=x;
		this.s3=y;
		this.s5=z;
		return s1;
}

//   Constructor of Student Class**********


public  Student(String ra) {
	
	f1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	f1.getContentPane().add(b1);
	f1.getContentPane().add(b2);
	f1.getContentPane().setLayout(new FlowLayout());  
	  
	 
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
	JLabel l = new JLabel("Roll No. : ");
	JLabel l1 = new JLabel("Name : ");
	JLabel l2 = new JLabel("Email : ");
	JLabel l3 = new JLabel("Address : ");
	JLabel l4 = new JLabel("Mobile No. : ");
	JLabel l5 = new JLabel("CGPA : ");
	JLabel l6 = new JLabel("Hostel name : ");
	JLabel l7 = new JLabel("Room no. : ");
	JLabel l8 = new JLabel("Date of birth : ");
	
	t1= new JTextField();
	t2=new JTextField();
	t3=new JTextField();
	t4=new JTextField();
	t5=new JTextField();
	t6=new JTextField();
	t7=new JTextField();
	t8=new JTextField();
	t9=new JTextField();
	
	
	try {
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  

		String q2="select * from student where roll_no='"+ra+"'";
		Statement stmt2=con.createStatement();
		ResultSet rs1 = stmt2.executeQuery(q2);
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);  
		 
	       f1.getContentPane().add(splitPane);  
		
		while(rs1.next())
			{
		 this.s1 = rs1.getString(1);
		System.out.print(s1  );
		this.s2 = rs1.getString(2);
		System.out.print(s2);
		this.s3 = rs1.getString(3);
		System.out.print(s3);
		this.s4 = rs1.getString(4);
		System.out.print(s4);
		this.s5 = rs1.getString(5);
		System.out.print(s5);
		this.s6 = rs1.getString(6);
		System.out.print(s6);
		this.s7 = rs1.getString(7);
		System.out.print(s7);
		this.s8 = rs1.getString(8);
		System.out.print(s8);
		this.s9 = rs1.getString(9);
		System.out.print(s9);
		System.out.println(" ");
		}



		}catch(Exception e1) {System.out.println(e1);}

	
			





       
       this.b1.addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent ae) {
    		  // f1.dispose();
        	   edit_info();
        	   
    	   }
    	   });
       this.b2.addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent ae1) {
    	   	new Activity(s1);
    	   }

    	   });
       
       this.b3.addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent ae) {
    		 
    		   f1.dispose();
    		   System.exit(1);
    	   }

				    	   });
       JButton br1 = new JButton("Competitive        ");
		JButton br2 = new JButton("Non-Competitive");
		JButton br3 = new JButton("Entrepreneurial  ");
		
		
						br1.addActionListener(new ActionListener() {
					    	   public void actionPerformed(ActionEvent ae1) {
					    		   boolean x =false;
					    		   new Competitive(x);
					    		   try {
					    				Class.forName("com.mysql.jdbc.Driver"); 
					    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  
					    				Statement stmt0=con.createStatement();
					    				String ap= "not approved";
					    				String q0 = "insert into participation(roll_no,status) values('"+s1+"','"+ap+"')";
					    				stmt0.executeUpdate(q0);
					    				Statement stmti=con.createStatement();
					    				String  qi = "select *from responsibility";
					    				ResultSet rsi = stmti.executeQuery(qi);
					    			
					    				
					    				int count =0;
					    				while (rsi.next()) {
					    					count++;
					    					System.out.print(count);
					    				}
					    				rsi.absolute(count);
					    				
					    				Statement stmt1=con.createStatement();
					    				Statement stmtf0=con.createStatement();
					    				String f0 ="SET FOREIGN_KEY_CHECKS=0";
					    				stmtf0.execute(f0);
					    				String q1 ="insert into competitive (resp_id) values('"+rsi.getInt(2)+"')";
					    				stmt1.executeUpdate(q1);
					    				Statement stmtf1=con.createStatement();
					    				
					    				String f1 ="SET FOREIGN_KEY_CHECKS=1";
					    				stmtf1.execute(f1);							
					    				
					    				
					   
					    								}catch(Exception e1) {System.out.println(e1);}

							    	   }
						
							    	   });
						br2.addActionListener(new ActionListener() {
					    	   public void actionPerformed(ActionEvent ae1) {
					    		   boolean x = false;
					    		   new Non_Competitive(x);
					    		   try {
					    				Class.forName("com.mysql.jdbc.Driver"); 
					    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  
					    				Statement stmt0=con.createStatement();
					    				String ap= "not approved";
					    				String q0 = "insert into participation(roll_no,status) values('"+s1+"','"+ap+"')";
					    				stmt0.executeUpdate(q0);
					    				Statement stmti=con.createStatement();
					    				String  qi = "select *from responsibility";
					    				ResultSet rsi = stmti.executeQuery(qi);
					    			
					    				
					    				int count =0;
					    				while (rsi.next()) {
					    					count++;
					    					System.out.print(count);
					    				}
					    				rsi.absolute(count);
					    				
					    				Statement stmt1=con.createStatement();
					    				
					    				Statement stmtf0=con.createStatement();
					    				String f0 ="SET FOREIGN_KEY_CHECKS=0";
					    				stmtf0.execute(f0);
					    				String q1 ="insert into non_competitive (resp_id) values('"+rsi.getInt(2)+"')";
					    				stmt1.executeUpdate(q1);
					    				Statement stmtf1=con.createStatement();
					    				String f1 ="SET FOREIGN_KEY_CHECKS=1";
					    				stmtf1.execute(f1);
					    		 									
					    				
					   
					    								}catch(Exception e1) {System.out.println(e1);}

							    	   }
						
							    	   });
						br3.addActionListener(new ActionListener() {
					 	   public void actionPerformed(ActionEvent ae1) {
					 	   	boolean x = false;
					 		   new Entrepreneurial(x);
					 		  try {
				    				Class.forName("com.mysql.jdbc.Driver"); 
				    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  
				    				Statement stmt0=con.createStatement();
				    				String ap= "not approved";
				    				String q0 = "insert into participation(roll_no,status) values('"+s1+"','"+ap+"')";
				    				stmt0.executeUpdate(q0);
				    				Statement stmti=con.createStatement();
				    				String  qi = "select *from responsibility";
				    				ResultSet rsi = stmti.executeQuery(qi);
				    			
				    				
				    				int count =0;
				    				while (rsi.next()) {
				    					count++;
				    					System.out.print(count);
				    				}
				    				rsi.absolute(count);
				    				
				    				Statement stmt1=con.createStatement();
				    				Statement stmtf0=con.createStatement();
				    				String f0 ="SET FOREIGN_KEY_CHECKS=0";
				    				stmtf0.execute(f0);
				    				String q1 ="insert into entrepreneur (resp_id) values('"+rsi.getInt(2)+"')";
				    				stmt1.executeUpdate(q1);
				    				Statement stmtf1=con.createStatement();
				    				String f1 ="SET FOREIGN_KEY_CHECKS=1";
				    				stmtf1.execute(f1);
				    		 									
				    				
				   
				    								}catch(Exception e1) {System.out.println(e1);}

						    	   }
					
						    	   });
		JButton bp1 = new JButton("Competitive        ");
		JButton bp2 = new JButton("Non-Competitive");
		JButton bp3 = new JButton("Entrepreneurial  ");
		
		
						bp1.addActionListener(new ActionListener() {
					    	   public void actionPerformed(ActionEvent ae1) {
					    		   boolean x = false;
					    		  new Competitive(x);
					    		   try {
					    				Class.forName("com.mysql.jdbc.Driver"); 
					    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  
					    				Statement stmt0=con.createStatement();
					    				String ap= "not approved";
					    				String q0 = "insert into participation(roll_no,status) values('"+s1+"','"+ap+"')";
					    				stmt0.executeUpdate(q0);
					    				Statement stmti=con.createStatement();
					    				String  qi = "select *from participation";
					    				ResultSet rsi = stmti.executeQuery(qi);
					    			
					    				
					    				int count =0;
					    				while (rsi.next()) {
					    					count++;
					    					System.out.print(count);
					    				}
					    				rsi.absolute(count);
					    				
					    				Statement stmt1=con.createStatement();
					    				Statement stmtf0=con.createStatement();
					    				String f0 ="SET FOREIGN_KEY_CHECKS=0";
					    				stmtf0.execute(f0);
					    				String q1 ="insert into competitive (app_id) values('"+rsi.getInt(2)+"')";
					    				stmt1.executeUpdate(q1);
					    				Statement stmtf1=con.createStatement();
					    				String f1 ="SET FOREIGN_KEY_CHECKS=1";
					    				stmtf1.execute(f1);
					    							
					    							
					    									
					    				
					    				
					    				
					    				
					    				
					    					


					    								}catch(Exception e1) {System.out.println(e1);}

					    	   }
				
					    	   });
						bp2.addActionListener(new ActionListener() {
					    	   public void actionPerformed(ActionEvent ae1) {
					    		   boolean x =false;
					    		   new Non_Competitive(x);
					    		   try {
					    				Class.forName("com.mysql.jdbc.Driver"); 
					    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  
					    				Statement stmt0=con.createStatement();
					    				String ap= "not approved";
					    				String q0 = "insert into participation(roll_no,status) values('"+s1+"','"+ap+"')";
					    				stmt0.executeUpdate(q0);
					    				Statement stmti=con.createStatement();
					    				String  qi = "select *from participation";
					    				ResultSet rsi = stmti.executeQuery(qi);
					    			
					    				
					    				int count =0;
					    				while (rsi.next()) {
					    					count++;
					    					System.out.print(count);
					    				}
					    				rsi.absolute(count);
					    				
					    				Statement stmt1=con.createStatement();
					    				Statement stmtf0=con.createStatement();
					    				String f0 ="SET FOREIGN_KEY_CHECKS=0";
					    				stmtf0.execute(f0);
					    				String q1 ="insert into non_competitive (app_id) values('"+rsi.getInt(2)+"')";
					    				stmt1.executeUpdate(q1);
					    				Statement stmtf1=con.createStatement();
					    				String f1 ="SET FOREIGN_KEY_CHECKS=1";
					    				stmtf1.execute(f1);
					    		 									
					    				
					   
					    								}catch(Exception e1) {System.out.println(e1);}

							    	   }
						
							    	   });
						
						
						bp3.addActionListener(new ActionListener() {
					 	   public void actionPerformed(ActionEvent ae1) {
					 	   	boolean x = false;
					 		   new Entrepreneurial(x);
					 		  try {
				    				Class.forName("com.mysql.jdbc.Driver"); 
				    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  
				    				Statement stmt0=con.createStatement();
				    				String ap= "not approved";
				    				String q0 = "insert into participation(roll_no,status) values('"+s1+"','"+ap+"')";
				    				stmt0.executeUpdate(q0);
				    				Statement stmti=con.createStatement();
				    				String  qi = "select *from participation";
				    				ResultSet rsi = stmti.executeQuery(qi);
				    			
				    				
				    				int count =0;
				    				while (rsi.next()) {
				    					count++;
				    					System.out.print(count);
				    				}
				    				rsi.absolute(count);
				    				
				    				Statement stmt1=con.createStatement();
				    				Statement stmtf0=con.createStatement();
				    				String f0 ="SET FOREIGN_KEY_CHECKS=0";
				    				stmtf0.execute(f0);
				    				String q1 ="insert into entrepreneur(app_id) values('"+rsi.getInt(2)+"')";
				    				stmt1.executeUpdate(q1);
				    				Statement stmtf1=con.createStatement();
				    				String f1 ="SET FOREIGN_KEY_CHECKS=1";
				    				stmtf1.execute(f1);
				    		 									
				    				
				   
				    								}catch(Exception e1) {System.out.println(e1);}

						    	   }
					
						    	   });
		JMenuBar x = new JMenuBar();
		JMenu a = new JMenu("Apply    ");
		JMenu a1 = new JMenu("Responsibilty    ");
		JMenu a2 = new JMenu("Participation    ");
		x.add(a);
		a.add(a1);
		
		
		a.add(a2);
		a2.add(bp1);
		a2.add(bp2);
		a2.add(bp3);
		a1.add(br1);
		a1.add(br2);
		a1.add(br3);
       l.setBounds(150,40,200,30);
       l1.setBounds(150,80,200,30);
       l2.setBounds(150,120,200,30);
       l3.setBounds(150,160,200,30);
       l4.setBounds(150,200,200,30);
       l5.setBounds(150,240,200,30);
       l6.setBounds(150,280,200,30);
       l7.setBounds(150,320,200,30);
       l8.setBounds(150,360,200,30);



       t1.setBounds(300,40, 200, 30);
       t2.setBounds(300,80,200,30);
       t3.setBounds(300,120, 200, 30);
       t4.setBounds(300,160,200,30);
       t5.setBounds(300,200,200,30);
       t6.setBounds(300,240,200,30);
       t7.setBounds(300,280,200,30);
       t8.setBounds(300,320,200,30);
       t9.setBounds(300,360,200,30);       	

this.b1.setBounds(150,400,150,40);
this.b3.setBounds(150,460,150,40);
x.setBounds(340,460,100,40);
this.b2.setBounds(340,400,150,40);
f1.add(l);
f1.add(l1);
f1.add(l2);
f1.add(l3);
f1.add(l4);
f1.add(l5);
f1.add(l6);
f1.add(l7);
f1.add(l8);
f1.add(t1);
f1.add(t2);
f1.add(t3);
f1.add(t4);
f1.add(t5);
f1.add(t6);
f1.add(t7);
f1.add(t8);
f1.add(t9);
t1.setText(s1);
t1.setEditable(false);
t1.setBackground(Color.white);
t2.setText(s2);
t2.setBackground(Color.white);
t2.setEditable(false);
t3.setText(s3);t3.setBackground(Color.white);
t3.setEditable(false);
t4.setText(s4);t4.setBackground(Color.white);
t4.setEditable(false);
t5.setText(s5);t5.setBackground(Color.white);
t5.setEditable(false);
t6.setText(s6);t6.setBackground(Color.white);
t6.setEditable(false);
t7.setText(s7);t7.setBackground(Color.white);
t7.setEditable(false);
t8.setText(s8);t8.setBackground(Color.white);
t8.setEditable(false);
t9.setText(s9);t9.setBackground(Color.white);
t9.setEditable(false);

f1.add(b1);
f1.add(b2);
f1.add(b3);
f1.add(x);
f1.setSize(600, 700);
f1.setLayout(null);
f1.setVisible(true);

}



		// Edit Function ************************************



		public void edit_info() {
		f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		f.getContentPane().add(this.b);
		f.getContentPane().setLayout(new FlowLayout());  
		
		 
		JLabel l = new JLabel("Roll No. : ");
		JLabel l1 = new JLabel("Name : ");
		JLabel l2 = new JLabel("Email : ");
		JLabel l3 = new JLabel("Address : ");
		JLabel l4 = new JLabel("Mobile No. : ");
		JLabel l5 = new JLabel("Cgpa : ");
		JLabel l6 = new JLabel("Hostel name : ");
		JLabel l7 = new JLabel("Room no. : ");
		JLabel l8 = new JLabel("Date of birth : ");
	//	JButton b= new JButton("Done");
		JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);  
		 
		       f.getContentPane().add(splitPane);  
		t1= new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		t5=new JTextField();
		t6=new JTextField();
		t7=new JTextField();
		t8=new JTextField();
		t9=new JTextField();
		
		t1.setText(this.s1);
		t1.setEditable(false);
		l.setBounds(50,40,200,30);
		l1.setBounds(50,80,200,30);
		l2.setBounds(50,120,200,30);
		l3.setBounds(50,160,200,30);
		l4.setBounds(50,200,200,30);
		l5.setBounds(50,240,200,30);
		l6.setBounds(50,280,200,30);
		l7.setBounds(50,320,200,30);
		l8.setBounds(50,360,200,30);
		
		
		
		
		t1.setBounds(150,40, 200, 30);
		t2.setBounds(150,80,200,30);
		t3.setBounds(150,120, 200, 30);
		t4.setBounds(150,160,200,30);
		t5.setBounds(150,200,200,30);
		t6.setBounds(150,240,200,30);
		t7.setBounds(150,280,200,30);
		t8.setBounds(150,320,200,30);
		t9.setBounds(150,360,200,30);
		this.b.setBounds(150,400,80,40);
		f.add(l);
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(l5);
		f.add(l6);
		f.add(l7);
		f.add(l8);
		f.add(t1);
		f.add(t2);
		f.add(t3);
		f.add(t4);
		f.add(t5);
		f.add(t6);
		f.add(t7);
		f.add(t8);
		f.add(t9);
		f.add(this.b);
		
		this.b.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae1) {
		try {
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  
		
		String q1 ="update student set "
			
		+"s_name='"+t2.getText()+"',email_id='"+t3.getText()+"',address='"+t4.getText()+"',mob_no='"+t5.getText()+"',cgpa='"+t6.getText()+"',hostel_name='"+t7.getText()+"',room_no='"+t8.getText()+"',dob='"+t9.getText()+"'"
		+"where roll_no='"+t1.getText()+"'";
				
		PreparedStatement stmt1=con.prepareStatement(q1);
		//stmt1.setString(1,"+t2.getText()+'");
		stmt1.executeUpdate(q1);
		JOptionPane.showMessageDialog(null,"Successfully");
		String q2="select * from student where roll_no='"+s1+"'";
		Statement stmt2=con.createStatement();
		ResultSet rs1 = stmt2.executeQuery(q2);
		while(rs1.next()) {
		
		s2 = rs1.getString(2);
		System.out.print(s2);
		 s3 = rs1.getString(3);
		System.out.print(s3);
		 s4 = rs1.getString(4);
		System.out.print(s4);
		 s5 = rs1.getString(5);
		System.out.print(s5);
		 s6 = rs1.getString(6);
		System.out.print(s6);
		 s7 = rs1.getString(7);
		System.out.print(s7);
		 s8 = rs1.getString(8);
		System.out.print(s8);
		 s9 = rs1.getString(9);
		System.out.print(s9);
		System.out.println(" ");
		}
		
		
		
		}catch(Exception e1) {System.out.println(e1);}
		
		}
		});
		
		      
		      
		
		
		
		f.setSize(600, 700);
		f.setLayout(null);
		f.setVisible(true);
		
		
		
		         
	
		
		
		}

}


