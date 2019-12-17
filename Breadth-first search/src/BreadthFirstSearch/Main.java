package BreadthFirstSearch;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
public static void main(String[] args) {
	JFrame frame = new JFrame("Поиск в ширину");
	frame.setSize(400,400);
	ControlPanel panel = new ControlPanel();
	frame.setContentPane(panel.createControlPanel());
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
}
}
