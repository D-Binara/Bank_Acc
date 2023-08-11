import java.io.File;
import java.io.FileWriter;
public class PrintStatment {

    void print() {

        try {
            File obj = new File("Bank_Statement.txt");
            obj.createNewFile();
            FileWriter Writer
                    = new FileWriter("Bank_Statement.txt");
            Writer.write(
                    "test");
            Writer.close();
            System.out.println(obj.exists());

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
