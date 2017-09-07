package helloworld;

import javax.swing.JOptionPane;
import util.Counter;


public class Test {

	public static void main(String[] args) {
		System.out.println("Helloworld");
		
		Counter counter= new Counter();
		int result = counter.count(5);
		System.out.println(result);
		System.out.println("test print out");
		JOptionPane.showMessageDialog(null, "Welcome to Java", "Display Message", JOptionPane.INFORMATION_MESSAGE);
		
		
		String annualIRS=JOptionPane.showInputDialog("Enter interest rate:");
		
		//convert string to double
		double annualIR=Double.parseDouble(annualIRS);
		
		//Obtain monthly interest rate
		double monthlyIR = annualIR/1200;
		
		//Enter number of years
		String numberYearS=JOptionPane.showInputDialog("Enter number of years, \nfor example:5 ");
		
		//convert string to int
		int numberYear=Integer.parseInt(numberYearS);
		
		//Enter loan amount
		String loanString=JOptionPane.showInputDialog("Enter loan amount: ");
		
		//convert string to double 
		double loanAmount = Double.parseDouble(loanString);
		
		double monthlyPayment= loanAmount * monthlyIR/(1-1/Math.pow(1+monthlyIR, numberYear*12));
		double totalPayment=monthlyPayment * numberYear*12;
		
		monthlyPayment = (int)(monthlyPayment*100)/100.0;
		totalPayment = (int)(totalPayment*100)/100.0;
		String output = "The monthly payment is" + monthlyPayment + "\nThe total payment is " + totalPayment;
		JOptionPane.showMessageDialog(null, output);
		
		
	}

}

/*public void fileNotFoundException() {
	try {
		createFileReader();
	}
	catch(FileNotFoundException e) {
		logger.error(e.getMessage(),e);
	}
}

public void fileNotFoundExceptionIsThrown() throws FileNoFoundException{
	createFileReader();
}

public void createFileReader() throws FileNotFoundException{
	File file =  new File("/text.txt");
	
	new FileReader(file);
}*/
