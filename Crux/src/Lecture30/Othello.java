package Lecture30;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Othello extends JFrame implements ActionListener {
    JButton[][] button = new JButton[8][8];
    boolean blacksTurn = true;
    
    static final int NORTH = 1;
    static final int NE = 2;
    static final int EAST = 3;
    static final int SE = 4;
    static final int SOUTH = 5;
    static final int SW = 6;
    static final int WEST = 7;
    static final int NW = 8;
    
	public static void main(String[] args) {
		new Othello();
	}
	
	public Othello(){
		super("Othello");
		
        setSize(640, 640);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        GridLayout grid = new GridLayout(8,8);
        setLayout(grid);
        
        for(int i = 0; i <= 7; i++){
        	for(int j = 0; j <= 7; j++){
        		button[i][j] = new JButton();
                button[i][j].addActionListener(this);
                add(button[i][j]);
        	}
        }
        
        setVisible(true);
        startGame();
	}
	
	public void startGame(){
		button[3][3].setBackground(Color.white);
        button[3][4].setBackground(Color.black);
        button[4][3].setBackground(Color.black);
        button[4][4].setBackground(Color.white);
        
        blacksTurn = true;
        markValidMoves();
	}
	
	public int markValidMoves(){
		int retVal = 0;
		
		for(int i = 0; i <= 7; i++){
			for(int j = 0; j <= 7; j++){
				if(isValidCell(i, j)){
					button[i][j].setBackground(blacksTurn? Color.blue: Color.red);
					retVal++;
				}
				else{
					if(button[i][j].getBackground() != Color.black && 
					   button[i][j].getBackground() != Color.white){
						button[i][j].setBackground(Color.green);
					}
				}
			}
		}
		
		return retVal;
	}
	
	public boolean isValidCell(int i, int j){
		Color backgroundColor = button[i][j].getBackground();
		if(backgroundColor == Color.black || backgroundColor == Color.white){
			return false;
		}
		else{
			int initI, initJ;
			
			// dir north (i--)
			if(checkValidityInDirection(NORTH, i, j)){
				return true;
			}
			
			// dir north east (i--, j++)
			if(checkValidityInDirection(NE, i, j)){
				return true;
			}
			
			// dir east (j++)
			if(checkValidityInDirection(EAST, i, j)){
				return true;
			}
			
			// dir south east (i++, j++)
			if(checkValidityInDirection(SE, i, j)){
				return true;
			}
			
			// dir south (i++)
			if(checkValidityInDirection(SOUTH, i, j)){
				return true;
			}
			
			// dir south west (i++, j--)
			if(checkValidityInDirection(SW, i, j)){
				return true;
			}
			
			// dir west (j--)
			if(checkValidityInDirection(WEST, i, j)){
				return true;
			}
			
			// dir north west (i--, j--)
			if(checkValidityInDirection(NW, i, j)){
				return true;
			}
			
			// invalid in all directions
			return false;
		}
	}
	
	public boolean checkValidityInDirection(int direction, int i, int j){
		int initI, initJ, incrI, incrJ;
		boolean atleastOneFound = false;
		
		switch(direction){
		case NORTH:
			incrI = -1;
			incrJ = 0;
			break;
		case NE:
			incrI = -1;
			incrJ = +1;
			break;
		case EAST:
			incrI = 0;
			incrJ = +1;
			break;
		case SE:
			incrI = +1;
			incrJ = +1;
			break;
		case SOUTH:
			incrI = +1;
			incrJ = 0;
			break;
		case SW:
			incrI = +1;
			incrJ = -1;
			break;
		case WEST:
			incrI = 0;
			incrJ = -1;
			break;
		case NW:
			incrI = -1;
			incrJ = -1;
			break;
		default:
			incrI = 0;
			incrJ = 0;
		}
		
		initI = i + incrI;
		initJ = j + incrJ;
		while(initI >= 0 && initI <= 7 && 
			  initJ >= 0 && initJ <= 7 && 
			  button[initI][initJ].getBackground() == (blacksTurn? Color.white: Color.black)){
			initI += incrI;
			initJ += incrJ;
			atleastOneFound = true;
		}
		
		if(initI >= 0 && initI <= 7 && 
		   initJ >= 0 && initJ <= 7 && 
		   atleastOneFound &&
		   button[initI][initJ].getBackground()  == (blacksTurn? Color.black: Color.white)){
			return true;
		}
		
		return false;
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton)e.getSource();
		
		if(source.getBackground() == (blacksTurn? Color.blue: Color.red)){
			// find the button
			int foundI = 0, foundJ = 0;
			
			for(int i = 0; i <= 7; i++){
				for(int j = 0; j <= 7; j++){
					if(button[i][j] == source){
						foundI = i;
						foundJ = j;
						break;
					}
				}
			}
			
			// make the move
			makeMove(foundI, foundJ);
			
			// flip next turn
			blacksTurn = !blacksTurn;
			int validMoves = markValidMoves();
			
			if(validMoves == 0){
				blacksTurn = !blacksTurn;
				validMoves = markValidMoves();
				
				if(validMoves == 0){
					declareWinner();
					dispose();
				}
			}
		}
	}

	public void makeMove(int i, int j){
		rePaintInDirection(NORTH, i, j);
		rePaintInDirection(NE, i, j);
		rePaintInDirection(EAST, i, j);
		rePaintInDirection(SE, i, j);
		rePaintInDirection(SOUTH, i, j);
		rePaintInDirection(SW, i, j);
		rePaintInDirection(WEST, i, j);
		rePaintInDirection(NW, i, j);
		
		button[i][j].setBackground(blacksTurn? Color.black: Color.white);
	}
	
	public void rePaintInDirection(int direction, int i, int j){
		int initI, initJ, incrI, incrJ;
		boolean atleastOneFound = false;
		
		switch(direction){
		case NORTH:
			incrI = -1;
			incrJ = 0;
			break;
		case NE:
			incrI = -1;
			incrJ = +1;
			break;
		case EAST:
			incrI = 0;
			incrJ = +1;
			break;
		case SE:
			incrI = +1;
			incrJ = +1;
			break;
		case SOUTH:
			incrI = +1;
			incrJ = 0;
			break;
		case SW:
			incrI = +1;
			incrJ = -1;
			break;
		case WEST:
			incrI = 0;
			incrJ = -1;
			break;
		case NW:
			incrI = -1;
			incrJ = -1;
			break;
		default:
			incrI = 0;
			incrJ = 0;
		}
		
		initI = i + incrI;
		initJ = j + incrJ;
		while(initI >= 0 && initI <= 7 && 
			  initJ >= 0 && initJ <= 7 && 
			  button[initI][initJ].getBackground() == (blacksTurn? Color.white: Color.black)){
			initI += incrI;
			initJ += incrJ;
			atleastOneFound = true;
		}
		
		if(initI >= 0 && initI <= 7 && 
		   initJ >= 0 && initJ <= 7 && 
		   atleastOneFound &&
		   button[initI][initJ].getBackground()  == (blacksTurn? Color.black: Color.white)){
			// paint
			while(initI != i || initJ != j){
				initI -= incrI;
				initJ -= incrJ;
				
				button[initI][initJ].setBackground(blacksTurn? Color.black: Color.white);
			}
		}
	}
	
	public void declareWinner(){
		int blacks = 0, whites = 0;
		
		for(int i = 0; i <= 7; i++){
			for(int j = 0; j <= 7; j++){
				if(button[i][j].getBackground() == Color.black){
					blacks++;
				}
				else if(button[i][j].getBackground() == Color.white){
					whites++;
				}
			}
		}
		
		if(blacks > whites){
			JOptionPane.showMessageDialog(null, "Black wins");
		}
		else{
			JOptionPane.showMessageDialog(null, "White wins");
		}
	}
}
