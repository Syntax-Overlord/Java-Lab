import java.util.Scanner;

// Main class for Tic Tac Toe CLI game
public class Main {

    public static void main(String[] args) {
        int chances = 9; // Maximum moves in Tic Tac Toe
        boolean win = false; // Flag to check if someone has won
        String turn = "X"; // Start with player X
        Scanner input = new Scanner(System.in);
        // Initial board positions
        String[][] positions = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        // Main game loop
        while (chances > 0) {
            printMatrix(positions); // Display the board
            System.out.println("\nPlayer " + turn + "'s turn.");
            positions = ask(positions, input, turn); // Get player's move
            if (checkWin(positions, turn)) { // Check for win
                printMatrix(positions);
                System.out.println("Player " + turn + " wins!");
                win = true;
                break;
            }
            // Switch turn between X and O
            turn = turn.equals("X") ? "O" : "X";
            chances--;
        }
        input.close(); // Close scanner
    }

    // Prints the current state of the board
    public static void printMatrix(String[][] matrix) {
        String Divider = "|-----|-----|-----|";
        System.out.println(Divider);
        for (String[] row : matrix) {
            System.out.println("|  " + row[0] + "  |  " + row[1] + "  |  " + row[2] + "  |");
            System.out.println(Divider);
        }
    }

    // Asks the player for their move and updates the board
    public static String[][] ask(String[][] matrix, Scanner input, String turn) {
        while (true) {
            System.out.print("Enter the position to place " + turn + ": ");
            String position = input.nextLine();
            boolean found = false;
            // Search for the chosen position
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j].equals(position)) {
                        matrix[i][j] = turn; // Place the player's mark
                        return matrix;
                    }
                }
            }
            // If position is invalid or already taken
            System.out.println("Invalid or taken position. Try again.");
            System.out.println("\n");
        }
    }

    // Checks if the current player has won
    public static boolean checkWin(String[][] matrix, String player) {
        // Check rows and columns for win
        for (int i = 0; i < 3; i++) {
            if ((matrix[i][0].equals(player) && matrix[i][1].equals(player) && matrix[i][2].equals(player)) ||
                    (matrix[0][i].equals(player) && matrix[1][i].equals(player) && matrix[2][i].equals(player))) {
                return true;
            }
        }
        // Check diagonals for win
        if ((matrix[0][0].equals(player) && matrix[1][1].equals(player) && matrix[2][2].equals(player)) ||
                (matrix[0][2].equals(player) && matrix[1][1].equals(player) && matrix[2][0].equals(player))) {
            return true;
        }
        return false; // No win found
    }
}