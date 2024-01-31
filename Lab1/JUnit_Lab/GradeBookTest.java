import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {

	// creating object using new operator 
    GradeBook instance1;
    GradeBook instance2; 
    
	
	@BeforeEach
	void setUp() throws Exception {
		
		instance1 = new GradeBook(5); 
	    instance2 = new GradeBook(5);
	    
		
        instance1.addScore(50);
        instance1.addScore(75);
        
        instance2.addScore(30);
        instance2.addScore(60);
         
	}

	@AfterEach
	void tearDown() throws Exception {
		
		 instance1 = instance2 = null;
		 
	}

	@Test
	void testAddScore() {

		assertTrue (instance1.toString().equals("50.0 75.0"));
		assertTrue (instance2.toString().equals("30.0 60.0"));
	}

	@Test
	void testSum() {
		
		assertEquals (125,instance1.sum(),.0001);
		assertEquals (90,instance2.sum(),.0001);
	}

	@Test
	void testMinimum() {
		
		assertEquals (50,instance1.minimum(),.001);
		assertEquals (30,instance2.minimum(),.001);
	}

	@Test
	void testFinalScore() {
		
		assertEquals (75,instance1.finalScore());
		assertEquals (60,instance2.finalScore());
		
	}

	@Test
	void testGetScoreSize() {
		
		assertEquals (2,instance1.getScoreSize());
		assertEquals (2,instance2.getScoreSize());
	}

	@Test
	void testToStringDoubleArray() {
		
		assertTrue (instance1.toString().equals("50.0 75.0"));
		assertTrue (instance2.toString().equals("30.0 60.0"));
		
	}

}
