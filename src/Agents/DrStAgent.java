package Agents;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import javafx.geometry.Insets;

public class DrStAgent extends Agent{
	  HashMap<String, Integer> Stock = new HashMap<String, Integer>();
	  ArrayList<String> Patient=new ArrayList<String>();
	    // Add keys and values (Country, City)
	  String MedRec="NOne";
	  static boolean running;

	protected void setup() {
	  	Stock.put("Doliprane", 30);
	  	Stock.put("Vitamine C", 30);
	  	Stock.put("Vitamine D",30);  
	  	Stock.put("Zinc", 30);
		addBehaviour(new CyclicBehaviour() {
				public void action() {
						ACLMessage msg = receive();
						if(msg != null) {try {
							Patient=(ArrayList<String>) msg.getContentObject();
						} catch (UnreadableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					MedRec=Patient.get( Patient.size()-1);
					if(!running)
					{
					running = true;
					
					
					JFrame f=new JFrame("Drug Store");
					JLabel Wel;
					Wel=new  JLabel(" Le Docteur recommande au patient  "+Patient.get(0)+" :  "+MedRec);
					Wel.setBounds(0,0, 400,30);
					f.add(Wel);
					 DefaultListModel<String> l1 = new DefaultListModel<>();  
			          l1.addElement("Doliprane");  
			          l1.addElement("Vitamine C");  
			          l1.addElement("Vitamine D");  
			          l1.addElement("Zinc");  
					  
			          JList<String> list = new JList<>(l1);  
			          list.setBounds(0,50, 200,200);  
			          list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			          list.addListSelectionListener(new ListSelectionListener() {
			             
			              public void valueChanged(ListSelectionEvent e) {
			                  if (!e.getValueIsAdjusting()) {
			                	  Object[] options = {"Oui",
			                      "Non"};
			       JOptionPane.showOptionDialog(f,
			    		   list.getSelectedValue(),"Vendre",
			      JOptionPane.YES_NO_OPTION,
			      JOptionPane.QUESTION_MESSAGE,
			      null,     //do not use a custom Icon
			      options,  //the titles of buttons
			      options[0]);
			      
			                  }
			              }
			          });
			          f.add(list);
			          
			          
				    
					
					f.setSize(400,400);  
				    f.setLayout(null);
				    f.setVisible(true);
					
					}
					}
					else {block();}
			}});

}}

