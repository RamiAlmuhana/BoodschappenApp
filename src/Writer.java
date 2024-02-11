import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    public void setWriteFile(String fileName, Item groceryItem){
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.write(groceryItem.toString());
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ik kan het bestand niet vinden");
        } catch (IOException e) {
            System.out.println("Er ging iets fout bij het schrijven!");
        }
    }

}
