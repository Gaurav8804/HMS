package assertion;

public class SoftAssert {
	
	public static void main(String[] args) {
		String a="dell";
		String b="Dell";
		String c=null;
	    int d=100;
	    int e=0;
		
		org.testng.asserts.SoftAssert sa=new org.testng.asserts.SoftAssert(); 
		sa.assertEquals(a, a);
		sa.assertNotEquals(d, e);
		sa.assertTrue(a.equalsIgnoreCase(b));
		sa.assertFalse(a.contentEquals(b));
//		sa.assertNotNull(c);
		sa.assertNull(c);
		sa.assertAll();
		
	}

}
