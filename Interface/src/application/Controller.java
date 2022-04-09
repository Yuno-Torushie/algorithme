package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller implements Initializable {
	
	/**
	 * 
	 * Mode 1 : QUE DES TABLES
	 * 
	 * afficher une table au hasard (par défaut)
	 * afficher la table du chiffre entré dans un espace de texte
	 * 
	 * @param e
	 */
	
	public int score;
	public static Table table;
	
	@FXML
	private Label textTable;
	
	@FXML
	private TextArea textAreaTable;
	
	@FXML
	private TextArea textAreaReponses;
	
	@FXML
	private TextField textFieldEntree;
	
	@FXML
	private Label labelScore;
	
	@FXML
	public void newCalculAuHasard(ActionEvent e) {
		System.out.println("nouveau calcul");
		int randomNumPourTable = ThreadLocalRandom.current().nextInt(1, 3 + 1);
		int randomNumPourChiffre = ThreadLocalRandom.current().nextInt(1, 9 + 1);
		table = new Table(PossibleOperation.actionForInt(randomNumPourTable), randomNumPourChiffre);
		System.out.println(table);
		textAreaTable.setText(table.display());
		textAreaReponses.setText("\n");
		textFieldEntree.setText("");
		labelScore.setText("Score : ");
	}
	
	@FXML
	public void validerResult(ActionEvent e) {
		if (!textFieldEntree.getText().isEmpty() && table.getTourReponse() <= 9) {
			//System.out.println(textFieldEntree.getText());
			textAreaReponses.setText(textAreaReponses.getText() + "\n" + textFieldEntree.getText());
			
			switch (table.getOperation()) {
			case ADDITION: {
				if (table.getChiffre() + table.getTourReponse() == Integer.parseInt(textFieldEntree.getText())) {
					score++;
				}
				break;
			} case SOUSTRACTION: {
				if (table.getChiffre() - table.getTourReponse() == Integer.parseInt(textFieldEntree.getText())) {
					score++;
				}
				break;
			} case MULTIPLICATION: {
				if (table.getChiffre() * table.getTourReponse() == Integer.parseInt(textFieldEntree.getText())) {
					score++;
				}
				break;
			} 
			default:
				throw new IllegalArgumentException("Unexpected value: " + table.getOperation());
			}
			
			textFieldEntree.setText("");
			table.setTourReponse(table.getTourReponse() + 1);
		}
		if (table.getTourReponse() == 10) {
			System.out.println("Score : " + score);
			labelScore.setText("Score : " + score);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		textAreaTable.setEditable(false);
		textAreaReponses.setEditable(false);
		textAreaReponses.setText("\n");
		score = 0;
	}
	
}
