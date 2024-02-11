import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {
    public String getFileName(String fileName) {
        File file = new File("src/" + fileName);
        String data = "\n";
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                data = scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ik kan het bestand niet vinden!");
        }
        return data;
    }
}