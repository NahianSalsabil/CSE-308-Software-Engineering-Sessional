import java.io.File;

public class File_Selection implements ParseFile{
    FileAdapter fileadapter;

    public void calculateSum(File file, String filetype){
        fileadapter = new FileAdapter(file,filetype);
        if(filetype.equalsIgnoreCase("int")){
            fileadapter.calculateSum(file,filetype);
        }
        else if(filetype.equalsIgnoreCase("char")){
            File converted_file;
            converted_file = fileadapter.convertToIntFile(file);
            fileadapter.calculateSum(converted_file,filetype);
        }

    }

}
