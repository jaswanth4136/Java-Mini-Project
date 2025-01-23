# Tic Tac Toe Game in Java

Welcome to the **Tic Tac Toe Game**, implemented in Java. This project features both Player-vs-Player and Player-vs-Computer modes, providing an interactive and engaging way to play the classic game.

---

## Features
- **Two Modes**: 
  - Player vs Player
  - Player vs Computer (with basic AI logic)
- **Dynamic Scoring**: Keeps track of the scores for each player and the computer.
- **Easy-to-Use Interface**: Simple console-based gameplay.
- **Tie Detection**: Automatically identifies and announces ties.

---

## How to Play
### Player vs Player Mode
1. Each player takes turns to input their move (position 1-9).
2. The game board updates after each move.
3. The player who aligns three symbols (horizontally, vertically, or diagonally) wins.

### Player vs Computer Mode
1. The player always uses `X`, and the computer uses `O`.
2. The computer uses basic AI to block or complete winning moves.
3. Continue until a player wins or the game results in a tie.

---

## Rules
- Positions are numbered from 1 to 9, as shown below:
  ```
   1 | 2 | 3
  ---------
   4 | 5 | 6
  ---------
   7 | 8 | 9
  ```
- Players must select an empty position for their move.
- The game detects invalid inputs or occupied positions and prompts for re-entry.

---

## Prerequisites
- **Java Development Kit (JDK)**: Ensure JDK 8 or later is installed.
- **IDE (Optional)**: You can use IntelliJ IDEA, Eclipse, or any text editor to run the program.

---

## How to Run
1. Clone or download the repository:
   ```bash
   git clone https://github.com/your-username/tic-tac-toe-java.git
   ```
2. Navigate to the project directory:
   ```bash
   cd tic-tac-toe-java
   ```
3. Compile the program:
   ```bash
   javac TicTacToe.java
   ```
4. Run the program:
   ```bash
   java TicTacToe
   ```

---

## Project Structure
- **TicTacToe.java**: Contains the main logic and gameplay implementation.

---

## Future Enhancements
- Add a GUI for better user experience.
- Implement advanced AI using Minimax algorithm for Player vs Computer mode.
- Save game states and scores for later continuation.

---

## Contributions
Feel free to fork the repository and submit pull requests for improvements or new features. Suggestions and feedback are always welcome!

