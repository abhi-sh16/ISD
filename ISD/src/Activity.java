

import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.event.*;
import java.awt.*;


import java.sql.*;
public class Activity {
JFrame f2=new JFrame("Student Activities");
JFrame f1=new JFrame("Edit Activity");

int resp_id;
int app_id;
String status,achievement,position,team_id;
//private JButton b4= new JButton("Add Activity");
private JButton b1= new JButton("Edit Activity");
private JButton b2= new JButton("Delete Activity");
private JButton b6= new JButton("Search Activity");

private JButton b3= new JButton("View Members");
private JButton b5= new JButton("Back");
public static void main(String s) {
	new Activity(s);
	
		
}

public Activity(String s)
{
JFrame rp = new JFrame();
	
	JTable resp =new JTable();
	JTable part =new JTable();
	JLabel l = new JLabel("Responsibilities ");
	JLabel l1 = new JLabel("Participations");
	JButton V =new JButton("View All Activities");
	
	try {
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");
		String q1="select achievement,status ,clg_team_id from competitive c,student s,participation p  where ( c.app_id = p.app_id and s.roll_no = p.roll_no and s.roll_no='"+s+"') "
				+ "union select achievement,status ,clg_team_id  from non_competitive nc,student s,participation p where ( nc.app_id = p.app_id and s.roll_no = p.roll_no and s.roll_no='"+s+"') "
				+ "union select achievement,status ,clg_team_id  from entrepreneur ec,student s,participation p where (ec.app_id = p.app_id and s.roll_no = p.roll_no and s.roll_no='"+s+"')";
		PreparedStatement stmt1=con.prepareStatement(q1);
		ResultSet rs1=stmt1.executeQuery(q1);
		String q2="select position ,status,clg_team_id from competitive c,student s,responsibility p  where ( c.resp_id = p.resp_id and s.roll_no = p.roll_no and s.roll_no='"+s+"') "
				+ "union select position ,status,clg_team_id from non_competitive nc,student s,responsibility p where ( nc.resp_id = p.resp_id and s.roll_no = p.roll_no and s.roll_no='"+s+"') "
				+ "union select position ,status,clg_team_id from entrepreneur ec,student s,responsibility p where (ec.resp_id = p.resp_id and s.roll_no = p.roll_no and s.roll_no='"+s+"');";
		PreparedStatement stmt2=con.prepareStatement(q2);
		ResultSet rs2= stmt2.executeQuery(q2);
		resp.setModel(DbUtils.resultSetToTableModel(rs1));
		part.setModel(DbUtils.resultSetToTableModel(rs2));
		resp.setEnabled(false);
		part.setEnabled(false);
		
	}catch(Exception e1) {System.out.println(e1);}
	
	JScrollPane scroll1 =new JScrollPane(resp,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
	JScrollPane scroll2 =new JScrollPane(part,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
	
	
	rp.add(l);
	rp.add(l1);
	rp.add(scroll1);
	rp.add(scroll2);
	rp.add(V);
	
	scroll1.setBounds(20,40,600,200);
	scroll2.setBounds(20,280,600,200);
	l.setBounds(240,10,600,20);
	l1.setBounds(240,250,600,20);
	V.setBounds(200,500,200,40);
	
	V.addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent ae1) {
    	   
    		   
    		   
    		activity(s );
    		   
    		   
    	   	}
			});
	rp.setSize(650, 600);
	rp.setLayout(null);
	rp.setVisible(true);
	
	
}



