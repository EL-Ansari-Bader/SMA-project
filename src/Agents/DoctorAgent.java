package Agents;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;


public class DoctorAgent extends Agent {
	ArrayList<String> Patient=new ArrayList<String>();
	
	private String test;
	private String Quarant ;
	private String Medic;
	static boolean running;
	
	
	public void setup() {
		running = false;
		System.out.println("I'm the doctor..");
		Scanner myObj = new Scanner(System.in);
		addBehaviour(new CyclicBehaviour() {
			public void action() {
					ACLMessage msg = receive();
					if(msg != null) {
						try {
					
						Patient=(ArrayList<String>) msg.getContentObject();
					} catch (UnreadableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(!running)
					{
					running = true;
					int i=0;
					
					JFrame f=new JFrame("Doctor");
					JLabel Wel;
					Wel=new  JLabel(" Dossier du patient  "+Patient.get(0)+",C.I.N : "+Patient.get(1));
					Wel.setBounds(0,0, 400,30);
					f.add(Wel);
					JLabel namel;  
				    namel=new JLabel("Test Covid-19 : ");  
				    namel.setBounds(50,25, 150,30);
				    final JCheckBox checkBox1 = new JCheckBox("Positive");  
			        checkBox1.setBounds(50,50, 150,30);
			        final JCheckBox checkBox2 = new JCheckBox("Negative");  
			        checkBox2.setBounds(250,50, 150,30); 
			        f.add(checkBox1);  
			        f.add(checkBox2);  
				    f.add(namel); 
				    checkBox1.addItemListener(new ItemListener() {    
			             public void itemStateChanged(ItemEvent e) {                 
							    if(checkBox1.isSelected()) {
							    	checkBox2.setSelected(false);
							    	test = "Positive";
							    }
							    
							    
			             }
			          });    
			        checkBox2.addItemListener(new ItemListener() {    
			             public void itemStateChanged(ItemEvent e) {                 
			            	 if(checkBox2.isSelected()) {
							    	checkBox1.setSelected(false);
							    	test = "Negative";
							    }  
			             }    
			          });    
				    
					JLabel cinl;
				    cinl=new JLabel("Médicament à prendre  : ");  
				    cinl.setBounds(50,75, 150,30);  
				    final JTextField cintf=new JTextField();  
				    cintf.setBounds(50,100, 150,20);
				    f.add(cintf);  
				    f.add(cinl);  
				    
				    JLabel malchl;
				    malchl=new JLabel("type du Quarantaine : ");  
				    malchl.setBounds(50,125, 150,30);  
				    String[] malchlist= {"Urgence","normal"};
				    final JComboBox<String> malchtf = new JComboBox<>(malchlist);
				    malchtf.setBounds(50,150, 150,20);
				    f.add(malchtf);  
				    f.add(malchl);  
					

				    JButton submit=new JButton("Submit");  
				    submit.setBounds(150,200,95,30); 
				    f.add(submit);
				    submit.addActionListener(new ActionListener(){  
				    	public void actionPerformed(ActionEvent e){  
				    		Medic=cintf.getText();
				            Quarant = (String) malchtf.getSelectedItem();
							Patient.add(test);
							
							if(test=="Positive") {
							Patient.add(Quarant);
							Patient.add(Medic);
							ACLMessage req = new ACLMessage(ACLMessage.INFORM);
							req.addReceiver(new AID("Drug Store", AID.ISLOCALNAME));
							req.addReceiver(new AID("Quarantine", AID.ISLOCALNAME));
							req.setLanguage("English");
							try {
								req.setContentObject(Patient);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							send(req);}
							else {
									ACLMessage req = new ACLMessage(ACLMessage.REQUEST);
									req.addReceiver(new AID("Vaccination", AID.ISLOCALNAME));
									req.setLanguage("English");
									try {
										req.setContentObject(Patient);
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									send(req);
								
							}
							}});
					f.setSize(400,400);  
				    f.setLayout(null);  
				    f.setVisible(true);
				    }
					
					}
			
					else {block();}
					}});
	}
}

