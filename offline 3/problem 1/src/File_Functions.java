import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class File_Functions {
    File file;
    public File_Functions(File file){
        this.file = file;
    }
    public void calculateIntSum(File converted_file){
        String content = "";
        int sum = 0;
        try{
            Scanner scanner = new Scanner(converted_file);
            content = scanner.nextLine();
            String[] strcharacter = content.split(" ");

            ArrayList<Integer> asciis = new ArrayList<Integer>();
            for (int i = 0; i < strcharacter.length; i++) {
                asciis.add(i, Integer.parseInt(strcharacter[i]));
                System.out.println(asciis.get(i));
                sum += asciis.get(i);
            }
            System.out.println("Sum is: " + sum);
        }
        catch (FileNotFoundException e){
            System.out.println(e);
        }
    }
}
