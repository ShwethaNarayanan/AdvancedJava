package patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee implements Comparable<Employee> {

	private int id;
	private String name;
	private int age;
	private double salary;

	protected Employee(int id, String name, int age, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public int compareTo(Employee o) {
		return this.name.compareTo(o.name);
	}

}

class AgeComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getAge() - e2.getAge();
	}

}

class SalaryComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee e1, Employee e2) {
		if (e1.getSalary() - e2.getSalary() > 0) {
			return 1;
		} else if (e1.getSalary() - e2.getSalary() < 0) {
			return -1;
		} else {
			return 0;
		}
	}
}
	class NameComparator implements Comparator<Employee> {
		@Override
		public int compare(Employee e1, Employee e2) {
			if (e1.getName().compareTo(e2.getName()) > 0) {
				return 1;
			} else if (e1.getName().compareTo(e2.getName()) < 0) {
				return -1;
			} else {
				return 0;
			}
		}

	}

public class ComparatorvsComparable {	
	public static void main(String[] args) {		
		Employee e1 = new Employee(1, "Abhi", 21, 20000); 
		Employee e2 = new Employee(2, "Sam", 23, 30000); 
		Employee e3 = new Employee(3, "Nina", 21, 40000); 
		Employee e4 = new Employee(4, "Rick", 20, 20000); 
		Employee e5 = new Employee(5, "Sonu", 21, 30000); 
		
//		List<Employee> emplist = Arrays.asList(e1, e2, e3, e4, e5);
		List<Employee> emplist = new ArrayList<>();
		emplist.add(e1);
		emplist.add(e2);
		emplist.add(e3);
		emplist.add(e4);
		emplist.add(e5);
		
		if(e1.compareTo(e5) > 0) {
			System.out.println("Employee :" + e1.getName() + "is greater than e2");
		}else if (e1.compareTo(e5) < 0){
			System.out.println("Employee :" + e1.getName() + "is less than e2");
		}else {
			System.out.println("Employee" + e1.getName() + "are of the same age");
		}
		//Default implementation in the Comparable interface
		Collections.sort(emplist);
		
		System.out.println(emplist);
		//Age
		Collections.sort(emplist, new AgeComparator());
		System.out.println(emplist);
		//Salary
		Collections.sort(emplist, new SalaryComparator());
		System.out.println(emplist);
		//Name
		Collections.sort(emplist, new NameComparator());
		
		//Grouping by - Results in a Map (key, List ) / (key, count)
		Map<Integer, List<Employee>> map = emplist.stream()
												 .collect(Collectors.groupingBy(Employee::getAge));
		map.forEach((age, list) -> {
			System.out.println(age);
			list.forEach(System.out::println);
					});
		
		Map<Integer, Long> count = emplist.stream()
										.collect(Collectors.groupingBy(Employee::getAge, Collectors.counting()));
	    System.out.println(count);
	    
	    
	    
	    // Group and list by salary
	    Map<Double, List<Employee>> sallist = emplist.stream()
	    		.collect(Collectors.groupingBy(Employee::getSalary));
	    sallist.forEach((salary, list) ->{
	    	System.out.println(salary);
	    	list.forEach(System.out::println);
	    });
	    
	    Map<Double, Long> count2 = emplist.stream()
		.								collect(Collectors.groupingBy(Employee::getSalary, Collectors.counting()));
	    System.out.println(count2);
		
	}
}

		

