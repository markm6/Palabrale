public class Letter {
    /** Letter **/
    private String c;
    /** Color ANSI string from Colors */
    private String color;
    public Letter(String c, String color) {
        this.color = color;
        this.c = c;
    }

    @Override
    public String toString() {
        return color + c + Colors.RESET;
    }

}
