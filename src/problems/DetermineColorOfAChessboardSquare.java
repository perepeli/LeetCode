package problems;

public class DetermineColorOfAChessboardSquare {
    public boolean squareIsWhite(String coordinates) {
        char column = coordinates.charAt(0);
        int row = coordinates.charAt(1) - '0';
        int columnIdx = column - 'a' + 1;
        return (columnIdx + row) % 2 != 0;
    }
}
