import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void main(String[] args) {
        Person testPerson1, testPerson2, testPerson3, testPerson4;
        ArrayList<Person> personArrayList = new ArrayList<>();

        testPerson1 = new Person("Veer Singh", LocalDate.of(1972, Month.AUGUST, 5), Person.Sex.MALE, "veer123@gmail.com");
        testPerson2 = new Person("Zaara Khan", LocalDate.of(1982, Month.MARCH, 10), Person.Sex.FEMALE, "zaara123@gmail.com");
        testPerson3 = new Person("Rahul Khanna", LocalDate.of(1976, Month.NOVEMBER, 14), Person.Sex.MALE, "rahulr123@gmail.com");
        testPerson4 = new Person("Anjali Sharma", LocalDate.of(1992, Month.JANUARY, 23), Person.Sex.FEMALE, "anjali123@gmail.com");
        personArrayList.add(testPerson1);
        personArrayList.add(testPerson2);
        personArrayList.add(testPerson3);
        personArrayList.add(testPerson4);


        //example of local class
        class checkForOver18 implements CheckPerson {
            @Override //function implenting from interface
            public Boolean test(Person person) {
                return person.getAge() >= 18;
            }
        }
        printPersons(personArrayList, new checkForOver18());

        //example of anonymous class
        printPersons(personArrayList, new CheckPerson() {
            @Override
            public Boolean test(Person person) {
                return person.getAge() >= 18;
            }
        });

        printPersons(personArrayList, person -> person.getAge() >= 45);
    }
}
