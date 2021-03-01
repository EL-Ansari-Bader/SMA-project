package Containers;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;

public class DScont {
	public static void main(String[] args) throws Exception {
		  Runtime runtime = Runtime.instance();
		  ProfileImpl profileimpl=new ProfileImpl();
		  profileimpl.setParameter(ProfileImpl.CONTAINER_NAME, "Drug Store");
		  AgentContainer Container= runtime.createAgentContainer(profileimpl);
		  AgentController Drcont = Container.createNewAgent("Drug Store","Agents.DrStAgent" , new Object[] {});
		  Drcont.start();
}}
