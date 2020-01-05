import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    String facultate;
    String specialitate;
    String an;

    public Student( String facultate, String specialitate, String an) {
        super(name, birthday, adres);
        this.name = name;
        this.birthday = birthday;
        this.adres = adres;
        this.facultate = facultate;
        this.specialitate = specialitate;
        this.an = an;
        System.out.println("constructor Student");
    }

    @Override
    public String toString() {
        System.out.println("toString");
        return name + " " + birthday + " " + adres + " " + facultate + " " + specialitate + " " + an + " ";
    }

}
