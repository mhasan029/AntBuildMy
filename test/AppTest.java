import junit.framework.*;

public class AppTest extends TestCase {
    public void test1() {
    	
    	App junit = new App();
		int result = junit.add(100, 200);
		assertEquals(301, result);
		
    }

   
}