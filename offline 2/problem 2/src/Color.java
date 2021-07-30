public class Color implements Aesthetics{
    private final String color;

    public Color(){
        color = "Blue";
    }

    @Override
    public String getFontName(String filetype) {
        return null;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getStyle() {
        return null;
    }
}
