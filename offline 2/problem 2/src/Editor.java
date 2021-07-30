public class Editor {
    private static Editor instance = null;
    private Editor(){

    }
    public static Editor getEditor(){
        if(instance == null)
            return new Editor();
        return instance;
    }

    public ParserFactory getParserFactory(){
        return new ParserFactory();
    }
    public AestheticFactory getAestheticFactory(){
        return new AestheticFactory();
    }

}
