package Exceptions;

public class OperandeTropGrandException extends Exception {

		/**
		 *Operande Trop Grand
		 */

		public OperandeTropGrandException(){
			super("Operande trop grand, la valeur de l' Operande doit etre inf�rieure � 10000");
		}
		

	}

