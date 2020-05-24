package Maven_4_2;



	import static org.junit.Assert.*;

	import java.util.Stack;

	import org.junit.Test;

	import Exceptions.DivisionParZeroException;
	import Exceptions.OperandeManquantException;
	import Exceptions.OperandeTropGrandException;
	import Exceptions.OperandeTropPetitException;


	public class MoteurTest {
		private Stack<Double> s = new Stack<Double>();
		private Stack<Double> h = new Stack<Double>();
		MoteurRPN m = new MoteurRPN(s,h);
		@Test
		public void testinterpreteur1() {
			
			assertNotNull(m);
		}
		
		@Test(expected=OperandeTropPetitException.class)
		public void testOperandeTropPetit() throws DivisionParZeroException, OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException{
			m.ajouterOperande(-20.00);
			}
		@Test(expected=DivisionParZeroException.class)
		public void testDivisionParZeroException() throws DivisionParZeroException, OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException{
			m.ajouterOperande(9.0);
			m.ajouterOperande(0.0);
			m.calculecommande("/");
			}
		@Test(expected=OperandeTropGrandException.class)
		public void testOperandeTropGrand() throws DivisionParZeroException, OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException{
			
			m.ajouterOperande(50000000000.0);
			}
		@Test
		public void testaddion() throws OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException, DivisionParZeroException{
		
			m.ajouterOperande(6.0);
			m.ajouterOperande(2.0);
			assertEquals(m.calculecommande("+"), 8.0, 0);
		}
		@Test
		public void testsous() throws OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException, DivisionParZeroException{
			m.ajouterOperande(7.0);
			m.ajouterOperande(5.0);
			assertEquals(m.calculecommande("-"), 2, 0);
		}
		
		@Test
		public void testdivision() throws OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException, DivisionParZeroException{
			m.ajouterOperande(8);
			m.ajouterOperande(4);
			assertEquals(m.calculecommande("/"), 2, 0);
		}
		@Test
		public void testmult() throws OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException, DivisionParZeroException{
			m.ajouterOperande(2);
			m.ajouterOperande(10);
			assertEquals(m.calculecommande("*"),20, 0);
		}
		
		@Test
		public void testmult2() throws OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException, DivisionParZeroException{
			m.ajouterOperande(2);
			m.ajouterOperande(5);
			m.ajouterOperande(5);
			assertEquals(m.calculecommande("*"),25, 0);
		}
		
		@Test
		public void testsous2() throws OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException, DivisionParZeroException{
			m.ajouterOperande(2);
			m.ajouterOperande(5);
			m.ajouterOperande(50);
			assertEquals(m.calculecommande("-"), -45, 0);
		}
		
		
		
		@Test
		public void testundo() throws OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException, DivisionParZeroException{
			m.ajouterOperande(2);
			m.ajouterOperande(15);
			m.ajouterOperande(50);
			m.ajouterOperande(2);
			m.calculecommande("+");
			m.traite("undo");
			assertEquals(s.size(),4, 0);
		}
		@Test
		public void testsize() throws OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException, DivisionParZeroException{
			m.ajouterOperande(2);
			m.ajouterOperande(15);
			m.ajouterOperande(50);
			m.ajouterOperande(2);
			m.calculecommande("+");
			assertEquals(s.size(),3, 0);
		}
		public void testsizehistorique() throws OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException, DivisionParZeroException{
			m.ajouterOperande(2);
			m.ajouterOperande(15);
			m.ajouterOperande(50);
			m.ajouterOperande(2);
			m.calculecommande("+");
			assertEquals(h.size(),2, 0);
		}
		public void testsizehistorique2() throws OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException, DivisionParZeroException{
			m.ajouterOperande(2);
			m.ajouterOperande(15);
			m.ajouterOperande(50);
			m.ajouterOperande(2);
			m.calculecommande("+");
			m.calculecommande("/");
			assertEquals(h.size(),4, 0);
		}
		public void testhistorique3() throws OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException, DivisionParZeroException{
			m.ajouterOperande(2);
			m.ajouterOperande(15);
			m.ajouterOperande(50);
			m.ajouterOperande(2);
			m.calculecommande("+");
			m.calculecommande("/");
			m.traite("undo");
			m.traite("undo");
			assertEquals(h.size(),0, 0);
		}
		public void testundo2() throws OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException, DivisionParZeroException{
			m.ajouterOperande(2);
			m.ajouterOperande(15);
			m.ajouterOperande(50);
			m.ajouterOperande(2);
			m.calculecommande("+");
			m.calculecommande("/");
			m.traite("undo");
			m.traite("undo");
			assertEquals(s.size(),4, 0);
		}
		
		
		
		

		
		
		
		
		
	}
