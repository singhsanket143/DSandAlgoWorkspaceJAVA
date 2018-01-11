package HashTableGui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUIManager extends JFrame implements ActionListener {
	JPanel left, right;
	JLabel labelKey, labelValue;
	JTextField textKey, textValue;
	JButton btnGet, btnPut, btnRemove;
	Hashtable<String, String> map;

	public GUIManager() {
		super("HashTable Graphic Demo");
		super.setSize(2048, 1080);
		super.setResizable(false);

		divideLeftRight();

		super.setVisible(true);
		this.map = new Hashtable<>();
	}

	private void divideLeftRight() {
		left = new JPanel();
		left.setSize(2048, 240);
		super.add(left);

		divideLeft();

		right = new JPanel();
		right.setSize(2048, 840);
		super.add(right);
	}

	private void divideLeft() {
		Font labelFont = new Font("Times New Roman", 1, 50);
		Font buttonFont = new Font("Times New Roman", 1, 75);

		left.setLayout(new GridLayout(3, 1));

		JPanel row1 = new JPanel();
		row1.setLayout(new FlowLayout());
		left.add(row1);

		JPanel row2 = new JPanel();
		row2.setLayout(new FlowLayout());
		left.add(row2);

		JPanel row3 = new JPanel();
		row3.setLayout(new GridLayout(1, 3));
		left.add(row3);

		labelKey = new JLabel("Key");
		labelKey.setFont(labelFont);
		row1.add(labelKey);

		textKey = new JTextField(15);
		textKey.setFont(labelFont);
		row1.add(textKey);

		labelValue = new JLabel("Value");
		labelValue.setFont(labelFont);
		row2.add(labelValue);

		textValue = new JTextField(15);
		textValue.setFont(labelFont);
		row2.add(textValue);

		btnGet = new JButton("Get");
		btnGet.setFont(buttonFont);
		btnGet.addActionListener(this);
		row3.add(btnGet);

		btnPut = new JButton("Put");
		btnPut.setFont(buttonFont);
		btnPut.addActionListener(this);
		row3.add(btnPut);

		btnRemove = new JButton("Remove");
		btnRemove.setFont(buttonFont);
		btnRemove.addActionListener(this);
		row3.add(btnRemove);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String key = textKey.getText();
			String value = textValue.getText();

			if (e.getSource() == btnGet) {
				String rValue = this.map.get(key);
				JOptionPane.showMessageDialog(null, rValue);
			} else if (e.getSource() == btnPut) {
				this.map.put(key, value);
			} else if (e.getSource() == btnRemove) {
				this.map.remove(key);
			}
			
			textKey.setText("");
			textValue.setText("");
			paintMap();
		} catch (Exception ex) {

		}
	}
	
	private void paintMap(){
		Graphics g = right.getGraphics();
		g.clearRect(0, 240, 2048, 1080);
		
		int numLL = this.map.lists.length;
		
		for(int i = 0; i < this.map.lists.length; i++){
			g.drawRect(10 + i * 100, 250, 100, 100);
			
			if(this.map.lists[i] != null){
				LinkedList<Hashtable<String, String>.Node>.Node temp = this.map.lists[i].head;
				int counter = 1;
				while(temp != null){
					g.drawRect(45 + i * 100, 300, 10, 100);
					g.drawRect(i * 100, 300 + counter * 100, 100, 100);
					
					g.setFont(new Font("Times New Roman", 1, 25));
					g.drawString(temp.data.key + ", " + temp.data.value, 
								 i * 100, 300 + counter * 100 + 50);
					
					temp = temp.next;
					counter++;
				}
			}
		}
	}
}

