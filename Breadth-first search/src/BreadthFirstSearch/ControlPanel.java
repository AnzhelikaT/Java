package BreadthFirstSearch;

import java.awt.BasicStroke;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.algorithms.layout.SpringLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.TreeLayout;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;

import javax.swing.*;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Stroke;
import java.awt.Window;
import java.awt.event.*;
import java.awt.FlowLayout;
public class ControlPanel  {
	public JPanel createControlPanel() {

		int level = 1;
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(null);
		
		SimpleGraphView sgv = new SimpleGraphView(); 
		Layout<Integer, String> layout = new SpringLayout<Integer, String>(sgv.g);    
		layout.setSize(new Dimension(300,240));     
		BasicVisualizationServer<Integer,String> vv = new BasicVisualizationServer<Integer,String>(layout);   
		 float dash[] = {10.0f};       
		 final Stroke edgeStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT,             
				 BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f);       
		 Transformer<String, Stroke> edgeStrokeTransformer = new Transformer<String, Stroke>() {          
			 public Stroke transform(String s) {            
				 return edgeStroke;            }    
			 };      
			 vv.getRenderContext().setEdgeStrokeTransformer(edgeStrokeTransformer);   
			 vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());       
		 vv.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);
		vv.setLocation(50,10);
		vv.setSize(300, 280);
		controlPanel.add(vv);
		
		JLabel headline = new JLabel("Наименование вершины начало:");
		headline.setLocation(10,300);
		headline.setSize(150,20);
		controlPanel.add(headline);
		
		JTextField vertexName = new JTextField(3);
		vertexName.setLocation(160,300);
		vertexName.setSize(40,20);
		controlPanel.add(vertexName);
		
		JLabel headline1 = new JLabel("Наименование вершины конец:");
		headline1.setLocation(10,320);
		headline1.setSize(150,20);
		controlPanel.add(headline1);
		
		JTextField vertexName1 = new JTextField(3);
		vertexName1.setLocation(160,320);
		vertexName1.setSize(40,20);
		controlPanel.add(vertexName1);
		/*vertexName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            System.out.println();
            }
        });*/
		
		JButton search = new JButton("Поиск");
		search.setLocation(250,300);
		search.setSize(70,20);
		search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	BFS bfs = new BFS();
            	String resultWay = bfs.search(sgv.g, Integer.parseInt(vertexName.getText()),Integer.parseInt(vertexName1.getText()), level);
                JOptionPane.showMessageDialog(null, resultWay, "Кратчайший путь:", JOptionPane.PLAIN_MESSAGE);
            
            }
        });
		controlPanel.add(search);
		
		/*JLabel result = new JLabel("Кратчайший путь:");
		result.setLocation(10,340);
		result.setSize(150,20);
		controlPanel.add(result);*/
		controlPanel.setOpaque(true);
		return controlPanel;
	}

}
