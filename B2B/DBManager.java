package B2B;

import java.io.FileReader; 
import java.util.Iterator; 
import java.util.Map; 
import java.util.HashMap;
import java.lang.*;

import org.json.simple.*;
import org.json.simple.parser.*;

public class DBManager {

	private HashMap<Integer,Invoice> invoicesMap;   
    private Object obj;	
	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public HashMap<Integer, Invoice> getInvoicesMap() {
		return invoicesMap;
	}

	public Invoice GetInvoice(Integer i )
	{
		return invoicesMap.get(i);
	}
	public void setInvoicesMap(HashMap<Integer, Invoice> invoicesMap) {
		//this.invoicesMap = invoicesMap;
	}

	public DBManager()
	{
		try
		{
		//this.setObj(new JSONParser().parse(new FileReader("C:\\Users\\VJN.ORADEV\\eclipse-workspace\\BinaryBeasts\\src\\B2B\\invoice.json")));
			this.setObj(new JSONParser().parse(new FileReader("invoice.json")));
		}
		catch (Exception e) {}
	}
	

	   /* public static void main(String[] args) throws Exception  
	    {         
	    	DBManager dbMgr = new DBManager();
	    	 
	    	// typecasting obj to JSONObject 
	    	System.out.println("Value of dbMgr "+dbMgr);
	        JSONObject jo = (JSONObject) dbMgr.getObj(); 
	        
	        // getting firstName and lastName 
	        String InvoiceId = (String) jo.get("InvoiceId"); 
	        System.out.println("Value of InvoiceId "+jo.get("InvoiceId"));
	        JSONObject Buyerjson = (JSONObject)jo.get("Seller"); 
	        
	        System.out.println("Value of seller name "+Buyerjson.get("Name"));
	          
	        System.out.println(InvoiceId); 
	             
         }*/ 
	} 