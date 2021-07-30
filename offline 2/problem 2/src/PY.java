public class PY implements Parser{
    private final String parser;

    public PY(){
        parser = ".py";
    }
    @Override
    public String getParserName() {
        return parser;
    }
}
