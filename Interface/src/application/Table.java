package application;

public class Table {

	private PossibleOperation possibleOperation;
	private int chiffre;
	private int tourReponse;
	private String contenu;

	public Table(PossibleOperation operation, int chiffre) {
		this.possibleOperation = operation;
		this.chiffre = chiffre;
		this.tourReponse = 1;
		this.contenu = "";
	}

	public int getChiffre() {
		return chiffre;
	}

	public void setChiffre(int chiffre) {
		this.chiffre = chiffre;
	}

	public PossibleOperation getOperation() {
		return possibleOperation;
	}

	public void setOperation(PossibleOperation operation) {
		this.possibleOperation = operation;
	}

	public int getTourReponse() {
		return tourReponse;
	}

	public void setTourReponse(int tourReponse) {
		this.tourReponse = tourReponse;
	}
	
	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	
	@Override
	public String toString() {
		return "Table [possibleOperation=" + possibleOperation + ", chiffre=" + chiffre + "]";
	}

	public String display() {

		String res = "Table ";

		// première partie de la phrase
		if (this.possibleOperation != PossibleOperation.ADDITION) {
			res += ("de " + ((this.possibleOperation).toString().toLowerCase()) + " ");
		} else {
			res += ("d'" + ((this.possibleOperation).toString().toLowerCase()) + " ");
		}

		// deuxième partie de la phrase
		res += ("de " + String.valueOf(this.chiffre) + " :\n\n");

		// affichage de l'exercice
		for (int i = 0; i < 9; i++) {
			String operation;
			switch (this.possibleOperation) {
			case ADDITION: {
				operation = "+";
				break;
			}
			case SOUSTRACTION: {
				operation = "-";
				break;
			}
			case MULTIPLICATION: {
				operation = "x";
				break;
			}
			case DIVISION: {
				operation = "/";
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + this.possibleOperation);
			}
			//System.out.print(this.chiffre + " " + operation + " " + String.valueOf(i + 1) + " " + " = \n");
			if (i == 9) {
				res += this.chiffre + " " + operation + " " + String.valueOf(i + 1) + " " + " = ";
			} else {
				res += this.chiffre + " " + operation + " " + String.valueOf(i + 1) + " " + " = \n";
			}

		}
		return res;
	}

}
