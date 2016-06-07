import java.util.Scanner;

/**
 * Created by ivantrofimov on 06.06.16.
 */
public class PubicsCube {
    //Original cub
    private char cub[][] =
            {
                    {' ', ' ', ' ', 'G', 'G', 'G', ' ', ' ', ' '},
                    {' ', ' ', ' ', 'G', 'G', 'G', ' ', ' ', ' '},
                    {' ', ' ', ' ', 'G', 'G', 'G', ' ', ' ', ' '},
                    {'R', 'R', 'R', 'W', 'W', 'W', 'O', 'O', 'O'},
                    {'R', 'R', 'R', 'W', 'W', 'W', 'O', 'O', 'O'},
                    {'R', 'R', 'R', 'W', 'W', 'W', 'O', 'O', 'O'},
                    {' ', ' ', ' ', 'B', 'B', 'B', ' ', ' ', ' '},
                    {' ', ' ', ' ', 'B', 'B', 'B', ' ', ' ', ' '},
                    {' ', ' ', ' ', 'B', 'B', 'B', ' ', ' ', ' '},
                    {' ', ' ', ' ', 'Y', 'Y', 'Y', ' ', ' ', ' '},
                    {' ', ' ', ' ', 'Y', 'Y', 'Y', ' ', ' ', ' '},
                    {' ', ' ', ' ', 'Y', 'Y', 'Y', ' ', ' ', ' '},
            };

    //circular turn
    private void circularTurn(int x, int y) {
        char newLine[] = new char[12];
        newLine[0] = cub[x + 2][y + 0];
        newLine[1] = cub[x + 1][y + 0];
        newLine[2] = cub[x + 0][y + 0];
        newLine[3] = cub[x + 0][y + 1];
        newLine[4] = cub[x + 0][y + 2];
        newLine[5] = cub[x + 1][y + 2];
        newLine[6] = cub[x + 2][y + 2];
        newLine[7] = cub[x + 2][y + 1];
        cub[x + 0][y + 0] = newLine[0];
        cub[x + 0][y + 1] = newLine[1];
        cub[x + 0][y + 2] = newLine[2];
        cub[x + 1][y + 2] = newLine[3];
        cub[x + 2][y + 2] = newLine[4];
        cub[x + 2][y + 1] = newLine[5];
        cub[x + 2][y + 0] = newLine[6];
         cub[x + 1][y + 0] = newLine[7];
    }

    public void makeMove() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int cur = 0;       //current step
        int k;             //amount of route
        char a;            //current symbol
        char newLine[] = new char[12]; //used for turn
        while (cur < str.length()) {
            k = 1;      // default amount of route
            boolean t = false;
            a = str.charAt(cur);
            if (cur + 1 < str.length()) {
                if (str.charAt(cur + 1) == '\'') {
                    k = 3; //changed on 3-route
                    t = true;
                }
                if (str.charAt(cur + 1) == '2') {
                    k = 2;
                    t = true;
                }
            }
            for (int p = 0; p < k; p++) { //repeat route
                switch (a) {
                    case 'R':
                        for (int i = 0; i < 12; i++) newLine[i] = cub[(i + 3) % 12][5];
                        for (int i = 0; i < 12; i++) cub[i][5] = newLine[i];
                        circularTurn(3, 6);
                        break;
                    case 'L':
                        for (int i = 0; i < 12; i++) newLine[i] = cub[(i + 9) % 12][3];
                        for (int i = 0; i < 12; i++) cub[i][3] = newLine[i];
                        circularTurn(3, 0);
                        break;
                    case 'F':
                        for (int i = 0; i < 9; i++) newLine[i] = cub[5][i];
                        for (int i = 9; i < 12; i++) newLine[i] = cub[9][14 - i];
                        for (int i = 0; i < 9; i++) cub[5][i] = newLine[(i + 9) % 12];
                        for (int i = 9; i < 12; i++) cub[9][14 - i] = newLine[(i + 9) % 12];
                        circularTurn(6, 3);
                        break;
                    case 'B':
                        for (int i = 0; i < 9; i++) newLine[i] = cub[3][i];
                        for (int i = 9; i < 12; i++) newLine[i] = cub[11][14 - i];
                        for (int i = 0; i < 9; i++) cub[3][i] = newLine[(i + 3) % 12];
                        for (int i = 9; i < 12; i++) cub[11][14 - i] = newLine[(i + 3) % 12];
                        circularTurn(0, 3);
                        break;
                    case 'U':
                        //Не успел доделать общий случай для случайных поворотов
                        newLine[0] = cub[5][2];
                        newLine[1] = cub[4][2];
                        newLine[2] = cub[3][2];
                        newLine[3] = cub[2][3];
                        newLine[4] = cub[2][4];
                        newLine[5] = cub[2][5];
                        newLine[6] = cub[3][6];
                        newLine[7] = cub[4][6];
                        newLine[8] = cub[5][6];
                        newLine[9] = cub[6][5];
                        newLine[10] = cub[6][4];
                        newLine[11] = cub[6][3];
                        cub[5][2] = newLine[9];
                        cub[4][2] = newLine[10];
                        cub[3][2] = newLine[11];
                        cub[2][3] = newLine[0];
                        cub[2][4] = newLine[1];
                        cub[2][5] = newLine[2];
                        cub[3][6] = newLine[3];
                        cub[4][6] = newLine[4];
                        cub[5][6] = newLine[5];
                        cub[6][5] = newLine[6];
                        cub[6][4] = newLine[7];
                        cub[6][3] = newLine[8];
                        circularTurn(3, 3);
                        break;
                    case 'D':
                        newLine[0] = cub[8][3];
                        newLine[1] = cub[8][4];
                        newLine[2] = cub[8][5];
                        newLine[3] = cub[5][8];
                        newLine[4] = cub[4][8];
                        newLine[6] = cub[0][5];
                        newLine[7] = cub[0][4];
                        newLine[8] = cub[0][3];
                        newLine[9] = cub[3][0];
                        newLine[10] = cub[4][0];
                        newLine[11] = cub[5][0];
                        cub[8][3] = newLine[9];
                        cub[8][4] = newLine[10];
                        cub[8][5] = newLine[11];
                        cub[5][8] = newLine[0];
                        cub[4][8] = newLine[1];
                        cub[3][8] = newLine[2];
                        cub[0][5] = newLine[3];
                        cub[0][4] = newLine[4];
                        cub[0][3] = newLine[5];
                        cub[3][0] = newLine[6];
                        cub[4][0] = newLine[7];
                        cub[5][0] = newLine[8];
                        circularTurn(9, 3);
                        break;
                    default:
                        System.out.println("Wrong input. Try again");
                        return;
                }
            }
            cur++;
            if (t) cur++;
        }
        print();
    }

    private void print() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(cub[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PubicsCube a = new PubicsCube();
        a.makeMove();
    }
}
