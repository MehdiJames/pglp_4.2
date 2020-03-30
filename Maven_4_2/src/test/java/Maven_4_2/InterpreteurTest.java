package Maven_4_2;


	

	import static org.junit.Assert.assertNotNull;
	

	import java.util.Stack;

	import org.junit.Test;

	

	public class InterpreteurTest {
		Stack<Double> s ;
		Stack<Double> h ;
		Interpreteur in = new Interpreteur(s,h);
			@Test
			public void testinterpreteur1() {
				
				assertNotNull(in);
			}
			
			
	
}
