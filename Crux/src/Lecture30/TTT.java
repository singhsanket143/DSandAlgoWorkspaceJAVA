package Lecture30;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TTT extends JFrame implements ActionListener {
	public static final int Board_Size = 3;
	boolean CrossTurn = true;

	private static enum GameStatus {
		Incomplete, XWins, ZWins, Tie,;
	}

	private JButton[][] buttons = new JButton[Board_Size][Board_Size];

	public TTT() {
		super.setTitle("Tic Tac Toe");
		super.setSize(600, 600);

		GridLayout grid = new GridLayout(Board_Size, Board_Size);
		super.setLayout(grid);
		Font font = new Font("Comic Sans", 1, 150);
		for (int row = 0; row < Board_Size; row++) {
			for (int col = 0; col < Board_Size; col++) {
				JButton button = new JButton("");
				buttons[row][col] = button;
				button.addActionListener(this);
				button.setFont(font);
				button.setBackground(Color.cyan);
				super.add(button);
			}
		}

		super.setResizable(false);
		super.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton) e.getSource();
		makemove(clickedButton);
	}

	private void makemove(JButton clickedButton) {
		String btntxt = clickedButton.getText();
		if (btntxt.length() > 0) {
			JOptionPane.showMessageDialog(this, "baap mat bann dhang se khel");
			return;
		}
		if (CrossTurn) {
			clickedButton.setText("X");
		} else {
			clickedButton.setText("O");
		}
		CrossTurn = !CrossTurn;
		GameStatus gs = this.getGameStatus();
		if (gs != GameStatus.Incomplete) {
			declareWinner(gs);

			int choice = JOptionPane.showConfirmDialog(this, "Restart");
			if (choice == JOptionPane.YES_OPTION) {
				for (int row = 0; row < Board_Size; row++) {
					for (int col = 0; col < Board_Size; col++) {
						buttons[row][col].setText("");
					}
				}
				CrossTurn = true;
			} else {
				super.dispose();
			}
		}
	}

	private GameStatus getGameStatus() {
		String text1 = "", text2 = "";
		int row = 0, col = 0;
		// test for rows
		row = 0;
		while (row < Board_Size) {
			col = 0;
			while (col < Board_Size - 1) {
				text1 = buttons[row][col].getText();
				text2 = buttons[row][col + 1].getText();

				if (!text1.equals(text2) || text1.length() == 0) {
					break;
				}
				col++;
			}
			if (col == Board_Size - 1) {
				if (text1.equals("X")) {
					return GameStatus.XWins;
				} else if (text1.equals("O")) {
					return GameStatus.ZWins;
				}
			}
			row++;
		}
		// test for col
		col = 0;
		while (col < Board_Size) {
			row = 0;
			while (row < Board_Size - 1) {
				text1 = buttons[row][col].getText();
				text2 = buttons[row + 1][col].getText();

				if (!text1.equals(text2) || text1.length() == 0) {
					break;
				}
				row++;
			}
			if (row == Board_Size - 1) {
				if (text1.equals("X")) {
					return GameStatus.XWins;
				} else if (text1.equals("O")) {
					return GameStatus.ZWins;
				}
			}
			col++;
		}

		// test for diag1
		row = 0;
		col = 0;
		while (col < Board_Size - 1 && row < Board_Size - 1) {
			text1 = buttons[row][col].getText();
			text2 = buttons[row + 1][col + 1].getText();

			if (!text1.equals(text2) || text1.length() == 0) {
				break;
			}
			col++;
			row++;
		}
		if (col == Board_Size - 1 && row == Board_Size - 1) {
			if (text1.equals("X")) {
				return GameStatus.XWins;
			} else if (text1.equals("O")) {
				return GameStatus.ZWins;
			}
		}

		// test for diag2
		row = 0;
		col = Board_Size - 1;
		while (col > 0 && row < Board_Size - 1) {
			text1 = buttons[row][col].getText();
			text2 = buttons[row + 1][col - 1].getText();

			if (!text1.equals(text2) || text1.length() == 0) {
				break;
			}
			col--;
			row++;
		}
		if (col == 0 && row == Board_Size - 1) {
			if (text1.equals("X")) {
				return GameStatus.XWins;
			} else if (text1.equals("O")) {
				return GameStatus.ZWins;
			}
		}

		String text = "";
		for (row = 0; row < Board_Size; row++) {
			for (col = 0; col < Board_Size; col++) {
				text = buttons[row][col].getText();
				if (text.length() == 0) {
					return GameStatus.Incomplete;
				}
			}
		}
		return GameStatus.Tie;
	}

	private void declareWinner(GameStatus gs) {
		if (gs == GameStatus.XWins) {
			JOptionPane.showMessageDialog(this, "X wins");
		} else if (gs == GameStatus.ZWins) {
			JOptionPane.showMessageDialog(this, "Y wins");
		} else {
			JOptionPane.showMessageDialog(this, "Tie");
		}
	}
}
