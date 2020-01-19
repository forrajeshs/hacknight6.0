package B2B;

class TransDetail {
private eTransType eTransType;
private String sBankName;
private String sTransId;

public TransDetail(B2B.eTransType eTransType, String sBankName, String sTransId) {
super();
this.eTransType = eTransType;
this.sBankName = sBankName;
this.sTransId = sTransId;
}

}