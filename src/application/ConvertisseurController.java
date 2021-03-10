package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

public class ConvertisseurController implements Initializable {



		@FXML
		private Tab weight;

		@FXML
		private TextField weighttxt2;

		@FXML
		private TextField weighttxt1;

		@FXML
		private ComboBox<String> weightbox2;

		@FXML
		private ComboBox<String> weightbox1;



		@FXML
		private Tab dist;

		@FXML
		private TextField disttxt1;

		@FXML
		private TextField disttxt2;

		@FXML
		private ComboBox<String> distbox1;

		@FXML
		private ComboBox<String> distbox2;


		@FXML
		private Tab argent;

		@FXML
		private TextField argenttxt1;

		@FXML
		private TextField argenttxt2;

		@FXML
		private ComboBox<String> argentbox1;

		@FXML
		private ComboBox<String> argentbox2;



		private ObservableList<String> listeW=(ObservableList<String>)FXCollections.observableArrayList("Gramme", "KiloGramme", "Livre", "Miligramme"); //Gramme est unité de base

		double[] Masse= {1.0 , 0.001 , 0.0022 , 1000};


		private ObservableList<String> listeD=(ObservableList<String>)FXCollections.observableArrayList("Kilometre", "Centimetre", "Metre", "Milimetre"); //Metre est unité de base

		double[] distance= {0.001 , 100, 1.0, 1000};


		private ObservableList<String> listeM=(ObservableList<String>)FXCollections.observableArrayList("CAD", "USD", "EUR"); //CAD est unité de basse

		double[] money = { 1.00 , 0.79 , 0.66 } ;




		@Override 
		public void initialize(URL location, ResourceBundle resources) {
				//masse 
				weightbox1.setItems(listeW); 
				weightbox2.setItems(listeW);
				weightbox1.getSelectionModel().selectFirst();
				weightbox2.getSelectionModel().selectFirst();

				//distance 
				distbox1.setItems(listeD); 
				distbox2.setItems(listeD);
				distbox1.getSelectionModel().selectFirst();
				distbox2.getSelectionModel().selectFirst();

				//money 
				argentbox1.setItems(listeM); 
				argentbox2.setItems(listeM);
				argentbox1.getSelectionModel().selectFirst();
				argentbox2.getSelectionModel().selectFirst();

		}



		@FXML 
		void calculeW() { 

				/*
				 * int item1W = weightbox1.getSelectionModel().getSelectedIndex(); int item2W =
				 * weightbox2.getSelectionModel().getSelectedIndex();
				 * 
				 * double tauxW=Masse[item1W]/Masse[item2W]; double
				 * resW=tauxW*(Double.parseDouble(weighttxt1.getText()));
				 * weighttxt2.setText(String.format("%,2f", resW));
				 */
				convertirW(weighttxt1, weighttxt2, weightbox1, weightbox2);
		}

		@FXML 
		void calculeW2() { 

				/*
				 * int item1W = weightbox2.getSelectionModel().getSelectedIndex(); int item2W =
				 * weightbox1.getSelectionModel().getSelectedIndex();
				 * 
				 * double tauxW=Masse[item2W]/Masse[item1W]; double
				 * resW=tauxW*(Double.parseDouble(weighttxt2.getText()));
				 * weighttxt1.setText(String.format("%,2f", resW));
				 */
				convertirW(weighttxt2, weighttxt1, weightbox2, weightbox1);
		}
		
		public void convertirW(TextField txt1W,TextField txt2W, ComboBox box1W, ComboBox box2W ) {
				
				int item1W = box1W.getSelectionModel().getSelectedIndex();
				int item2W = box2W.getSelectionModel().getSelectedIndex();	

				double tauxW=Masse[item2W]/Masse[item1W];
				double resW=tauxW*(Double.parseDouble(txt1W.getText()));
				txt2W.setText(String.format("%,2f", resW));
				
		}
		
		
		@FXML 
		void calculeD() { 
				convertirD(disttxt1, disttxt2, distbox1, distbox2);
				
		}
		
		@FXML 
		void calculeD2() { 
				convertirD(disttxt2, disttxt1, distbox2, distbox1);
			
				
		}
		
		public void convertirD(TextField txt1D,TextField txt2D, ComboBox box1D, ComboBox box2D ) {
				
				int item1D = box1D.getSelectionModel().getSelectedIndex();
				int item2D = box2D.getSelectionModel().getSelectedIndex();	

				double tauxD=distance[item2D]/distance[item1D];
				double resD=tauxD*(Double.parseDouble(txt1D.getText()));
				txt2D.setText(String.format("%,2f", resD));
				
		} 





		@FXML 
		void calculeM() { 
		convertirM(argenttxt1, argenttxt2, argentbox1, argentbox2);
		
		}

		@FXML 
		void calculeM2() { 
		convertirM(argenttxt2, argenttxt1, argentbox2, argentbox1);
		}

		public void convertirM(TextField txt1M,TextField txt2M, ComboBox box1M, ComboBox box2M ) {
		
		int item1M = box1M.getSelectionModel().getSelectedIndex();
		//System.out.println(item1M);
		int item2M = box2M.getSelectionModel().getSelectedIndex();
		//System.out.println(item2M);

		double tauxM= money[item2M]/money[item1M];
		double resM=tauxM*(Double.parseDouble(txt1M.getText()));
		txt2M.setText(String.format("%,2f", resM));
		
		}

//github.








}
