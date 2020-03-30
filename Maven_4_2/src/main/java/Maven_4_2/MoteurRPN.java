package Maven_4_2;



	import java.util.HashMap;
   
	import java.util.Map;
	import java.util.Stack;

	import Exceptions.DivisionParZeroException;
	import Exceptions.OperandeManquantException;
	import Exceptions.OperandeTropGrandException;
	import Exceptions.OperandeTropPetitException;
	/**
	 * 
	 * @author Mehdi
	 *
	 */
	public class MoteurRPN extends Interpreteur {
		public static  final double MAX_VALUE = 10000;
		public  static final double MIN_VALUE = 0;
		private Stack<Double> stockage ;
		private Stack<Double> historique ;
		private Map<String , SpecCommand> commandes ;
		/**
		 * 
		 * @param pile stockage 
		 * @param histor pile 
		 */
		public MoteurRPN(final Stack<Double> stockage,final Stack<Double> historique) {
			super(stockage, historique);
			this.commandes = new HashMap <String,SpecCommand>();
			commandes.put("+", new Addition());
			commandes.put("*", new Multiplication());
			commandes.put("-", new Soustraction());
			commandes.put("/", new Division(stockage));
	        this.stockage=stockage ;
	        this.historique=historique;
			
		}
		/**
		 * 
		 * @param operande  operande
		 * 
		 * 
		 * @throws OperandeTropGrandException OperandeTropGrandException
		 * @throws OperandeTropPetitException OperandeTropPetitException
		 * fonction pour ajouter un operand dans la pile stockage
		 */
		public void ajouterOperande(double operande) throws OperandeTropGrandException , OperandeTropPetitException
		{
	       if(operande < MIN_VALUE) {
	    	   throw new OperandeTropPetitException() ;
	       }
	       else if (operande > MAX_VALUE){
	    	   throw new OperandeTropGrandException();
	       }
	       this.stockage.push(operande);

		}
		/**
		 * 
		 * @return affichage pile 
		 */
		public String afficher()
		 {
			String i = "";
			String j = " ";
		 for(double p :stockage)
			 {
				i += p + j;
		}
			return i;
		  }
		/**
		 * 
		 * @author Mehdi
		 * addition
		 *
		 */
		private static class Addition implements SpecCommand{
	        public Addition() {
	         }
			public double apply(double operande_1, double operande_2) {
				
				return operande_1+operande_2;
			 }

			
		  }
	/**
		* 
		* @author Mehdi
		*multiplication
		*/
		private static class Multiplication implements SpecCommand{
	       public Multiplication()  {
	          }
		public double apply(double operande_1, double operande_2)  {
				
				return operande_1*operande_2;
		  }
			
			  }
	  /**
	   * 
	   * @author Mehdi
	   * division
	   *
	   */
	    private class Division implements SpecCommand {
	       public Division(Stack<Double> stosckage){
	           }
	        
		    public double apply(double operande_1, double operande_2)throws DivisionParZeroException {
			  if (operande_1 != 0){
				    return operande_2/operande_1;
				  }
				  else  {
          		 stockage.push(operande_2);
				 stockage.push(operande_1);
				 historique.pop();
				 historique.pop();
				 throw new DivisionParZeroException() ;
				   }
			    }
			
				  }
		/**
		 * 
		 * @author Mehdi
		 * 
		 * soustraction
		 *
		 */
		  private static  class Soustraction implements SpecCommand{
	         public Soustraction() {
	          }
			  public double apply(double operande_1, double operande_2) {
				
				  return operande_2-operande_1;
			  }
			
			
			
				  }
		/**
		 * 
		 * @param commande 
		 * @return result exec de la commande 
		 * @throws OperandeManquantException OperandeManquantException
		 * @throws DivisionParZeroException  DivisionParZeroException
		 */

		public double calcule(SpecCommand comd) throws OperandeManquantException, DivisionParZeroException
		{
		
				if (this.stockage.size() >= 2){
					double operande1 = this.stockage.pop(); 
					double operande2 = this.stockage.pop(); 
					this.historique.push(operande1);
					this.historique.push(operande2);
					double k=comd.apply(operande1, operande2);
					stockage.push(k);
					return k;
					
				}   else throw new OperandeManquantException();
		}
		/**
		 * 
		 * @param operation défnit la commande
		 * @return  comd va definir le type de la commande 
		 * @throws OperandeManquantException OperandeManquantException
		 * @throws DivisionParZeroException DivisionParZeroException
		 */
	         public double calculecommande(String operation) throws OperandeManquantException, DivisionParZeroException {
			
		     	 return  this.calcule(this.commandes.get(operation));
		  }
	      
        	}
