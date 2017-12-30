package GameBtr;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.*;
import java.util.Random;

public class TTT extends JFrame implements ActionListener {
	private enum GameStatus {
		ZeroWon, CrossWon, Tie, Incomplete;
	}

	private boolean playerflag = players();
	private boolean crossTurn = true;
	public static final int BOARD_SIZE = 3;
	public static final String CROSS = "X";
	public static final String ZERO = "O";
	private JButton[][] buttons = new JButton[BOARD_SIZE][BOARD_SIZE];

	public TTT() {
		super.setTitle("TIC TAC TOE");
		super.setBackground(Color.GRAY);
		GridLayout layout = new GridLayout(BOARD_SIZE, BOARD_SIZE);
		super.setLayout(layout);
		super.setSize(900, 900);
		super.setResizable(false);

		Font font = new Font("Serif", 1, 150);
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				JButton button = new JButton();
				button.setFont(font);
				button.addActionListener(this);
				this.buttons[row][col] = button;
				button.setBackground(Color.cyan);
				super.add(button);

			}
		}
		super.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clickedbutton = (JButton) e.getSource();
		clickedbutton.setBackground(Color.CYAN);
		makeMove(clickedbutton);
		if (playerflag) {
			cpuMove();
		}
		GameStatus gs = getGameStatus();
		if (gs == GameStatus.Incomplete) {
			return;
		} else {
			declareWinner(gs);

			int Jchoice = JOptionPane.showConfirmDialog(this, "AGAIN ");

			if (Jchoice == JOptionPane.YES_OPTION) {
				for (int row = 0; row < BOARD_SIZE; row++) {
					for (int col = 0; col < BOARD_SIZE; col++) {
						JButton button = this.buttons[row][col];
						button.setText("");
						button.setBackground(Color.cyan);
					}
				}
				this.crossTurn = true;
			} else {
				super.dispose();
			}
		}

	}

	private void makeMove(JButton clickedbutton) {
		if (clickedbutton.getText().length() > 0) {
			JOptionPane.showMessageDialog(this, "Dhang se khelo");
			return;
		} else if (crossTurn) {
			clickedbutton.setText(CROSS);
		} else {
			clickedbutton.setText(ZERO);
		}
		crossTurn = !crossTurn;

	}

	public void cpuMove() {
		int x = 0;
		int y = 0;
		do {
			Random rand = new Random();
			x = rand.nextInt(3);
			y = rand.nextInt(3);
			if (this.buttons[x][y].getText().equals("")) {
				this.buttons[x][y].setText(ZERO);
				crossTurn = true;
				getGameStatus();
			}
		} while (crossTurn == false);
	}

	private GameStatus getGameStatus() {
		String prev = "", nxt = "";
		int row = 0, col = 0;
		row = 0;
		while (row < BOARD_SIZE) {
			col = 0;
			while (col < BOARD_SIZE - 1) {
				prev = buttons[row][col].getText();
				nxt = buttons[row][col + 1].getText();

				if (!prev.equals(nxt) || prev.length() == 0) {
					break;
				}
				col++;
			}
			if (col == BOARD_SIZE - 1) {
				if (prev.equals(CROSS)) {
					return GameStatus.CrossWon;
				} else if (prev.equals(ZERO)) {
					return GameStatus.ZeroWon;
				}
			}
			row++;
		}
		col = 0;
		while (col < BOARD_SIZE) {
			row = 0;
			while (row < BOARD_SIZE - 1) {
				prev = buttons[row][col].getText();
				nxt = buttons[row + 1][col].getText();

				if (!prev.equals(nxt) || prev.length() == 0) {
					break;
				}
				row++;
			}
			if (row == BOARD_SIZE - 1) {
				if (prev.equals(CROSS)) {
					return GameStatus.CrossWon;
				} else if (prev.equals(ZERO)) {
					return GameStatus.ZeroWon;
				}
			}
			col++;
		}
	
		row = 0;
		col = 0;
		while (col < BOARD_SIZE - 1 && row < BOARD_SIZE - 1) {
			prev = buttons[row][col].getText();
			nxt = buttons[row + 1][col + 1].getText();

			if (!prev.equals(nxt) || prev.length() == 0) {
				break;
			}
			col++;
			row++;
		}
		if (col == BOARD_SIZE - 1 && row == BOARD_SIZE - 1) {
			if (prev.equals("X")) {
				return GameStatus.CrossWon;
			} else if (prev.equals("O")) {
				return GameStatus.ZeroWon;
			}
		}

	
		row = 0;
		col = BOARD_SIZE - 1;
		while (col > 0 && row < BOARD_SIZE - 1) {
			prev = buttons[row][col].getText();
			nxt = buttons[row + 1][col - 1].getText();

			if (!prev.equals(nxt) || prev.length() == 0) {
				break;
			}
			col--;
			row++;
		}
		if (col == 0 && row == BOARD_SIZE - 1) {
			if (prev.equals(CROSS)) {
				return GameStatus.CrossWon;
			} else if (prev.equals(ZERO)) {
				return GameStatus.ZeroWon;
			}
		}
		


		for (row = 0; row < BOARD_SIZE; row++) {
			for (col = 0; col < BOARD_SIZE; col++) {
				JButton button = this.buttons[row][col];
				if (button.getText().length() == 0) {
					return GameStatus.Incomplete;
				}

			}
		}
		return GameStatus.Tie;
	}

	private void declareWinner(GameStatus gs) {
		if (gs == GameStatus.ZeroWon) {
			JOptionPane.showMessageDialog(this, "Zero is winner");
		}
		if (gs == GameStatus.CrossWon) {
			JOptionPane.showMessageDialog(this, "Cross is winner");
		}
		if (gs == GameStatus.Tie) {
			JOptionPane.showMessageDialog(this, "TIE");
		}

	}

	public boolean players() {
		int playerchoice = JOptionPane.showConfirmDialog(this, "WANT TO PLAY WITH COMPUTER ");
		if (playerchoice == JOptionPane.YES_OPTION) {
			this.playerflag = true;
		} else {
			this.playerflag = false;
		}
		return playerflag;
	}
}