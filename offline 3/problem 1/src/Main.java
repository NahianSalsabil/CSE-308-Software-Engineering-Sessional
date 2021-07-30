import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file = new File("src/sample/input.txt");
        String filetype = scanner.nextLine();
        File_Selection file_selection = new File_Selection();
        file_selection.calculateSum(file, filetype);
    }
}
