package B2B;

/*** This class is used for both Buyer and Seller Profile***/

class Profile {
	private String sName;
	private String sAddress;
	private String sCountry;
	private String sState;


	public Profile(String sBuyerName, String sBuyerAddress, String sCountry, String sState) {
		super();
		this.sName = sBuyerName;
		this.sAddress = sBuyerAddress;
		this.sCountry = sCountry;
		this.sState = sState;
	}


	public String getsBuyerName() {
		return sName;
	}


	public String getsBuyerAddress() {
		return sAddress;
	}


	public String getsCountry() {
		return sCountry;
	}


	public String getsState() {
		return sState;
	}

}