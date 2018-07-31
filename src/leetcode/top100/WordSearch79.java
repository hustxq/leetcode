package leetcode.top100;

/**
 * Created by qxiong on 2018/1/9.
 */
public class WordSearch79 {
    public static void main(String[] args) {
        char[][] barr = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        WordSearch79 test = new WordSearch79();
        System.out.println(test.exist(barr, "ABC"));
    }

    public boolean exist(char[][] board, String word) {
        char[] warr = word.toCharArray();
        char f = word.charAt(0);
        for (int i = 0, xlen = board.length; i < xlen; i++) {
            for (int j = 0, ylen = board[0].length; j < ylen; j++) {
                if (found(i, j, board, warr, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean found(int i, int j, char[][] board, char[] carr, int p) {
        if (carr.length == p) return true;
        if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] != carr[p]) return false;
        board[i][j] = '*';
        boolean res = found(i - 1, j, board, carr, p + 1)
                || found(i + 1, j, board, carr, p + 1)
                || found(i, j - 1, board, carr, p + 1)
                || found(i, j + 1, board, carr, p + 1);
        board[i][j] = carr[p];
        return res;
    }
}
