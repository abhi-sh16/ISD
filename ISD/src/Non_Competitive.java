
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
public class Non_Competitive {
	String s1,s2,s3,s4,s5,s6;
JFrame f=new JFrame("Non_Competitive");
boolean x;
public static void main(boolean x) {
new Non_Competitive(x);
}
public Non_Competitive(boolean x) {

				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				f.setVisible(true);
				
				
				
				//String s1,s2,s3,s4;
				
				JLabel l = new JLabel("Event : ");
				JLabel l1 = new JLabel("level : ");
				JLabel l2 = new JLabel("Start_date : ");
				JLabel l3 = new JLabel(" End_date: ");
				JLabel l4 = new JLabel("Description : ");
				JLabel l5 = new JLabel("Members : ");
				JLabel li = new JLabel("Roll No : ");
				JButton b= new JButton("Done");
				JButton b1= new JButton("Submit");
				JButton b2= new JButton("Add More");
				JLabel la = new JLabel("Achievements : ");
				JLabel lp = new JLabel("Position : ");
				JLabel lid = new JLabel("Clg team-id : ");
				JLabel lor = new JLabel("OR : ");
				JTextField t1,t2,t3,t4,t5,t6,ti,t7,t8,t9;
				t1=new JTextField();
				t2=new JTextField();
				t3=new JTextField();
				t4=new JTextField();
				t5=new JTextField();
				t6=new JTextField();
				ti =new JTextField();
				t7 =new JTextField();
				t8 =new JTextField();
				t9 =new JTextField();
				
				s1 = t1.getText();
				s2 = t2.getText();
				s3 = t3.getText();
				s4 = t4.getText();
				s5 = t4.getText();
				s6 = t4.getText();
				li.setBounds(50,40,200,30);
				l.setBounds(50,80,200,30);
				l1.setBounds(50,120,200,30);
				l2.setBounds(50,160,200,30);
				l3.setBounds(50,200,200,30);
				l4.setBounds(50,240,200,30);
				l5.setBounds(50,280,200,30);
				la.setBounds(50,320,200,30);
				lor.setBounds(50,360,200,30);
				lp.setBounds(50,400,200,30);
				lid.setBounds(50,440,200,30);
				
				
				ti.setBounds(150,40, 200, 30);
				t1.setBounds(150,80,200,30);
				t2.setBounds(150,120, 200, 30);
				t3.setBounds(150,160,200,30);
				t4.setBounds(150,200, 200, 30);
				t5.setBounds(150,240,200,30);
				t6.setBounds(150,280,120,30);
				t7.setBounds(150,320,200,30);
				t8.setBounds(150,400,200,30);
				t9.setBounds(150,440,200,30);
				b.setBounds(180,480,80,40);
				b1.setBounds(280,280,100,30);
				b2.setBounds(400,280,120,30);
				f.add(li);
				f.add(l);
				f.add(l1);
				f.add(l2);
				f.add(l3);
				f.add(l4);
				f.add(l5);
				f.add(la);
				f.add(lp);
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
				f.add(ti);
				f.add(b1);
				f.add(b2);
				
				f.setSize(800,800);
				f.setLayout(null);
				f.setVisible(true);
				
				b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae1) {
				try {
					Class.forName("com.mysql.jdbc.Driver"); 
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  
				
				
					Statement stmti=con.createStatement();
					String qi = "select *from non_competitive";
								
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
    				
					String q1 ="update non_competitive set "
							+"event='"+s1+"',level'"+s2+"',start_date'"+s3+"',end_date'"+s4+"',description'"+s5+"')"
							+"where nact_id ='"+rsi.getInt(1)+"'";
									
					
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
														+ "('"+t6.getText()+"','"+rsi.getInt(7)+"','"+rsi.getInt(8)+"')";									
												stmtmem.executeUpdate(mem);
											}catch(Exception e1) {System.out.println(e1);}
									

										}});

									b1.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent ae2) {
											
									t6.setText(null);

										}});
								
				

								
												if(t7.getText()!=null ||t8.getText() ==null )
												{
													Statement pre =con.createStatement();
													String prep ="update participation set achievement='"+t8.getText()+"',clg_team_id='"+t9.getText()+"'"
													+ "  where app_id = '"+rsi.getInt(7)+"'";
													pre.executeUpdate(prep);
												}	
												else if(t7.getText()==null ||t8.getText() !=null )
												{
													Statement pre =con.createStatement();
													String prep ="update responsibility set positiont='"+t8.getText()+"',clg_team_id='"+t9.getText()+"'"
															+ "  where resp_id = '"+rsi.getInt(8)+"'";
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

		public Non_Competitive(JTextField v) 
		{
			JFrame f1 = new JFrame();
			f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			f1.setVisible(true);
			
			
			
			//String s1,s2,s3,s4;
			
			JLabel l = new JLabel("Event : ");
			JLabel l1 = new JLabel("level : ");
			JLabel l2 = new JLabel("Start_date : ");
			JLabel l3 = new JLabel(" End_date: ");
			JLabel l4 = new JLabel("Description : ");
			JLabel l5 = new JLabel("Members : ");
			JLabel li = new JLabel("Roll No : ");
			JButton b= new JButton("Done");
			JButton b1= new JButton("Submit");
			JButton b2= new JButton("Add More");
			JTextField t1,t2,t3,t4,t5,t6,ti;
			t1=new JTextField();
			t2=new JTextField();
			t3=new JTextField();
			t4=new JTextField();
			t5=new JTextField();
			t6=new JTextField();
			ti =new JTextField();
			
			s1 = t1.getText();
			s2 = t2.getText();
			s3 = t3.getText();
			s4 = t4.getText();
			s5 = t4.getText();
			s6 = t4.getText();
			li.setBounds(50,40,200,30);
			l.setBounds(50,80,200,30);
			l1.setBounds(50,120,200,30);
			l2.setBounds(50,160,200,30);
			l3.setBounds(50,200,200,30);
			l4.setBounds(50,240,200,30);
			l5.setBounds(50,280,200,30);
			
			
			ti.setBounds(150,40, 200, 30);
			t1.setBounds(150,80,200,30);
			t2.setBounds(150,120, 200, 30);
			t3.setBounds(150,160,200,30);
			t4.setBounds(150,200, 200, 30);
			t5.setBounds(150,240,200,30);
			t6.setBounds(150,280,120,30);
			b.setBounds(180,320,80,40);
			b1.setBounds(280,280,100,30);
			b2.setBounds(400,280,120,30);
			f1.add(li);
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
			f1.add(ti);
			f1.add(b1);
			f1.add(b2);
			
			f1.setSize(550,550);
			f1.setLayout(null);
			f1.setVisible(true);
			
			b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae1) {
			try {
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  
			
			
			Statement stmt1=con.createStatement();
			
			
			String q1 ="update non_competitive set "
			+"event='"+s1+"',level'"+s2+"',start_date'"+s3+"',end_date'"+s4+"',description'"+s5+"')"
			+"where nact_id ='"+v.getText()+"'";
									
									
						
			 stmt1.executeUpdate(q1);
				
			
			
			
			
			
			}catch(Exception e1) {System.out.println(e1);}
			
			JOptionPane.showMessageDialog(null,"Successfully updated");
			f1.dispose();
			}
			});
			
		}
}
