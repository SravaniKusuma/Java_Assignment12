package question12;

public class Student
{
    int id;
    String name;
    int age;
    String engDepartment;
    int yearOfEnrollment;
    double perTillDate;
    String gender;
    public Student(int id, String name, int age,String gender,String engDepartment, int yearOfEnrollment,double perTillDate){
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.engDepartment = engDepartment;
        this.yearOfEnrollment = yearOfEnrollment;
        this.perTillDate = perTillDate;
    }
    
    public int getYearOfEnrollment()
    {
        return yearOfEnrollment;
    }

    public String getEngDepartment() 
    {
        return this.engDepartment;
    }
    public double getPerTillDate()
    {
        return perTillDate;
    }

    public String getName() 
    {
        return name;
    }
    public String getGender()
    {
        return gender;
    }
    public int getId()
    {
        return id;
    }
    public int getAge() 
    {
        return age;
    }
    
}