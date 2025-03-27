public class Game {
    private int guesses;
    private Board board;
    public Game() {
        board = BoardHelper.createEmptyBoard();
    }

    public void start() {
        System.out.println("Welcome to Palabrale!");
    }
}
