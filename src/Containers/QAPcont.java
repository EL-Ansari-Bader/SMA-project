package Containers;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;

public class QAPcont {

		public static void main(String[] args) throws Exception {
			  Runtime runtime = Runtime.instance();
			  ProfileImpl profileimpl=new ProfileImpl();
			  profileimpl.setParameter(ProfileImpl.CONTAINER_NAME, "Quarantine & Operations");
			  AgentContainer Container= runtime.createAgentContainer(profileimpl);
			  AgentController rec = Container.createNewAgent("Quarantine","Agents.Quarantine" , new Object[] {});
			  rec.start();
				  }
				 

}

