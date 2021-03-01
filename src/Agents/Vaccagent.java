package Agents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class Vaccagent extends Agent{
	ArrayList<String> Patient = new ArrayList<String>();
	protected void setup() {
		
		addBehaviour(new CyclicBehaviour() {
			public void action() {
				ACLMessage msg = receive();
				if(msg != null) {
					try {
						Patient=(ArrayList<String>) msg.getContentObject();
					} catch (UnreadableException e) {
						e.printStackTrace();
					}
					JFrame f= new JFrame("Vaccination");
					JLabel namel;  
				    namel=new JLabel("Nom : " + Patient.get(0));  
				    namel.setBounds(50,25, 200,30); 
				    JButton submit=new JButton("Approve");  
				    submit.setBounds(50,50,95,30);  
				    submit.addActionListener(new ActionListener(){  
				    	public void actionPerformed(ActionEvent e){  
				    		System.out.println("Vaccinée !!");
							f.dispose();
				        }  
				    });
				    f.add(namel);
				    f.add(submit);
				    f.setSize(300,200);  
				    f.setLayout(null);  
				    f.setVisible(true);
				}
				else {
					block();
				}

			}
		});
	}	

}
