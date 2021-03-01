package Containers;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;


public class DPI {


		public static void main(String[] args) throws Exception {
			  Runtime runtime = Runtime.instance();
			  ProfileImpl profileimpl=new ProfileImpl();
			  profileimpl.setParameter(ProfileImpl.CONTAINER_NAME, "DPI");
			  AgentContainer Container= runtime.createAgentContainer(profileimpl);
			  AgentController doctorcontroller = Container.createNewAgent("Doctor","Agents.DoctorAgent" , new Object[] {});
			  doctorcontroller.start();}
		 

}
