package B2B;

import java.util.*;

enum PAYMENTTYPE{
	NEFT,
	UPI,
	RTGS,
	RECURR
}
class PayAccountDetails {

}

abstract class Payment
{
	private String invoiceId;
	private PayAccountDetails Accdtls;
	
	public Payment(String invoiceId2, PayAccountDetails accdtls2) {
		this.invoiceId = invoiceId2;
		this.Accdtls = accdtls2;
	}

	public abstract Boolean Process();	
	
}

class NEFTPayment extends Payment
{
	NEFTPayment(String invoiceId , PayAccountDetails Accdtls)
	{
		super(invoiceId,Accdtls);
	}
	
	@Override
	public Boolean Process() {
		return true;
	}
	
}

class UPIPayment extends Payment
{
	UPIPayment(String invoiceId , PayAccountDetails Accdtls)
	{
		super(invoiceId,Accdtls);
	}
	
	@Override
	public Boolean Process() {
		return true;
	}	
}

class RTGSPayment extends Payment
{
	RTGSPayment(String invoiceId , PayAccountDetails Accdtls)
	{
		super(invoiceId,Accdtls);
	}
	
	@Override
	public Boolean Process() {
		return true;
	}
}

class ReOccuringPayment extends Payment
{
	ReOccuringPayment(String invoiceId , PayAccountDetails Accdtls)
	{
		super(invoiceId,Accdtls);
	}
	
	@Override
	public Boolean Process() {
		return true;
	}
}

class PaymentQueueMgr
{
	private HashSet<Payment> paymentsSet ;
	
	public void AddPayment(Payment p)
	{
		paymentsSet.add(p);
	}
	
	public void DeletePayment(Payment p)
	{
		 paymentsSet.remove(p);
	}
}

public class PaymentManager {

	private PaymentQueueMgr qMgr;
	
	static PaymentManager paymentManager_inst=null;
	private PaymentManager()
	{

	}

	public static PaymentManager get_PaymentManager()
	{
		
		if(paymentManager_inst == null) {
			paymentManager_inst = new PaymentManager();
		}
			return paymentManager_inst ;
	}	

	
	int Pay(PAYMENTTYPE type,String invoiceId , PayAccountDetails Accdtls)
	{
		Payment p=null;
		switch(type)
		{
		case NEFT :
			 p = new NEFTPayment(invoiceId,Accdtls);
			 break;
		case UPI :
			 p = new UPIPayment(invoiceId,Accdtls);
			 break;
		case RTGS :
			 p = new RTGSPayment(invoiceId,Accdtls);
			 break;
		case RECURR :
			 p = new ReOccuringPayment(invoiceId,Accdtls);
			 break;			 
		default:
			//Error
			break;
		}
		
		qMgr.AddPayment(p);
		
		if(p.Process())
		{
			qMgr.DeletePayment(p);
			return 0;		
		}
		
		return 1;
	}
	
}
