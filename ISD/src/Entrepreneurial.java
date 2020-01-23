
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
public class Entrepreneurial {
	String s1,s2,s3,s4,s5,s6,s7;
JFrame f=new JFrame("Entrepreneurial");
boolean x;

public static void main(boolean x) {
new Entrepreneurial(x);
}
public Entrepreneurial(boolean x) {

	
						f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						f.setSize(300,300);
						f.setVisible(true);
						
						
						
						//String s1,s2,s3,s4;
						JLabel li = new JLabel("Roll_No : ");
						JLabel l = new JLabel("Event_Name : ");
						JLabel l1 = new JLabel("Location : ");
						
						JLabel l2 = new JLabel("Level : ");
						JLabel l3 = new JLabel("Description : ");
						JLabel l4 = new JLabel("Start Date : ");
						JLabel l5 = new JLabel("End Date : ");
						JLabel l6 = new JLabel("Mentors : ");
						JLabel la = new JLabel("Achievements : ");
						JLabel lp = new JLabel("Position : ");
						JLabel lid = new JLabel("Clg team-id : ");
						JLabel lor = new JLabel("OR : ");
						
						JButton b= new JButton("Done");
						JButton b1= new JButton("Submit");
						JButton b2= new JButton("Add More");
						
						JTextField t1,t2,t3,t4,t5,t6,t7,ti,t8,t9,t10;
						t1=new JTextField();
						t2=new JTextField();
						t3=new JTextField();
						t4=new JTextField();
						t5=new JTextField();
						t6=new JTextField();
						t7=new JTextField();
						ti=new JTextField();
						t8=new JTextField();
						t9=new JTextField();
						t10=new JTextField();
						
						s1 = t1.getText();
						s2 = t2.getText();
						s3 = t3.getText();
						s4 = t4.getText();
						s5 = t5.getText();
						s6 = t6.getText();
						s7 = t7.getText();
						
						li.setBounds(50,40,200,30);
						l.setBounds(50,80,200,30);
						l1.setBounds(50,120,200,30);
						l2.setBounds(50,160,200,30);
						l3.setBounds(50,200,200,30);
						l4.setBounds(50,240,200,30);
						l5.setBounds(50,280,200,30);
						l6.setBounds(50,320,200,30);
						la.setBounds(50,360,200,30);
						lor.setBounds(50,400,200,30);
						lp.setBounds(50,440,200,30);
						lid.setBounds(50,480,200,30);
						
						ti.setBounds(150,40, 200, 30);
						t1.setBounds(150,80,200,30);
						t2.setBounds(150,120, 200, 30);
						t3.setBounds(150,160,200,30);
						t4.setBounds(150,200,200,30);
						t5.setBounds(150,240,200,30);
						t6.setBounds(150,280,200,30);
						t7.setBounds(150,320,120,30);
						t8.setBounds(150,360,200,30);
						t9.setBounds(150,440,200,30);
						t10.setBounds(150,480,200,30);
						
						b.setBounds(180,530,80,40);
						b1.setBounds(280,330,100,20);
						b2.setBounds(400,330,120,20);
						f.add(li);
						f.add(l);
						f.add(l1);
						f.add(l2);
						f.add(l3);
						f.add(l4);
						f.add(l5);
						f.add(l6);
						f.add(la);
						f.add(lp);
						f.add(lor);
						f.add(lid);
						f.add(ti);
						f.add(t1);
						f.add(t2);
						f.add(t3);
						f.add(t4);
						f.add(t5);
						f.add(t6);
						f.add(t7);
						f.add(t8);
						f.add(t9);
						f.add(t10);
						f.add(b);
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
							String qi = "select *from entrepreneur";
										
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
		    				
		    				String q1 ="update entrepreneur set"
									+"event='"+s1+"',location='"+s2+"',level='"+s3+"',start_date='"+s4+"',end_date='"+s5+"',description]='"+s6+"'"
									+ "where eact_id ='"+rsi.getInt(1)+"'";
		    				
		    				Statement stmtf1=con.createStatement();
		    				String f1 ="SET FOREIGN_KEY_CHECKS=1";
		    				stmtf1.execute(f1);	
							
											stmt1.executeUpdate(q1);
											b1.addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent ae2) {
													try {
														Class.forName("com.mysql.jdbc.Driver"); 
														Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  
														Statement stmtmem=con.createStatement();	
														String mem = "insert into mem_out (m_name,app_id,resp_id) values"
																+ "('"+t6.getText()+"','"+rsi.getInt(3)+"','"+rsi.getInt(4)+"')";									
														stmtmem.executeUpdate(mem);
													}catch(Exception e1) {System.out.println(e1);}
											
												
													
																					
											
												
												
												}});
										
						

										
														if(t8.getText()!=null ||t9.getText() ==null )
														{
															Statement pre =con.createStatement();
															String prep ="update participation set achievement='"+t7.getText()+"',clg_team_id='"+t9.getText()+"'"
																	+ "where app_id='"+rsi.getInt(3)+"'";
															pre.executeUpdate(prep);
														}	
														else if(t8.getText()==null ||t9.getText() !=null )
														{
															Statement pre =con.createStatement();
															String prep ="update responsibility set position='"+t8.getText()+"',clg_team_id='"+t9.getText()+"' "
																	+ "where resp_id = '"+rsi.getInt(4)+"'";
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
		public Entrepreneurial(JTextField v)
		{
			JFrame f1 = new JFrame();
			f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f1.setSize(300,300);
			f1.setVisible(true);
			
			
			
			//String s1,s2,s3,s4;
			JLabel li = new JLabel("Roll_No : ");
			JLabel l = new JLabel("Event_Name : ");
			JLabel l1 = new JLabel("Location : ");
			
			JLabel l2 = new JLabel("Level : ");
			JLabel l3 = new JLabel("Description : ");
			JLabel l4 = new JLabel("Start Date : ");
			JLabel l5 = new JLabel("End Date : ");
			JLabel l6 = new JLabel("Mentors : ");
			
			JButton b= new JButton("Done");
			JButton b1= new JButton("Submit");
			JButton b2= new JButton("Add More");
			
			JTextField t1,t2,t3,t4,t5,t6,t7,ti;
			t1=new JTextField();
			t2=new JTextField();
			t3=new JTextField();
			t4=new JTextField();
			t5=new JTextField();
			t6=new JTextField();
			t7=new JTextField();
			ti=new JTextField();
			
			s1 = t1.getText();
			s2 = t2.getText();
			s3 = t3.getText();
			s4 = t4.getText();
			s5 = t5.getText();
			s6 = t6.getText();
			s7 = t7.getText();
			li.setBounds(50,40,200,30);
			l.setBounds(50,80,200,30);
			l1.setBounds(50,120,200,30);
			l2.setBounds(50,160,200,30);
			l3.setBounds(50,200,200,30);
			l4.setBounds(50,240,200,30);
			l5.setBounds(50,280,200,30);
			l6.setBounds(50,320,200,30);
			
			ti.setBounds(150,40, 200, 30);
			t1.setBounds(150,80,200,30);
			t2.setBounds(150,120, 200, 30);
			t3.setBounds(150,160,200,30);
			t4.setBounds(150,200,200,30);
			t5.setBounds(150,240,200,30);
			t6.setBounds(150,280,200,30);
			t7.setBounds(150,320,120,30);
			
			b.setBounds(180,360,80,40);
			b1.setBounds(280,330,100,20);
			b2.setBounds(400,330,120,20);
			f1.add(li);
			f1.add(l);
			f1.add(l1);
			f1.add(l2);
			f1.add(l3);
			f1.add(l4);
			f1.add(l5);
			f1.add(l6);
			f1.add(ti);
			f1.add(t1);
			f1.add(t2);
			f1.add(t3);
			f1.add(t4);
			f1.add(t5);
			f1.add(t6);
			f1.add(t7);
			f1.add(b);
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
				String q1;
				
					q1 ="update entrepreneur set"
							+"event='"+s1+"',location='"+s2+"',level='"+s3+"',start_date='"+s4+"',end_date='"+s5+"',description]='"+s6+"'"
									+ "where eact_id ='"+v.getText()+"'";
							
									
				stmt1.executeUpdate(q1);
				
				
				
				
					


								}catch(Exception e1) {System.out.println(e1);}
								JOptionPane.showMessageDialog(null,"Successfully updated");
								f1.dispose();
								}
								});
			
		}	

}

