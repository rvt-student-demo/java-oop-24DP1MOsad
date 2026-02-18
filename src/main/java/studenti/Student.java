package studenti;

public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private String personalCode;
    private String registrationDateTime;

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

    public void editStudent(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void editFirstname(String firstname) {
        this.firstName = firstname;
    }

    public void editLastname(String lastname) {
        this.lastName = lastname;
    }

    public void editEmail(String email) {
        this.email = email;
    }
}
