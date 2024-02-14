package tictactoe2;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String[][] board = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
	private JPanel contentPane;
	public static String current="";
	private static boolean isOver = false;

	private static  boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == " ";
    }

    private static void makeMove(int row, int col) {
        board[row][col] = current;
    }

    private static boolean checkWin() {
        // Check rows, columns, and diagonals for a win
        return checkRows() || checkColumns() || checkDiagonals();
    }


    private static boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == current && board[i][1] == current && board[i][2] == current) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == current && board[1][i] == current && board[2][i] == current) {
                return true;
            }
        }
        return false;
    }

    private static  boolean checkDiagonals() {
        return (board[0][0] == current && board[1][1] == current && board[2][2] == current) ||
               (board[0][2] == current && board[1][1] == current && board[2][0] == current);
    }
    
    private static void ProcessGame(int row, int col) {
    	 if (isValidMove(row, col)) {
             makeMove(row, col);
             if (checkWin()) {
            	 JOptionPane.showOptionDialog(
                         null,
                         "Player " + current + " wins!",
                         "Message",
                         JOptionPane.DEFAULT_OPTION,
                         JOptionPane.INFORMATION_MESSAGE,
                         null,
                         new Object[]{"OK"},
                         "OK"
                 );         	 
             } else if (isBoardFull()) {
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
             } else {
            	 MainGame mainGameFrame = new MainGame();
	                mainGameFrame.setVisible(true);

	                MiniGame miniGameFrame = new MiniGame();
	                miniGameFrame.setVisible(true);

	                // Disable the MainGame frame while MiniGame is visible
	                mainGameFrame.setEnabled(false);

	                // Add a window listener to re-enable MainGame when MiniGame is closed
	                miniGameFrame.addWindowListener(new WindowAdapter() {
	                    @Override
	                    public void windowClosed(WindowEvent e) {
	                        mainGameFrame.setEnabled(true);
	                        JOptionPane.showOptionDialog(
	                                null,
	                                current + " must select!",
	                                "Message",
	                                JOptionPane.DEFAULT_OPTION,
	                                JOptionPane.INFORMATION_MESSAGE,
	                                null,
	                                new Object[]{"OK"},
	                                "OK"
	                        );
	                    }
	                });
             }
         } else {
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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
						MainGame mainGameFrame = new MainGame();
		                mainGameFrame.setVisible(true);
		                
		                MiniGame miniGameFrame = new MiniGame();
		                miniGameFrame.setVisible(true);

		                // Disable the MainGame frame while MiniGame is visible
		                mainGameFrame.setEnabled(false);

		                // Add a window listener to re-enable MainGame when MiniGame is closed
		                miniGameFrame.addWindowListener(new WindowAdapter() {
		                    @Override
		                    public void windowClosed(WindowEvent e) {
		                        mainGameFrame.setEnabled(true);
		                        JOptionPane.showOptionDialog(
		                                null,
		                                current + " must select!",
		                                "Message",
		                                JOptionPane.DEFAULT_OPTION,
		                                JOptionPane.INFORMATION_MESSAGE,
		                                null,
		                                new Object[]{"OK"},
		                                "OK"
		                        );
		                    }
		                });
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 638);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_maingame1 = new JButton("");
		btn_maingame1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btn_maingame1.setText(current);
				btn_maingame1.setEnabled(false);
				ProcessGame(0,0);
			}
		});
		btn_maingame1.setBounds(61, 56, 155, 155);
		contentPane.add(btn_maingame1);
		
		JButton btn_maingame2 = new JButton("");
		btn_maingame2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btn_maingame2.setText(current);
				btn_maingame2.setEnabled(false);
				ProcessGame(0,1);
			}
		});
		btn_maingame2.setBounds(226, 56, 155, 155);
		contentPane.add(btn_maingame2);
		
		JButton btn_maingame3 = new JButton("");
		btn_maingame3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btn_maingame3.setText(current);
				btn_maingame3.setEnabled(false);
				ProcessGame(0,2);
				
			}
		});
		btn_maingame3.setBounds(391, 56, 155, 155);
		contentPane.add(btn_maingame3);
		
		JButton btn_maingame4 = new JButton("");
		btn_maingame4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btn_maingame4.setText(current);
				btn_maingame4.setEnabled(false);
				ProcessGame(1,0);
				
			}
		});
		btn_maingame4.setBounds(61, 221, 155, 155);
		contentPane.add(btn_maingame4);
		
		JButton btn_maingame5 = new JButton("");
		btn_maingame5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btn_maingame5.setText(current);
				btn_maingame5.setEnabled(false);
				ProcessGame(1,1);
				
			}
		});
		btn_maingame5.setBounds(226, 221, 155, 155);
		contentPane.add(btn_maingame5);
		
		JButton btn_maingame6 = new JButton("");
		btn_maingame6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btn_maingame6.setText(current);
				btn_maingame6.setEnabled(false);
				ProcessGame(1,2);
				
			}
		});
		btn_maingame6.setBounds(391, 221, 155, 155);
		contentPane.add(btn_maingame6);
		
		JButton btn_maingame7 = new JButton("");
		btn_maingame7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btn_maingame7.setText(current);
				btn_maingame7.setEnabled(false);
				ProcessGame(2,0);
				
			}
		});
		btn_maingame7.setBounds(61, 386, 155, 155);
		contentPane.add(btn_maingame7);
		
		JButton btn_maingame8 = new JButton("");
		btn_maingame8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btn_maingame8.setText(current);
				btn_maingame8.setEnabled(false);
				ProcessGame(2,1);
				
			}
		});
		btn_maingame8.setBounds(226, 386, 155, 155);
		contentPane.add(btn_maingame8);
		
		JButton btn_maingame9 = new JButton("");
		btn_maingame9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btn_maingame9.setText(current);
				btn_maingame9.setEnabled(false);
				ProcessGame(2,2);
				
			}
		});
		btn_maingame9.setBounds(391, 386, 155, 155);
		contentPane.add(btn_maingame9);		
		
	}

}
