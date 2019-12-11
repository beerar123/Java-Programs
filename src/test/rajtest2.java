package test;

public class rajtest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String browser = "Chrome";
		if(browser.equals("Chrom"))
		{
			System.out.println("it is not Firefox" );
		}
		else if(browser.endsWith("r"))
		{
			System.out.println("this is something browser" );
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.out.println("It is Chorme");
		}
		else if(browser.contains("Chr"))
		{
			System.out.println("it is something");
		}
		//else
		//{
		//	System.out.println("it is nothing");
		//}
	}

}
