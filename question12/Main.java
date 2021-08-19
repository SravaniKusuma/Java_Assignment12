package question12;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;


public class Main
{
    public static void main(String[] args)
    {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(111, "Jiya Brein", 17, "Female", "Computer Science", 2018, 70.8));
        studentList.add(new Student(122, "Paul Niksui", 18, "Male", "Mechanical", 2016, 50.2));
        studentList.add(new Student(133, "Martin Theron", 17, "Male", "Electronic", 2017, 90.3));
        studentList.add(new Student(144, "Murali Gowda", 18, "Male", "Electrical", 2018, 80));
        studentList.add(new Student(155, "Nima Roy", 19, "Female", "Textile", 2016, 70));
        studentList.add(new Student(166, "Iqbal Hussain", 18, "Male", "Security", 2016, 70));
        studentList.add(new Student(177, "Manu Sharma", 16, "Male", "Chemical", 2018, 70));
        studentList.add(new Student(188, "Wang Liu", 20, "Male", "Computer Science", 2015, 80));
        studentList.add(new Student(199, "Amelia Zoe", 18, "Female", "Computer Science", 2016, 85));
        studentList.add(new Student(200, "Jaden Dough", 18, "Male", "Security", 2015, 82));
        studentList.add(new Student(211, "Jasna Kaur", 20, "Female", "Electronic", 2019, 83));
        studentList.add(new Student(222, "Nitin Joshi", 19, "Male", "Textile", 2016, 60.4));
        studentList.add(new Student(233, "Jyothi Reddy", 16, "Female", "Computer Science", 2015, 45.6));
        studentList.add(new Student(244, "Nicolus Den", 16, "Male", "Electronic", 2017, 95.8));
        studentList.add(new Student(255, "Ali Baig", 17, "Male", "Electronic", 2018, 88.4));
        studentList.add(new Student(266, "Sanvi Pandey", 17, "Female", "Electric", 2019, 72.4));
        studentList.add(new Student(277, "Anuj Chettiar", 18, "Male", "Computer Science", 2017, 57.5));

        Stream<Student> stream = studentList.stream();

        // print all the departments 
        System.out.println("Printing the departments of students");
        stream.map(d -> d.getEngDepartment()).distinct().forEach(System.out::println);

        // print the  names of students  who enrolled after 2018
        Stream<Student> stream2 = studentList.stream();
        System.out.println("Printing names of students who enrolled after 2018");
        stream2.filter(d -> d.getYearOfEnrollment() > 2018).forEach(d -> System.out.println(d.getName()));

        //print the names of all male students in computer science
        Stream<Student> stream3 = studentList.stream();
        System.out.println("Printing names of all male students in computer science");
        stream3.filter(d -> d.getGender() == "Male" && d.getEngDepartment() == "Computer Science").forEach(d -> System.out.println("Name : " + d.getName() + "\nAge : " + d.getAge() + "\nYear of enrollment : " + d.getYearOfEnrollment() + "\nPer till date : " + d.getPerTillDate()));


        // print the number of students in each gender
        studentList.stream().collect(Collectors.groupingBy(Student::getGender)).forEach((s, students) -> System.out.println(s + " Count: " + students.size()));

        //print the average age of students
        System.out.println("Average Age:" + studentList.stream().collect(Collectors.averagingInt(Student::getAge)));

        // print the student with maximum percentage
        System.out.println("Student with max percentage:" + studentList.stream().max(Comparator.comparingDouble(Student::getPerTillDate)));

        // print the count of students in each department
        studentList.stream().collect(Collectors.groupingBy(Student::getEngDepartment)).forEach((s, students) -> System.out.println(s + " Dept Count: " + students.size()));

        //print the average percentage in each department
        studentList.stream().collect(Collectors.groupingBy(Student::getEngDepartment, Collectors.averagingDouble(Student::getPerTillDate))).forEach((s, aDouble) -> System.out.println(s + " Dept average: " + aDouble));

        //print the youngest male student in electronics
        System.out.println("Youngest in Electronics:" + studentList.stream().filter(student -> student.getEngDepartment().equals("Electronic")).collect(Collectors.minBy(Comparator.comparingInt(Student::getAge))));

        //print the number of male and female students in computer science department
        studentList.stream().filter(student -> student.getEngDepartment().equals("Computer Science")).collect(Collectors.groupingBy(Student::getGender)).forEach((s, students) -> System.out.println("Computer Science " + s + " count:" + students.size()));
    }
}
