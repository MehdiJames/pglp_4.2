package Maven_4_2;

import java.util.Scanner;
import java.util.Stack;

import Exceptions.DivisionParZeroException;
import Exceptions.OperandeManquantException;
import Exceptions.OperandeTropGrandException;
import Exceptions.OperandeTropPetitException;


public class SaisieRPN {
	/**
	 * 
	 */
	private Stack<Double> stockage ;
	private Stack<Double>historique ;
	private MoteurRPN mon_moteurrpn;
	/**
	 * 
	 */
	public SaisieRPN()
	{
		this.historique= new Stack<Double>() ;
		this.stockage = new Stack<Double>();
		this.mon_moteurrpn = new MoteurRPN(stockage,historique);
		
	}
	/**
	 * 
	 * @throws OperandeTropGrandException OperandeTropGrandException
	 * 
	 * @throws OperandeTropPetitException OperandeTropPetitException
	 * @throws OperandeManquantException OperandeManquantException
	 * @throws DivisionParZeroException  DivisionParZeroException
	 * 
	 * 
	 */
	public void traitement() throws OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException, DivisionParZeroException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez une operande ou exit pour quitter le programme ou undo pour retour en arrière ");
		String saisie = sc.nextLine();
		Double d;
		while (true)
		{ 
			if (saisie.equals("undo")|| saisie.equals("exit")){
				mon_moteurrpn.traite(saisie);
				
				
				
				if( saisie.equals("exit"))
				{
					 System.exit(0) ;
				}else
				{
					System.out.println(mon_moteurrpn.afficher());
					saisie = sc.nextLine();
				}
			
			 
		     }
			
			else{
			
			try 
			{
				if(saisie.equals("+")|| saisie.equals("-")|| saisie.equals("*")|| saisie.equals("/"))
				{
					mon_moteurrpn.calculecommande(saisie);
				
				}
				
				
				else
				{
					d = new Double(saisie);
					mon_moteurrpn.ajouterOperande(d);
				}
				
			}
			
			catch(OperandeManquantException | DivisionParZeroException | OperandeTropPetitException | OperandeTropGrandException e)
			{
				System.out.println(e.getMessage());
			}
			catch(NumberFormatException e)
			{
				System.out.println("saisie incorrecte (Entrez une operande ou exit pour quitter le programme  ou undo pour retour en arrière )");
			}
			finally {
				System.out.println(mon_moteurrpn.afficher());
				saisie = sc.nextLine();
			}
			}
						
		}
		
			
				
		
		
		
	}
}