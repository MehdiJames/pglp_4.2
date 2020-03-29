package Maven_4_2;

public enum CalculatriceRPN {
	        CALCUL;
	public void start( String[] args ) {

SaisieRPN Saisie = new SaisieRPN();
Saisie.saisie();
}
public static void main(String[] args) {
CALCUL.start(args);
}
}

