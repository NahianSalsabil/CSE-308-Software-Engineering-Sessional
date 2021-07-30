public class Font implements Aesthetics{
    public String getFontName(String filetype){
        if(filetype == null)
            return null;
        else if(filetype.equalsIgnoreCase("c"))
            return "Courier New";
        else if(filetype.equalsIgnoreCase("cpp"))
            return "Monaco";
        else if(filetype.equalsIgnoreCase("py"))
            return "Consolas";
        return null;
    }

    @Override
    public String getColor() {
        return null;
    }

    @Override
    public String getStyle() {
        return null;
    }

}
