import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileAdapter implements ParseFile{
    File_Functions fileFunctions;
    public FileAdapter(File file, String filetype){
        fileFunctions = new File_Functions(file);
    }

    public File convertToIntFile(File file)  {
        String content = "";
        File converted_file = new File("converted_file.txt");;
        try {
            Scanner scanner = new Scanner(file);
            content = scanner.nextLine();
            String[] strcharacter = content.split(" ");

            ArrayList<Integer> asciis = new ArrayList<Integer>();

            for (int i = 0; i < strcharacter.length; i++) {
                asciis.add(i, (int) strcharacter[i].charAt(0));
            }

            FileWriter myWriter = new FileWriter(converted_file);
            for (int i = 0; i < asciis.size(); i++){
                myWriter.write(String.valueOf(asciis.get(i)));
                myWriter.write(" ");
            }
            myWriter.close();
        }
        catch (FileNotFoundException e){
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return converted_file;
    }

    @Override
    public void calculateSum(File converted_file, String filetype) {
        fileFunctions.calculateIntSum(converted_file);
    }
}
