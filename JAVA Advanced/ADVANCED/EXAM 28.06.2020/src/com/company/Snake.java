import java.util.Scanner;

public class Snake {
    public static boolean IF_SNAKE_WON = false;
    public static boolean IF_SNAKE_IS_OUT_OF_GAME = false;
    public static int FOOD = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsAndCows = Integer.parseInt(scanner.nextLine());
        char[][] game = new char[rowsAndCows][rowsAndCows];
        for (int row = 0; row < rowsAndCows; row++) {
            game[row] = scanner.nextLine().toCharArray();
        }

        while (!IF_SNAKE_WON && !IF_SNAKE_IS_OUT_OF_GAME) {
            String cmd = scanner.nextLine();
            switch (cmd) {
                case "up":
                    moveUp(game);
                    break;
                case "down":
                    moveDown(game);
                    break;
                case "left":
                    moveLeft(game);
                    break;
                case "right":
                    moveRight(game);
                    break;
            }
        }

        if(IF_SNAKE_IS_OUT_OF_GAME) {
            System.out.println("Game over!");
        } else if (FOOD >= 10) {
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Food eaten: " + FOOD);

        for (char[] row : game) {
            for (char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    private static int[] getSnakePosition(char[][] matrix) {
        int[] position = new int[2];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'S') {
                    position[0] = row;
                    position[1] = col;
                }
            }
        }

        return position;
    }

    private static void moveRight(char[][] game) {
        int[] position = getSnakePosition(game);
        int pos1 = position[0];
        int pos2 = position[1];

        try {

            if (game[pos1][pos2 + 1] == '*') {
                FOOD++;

                if (FOOD >= 10) {
                    IF_SNAKE_WON = true;
                }

                game[pos1][pos2] = '.';
                game[pos1][pos2 + 1] = 'S';
            } else if (game[pos1][pos2 + 1] == 'B') {

                game[pos1][pos2] = '.';
                game[pos1][pos2 + 1] = '.';

                int[] bpos = getbpos(game);
                game[bpos[0]][bpos[1]] = 'S';
            } else {
                game[pos1][pos2] = '.';
                game[pos1][pos2 + 1] = 'S';
            }

        } catch (IndexOutOfBoundsException e) {
            IF_SNAKE_IS_OUT_OF_GAME = true;
            game[pos1][pos2] = '.';
        }
    }

    private static void moveLeft(char[][] game) {
        int[] position = getSnakePosition(game);
        int pos1 = position[0];
        int pos2 = position[1];

        try {

            if (game[pos1][pos2 - 1] == '*') {
                FOOD++;

                if (FOOD >= 10) {
                    IF_SNAKE_WON = true;
                }

                game[pos1][pos2] = '.';
                game[pos1][pos2 - 1] = 'S';
            } else if (game[pos1][pos2 - 1] == 'B') {
                game[pos1][pos2] = '.';
                game[pos1][pos2 - 1] = '.';

                int[] bPosition = getbpos(game);
                game[bPosition[0]][bPosition[1]] = 'S';
            } else {
                game[pos1][pos2] = '.';
                game[pos1][pos2 - 1] = 'S';
            }


        } catch (IndexOutOfBoundsException e) {
            IF_SNAKE_IS_OUT_OF_GAME = true;
            game[pos1][pos2] = '.';
        }
    }

    private static int[] getbpos(char[][] matrix) {
        int[] bPosition = new int[2];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'B') {
                    bPosition[0] = row;
                    bPosition[1] = col;
                }
            }
        }

        return bPosition;
    }

    private static void moveDown(char[][] game) {
        int[] position = getSnakePosition(game);
        int pos1 = position[0];
        int pos2 = position[1];

        try {

            if (game[pos1 + 1][pos2] == '*') {
                FOOD++;

                if (FOOD >= 10) {
                    IF_SNAKE_WON = true;
                }

                game[pos1][pos2] = '.';
                game[pos1 + 1][pos2] = 'S';
            } else if (game[pos1 + 1][pos2] == 'B') {
                game[pos1][pos2] = '.';
                game[pos1 + 1][pos2] = '.';

                int[] bpos = getbpos(game);
                game[bpos[0]][bpos[1]] = 'S';
            } else {
                game[pos1][pos2] = '.';
                game[pos1 + 1][pos2] = 'S';
            }

        } catch (IndexOutOfBoundsException e) {
            IF_SNAKE_IS_OUT_OF_GAME = true;
            game[pos1][pos2] = '.';
        }
    }

    private static void moveUp(char[][] matrix) {
        int[] position = getSnakePosition(matrix);
        int xPosition = position[0];
        int yPosition = position[1];

        try {

            if (matrix[xPosition - 1][yPosition] == '*') {
                FOOD++;

                if (FOOD >= 10) {
                    IF_SNAKE_WON = true;
                }

                matrix[xPosition][yPosition] = '.';
                matrix[xPosition - 1][yPosition] = 'S';
            } else if (matrix[xPosition - 1][yPosition] == 'B') {
                matrix[xPosition][yPosition] = '.';
                matrix[xPosition - 1][yPosition] = '.';

                int[] bPosition = getbpos(matrix);
                matrix[bPosition[0]][bPosition[1]] = 'S';
            } else {
                matrix[xPosition][yPosition] = '.';
                matrix[xPosition - 1][yPosition] = 'S';
            }

        } catch (IndexOutOfBoundsException e) {
            IF_SNAKE_IS_OUT_OF_GAME = true;
            matrix[xPosition][yPosition] = '.';
        }
    }

}
 