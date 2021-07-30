public class ParserFactory extends AbstractFactory{
    public Parser getParser(String filetype){
        if(filetype == null)
            return null;
        else if(filetype.equalsIgnoreCase("cpp"))
            return new CPP();
        else if(filetype.equalsIgnoreCase("c"))
            return new C();
        else if (filetype.equalsIgnoreCase("py"))
            return new PY();
        return null;
    }

    @Override
    public Aesthetics getAesthetics(String aesthetictype) {
        return null;
    }
}
