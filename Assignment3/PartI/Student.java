public class Student {
	private static int nextId;
	private int id;
	private String name;
	private int age;
	private String major;

	public Student() {
		this.id = nextId;
		id++;
	}

	public Student(String name, int age, String major) {
		this();
		this.name = name;
		this.age = age;
		this.major = major;
	}

	public static boolean hasSameMajor(Student s1, Student s2) {
		return (s1.major.equals(s2.major));
	}

	public static double avgAge(Student[] students) {
		double sum = 0;
		for (Student s : students) {
			sum += s.getAge();
		}
		return sum / students.length;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getMajor() {
		return this.major;
	}
	public void setMajor(String major) {
		this.major = major;
	}

	public int getId() {
		return this.id;
	}


	public String toString() {
		String stringAge = String.valueOf(this.age);
		return (this.name + ": " + stringAge + ", " + this.major);
	}


	public static void main(String[] args) {
		
		Student[] students = new Student[5];
		students[0] = new Student("John", 20, "English");
		students[1] = new Student("Robert", 22, "Physics");
		
	}
}
