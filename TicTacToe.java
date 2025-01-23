import java.util.*;

public class TicTacToe {
    static char[] board;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("'X' is your key and 'O' is computer's key in case you play against the computer.\n");

        int computerScore = 0;
        int player1Score = 0;
        int player2Score = 0;
        int playerScore = 0;
        int matchTie = 0;
        char choice = 'y';

        while (choice == 'y' || choice == 'Y') {
            System.out.println("Enter 1 to play against another player");
            System.out.println("Enter 2 to play against the computer");
            System.out.print("Enter your choice: ");
            int option = sc.nextInt();
            System.out.println();

            if (option == 2) {
                createBoard();
                while (true) {
                    displayBoard();
                    if (!isFull()) {
                        if (!isWon('X') && !isWon('O')) {
                            playerMove('X', 1);
                            if (!isWon('X') && !isFull()) {
                                computerMove('O');
                            } else if (isWon('X')) {
                                playerScore++;
                                System.out.println("You Won... Diddy");
                                break;
                            } else {
                                matchTie++;
                                System.out.println("Match Tie!");
                                break;
                            }
                        } else {
                            computerScore++;
                            System.out.println("Computer Won... Try Hard!");
                            break;
                        }
                    } else {
                        matchTie++;
                        System.out.println("Match Tie!");
                        break;
                    }
                }
            } else if (option == 1) {
                createBoard();
                while (true) {
                    displayBoard();
                    if (!isFull()) {
                        if (!isWon('X') && !isWon('O')) {
                            playerMove('X', 1);
                            if (!isWon('X') && !isFull()) {
                                displayBoard();
                                playerMove('O', 2);
                            } else if (isWon('X')) {
                                player1Score++;
                                System.out.println("Player 1 Won... Good Job");
                                break;
                            } else {
                                matchTie++;
                                System.out.println("Match Tie!");
                                break;
                            }
                        } else {
                            player2Score++;
                            System.out.println("Player 2 Won... Good Job");
                            break;
                        }
                    } else {
                        matchTie++;
                        System.out.println("Match Tie!");
                        break;
                    }
                }
            } else {
                System.out.println("Invalid input!");
            }
            System.out.print("Want to play again (y/any key): ");
            choice = sc.next().charAt(0);
        }

        System.out.println();
        System.out.println("Final Scores are:");
        System.out.println("====================");
        System.out.println();
        System.out.println(" : Against computer : ");
        System.out.println("----------------------");

        System.out.println("Computer Score = " + computerScore + "         Your Score = " + playerScore);
        System.out.println(" : Player Against Player : ");
        System.out.println("---------------------------");
        System.out.println("Player 1 Score = " + player1Score + "        Player 2 Score = " + player2Score);
        System.out.println("--------------------");
        System.out.println("Match Tied = " + matchTie);
    }

    public static void createBoard() {
        board = new char[9];
        Arrays.fill(board, ' ');
    }

    public static void displayBoard() {
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("---------");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("---------");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
    }

    public static void playerMove(char letter, int playerNo) {
        while (true) {
            try {
                System.out.print("Player " + playerNo + " input your next move (" + letter + ") position (1-9): ");
                int position = sc.nextInt() - 1;
                if (position >= 0 && position < 9 && board[position] == ' ') {
                    board[position] = letter;
                    break;
                } else {
                    System.out.println("Position already occupied or invalid! Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 9.");
                sc.next(); // Clear invalid input
            }
        }
    }

    public static boolean isWon(char letter) {
        return (board[0] == letter && board[1] == letter && board[2] == letter) ||
                (board[3] == letter && board[4] == letter && board[5] == letter) ||
                (board[6] == letter && board[7] == letter && board[8] == letter) ||
                (board[0] == letter && board[3] == letter && board[6] == letter) ||
                (board[1] == letter && board[4] == letter && board[7] == letter) ||
                (board[2] == letter && board[5] == letter && board[8] == letter) ||
                (board[0] == letter && board[4] == letter && board[8] == letter) ||
                (board[2] == letter && board[4] == letter && board[6] == letter);
    }

    public static boolean isFull() {
        for (char c : board) {
            if (c == ' ') return false;
        }
        return true;
    }

    public static void computerMove(char letter) {
        List<Integer> vacantPlaces = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (board[i] == ' ') vacantPlaces.add(i);
        }

        for (int i : vacantPlaces) {
            board[i] = letter;
            if (isWon(letter)) {
                System.out.println("Computer's move (O) at position: " + (i + 1));
                return;
            }
            board[i] = ' ';
        }

        for (int i : vacantPlaces) {
            board[i] = 'X';
            if (isWon('X')) {
                board[i] = letter;
                System.out.println("Computer's move (O) at position: " + (i + 1));
                return;
            }
            board[i] = ' ';
        }

        int randomIndex = new Random().nextInt(vacantPlaces.size());
        int position = vacantPlaces.get(randomIndex);
        board[position] = letter;
        System.out.println("Computer's move (O) at position: " + (position + 1));
    }
}
