abstract class AbstractFactory {
    abstract public Parser getParser(String filetype);
    abstract public Aesthetics getAesthetics(String aesthetictype);
}
