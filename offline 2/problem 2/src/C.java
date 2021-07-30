public class C implements Parser{
    private final String parser;

    public C(){
        parser = ".c";
    }
    @Override
    public String getParserName() {
        return parser;
    }
}
