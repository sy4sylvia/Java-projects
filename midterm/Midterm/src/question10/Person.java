package question10;

public class Person {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public static Person changePerson(Object o) {
        Person p = (Person)o;
        p.age = 25;
        return p;
    }

    public static void main(String[] args) {
        Person p1 = new Person(22, "John");
        Person p2 = changePerson(p1);

        System.out.println("p1.age = "  + p1.age);
        System.out.println("p2.age = " + p2.age);
    }

}
