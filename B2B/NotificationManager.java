package B2B;

import java.util.*;

class NotificationMessage {
	protected String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}

class PhoneMessage extends NotificationMessage
{
	void SetMsg(String msg)
	{
		this.msg = msg;
	}
}

class EmailMessage extends NotificationMessage
{
	void SetMsg(String msg)
	{
		this.msg = msg;
	}
}

class WatsAppMessage extends NotificationMessage
{
	void SetMsg(String msg)
	{
		this.msg = msg;
	}
}

interface Notify
{
	public void update(NotificationMessage msg) ;
}

public class NotificationManager {

	private List<Notify> defaultNotifers; 
	private Map<String, List<Notify>> invoiceIdNotifers ;
	static NotificationManager notificationManager_inst=null;
	private NotificationManager()
	{
		defaultNotifers = new LinkedList<Notify>();
		RegisterDefaultNotifier((Notify)new EmailMessage());
		
		List<Notify> l = new LinkedList<Notify>();
		invoiceIdNotifers = new HashMap<String, List<Notify>>();
	}

	public static NotificationManager get_NotificationManager()
	{
		
		if(notificationManager_inst == null) {
			notificationManager_inst = new NotificationManager();
		}
			return notificationManager_inst ;
	}	
	
	public void RegisterDefaultNotifier(Notify n)
	{
		defaultNotifers.add(n) ;
	}
	
	public void RegisterInvoiceNotifier(String invoiceId, Notify n)
	{
		if(invoiceIdNotifers.containsKey(invoiceId))
			invoiceIdNotifers.get(invoiceId).add(n) ;
	}

	public void DeRegisterInvoiceNotifier(String invoiceId, Notify n)
	{
		if(invoiceIdNotifers.containsKey(invoiceId))
		{
			invoiceIdNotifers.get(invoiceId).remove(n) ;
			
			if(invoiceIdNotifers.get(invoiceId).isEmpty())
				invoiceIdNotifers.remove(invoiceId);
		}
	}
	
	public void NotifyDefaultSubscribers(NotificationMessage msg)
	{
		for(Notify notifier : defaultNotifers)
		{
			notifier.update(msg);
		}
	}

	public void NotifyInvoiceNotifierSubscribers(String invoiceId ,NotificationMessage msg)
	{
		if(! invoiceIdNotifers.containsKey(invoiceId))
			return ;
		
		List<Notify> subscribers = invoiceIdNotifers.get(invoiceId) ;
		
		for(Notify notifier : subscribers)
		{
			notifier.notify();
		}
	}	
}

