package Agents;
import java.util.ArrayList;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

import java.util.ArrayList;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

import javax.swing.*;  

public class Quarantine extends Agent {
	ArrayList<ArrayList<String>> Patients = new ArrayList<ArrayList<String>>();
	String type;
	int lit = 150;
	int lit_dispo=lit;
	protected void setup() {
		JFrame f= new JFrame("Quarantaine");  
        DefaultListModel<String> l1 = new DefaultListModel<>();  
        JList<String> list = new JList<>(l1);  
        list.setBounds(0,0, 200,400);  
        
		addBehaviour(new CyclicBehaviour() {
			public void action() {
				
				ArrayList<String> Patient = new ArrayList<String>();
				ACLMessage msg = receive();
				if(msg != null) {
					try {
						Patient=(ArrayList<String>) msg.getContentObject();
					} catch (UnreadableException e) {
						e.printStackTrace();
					}
					type = Patient.get(Patient.size()-2);
					if(type.equals("Urgence") && lit_dispo > 0) {
						lit_dispo--;
						Patients.add(Patient);
						l1.addElement(Patient.get(0));
					}
				}
				else {
					block();
				}

			}
		});
        f.add(list);
        f.setSize(200,400);  
        f.setLayout(null);  
        f.setVisible(true); 
	}
}
