package tictactoe2;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.event.ActionEvent;

public class MiniGame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String[][] board = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
	private static String currentPlayer = "X";
    private static MiniGame mg;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */

	private static  boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == " ";
    }

    private static void makeMove(int row, int col) {
        board[row][col] = currentPlayer;
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == "X") ? "O" : "X";
    }

    private static boolean checkWin() {
        // Check rows, columns, and diagonals for a win
        return checkRows() || checkColumns() || checkDiagonals();
    }


    private static boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    private static  boolean checkDiagonals() {
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
               (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }
    
    private static void ProcessGame(int row, int col) {
        if (isValidMove(row, col)) {
            makeMove(row, col);
            if (checkWin()) {
                JOptionPane.showOptionDialog(
                        null,
                        "Player " + currentPlayer + " wins!",
                        "Message",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        new Object[]{"OK"},
                        "OK"
                );
                MainGame.current = currentPlayer;
                mg.dispose();
            } else if (isBoardFull()) {
                MainGame.current = "";
                JOptionPane.showOptionDialog(
                        null,
                        "It's a draw!",
                        "Message",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        new Object[]{"OK"},
                        "OK"
                );
                resetBoard();  // Reset the board for a new round
            } else {
                switchPlayer();
            }
        }
    }
    private static void resetBoard() {
        // Reset the board array to its initial state
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = " ";
            }
        }

        // Reset the current player to "X"
        currentPlayer = "X";

        // Enable all buttons and clear their text
        enableAllButtons();
    }

    private static void enableAllButtons() {
        Component[] components = mg.getContentPane().getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                button.setEnabled(true);
                button.setText("");
            }
        }
    }
    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == " ") {
                    return false;
                }
            }
        }
        return true;
    }
    
	/**
	 * Create the frame.
	 */
	public MiniGame() {
		MiniGame.board = new String[][]{{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
		MiniGame.mg=this;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 411, 441);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_mini1 = new JButton("");
		btn_mini1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_mini1.setText(currentPlayer);
				btn_mini1.setEnabled(false);
				ProcessGame(0,0);
			}
		});
		
		btn_mini1.setBounds(43, 41, 96, 101);
		contentPane.add(btn_mini1);
		
		JButton btn_mini2 = new JButton("");
		btn_mini2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btn_mini2.setText(currentPlayer);
				btn_mini2.setEnabled(false);
				ProcessGame(0,1);
			}
		});
		
		btn_mini2.setBounds(149, 41, 96, 101);
		contentPane.add(btn_mini2);
		
		JButton btn_mini3 = new JButton("");
		btn_mini3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_mini3.setText(currentPlayer);
				btn_mini3.setEnabled(false);
				ProcessGame(0,2);
			}
		});
		
		btn_mini3.setBounds(255, 41, 96, 101);
		contentPane.add(btn_mini3);
		
		JButton btn_mini4 = new JButton("");
		btn_mini4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btn_mini4.setText(currentPlayer);
				btn_mini4.setEnabled(false);
				ProcessGame(1,0);
			}
		});
		btn_mini4.setBounds(43, 152, 96, 101);
		contentPane.add(btn_mini4);
		
		JButton btn_mini5 = new JButton("");
		btn_mini5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_mini5.setText(currentPlayer);
				btn_mini5.setEnabled(false);
				ProcessGame(1,1);
			}
		});
		btn_mini5.setBounds(149, 152, 96, 101);
		contentPane.add(btn_mini5);
		
		JButton btn_mini6 = new JButton("");
		btn_mini6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_mini6.setText(currentPlayer);
				btn_mini6.setEnabled(false);
				ProcessGame(1,2);
			}
		});
		btn_mini6.setBounds(255, 152, 96, 101);
		contentPane.add(btn_mini6);
		
		JButton btn_mini7 = new JButton("");
		btn_mini7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btn_mini7.setText(currentPlayer);
				btn_mini7.setEnabled(false);
				ProcessGame(2,0);
			}
		});
		btn_mini7.setBounds(43, 263, 96, 101);
		contentPane.add(btn_mini7);
		
		JButton btn_mini8 = new JButton("");
		btn_mini8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_mini8.setText(currentPlayer);
				btn_mini8.setEnabled(false);
				ProcessGame(2,1);
			}
		});
		btn_mini8.setBounds(149, 263, 96, 101);
		contentPane.add(btn_mini8);
		
		JButton btn_mini9 = new JButton("");
		btn_mini9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btn_mini9.setText(currentPlayer);
				btn_mini9.setEnabled(false);
				ProcessGame(2,2);
			}
		});
		btn_mini9.setBounds(255, 263, 96, 101);
		contentPane.add(btn_mini9);
	}
}
