package array;

/**
 * Created by liqiushi on 7/1/14.
 */
public class ValidateSoduku {
    public static void main(String[] args) {
//        char[][] board = {
//                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//        };
        char[][] board = {
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '5', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };

        System.out.print(isValidSudoku(board));
    }
//
//    [
//            "....5..1.",
//            ".4.3.....",
//            ".....3..1",
//            "8......2.",
//            "..2.7....",
//            ".15......",
//            ".....2...",
//            ".2.9.....",
//            "..4......"
//            ]

    private static boolean isValidSudoku(char[][] board) {
        int square_row = 0, square_column = 0;
        for (int i = 0; i < 9; i++) {
            // row, column
            int row = 1, column = 1;
            for (int j = 0; j < 9; j++) {
                char c_row = board[i][j];
                if (c_row != '.') {
                    int num = Character.getNumericValue(c_row);
                    int s = row >> num & 0x1;
                    if (s == 1)
                        return false;

                    row |= 1 << num;
                }

                char c_column = board[j][i];
                if (c_column != '.') {
                    int num = Character.getNumericValue(c_column);
                    int s = column >> num & 0x1;
                    if (s == 1)
                        return false;

                    column |= 1 << num;
                }
            }

            // square
            int square = 1;
            for (int r = square_row; r <= square_row + 2; r++) {
                for (int c = square_column; c <= square_column + 2; c++) {
                    char c_square = board[r][c];
                    if (c_square != '.') {
                        int num = Character.getNumericValue(c_square);
                        int s = square >> num & 0x1;
                        if (s == 1)
                            return false;

                        square |= 1 << num;
                    }
                }
            }

            // i在这里是次数
            if ((i + 1) % 3 == 0) {
                square_row += 3;
                square_column = 0;
            } else {
                square_column += 3;
            }
        }
        return true;
    }
}
