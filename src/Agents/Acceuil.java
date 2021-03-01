
package Agents;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.Agent;

import jade.lang.acl.ACLMessage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Acceuil extends Agent{
	
	static boolean running;
	public String name;
	public String cin;
	public String malch;
	ArrayList<ArrayList<String> > listofPatient=new ArrayList<ArrayList<String>>();
	

	protected void setup() {

		running = false;
		addBehaviour(new CyclicBehaviour() {

			@Override
			public void action() {
				if(!running)
				{
				running = true;
				int i=0;
				ArrayList<String> Patient=new ArrayList<String>();
				
				JFrame f=new JFrame("Acceuil");
				JLabel Wel;
				Wel=new  JLabel(" Enregistrement ");
				Wel.setFont(new Font("Serif", Font.PLAIN, 20));
				Wel.setBounds(75,0, 150,30);
				f.add(Wel);
				JLabel namel;  
			    namel=new JLabel("Nom : ");  
			    namel.setBounds(50,25, 150,30);  
			    final JTextField nametf=new JTextField();  
			    nametf.setBounds(50,50, 150,20);
			    f.add(nametf);  
			    f.add(namel); 
			    
				JLabel cinl;
			    cinl=new JLabel("CIN : ");  
			    cinl.setBounds(50,75, 150,30);  
			    final JTextField cintf=new JTextField();  
			    cintf.setBounds(50,100, 150,20);
			    f.add(cintf);  
			    f.add(cinl);  
			    
			    JLabel malchl;
			    malchl=new JLabel("aviez vous une maladie chronique ?oui/non : ");  
			    malchl.setBounds(50,125, 150,30);  
			    //final JTextField malchtf=new JTextField(); 
			    String[] malchlist= {"oui","non"};
			    final JComboBox<String> malchtf = new JComboBox<>(malchlist);
			    malchtf.setBounds(50,150, 150,20);
			    f.add(malchtf);  
			    f.add(malchl);  
				
			    
			    JButton submit=new JButton("Submit");  
			    submit.setBounds(50,200,95,30);  
			    submit.addActionListener(new ActionListener(){  
			    	public void actionPerformed(ActionEvent e){  
			            name = nametf.getText();
			            cin = cintf.getText();
			            malch = (String) malchtf.getSelectedItem();
			            Patient.add(name);
			            Patient.add(cin);
			            Patient.add(malch);
			            ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
						msg.addReceiver(new AID("Doctor", AID.ISLOCALNAME));
						msg.setLanguage("English");
						try {
							msg.setContentObject(Patient);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						send(msg);
						f.dispose();
						//running = false;
			        }  
			    });  
			    f.add(submit);
			    f.setSize(300,300);  
			    f.setLayout(null);  
			    f.setVisible(true);
			    
				}
				else {
					block();
				}
			    
			
			}});
	}
	
		
	


}
