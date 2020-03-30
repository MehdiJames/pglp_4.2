package Maven_4_2;

import java.util.Scanner;

/**
 * @author Mehdi
 *Cette classe permet la saisie de commandes
 */
public class SaisieRPN {
    /**
     *Cette classe permet la lecture des entrées
     */
    private Scanner scan;
    /**
     * calcul.
     */
    private MoteurRPN mot;

   /**
   * constructeur saisieRPN.
   */
    public SaisieRPN() {
        scan = new Scanner(System.in);
        mot = MoteurRPN.init();
        System.out.print(mot.commande);
        while (MoteurRPN.getStop() != 1) {
            if (scan.hasNextInt()) {
                mot.addOperande(scan.nextInt());
                } else {
                    mot.executeCommande(scan.next());
                    }
            }
        System.out.println("end");
        }
}
