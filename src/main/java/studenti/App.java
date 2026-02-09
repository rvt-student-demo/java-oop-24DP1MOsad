package studenti;


public class App {
    public static void main(String[] args) {
        Regex r = new Regex();
        System.out.println(r.checkWord("j"));
        System.out.println(r.checkWord("jjjjj"));
        System.out.println(r.checkWord("jjj5"));
        System.out.println(r.checkWord("j_jj"));
    }
}
