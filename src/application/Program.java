package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		byte numberOfRegister;
		int idCounter, idSearch;
		
		
		List<Employee> list = new ArrayList<Employee>();
		Employee empTemp;
		System.out.println("How employees will be registered?");
		numberOfRegister = sc.nextByte();
		
		idCounter=1;
		
		for (byte i=0; i<numberOfRegister;i++) {
			sc.nextLine();
			System.out.println("Employee name: ");
			String tempName = sc.nextLine();
			System.out.println("Employee Salary");
			double tempSalary = sc.nextFloat();
			Employee employee = new Employee(tempName, idCounter, tempSalary);
			idCounter += 1;
			list.add(employee);
		}
		
				
		for (Employee x : list) {
			System.out.printf("ID: #%d%nNAME: %s%nSalary: %.2f%n%n",x.getId(), x.getName(), x.getSalary());
		}
		
		empTemp = null;
		
				
		System.out.println("Enter de EmployeeID that will have salary increase");
		idSearch = sc.nextInt();
		
		empTemp = list.stream().filter(x -> x.getId() == idSearch).findFirst().orElse(null);
		
		if (empTemp == null) {
			System.out.println("This ID does not exist in this data base");
		}
		else {
			System.out.println("Percentage of raise: ");
			empTemp.salaryRaise(sc.nextDouble()); 
		}
		
		for (Employee x : list) {
			System.out.println("ID: #"+x.getId());
			System.out.println("NAME: "+x.getName());
			System.out.printf("SALARY: %.2f%n%n", x.getSalary());
		}

		
		sc.close();
	}

}
