package studenti;

public class Regex {
    public boolean checkWord(String word) {
        return word.matches("^[a-zA-Z]{3,}$");
    }

    public boolean checkEmail(String email) {
        return email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }

    public boolean checkPersonCode(String code) {
        return code.matches("^\\d{6}-\\d{5}$");
    }
}
