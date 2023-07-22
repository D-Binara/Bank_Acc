import java.io.File;
public class PrintStatment {

    void print() {

        try {
            File obj = new File("Bank_Statement.txt");
            System.out.println(obj.exists());

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
