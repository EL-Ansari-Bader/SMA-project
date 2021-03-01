package Containers;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;

public class Vacccont {
	public static void main(String[] args) throws Exception {
		  Runtime runtime = Runtime.instance();
		  ProfileImpl profileimpl=new ProfileImpl();
		  profileimpl.setParameter(ProfileImpl.CONTAINER_NAME, "Vaccination");
		  AgentContainer Container= runtime.createAgentContainer(profileimpl);
		  AgentController vac = Container.createNewAgent("Vaccination", "Agents.Vaccagent", new Object[] {});
		  vac.start();
}}