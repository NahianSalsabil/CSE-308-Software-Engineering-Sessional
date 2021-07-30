import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Editor editor = Editor.getEditor();
        Scanner scanner = new Scanner(System.in);
        String filename;
        while(true){
            filename = scanner.nextLine();
            String filetype = filename.split("\\.")[1];

            System.out.println("Parser: " + editor.getParserFactory().getParser(filetype).getParserName());
            System.out.println("Font: " + editor.getAestheticFactory().getAesthetics("font").getFontName(filetype));
            System.out.println("Style: " + editor.getAestheticFactory().getAesthetics("style").getStyle());
            System.out.println("Color: " + editor.getAestheticFactory().getAesthetics("color").getColor());
        }


    }
}
