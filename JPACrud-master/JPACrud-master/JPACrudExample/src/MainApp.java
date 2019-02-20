import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainApp {

	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("emp");
	static EntityManager entityManager = factory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Enter Choice");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				insert();
				break;
			case 2:
				find();
				break;
			case 3:
				delete();
				break;
			case 4:
				update();
				break;
			}
		}

	}

	public static void insert()

	{
		entityTransaction.begin();
		Employee employee = new Employee();
		employee.setEmpNo(4);
		employee.setName("Jyoti");
		entityManager.persist(employee);
		entityTransaction.commit();
	}
	public static void find() {
		Employee employee = entityManager.find(Employee.class, 4);
		System.out.println("Employee Name:"+employee.getName());
		System.out.println("Employee No:"+employee.getEmpNo());
	}
	public static void delete()
	{
		entityTransaction.begin();
		Employee employee = entityManager.find(Employee.class, 4);
		entityManager.remove(employee);
		System.out.println("Deleted");
		entityTransaction.commit();	
		
		
	}
	public static void update()
	{entityTransaction.begin();
	Employee employee=entityManager.find(Employee.class, 4);
	employee.setName("Tani");
	entityManager.persist(employee);
	entityTransaction.commit();	
	}

}