public void activity(String s) {
	JTable comp = new JTable();
	JTable ncomp = new JTable();
	JTable entp = new JTable();
	JLabel l = new JLabel("Competitve Activities ");
	JLabel l1 = new JLabel("Non-Competitve Activities");
	JLabel l2 = new JLabel("Enterpreneurial Activities");
	

		try {
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  
		
		
		String q1 ="select cact_id,comp_name,level,start_date,end_date from competitive c,student s"
				+ ",participation r where c.app_id = r.app_id and s.roll_no=r.roll_no"
				+ "  and r.roll_no='"+s+"'"
				+ "union select cact_id,comp_name,level,start_date,end_date from competitive c,student s"
				+ ",responsibility r where c.resp_id = r.resp_id and s.roll_no=r.roll_no"
				+ "  and r.roll_no='"+s+"'";
		
		String q2 ="select nact_id,event,level,start_date,end_date,description from non_competitive  c,student s"
				+ ",participation r where c.app_id = r.app_id and s.roll_no=r.roll_no"
				+ "  and r.roll_no='"+s+"'"
				+ "union select nact_id,event,level,start_date,end_date,description from non_competitive  c,student s"
				+ ",responsibility r where c.resp_id = r.resp_id and s.roll_no=r.roll_no"
				+ "  and r.roll_no='"+s+"'";
		
		
		String q3 ="select eact_id,event,location,level,start_date,end_date,description from entrepreneur  c,student s"
				+ ",participation r where c.app_id = r.app_id and s.roll_no=r.roll_no"
				+ "  and r.roll_no='"+s+"'"
				+ "union select eact_id,event,location,level,start_date,end_date,description from entrepreneur  c,student s"
				+ ",responsibility r where c.resp_id = r.resp_id and s.roll_no=r.roll_no"
				+ "  and r.roll_no='"+s+"'";
		
		
		PreparedStatement stmt1=con.prepareStatement(q1);
		ResultSet rs1=stmt1.executeQuery(q1);
		
		PreparedStatement stmt2=con.prepareStatement(q2);
		ResultSet rs2= stmt2.executeQuery(q2);
		PreparedStatement stmt3=con.prepareStatement(q3);
		ResultSet rs3= stmt3.executeQuery(q3);
		comp.setModel(DbUtils.resultSetToTableModel(rs1));
		ncomp.setModel(DbUtils.resultSetToTableModel(rs2));
		entp.setModel(DbUtils.resultSetToTableModel(rs3));

comp.setEnabled(false);
ncomp.setEnabled(false);
entp.setEnabled(false);

		}catch(Exception e1) {System.out.println(e1);}
		 
	//view members
		
		this.b3.addActionListener(new ActionListener() {
	    	   public void actionPerformed(ActionEvent ae1) {
	    		   JFrame f3=new JFrame("search");
	    		    f3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    			f3.getContentPane().setLayout(new FlowLayout()); 
	    			JLabel l = new JLabel("Enter Activity id ");
	    			JLabel l2 = new JLabel("Same College Members ");
	    			JLabel l1 = new JLabel("Other College Members ");
	    			JLabel l3 = new JLabel("Enter College Team-id ");
	    			JTextField t1= new JTextField();
	    			JTextField t2= new JTextField();
	    			JButton team = new JButton("Search");
	    			
	    			t1.setBounds(10,70, 200, 30);	
	    			t2.setBounds(10,200, 200, 30);
	    		    f3.add(t1);
	    		    f3.add(l2);
	    		    f3.add(l3);
	    		    f3.add(l1);
	    		    f3.add(team);
	    		    f3.add(t2);
	    		  // JButton search = new JButton("Search");
	    		  // f3.add(search);
	    		   f3.add(l);
	    		  // search.setBounds(220,40,150,30);
	    		   l1.setBounds(10,10,200,20);
	    		   l.setBounds(10,40,200,20);
	    		   l2.setBounds(10,130,200,20);
	    		   l3.setBounds(10,160,200,20);
	    		   team.setBounds(220,200,100,40);
	    		   
	    		   team.addActionListener(new ActionListener() {
    		    	   public void actionPerformed(ActionEvent ae1) {
    		    		   try { 
    		    		   JFrame f4 = new JFrame("Members");
		    			   JTable mem = new JTable();
		    			   
		    			   f4.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			    			f4.getContentPane().setLayout(new FlowLayout());	    		    			   
		    			   	Class.forName("com.mysql.jdbc.Driver"); 
		    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  
		    				String q1 = "select s_name from student s ,participation p1,participation p2 "
		    						+ "where p1.clg_team_id =p2.clg_team_id and "
		    						+ "p1.clg_team_id='"+t2.getText()+"'and p1.roll_no =s.roll_no";  
		    						
		    				PreparedStatement stmt1=con.prepareStatement(q1);
		    				ResultSet rs1=stmt1.executeQuery(q1);
		    				mem.setModel(DbUtils.resultSetToTableModel(rs1));
		    				mem.setBounds(10, 10, 100, 100);
		    				f4.add(mem);
		    				f4.setSize(300, 300);
			    			f4.setLayout(null);
			    			f4.setVisible(true);
		    		   }catch(Exception e1) {System.out.println(e1);}
    		    		   
    		    		   
    		    		   
    		    	   }});
	    		    JButton bx1 = new JButton("Competitive        ");
	    			JButton bx2 = new JButton("Non-Competitive");
	    			JButton bx3 = new JButton("Entrepreneurial  ");
	    			
	    			JMenuBar x1 = new JMenuBar();
		    		   JMenu sa = new JMenu("Select Activity type");
		    		   x1.add(sa);
		    	       sa.add(bx1);
		    	       sa.add(bx2);
		    	       sa.add(bx3);
		    		   f3.add(x1);
		    		   f3.add(l);
		    		
		    		   x1.setBounds(220,70 , 150, 30);
		    		   f3.setSize(400, 300);
		    			f3.setLayout(null);
		    			f3.setVisible(true);
						    			bx1.addActionListener(new ActionListener() {
						    		    	   public void actionPerformed(ActionEvent ae1) {
						    		    		   try {
						    		    			   JFrame f4 = new JFrame("Members");
						    		    			   JTable mem = new JTable();
						    		    			   
						    		    			   f4.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
						    			    			f4.getContentPane().setLayout(new FlowLayout());	    		    			   
						    		    			   	Class.forName("com.mysql.jdbc.Driver"); 
						    		    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  
						    		    				String q1 = "select m_name from mem_out where app_id='"+t1.getText()+"' ";
						    		    				PreparedStatement stmt1=con.prepareStatement(q1);
						    		    				ResultSet rs1=stmt1.executeQuery(q1);
						    		    				mem.setModel(DbUtils.resultSetToTableModel(rs1));
						    		    				mem.setBounds(10, 10, 100, 100);
						    		    				f4.add(mem);
						    		    				f4.setSize(250, 250);
						    			    			f4.setLayout(null);
						    			    			f4.setVisible(true);
						    		    		   }catch(Exception e1) {System.out.println(e1);}
						    		    		   }
					
							    		    	   });
						    			bx2.addActionListener(new ActionListener() {
						    		    	   public void actionPerformed(ActionEvent ae1) {
						    		    		   try {
						    		    			   JFrame f4 = new JFrame("Members");
						    		    			   JTable mem = new JTable();
						    		    			   
						    		    			   f4.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
						    			    			f4.getContentPane().setLayout(new FlowLayout());	    		    			 
						    		    			   	Class.forName("com.mysql.jdbc.Driver"); 
						    		    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  
						    		    				String q1 = "select m_name from memb_out where app_id='"+t1.getText()+"' ";
						    		    				PreparedStatement stmt1=con.prepareStatement(q1);
						    		    				ResultSet rs1=stmt1.executeQuery(q1);
						    		    				f4.add(mem);
						    		    				mem.setModel(DbUtils.resultSetToTableModel(rs1));
						    		    				mem.setBounds(10, 10, 100, 100);
						    		    				f4.setSize(250, 250);
						    			    			f4.setLayout(null);
						    			    			f4.setVisible(true);
						    		    		   }catch(Exception e1) {System.out.println(e1);}
						    		    	   }
					
						    		    	   });
						    			bx3.addActionListener(new ActionListener() {
						    		 	   public void actionPerformed(ActionEvent ae1) {
						    		 		  try {
					   		    			   JFrame f4 = new JFrame("Members");
					   		    			   JTable mem = new JTable();
					   		    			   
					   		    			   f4.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					   			    			f4.getContentPane().setLayout(new FlowLayout());	    		    			
					   		    			   	Class.forName("com.mysql.jdbc.Driver"); 
					   		    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  
					   		    				String q1 = "select m_name from mem_out where app_id='"+t1.getText()+"' ";
					   		    				PreparedStatement stmt1=con.prepareStatement(q1);
					   		    				ResultSet rs1=stmt1.executeQuery(q1);
					   		    				mem.setModel(DbUtils.resultSetToTableModel(rs1));
					   		    				mem.setBounds(10, 10, 100, 100);
					   		    				f4.add(mem);
					   		    				f4.setSize(250, 250);
					   			    			f4.setLayout(null);
					   			    			f4.setVisible(true);
					   		    		   }catch(Exception e1) {System.out.println(e1);}
						    		 	   	
						    		 	   }
						    		
						    		 	   });  
		    		   	
	    		   
	    	   }

	    	   });			
	
		
		
		
	// delete activity
		
		this.b2.addActionListener(new ActionListener() {
	    	 
			public void actionPerformed(ActionEvent ae1) {
	    		   JFrame f3=new JFrame("Delete Activity");
	    		    f3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    			f3.getContentPane().setLayout(new FlowLayout()); 
	    			JLabel l = new JLabel("Enter Activity id ");
	    			JTextField t1= new JTextField();
	    			t1.setBounds(10,40, 200, 30);	    		   
	    		    f3.add(t1);
	    		  // JButton search = new JButton("Search");
	    		  // f3.add(search);
	    		   f3.add(l);
	    		  // search.setBounds(220,40,150,30);
	    		   l.setBounds(10,10,200,20);
	    		  
	    		  
	    		    JButton bx1 = new JButton("Competitive        ");
	    			JButton bx2 = new JButton("Non-Competitive");
	    			JButton bx3 = new JButton("Entrepreneurial  ");
	    			
	    			JMenuBar x1 = new JMenuBar();
		    		   JMenu sa = new JMenu("Select Activity type");
		    		   x1.add(sa);
		    	       sa.add(bx1);
		    	       sa.add(bx2);
		    	       sa.add(bx3);
		    		   f3.add(x1);
		    		   f3.add(l);
		    		
		    		   x1.setBounds(220,40 , 150, 30);
		    		   f3.setSize(400, 300);
		    			f3.setLayout(null);
		    			f3.setVisible(true);
					    							
		    			
		    										bx1.addActionListener(new ActionListener() {
					    							public void actionPerformed(ActionEvent ae1) {
					    									try {
					    		    			   	    		    			   
					    		    			   	Class.forName("com.mysql.jdbc.Driver"); 
					    		    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  
					    		    				String q1 = "select app_id,resp_id from competitive where cact_id='"+t1.getText()+"' ";
					    		    				PreparedStatement stmt1=con.prepareStatement(q1);
					    		    				ResultSet rs1=stmt1.executeQuery(q1);
					    		    				while (rs1.next())
					    		    				{
					    		    					if(rs1.getInt(1)!=0)
					    		    					{
					    		    						String q2 = "delete from participation where app_id='"+rs1.getInt(1)+"' ";
					    		    						String q3 = "delete from competitive where cact_id='"+t1.getText()+"' ";
							    		    				PreparedStatement stmt2=con.prepareStatement(q1);
							    		    				PreparedStatement stmt3=con.prepareStatement(q2);
							    		    				stmt2.executeQuery(q2);
							    		    				stmt3.executeQuery(q3);
							    		    				JOptionPane.showMessageDialog(null,"Deleted Successfully");
							    		    				
					    		    					}
					    		    					else if(rs1.getInt(2)!=0)
					    		    					{
					    		    						String q2 = "delete from responsibility where resp_id='"+rs1.getInt(1)+"' ";
					    		    						String q3 = "delete from competitive where cact_id='"+t1.getText()+"' ";
							    		    				PreparedStatement stmt2=con.prepareStatement(q1);
							    		    				PreparedStatement stmt3=con.prepareStatement(q2);
							    		    				stmt2.executeQuery(q2);
							    		    				stmt3.executeQuery(q3);
							    		    				JOptionPane.showMessageDialog(null,"Deleted Successfully");
					    		    					}
					    		    					}
					    		    					
					    									}catch(Exception e1) {System.out.println(e1);}
					    								}
					    							
					    								});
					    								
					    							
					    								bx2.addActionListener(new ActionListener() {
					    								public void actionPerformed(ActionEvent ae1) {
					    								
					    								try {
						    		    			  	    		    			   
						    		    			   	Class.forName("com.mysql.jdbc.Driver"); 
						    		    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  
						    		    				String q1 = "select app,id,resp_id from competitive where cact_id='"+t1.getText()+"' ";
						    		    				PreparedStatement stmt1=con.prepareStatement(q1);
						    		    				ResultSet rs1=stmt1.executeQuery(q1);
						    		    				while (rs1.next())
						    		    				{
						    		    					if(rs1.getInt(1)!=0)
						    		    					{
						    		    						String q2 = "delete from participation where app_id='"+rs1.getInt(1)+"' ";
						    		    						String q3 = "delete from non_competitive where nact_id='"+t1.getText()+"' ";
								    		    				PreparedStatement stmt2=con.prepareStatement(q1);
								    		    				PreparedStatement stmt3=con.prepareStatement(q2);
								    		    				stmt2.executeQuery(q2);
								    		    				stmt3.executeQuery(q3);
								    		    				JOptionPane.showMessageDialog(null,"Deleted Successfully");
						    		    					}
						    		    					else if(rs1.getInt(2)!=0)
						    		    					{
						    		    						String q2 = "delete from responsibility where resp_id='"+rs1.getInt(1)+"' ";
						    		    						String q3 = "delete from non_competitive where nact_id='"+t1.getText()+"' ";
								    		    				PreparedStatement stmt2=con.prepareStatement(q1);
								    		    				PreparedStatement stmt3=con.prepareStatement(q2);
								    		    				stmt2.executeQuery(q2);
								    		    				stmt3.executeQuery(q3);
								    		    				JOptionPane.showMessageDialog(null,"Deleted Successfully");
						    		    					}
						    		    					}
						    		    				
						    		    					
					    										}catch(Exception e1) {System.out.println(e1);}
					    									}
					    		    	   
					    									});
					    								
					    									
					    									bx3.addActionListener(new ActionListener() {
					    									public void actionPerformed(ActionEvent ae1) {
					    												try {
				    		    			  	    		    			   
					    									Class.forName("com.mysql.jdbc.Driver"); 
					    									Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  
					    									String q1 = "select app,id,resp_id from competitive where cact_id='"+t1.getText()+"' ";
					    									PreparedStatement stmt1=con.prepareStatement(q1);
					    									ResultSet rs1=stmt1.executeQuery(q1);
					    									while (rs1.next())
							    		    				{
							    		    					if(rs1.getInt(1)!=0)
							    		    					{
							    		    						String q2 = "delete from participation where app_id='"+rs1.getInt(1)+"' ";
							    		    						String q3 = "delete from entrepreneur where eact_id='"+t1.getText()+"' ";
									    		    				PreparedStatement stmt2=con.prepareStatement(q1);
									    		    				PreparedStatement stmt3=con.prepareStatement(q2);
									    		    				stmt2.executeQuery(q2);
									    		    				stmt3.executeQuery(q3);
									    		    				JOptionPane.showMessageDialog(null,"Deleted Successfully");
							    		    					}
							    		    					else if(rs1.getInt(2)!=0)
							    		    					{
							    		    						String q2 = "delete from responsibility where resp_id='"+rs1.getInt(1)+"' ";
							    		    						String q3 = "delete from entrepreneur where eact_id='"+t1.getText()+"' ";
									    		    				PreparedStatement stmt2=con.prepareStatement(q1);
									    		    				PreparedStatement stmt3=con.prepareStatement(q2);
									    		    				stmt2.executeQuery(q2);
									    		    				stmt3.executeQuery(q3);
									    		    				JOptionPane.showMessageDialog(null,"Deleted Successfully");
							    		    					}
							    		    				}
							    		    				
							    		    		   }catch(Exception e1) {System.out.println(e1);}
								    		 	   	
					    									}
								    		
					    									});  
	    		   	
	    		   
	    	   			}

					});

					
	//Edit Activity	
						this.b1.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent ae1) {
		    		   
							JFrame f3=new JFrame("Edit Activity");
		    		    
						f3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		    			f3.getContentPane().setLayout(new FlowLayout()); 
		    			JLabel l = new JLabel("Enter Activity id ");
		    			JTextField t1= new JTextField();
		    			t1.setBounds(10,40, 200, 30);	    		   
		    		    f3.add(t1);
		    		  // JButton search = new JButton("Search");
		    		  // f3.add(search);
		    		   f3.add(l);
		    		  // search.setBounds(220,40,150,30);
		    		   l.setBounds(10,10,200,20);
		    		  
		    		  
		    		    JButton bx1 = new JButton("Competitive        ");
		    			JButton bx2 = new JButton("Non-Competitive");
		    			JButton bx3 = new JButton("Entrepreneurial  ");
		    			
		    			JMenuBar x1 = new JMenuBar();
			    		   JMenu sa = new JMenu("Select Activity type");
			    		   x1.add(sa);
			    	       sa.add(bx1);
			    	       sa.add(bx2);
			    	       sa.add(bx3);
			    		   f3.add(x1);
			    		   f3.add(l);
			    		
			    		   x1.setBounds(220,40 , 150, 30);
			    		   f3.setSize(400, 300);
			    		   f3.setLayout(null);
			    		   f3.setVisible(true);
					    			bx1.addActionListener(new ActionListener() {
					    		    	   public void actionPerformed(ActionEvent ae1) {
					    		    		 new Competitive(t1);
					    		    		   }
				
					    		    	   });
					    			bx2.addActionListener(new ActionListener() {
					    		    	   public void actionPerformed(ActionEvent ae1) {
					    		    		   try {
					    		    			  new Non_Competitive(t1);
					    		    		   }catch(Exception e1) {System.out.println(e1);}
					    		    	   }
				
					    		    	   });
					    			bx3.addActionListener(new ActionListener() {
					    		 	   public void actionPerformed(ActionEvent ae1) {
					    		 		  try {
					    		 			 new Entrepreneurial(t1);
				   		    		   }catch(Exception e1) {System.out.println(e1);}
					    		 	   	
					    		 	   }
					    		
					    		 	   });  
	    		   	
			    		   
			    	   }
		
			    	   });

						
	// Search Activity			
				this.b6.addActionListener(new ActionListener() {
					    	  						
				public void actionPerformed(ActionEvent ae1) {
					    		   
					
									JFrame f3=new JFrame("search");
					    		    f3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					    			f3.getContentPane().setLayout(new FlowLayout()); 
					    			JLabel l = new JLabel("Enter Activity id ");
					    			JTextField t1= new JTextField();
					    			t1.setBounds(10,40, 200, 30);	    		   
					    		    f3.add(t1);
					    		  // JButton search = new JButton("Search");
					    		  // f3.add(search);
					    		   f3.add(l);
					    		  // search.setBounds(220,40,150,30);
					    		   l.setBounds(10,10,200,20);
					    		  
					    		  
					    		    JButton bx1 = new JButton("Competitive        ");
					    			JButton bx2 = new JButton("Non-Competitive");
					    			JButton bx3 = new JButton("Entrepreneurial  ");
					    			
					    			JMenuBar x2 = new JMenuBar();
						    		   JMenu sa = new JMenu("Select Activity type");
						    		   x2.add(sa);
						    	       sa.add(bx1);
						    	       sa.add(bx2);
						    	       sa.add(bx3);
						    		   f3.add(x2);
						    		   f3.add(l);
						    		
						    		   x2.setBounds(220,40 , 150, 30);
						    		   f3.setSize(400, 300);
						    			f3.setLayout(null);
						    			f3.setVisible(true);
									    			bx1.addActionListener(new ActionListener() {
									    		    	   public void actionPerformed(ActionEvent ae1) {
									    		    		   try {
									    		    			   JFrame f4 = new JFrame("Result");
									    		    			  JTable c = new JTable();
									    		    			   
									    		    			   f4.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
									    			    			f4.getContentPane().setLayout(new FlowLayout());	    		    			   
									    		    			   	Class.forName("com.mysql.jdbc.Driver"); 
									    		    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  
									    		    				String q1 = "select comp_name,level,start_date,end_date from competitive where cact_id='"+t1.getText()+"' ";
									    		    				PreparedStatement stmt1=con.prepareStatement(q1);
									    		    				ResultSet rs1=stmt1.executeQuery(q1);
									    		    				
									    		    				JScrollPane scroll1 =new JScrollPane(c,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
									    		    				c.setModel(DbUtils.resultSetToTableModel(rs1));
									    		    				scroll1.setBounds(10, 10, 900, 100);
									    		    				f4.add(scroll1);
									    		    				f4.setSize(1000, 250);
									    			    			f4.setLayout(null);
									    			    			f4.setVisible(true);
									    		    		   }catch(Exception e1) {System.out.println(e1);}
									    		    		   }
								
									    		    	   });
									    			bx2.addActionListener(new ActionListener() {
									    		    	   public void actionPerformed(ActionEvent aex2) {
									    		    		   
									    		    			   try {
									    		    				   JFrame f4 = new JFrame("Result");
											    		    			  JTable nc = new JTable();
											    		    			   
											    		    			   f4.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
											    			    			f4.getContentPane().setLayout(new FlowLayout());	    		    			   
											    		    			   	Class.forName("com.mysql.jdbc.Driver"); 
											    		    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  
											    		    				String q1 = "select event,level,start_date,end_date,description from non_competitive where nact_id='"+t1.getText()+"'";
											    		    				PreparedStatement stmt1=con.prepareStatement(q1);
											    		    				ResultSet rs1=stmt1.executeQuery(q1);
											    		    				JScrollPane scroll1 =new JScrollPane(nc,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
											    		    				nc.setModel(DbUtils.resultSetToTableModel(rs1));
											    		    				scroll1.setBounds(10, 10, 900, 100);
											    		    				f4.add(scroll1);
											    		    				f4.setSize(1000, 250);
											    			    			f4.setLayout(null);
											    			    			f4.setVisible(true);
											    		    		   }catch(Exception e1) {System.out.println(e1);}
									    		    	   }
									    		    	    
									    		    	   });
									    			bx3.addActionListener(new ActionListener() {
									    		 	   public void actionPerformed(ActionEvent aex3) {
									    		 		  try {
									    		 			 JFrame f4 = new JFrame("Result");
								    		    			  JTable ec = new JTable();
								    		    			   
								    		    			   f4.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
								    			    			f4.getContentPane().setLayout(new FlowLayout());	    		    			   
								    		    		
								    			    			Class.forName("com.mysql.jdbc.Driver"); 
								    		    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  
								    		    				String q1 = "select event,level,start_date,end_date,description,location from entrepreneur where eact_id='"+t1.getText()+"' ";
								    		    				PreparedStatement stmt1=con.prepareStatement(q1);
								    		    				ResultSet rs1=stmt1.executeQuery(q1);
								    		    				JScrollPane scroll1 =new JScrollPane(ec,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
								    		    				ec.setModel(DbUtils.resultSetToTableModel(rs1));
								    		    				scroll1.setBounds(10, 10, 900, 100);
								    		    				f4.add(scroll1);
								    		    				f4.setSize(1000, 250);
								    			    			f4.setLayout(null);
								    			    			f4.setVisible(true);
								    			    			
								    		    		   }catch(Exception e1) {System.out.println(e1);}
									    		 	   	
									    		 	   }
									    		
									    		 	   });  
					    		   	
					    		   
					    	   }

					    	   });
				
						this.b5.addActionListener(new ActionListener() {
					    	   public void actionPerformed(ActionEvent ae1) {
					    	   	f2.dispose();
					    	  
					    	   	//new Student(a);
					    	   	
					    	   	
					    	   }
					    	   
					    	   
					    	   });
	
						
////Add Activity
						
						
		JButton br1 = new JButton("Competitive        ");
		JButton br2 = new JButton("Non-Competitive");
		JButton br3 = new JButton("Entrepreneurial  ");
		
		
						br1.addActionListener(new ActionListener() {
					    	   public void actionPerformed(ActionEvent ae1) {
					    		   boolean x = true;
					    		   new Competitive(x);
					    		   try {
					    				Class.forName("com.mysql.jdbc.Driver"); 
					    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  
					    				Statement stmt0=con.createStatement();
					    				String ap= "approved";
					    				String q0 = "insert into participation(roll_no,status) values('"+s+"','"+ap+"')";
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
					    		   boolean x = true;
					    		   new Non_Competitive(x);
					    		   try {
					    				Class.forName("com.mysql.jdbc.Driver"); 
					    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  
					    				Statement stmt0=con.createStatement();
					    				String ap= "approved";
					    				String q0 = "insert into participation(roll_no,status) values('"+s+"','"+ap+"')";
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
					 	   	boolean x = true;
					 		   new Entrepreneurial(x);
					 		  try {
				    				Class.forName("com.mysql.jdbc.Driver"); 
				    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  
				    				Statement stmt0=con.createStatement();
				    				String ap= "approved";
				    				String q0 = "insert into participation(roll_no,status) values('"+s+"','"+ap+"')";
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
					    		   boolean x = true;
					    		  new Competitive(x);
					    		   try {
					    				Class.forName("com.mysql.jdbc.Driver"); 
					    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  
					    				Statement stmt0=con.createStatement();
					    				String ap= "approved";
					    				String q0 = "insert into participation(roll_no,status) values('"+s+"','"+ap+"')";
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
					    		   boolean x = true;
					    		   new Non_Competitive(x);
					    		   try {
					    				Class.forName("com.mysql.jdbc.Driver"); 
					    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  
					    				Statement stmt0=con.createStatement();
					    				String ap= "approved";
					    				String q0 = "insert into participation(roll_no,status) values('"+s+"','"+ap+"')";
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
					 	   	boolean x = true;
					 		   new Entrepreneurial(x);
					 		  try {
				    				Class.forName("com.mysql.jdbc.Driver"); 
				    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");  
				    				Statement stmt0=con.createStatement();
				    				String ap= "approved";
				    				String q0 = "insert into participation(roll_no,status) values('"+s+"','"+ap+"')";
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
		JMenu a = new JMenu("Add Activity    ");
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
		
		
	JScrollPane scroll1 =new JScrollPane(comp,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
	JScrollPane scroll2 =new JScrollPane(ncomp,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
	JScrollPane scroll3 =new JScrollPane(entp,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);	

	
	
	
	
	
	
	f2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		f2.getContentPane().setLayout(new FlowLayout());  
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);  
		 
	       f2.getContentPane().add(splitPane);  
	       
		
	 f2.add(b1);
	 f2.add(b2);
	 f2.add(b3);
	 f2.add(x);
	 f2.add(b5);
	 f2.add(b6);
	 
	f2.add(l);
	f2.add(l1);
	f2.add(l2);
	f2.add(scroll1);
	f2.add(scroll2);
	f2.add(scroll3);
	l.setBounds(400,10,200,40);
	scroll1.setBounds(20,50,1180,100);	
	l1.setBounds(400,170,200,40);
	scroll2.setBounds(20,220,1180,100);
	l2.setBounds(400,330,200,40);
	scroll3.setBounds(20,380,1180,100);
	b1.setBounds(100, 500,200,40);
	b2.setBounds(400, 500,200,40);
	b3.setBounds(100, 560,200,40);
	x.setBounds(400, 560,100,40);
	b6.setBounds(650, 500,150,40);
	b5.setBounds(650, 560,100,40);
	f2.setSize(1200, 1000);
	f2.setLayout(null);
	f2.setVisible(true);	

}

}