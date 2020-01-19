package B2B;
import java.util.Scanner;
public class B2BMain {

	/* Single Ton Class */
	//private static SellerManager SellerManager_instance = null;

	public static void main(String[] args) {
		/* Generate Threads for each User logging in
		 * thread will call login function*/
		GUI gui = new GUI();
		gui.login();
	}

	private static void openGUI()
	{
		/* Create Threads with login function */
	}

	private int login()
	{
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter Login name");
		String sEmplLoginName = scan.next();
		scan.close();
		/* assert login */
		if(sEmplLoginName == "")
		{
			/* exit thread */
			return 1;
		}

		/* Wait in an infinite loop in this thread */

		waitForEvents();

		return 0;
	}

	private void waitForEvents() {
		/* In a loop wait for all the events and call
		 * Invoice Manager and process the invoice
		 */
		while(true)
		{

		}
	}

}