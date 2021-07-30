public class Style implements Aesthetics{
    private final String style;

    public Style(){
        style = "Normal";
    }

    @Override
    public String getFontName(String filetype) {
        return null;
    }

    @Override
    public String getColor() {
        return null;
    }

    public String getStyle(){
        return style;
    };
}
