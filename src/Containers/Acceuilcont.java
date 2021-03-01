package Containers;




import java.io.IOException;
import java.util.ArrayList;

import Agents.Acceuil;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.gui.GuiEvent;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Acceuilcont {

	public static void main(String[] args) throws Exception  {
		  Runtime runtime = Runtime.instance();
		  ProfileImpl profileimpl=new ProfileImpl();
		  profileimpl.setParameter(ProfileImpl.CONTAINER_NAME, "Acceuil");
		  AgentContainer Container= runtime.createAgentContainer(profileimpl);
		  AgentController rec = Container.createNewAgent("Acceuil","Agents.Acceuil" ,new Object[] {});
		  rec.start();
			
		  }
}

