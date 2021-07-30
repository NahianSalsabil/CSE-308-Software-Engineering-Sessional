public class CPP implements Parser{
    private final String parser;

    public CPP(){
        parser = ".cpp";
    }
    @Override
    public String getParserName() {
        return parser;
    }
}
