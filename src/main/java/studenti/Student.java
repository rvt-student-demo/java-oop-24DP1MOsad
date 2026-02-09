package studenti;

public class Student {
    String firstName;
    String lastName;
    String email;
    String personalCode;
    String registrationDateTime;

    public Student(String firstName, String lastName, String email, String personalCode, String registrationDateTime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.personalCode = personalCode;
        this.registrationDateTime = registrationDateTime;
    }

    public String toCsv() {
        return firstName + "," +
           lastName + "," +
           email + "," +
           personalCode + "," +
           registrationDateTime;
    }

    public String getPersonalCode() {
        return personalCode;
    }
}
