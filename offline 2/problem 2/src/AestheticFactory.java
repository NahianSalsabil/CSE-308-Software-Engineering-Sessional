public class AestheticFactory extends AbstractFactory {
    @Override
    public Parser getParser(String filetype) {
        return null;
    }

    public Aesthetics getAesthetics(String aesthetictype){
        if(aesthetictype == null)
            return null;
        else if(aesthetictype == "font")
            return new Font();
        else if(aesthetictype.equalsIgnoreCase("style"))
            return new Style();
        else if(aesthetictype.equalsIgnoreCase("color"))
            return new Color();
        return null;
    }
}
