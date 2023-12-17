package app;
import java.sql.SQLException;
import java.util.*;
import dao.InsuranceServiceImpl;
import entity.*;
import exceptionn.PoliciesNotFouund;
import exceptionn.PolicyAlreadyExists;
import exceptionn.PolicyNotFoundException;
public class Main {
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		Scanner sc=new Scanner(System.in);
		InsuranceServiceImpl i1 = new InsuranceServiceImpl();
		System.out.println("Hi Sir welcome to Insurance Mangement");
		boolean ans=true;
		while(ans)
		{
			System.out.println("----------------------------");
			System.out.println("1>>create policy");
			System.out.println("2>>get policy");
			System.out.println("3>>get all policies");
			System.out.println("4>> update policy details");
			System.out.println("5>>delete policy ");
			System.out.println("6>>Exit");
			System.out.println("----------------------------");
			int t=sc.nextInt();
			switch(t)
			{
			case(1):
			{
				Policy p=new Policy();
				boolean validInput=false;
				
				
				
				do {
				    try {
				        System.out.println("Enter the policy id");
				        p.setPolicyId(sc.nextInt());
				        validInput = true; 
				        sc.nextLine();
				        } catch (InputMismatchException e) {
				        System.out.println("Please enter a valid number");
				        sc.nextLine();  
				    }
				} while (!validInput);
				
				System.out.println("enter the policy name");
				p.setPolicyName(sc.nextLine());
				
				System.out.println("enter the policy type");
				p.setPolicyType(sc.nextLine());
				try
				{
				boolean v=i1.createPolicy(p);
				System.out.println("policy successfully created");
				}
				catch (PolicyAlreadyExists e)
				{
					System.out.println(e.getMessage());
				}
				
				
				break;
				
			}
			case(2):
			{
				int search_item = 0;
				boolean validInput=false;
				do {
				    try {
				        System.out.println("Enter the policy id");
				        search_item=sc.nextInt();
				        validInput = true; 
				        sc.nextLine();
				        } catch (InputMismatchException e) {
				        System.out.println("Please enter a valid number");
				        sc.nextLine();  
				    }
				} while (!validInput);
				try
				{
					Policy p1=i1.getPolicy(search_item);
					System.out.println("the policy details are below");
					System.out.println(p1);
				}
				catch(PolicyNotFoundException e)
				{
					System.out.println(e.getMessage());
				}
				
				break;
			}
			case(3):
			{
				try
				{
				Collection<Policy> ar=new ArrayList<>();
				
				ar=i1.getAllPolicies();
				Iterator<Policy> i2=ar.iterator();
				while(i2.hasNext())
				{
					System.out.println(i2.next());
				}
				}
				catch(PoliciesNotFouund e)
				{
					System.out.println(e.getMessage());
				}
				
				break;
				
			}
			case(4):
			{
				Policy p=new Policy();
				boolean validInput=false;
				
				
				
				do {
				    try {
				        System.out.println("Enter the policy id");
				        p.setPolicyId(sc.nextInt());
				        validInput = true; 
				        sc.nextLine();
				        } catch (InputMismatchException e) {
				        System.out.println("Please enter a valid number");
				        sc.nextLine();  
				    }
				} while (!validInput);
				
				System.out.println("enter the policy name");
				p.setPolicyName(sc.nextLine());
				
				System.out.println("enter the policy type");
				p.setPolicyType(sc.nextLine());
				try
				{
					boolean v1=i1.updatePolicy(p);
					System.out.println("Succesfully updated");
				}
				catch(PolicyNotFoundException e)
				{
					System.out.println(e.getMessage());
				}
				
				break;
				
			}
			case(5):
			{
				int delete_item = 0;
				boolean validInput=false;
				do {
				    try {
				        System.out.println("Enter the policy id");
				        delete_item=sc.nextInt();
				        validInput = true; 
				        sc.nextLine();
				        } catch (InputMismatchException e) {
				        System.out.println("Please enter a valid number");
				        sc.nextLine();  
				    }
				} while (!validInput);
				try
				{
				boolean p1=i1.deletePolicy(delete_item);
					System.out.println("reccords with id "+delete_item+" are deleted");
				
				
			}
				catch(PolicyNotFoundException e)
				{
					System.out.println(e.getMessage());
				}
				break;
				}
			case(6):
			{
				System.out.println("Thankyou for visiting our website");
				System.out.println(i1.closeConnection());
				ans=false;
				break;
			}
			default:
				System.out.println("please enter a valid value");		
		


		
			}
			
	}
		
	}

}
