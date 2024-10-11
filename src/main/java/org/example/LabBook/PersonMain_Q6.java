package org.example.LabBook;
/*Q3
Create default and parameterized constructor for Person class.
Also Create “PersonMain.java” program and write code for following operations:
Create an object of Person class and specify person details through constructor.
Display the details in the format given in Lab assignment 1.4
*/

public class PersonMain_Q6 {


    private String FirstName;
    private String LastName;
    private String Gender;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    //Default constructor
    public PersonMain_Q6() {

    }
    //Parametrized constructor
    public PersonMain_Q6(String firstName, String lastName, String gender) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Gender = gender;
    }

    public static void main(String[] args) {
        PersonMain_Q6 p1 = new PersonMain_Q6();
        p1.setFirstName("Imam");
        p1.setLastName("Hussain");
        p1.setGender("Male");
        System.out.println("FirstName :"+p1.getFirstName());
        System.out.println("LastName :"+p1.getLastName());
        System.out.println("Gender :"+p1.getGender());


    }


}
