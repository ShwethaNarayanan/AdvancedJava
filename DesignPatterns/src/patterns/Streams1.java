package patterns;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student {
	private int id;
	private String fName;
	private String lName;
	private int age;
	private String section;

	Student(int id, String fName, String lName, int age, String section) {
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.age = age;
		this.section = section;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", fName=" + fName + ", lName=" + lName + ", age=" + age + "]";
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

}

public class Streams1 {

	public static void main(String[] args) {

		Student std1 = new Student(1, "Anu", "Mohan", 20, "1A");
		Student std2 = new Student(2, "Manu", "Mohan", 20, "1A");
		Student std3 = new Student(3, "Rinu", "Mohan", 22, "2B");
		Student std4 = new Student(4, "Chinnu", "Mohan", 21, "3C");
		Student std5 = new Student(5, "Minu", "Mohan", 21, "2B");

		List<Student> listStd = Arrays.asList(std1, std2, std3, std4, std5);

		listStd.stream().filter(std -> std.getAge() >= 21).map(std -> std.getfName()).limit(4).sorted()
				.forEach(System.out::println);

		listStd.stream().limit(4).sorted(Comparator.comparing(Student::getAge)).forEach(System.out::println);

		// Count
		Map<String, List<Student>> mapList = listStd.stream()
				.collect(Collectors.groupingBy(Student::getSection, TreeMap::new, Collectors.toList()));

		mapList.forEach((dept, emplist) -> {
			System.out.println(dept);
			emplist.forEach(System.out::println);
		});

		// Group by age
		Map<Integer, List<Student>> mapListAge = listStd.stream().collect(Collectors.groupingBy(Student::getAge));

		mapListAge.forEach((age, emplist) -> {
			System.out.println(age);
			emplist.forEach(System.out::println);
		});

		Map<Integer, Long> mapA = listStd.stream()
				.collect(Collectors.groupingBy(Student::getAge, Collectors.counting()));

		mapA.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));

		Optional<Student> minAge = listStd.stream().min(Comparator.comparingInt(Student::getAge));
		System.out.println(minAge.get());

		OptionalInt ageMin = listStd.stream().mapToInt(Student::getAge).min();
		if (ageMin.isPresent())
			System.out.println(ageMin.getAsInt());
		
		Optional<Student> maxAge = listStd.stream()
			.max(Comparator.comparingDouble(Student::getAge));
		if (maxAge.isPresent())
			System.out.println(maxAge.get());
	}
}
