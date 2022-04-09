package Model;

import Util.Interaction;

public class Table {
	private PossibleOperation possibleOperation;
	private int chiffre;

	public Table(PossibleOperation operation, int chiffre) {
		this.possibleOperation = operation;
		this.chiffre = chiffre;
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

	@Override
	public String toString() {
		return "Table [possibleOperation=" + possibleOperation + ", chiffre=" + chiffre + "]";
	}

	public void resoudre() {

		String res = "Table ";

		// première partie de la phrase
		if (this.possibleOperation != PossibleOperation.ADDITION) {
			res += ("de " + ((this.possibleOperation).toString().toLowerCase()) + " ");
		} else {
			res += ("d'" + ((this.possibleOperation).toString().toLowerCase()) + " ");
		}

		// deuxième partie de la phrase
		res += ("de " + String.valueOf(this.chiffre) + " :");

		// affichage de l'exercice
		int rep;
		int score = 0;

		System.out.println(res);

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
			System.out.print(this.chiffre + " " + operation + " " + String.valueOf(i + 1) + " " + " = ");
			rep = Interaction.lireInt();

			switch (this.possibleOperation) {
			case ADDITION: {
				if (rep == this.chiffre + i + 1) {
					score++;
				}
				break;
			}
			case SOUSTRACTION: {
				if (rep == this.chiffre - i + 1) {
					score++;
				}
				break;
			}
			case MULTIPLICATION: {
				if (rep == this.chiffre * i + 1) {
					score++;
				}
				break;
			}
			case DIVISION: {
				/*
				 * if (rep == this.chiffre / i+1 ) { score++; }
				 */
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + this.possibleOperation);
			}

		}
		System.out.println("Score : " + score);
	}
}