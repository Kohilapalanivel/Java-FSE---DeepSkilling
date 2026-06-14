import java.util.*;
class Employee
{
	int employeeId;
	String name;
	String position;
	double salary;
	Employee(int employeeId, String name,String position, double salary)
	{
		this.employeeId = employeeId;
		this.name = name;
		this.position = position;
		this.salary = salary;
	}
	void display()
	{
		System.out.println("Employee ID : " + employeeId);
		System.out.println("Name        : " + name);
		System.out.println("Position    : " + position);
		System.out.println("Salary      : " + salary);
		System.out.println();
	}
}
public class EmployeeManagementSystem
{
	static Employee employees[] = new Employee[100];
	static int count = 0;
	public static void addEmployee(Employee emp)
	{
		if(count < employees.length)
		{
			employees[count++] = emp;
			System.out.println("Employee Added Successfully\n");
		}
		else
		{
			System.out.println("Storage Full!\n");
		}
	}
	public static void displayAll()
	{
		if(count == 0)
		{
			System.out.println("No Employees Found\n");
			return;
		}
		for(int i = 0; i < count; i++)
		{
			employees[i].display();
		}
	}
	public static void searchEmployee(int id)
	{
		for(int i = 0; i < count; i++)
		{
			if(employees[i].employeeId == id)
			{
				System.out.println("Employee Found:");
				employees[i].display();
				return;
			}
		}
		System.out.println("Employee Not Found\n");
	}
	public static void deleteEmployee(int id)
	{
		int index = -1;

		for(int i = 0; i < count; i++)
		{
			if(employees[i].employeeId == id)
			{
				index = i;
				break;
			}
		}
		if(index == -1)
		{
			System.out.println("Employee Not Found\n");
			return;
		}

		for(int i = index; i < count - 1; i++)
		{
			employees[i] = employees[i + 1];
		}
		count--;
		System.out.println("Employee Deleted Successfully\n");
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		addEmployee(new Employee(101,"Anu","Manager",50000));
        addEmployee(new Employee(102,"Arun","Developer",40000));
        addEmployee(new Employee(103,"Kohila","Tester",35000));
		System.out.println("1. Add Employee");
		System.out.println("2. Display All Employees");
		System.out.println("3. Search Employee");
		System.out.println("4. Delete Employee");
		System.out.println("5. Exit");
		System.out.print("Enter choice: ");
		int choice = sc.nextInt();
		switch(choice)
		{
		case 1:
			System.out.print("Enter ID: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter Name: ");
			String name = sc.nextLine();
			System.out.print("Enter Position: ");
			String position = sc.nextLine();
			System.out.print("Enter Salary: ");
			double salary = sc.nextDouble();
			addEmployee(new Employee(id, name, position, salary));
			break;
		case 2:
			displayAll();
			break;
		case 3:
			System.out.print("Enter Employee ID to Search: ");
			searchEmployee(sc.nextInt());
			break;
		case 4:
			System.out.print("Enter Employee ID to Delete: ");
			deleteEmployee(sc.nextInt());
			break;
		default:
			System.out.println("Invalid Choice!\n");
		}
	}
}
