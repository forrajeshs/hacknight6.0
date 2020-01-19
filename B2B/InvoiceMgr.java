package B2B;
import java.util.Random;

class InvoiceMgr
{
	// static variable single_instance of type InvoiceMgr 
    private static InvoiceMgr InvoiceMgr_instance = null;
    
	public Invoice GenerateNewInvoice(String buyerDetails,String SellerDetails)
	{
		//Generate unique ID for Invoice
		// create instance of Random class 
		Random rand = new Random(); 
		double nInvId = rand.nextDouble();
        
		return new Invoice(nInvId,buyerDetails,SellerDetails);
	}
	
	public int SaveInvoice(Invoice objInvoice)
	{
		//DBMANAGER. save
		return 0;
	}
	public Invoice fetchInvoice (double nInvId){
		//DBMANAGER. get
		return new Invoice(1,"Buy1", "Sell1");
	}
	
	//Need a singleTon Class 
	public static InvoiceMgr GetInvoiceMgr() {
		 
	        if (InvoiceMgr_instance == null) 
	        	InvoiceMgr_instance = new InvoiceMgr(); 
	  
	        return InvoiceMgr_instance; 
	    		
	}
	private InvoiceMgr() {}
}