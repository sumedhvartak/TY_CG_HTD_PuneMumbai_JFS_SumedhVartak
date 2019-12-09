package home.oct09;

public class TestEmployee {

	public static void main(String[] args) 
	{
		Employee e = new Employee();
		System.out.println(e);
		e.setName("Sumedh Vartak");
		e.setId(1);
		e.setSalary(450000);
		Employee e1 = new Employee();
		System.out.println(e1);
		Database db = new Database();
		db.receive(e);
	}

}
