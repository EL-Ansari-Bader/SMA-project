package Containers;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;


public class MyMainContainer {
  public static void main(String[] args) throws Exception {
	  Runtime runtime = Runtime.instance();
	  ProfileImpl profileimpl=new ProfileImpl();
	  profileimpl.setParameter(ProfileImpl.GUI, "true");
	  AgentContainer mainContainer=runtime.createMainContainer(profileimpl);
	  mainContainer.start();
  }
}
