package Maven_4_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import Exceptions.OperandeManquantException;
/**
 * 
 * @author Mehdi
 *
 */

public class Interpreteur {
	  private Map<String , GeneriqueCommande> commandes ;

	/**
	 * 
	 * @param pile de stockage 
	 * @param pile d'historique
	 */
	public Interpreteur ( final  Stack<Double> stockage , final  Stack<Double> historique )
	{
		this.commandes = new HashMap <String , GeneriqueCommande> ();
		this.commandes.put("undo", new Undo(stockage, historique));
		this.commandes.put("exit", new Quit());
	}
	/**
	 * 
	 * @param undo ou quit 
	 * @throws OperandeManquantException
	 * 
	 */
	public void traite(String str) throws OperandeManquantException {
		GeneriqueCommande commande = this.commandes.get(str);
	    commande.apply();
		
	}
	/**
	 * 
	 * @author Mehdi
	 *quitter 
	 */
	     private  static class Quit implements GeneriqueCommande {

			public void apply() {
				System.out.println("vous avez quitte l'appli ");
				
			}
	     }
	    /**
	     *  
	     * @author Mehdi
	     *
	     */
		private static class Undo implements GeneriqueCommande {
	          private Stack<Double> stockage;
	          private Stack<Double>  hist;
			public Undo(final Stack<Double>  stockage, final Stack<Double> hist) {
				this.hist=hist; 
				this.stockage=stockage;
				
			}
			/**
			 * 
			 */
			public void apply() throws OperandeManquantException{
	               if (!this.stockage.empty()){
	            	   this.stockage.pop();
	             if (this.hist.size()>= 2){
	            	double a = this.hist.pop();
	            	double b = this.hist.pop();
	            	this.stockage.push(a);
	            	this.stockage.push(b);
	             }
	             else throw new OperandeManquantException();
				
			} else throw new IllegalStateException();
			}
			
			
		}
	    	 
	     
}
