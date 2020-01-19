package B2B;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InvoiceTest {

	@Test
	void test() {
		
		testsetInvState();
		
		
	}
   void testsetInvState() {
	   Invoice testinvoice =  new Invoice(1,"Buy1", "dDD");
	   testinvoice.seteInvState();
	   //System.out.println("valud is "+testinvoice.geteInvState());
	   assertTrue(InvState.PEND_PAY ==testinvoice.geteInvState());
   }
}
