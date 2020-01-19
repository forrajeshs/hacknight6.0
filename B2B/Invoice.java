package B2B;

import java.util.Date;

enum InvState
{
	NEW, PEND_PAY, DISPATCH_PROGRESS, DISPATCHED, RECEIVED, TRANS_COMPLETED;
	public InvState getNext() {
		return this.ordinal() < InvState.values().length - 1
				? InvState.values()[this.ordinal() + 1]
						: null;
	}	
}

enum eTransType
{
	NEFT, IMPS, UPI, RTGS;
}

/* Invoice Class
 *
 */
public class Invoice {

	private double nInvId;
	private String buyerDetails;
	private String sellerDetails;
	public InvState eInvState;
	private Date InvDate;
	private Date EndDate;
	private TransDetail transDetail;

	public String generateDisplayReport()
	{
		// This will display the display report 	
		return "";
	}

	public Invoice(double nInvId, String buyerDetails,String sellerDetails) {
		super();
		this.nInvId = nInvId;
		this.buyerDetails = buyerDetails;
		this.sellerDetails = sellerDetails;
		this.eInvState = InvState.NEW;
	}

	public double getnInvId() {
		return nInvId;
	}

	public String getBuyerDetails() {
		return buyerDetails;
	}

	public InvState geteInvState() {
		return eInvState;
	}

	public void seteInvState() {
		/* State movement checks */
		switch(this.eInvState) {
		case NEW:
			break;
		case PEND_PAY:
			/*
			 * Based on transaction type form GUI, setTransDetail and pass acctDetails to Payment Manager
			 * PayAccountDetails acctDetails=this.buyerDetails.getAccountDetails
			PaymentManager.get_PaymentManager().Pay(PAYMENTTYPE.NEFT, this.nInvId, acctDetails)
			this.getTransDetail();*/
			break;
		case DISPATCH_PROGRESS:
			break;
		case DISPATCHED:
			break;
		case RECEIVED:
			break;
		case TRANS_COMPLETED:
			break;
		}
		this.eInvState = this.eInvState.getNext();
		NotificationManager.get_NotificationManager().NotifyDefaultSubscribers(new EmailMessage());
	}

	public String getSellerDetails() {
		return sellerDetails;
	}

	public void setSellerDetails(String sellerDetails) {
		this.sellerDetails = sellerDetails;
	}

	public Date getInvDate() {
		return InvDate;
	}

	public void setInvDate(Date invDate) {
		InvDate = invDate;
	}

	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}

	public TransDetail getTransDetail() {
		return transDetail;
	}

	public void setTransDetail(TransDetail transDetail) {
		this.transDetail = transDetail;
	}

}



