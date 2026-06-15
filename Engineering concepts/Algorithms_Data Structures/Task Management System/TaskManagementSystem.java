import java.util.*;
class Task
{
	int taskId;
	String taskName;
	String status;
	Task(int taskId,String taskName,String status)
	{
		this.taskId = taskId;
		this.taskName = taskName;
		this.status = status;
	}
}
class Node
{
	Task task;
	Node next;
	Node(Task task)
	{
		this.task = task;
		this.next = null;
	}
}
class LinkedList
{
	Node head;
	void addTask(Task task)
	{
		Node newNode = new Node(task);
		if (head == null)
		{
			head = newNode;
			return;
		}
		Node temp = head;
		while (temp.next != null)
		{
			temp = temp.next;
		}
		temp.next = newNode;
	}
	void searchTask(int id)
	{
		Node temp = head;
		while (temp != null)
		{
			if (temp.task.taskId == id)
			{
				System.out.println("Task Found");
				System.out.println("ID: " + temp.task.taskId);
				System.out.println("Name: " + temp.task.taskName);
				System.out.println("Status: " + temp.task.status);
				return;
			}
			temp = temp.next;
		}

		System.out.println("Task Not Found");
	}
	void traverseTasks()
	{
		Node temp = head;
		while (temp != null)
		{
			System.out.println(temp.task.taskId + " " + temp.task.taskName + " "+ temp.task.status);
			temp = temp.next;
		}
	}
	void deleteTask(int id) {

		if (head == null) {
			System.out.println("List Empty");
			return;
		}

		if (head.task.taskId == id) {
			head = head.next;
			System.out.println("Task Deleted");
			return;
		}

		Node temp = head;

		while (temp.next != null && temp.next.task.taskId != id)
		{
			temp = temp.next;
		}

		if (temp.next == null)
		{
			System.out.println("Task Not Found");
		}
		else
		{
			temp.next = temp.next.next;
			System.out.println("Task Deleted");
		}
	}
}
class TaskManagementSystem
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		LinkedList list = new LinkedList();
		int choice;
		do {
			System.out.println("\n--- Task Management System ---");
			System.out.println("1. Add Task");
			System.out.println("2. Search Task");
			System.out.println("3. Display Tasks");
			System.out.println("4. Delete Task");
			System.out.println("5. Exit");
			System.out.print("Enter Choice: ");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice)
			{
			case 1:
				System.out.print("Enter Task ID: ");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Task Name: ");
				String name = sc.nextLine();
				System.out.print("Enter Status: ");
				String status = sc.nextLine();
				list.addTask(new Task(id, name, status));
				System.out.println("Task Added Successfully");
				break;
			case 2:
				System.out.print("Enter Task ID to Search: ");
				id = sc.nextInt();
				list.searchTask(id);
				break;
			case 3:
				System.out.println("Task List:");
				list.traverseTasks();
				break;
			case 4:
				System.out.print("Enter Task ID to Delete: ");
				id = sc.nextInt();
				list.deleteTask(id);
				break;
			case 5:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid Choice");
			}
		} while (choice != 5);
	}
}
