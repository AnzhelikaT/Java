package BreadthFirstSearch;

import java.awt.BasicStroke;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.algorithms.layout.SpringLayout;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.TreeLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
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
		
		//Download downloadGraph = new Download();
		Download sgv = new Download();
		Layout<Integer, String> layout = new CircleLayout(sgv.graph);
        layout.setSize(new Dimension(300,300));
        VisualizationViewer<Integer,String> vv = new VisualizationViewer<Integer,String>(layout);
        vv.setPreferredSize(new Dimension(350,300));        // Show vertex and edge labels
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
            // Create a graph mouse and add it to the visualization component
          DefaultModalGraphMouse gm = new DefaultModalGraphMouse();
          gm.setMode(ModalGraphMouse.Mode.TRANSFORMING);
          vv.setGraphMouse(gm);
          vv.setLocation(50,10);
  		  vv.setSize(400, 280);
          controlPanel.add(vv);
		
		//SimpleGraphView sgv = new SimpleGraphView(); 
		/*Layout<Integer, String> layout = new CircleLayout(sgv);    
		layout.setSize(new Dimension(100,240));     
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
		vv.setSize(100, 280);
		vv.setVisible(true);
		controlPanel.add(vv);*/
		
		JLabel headline = new JLabel("Наименование вершины начало:");
		headline.setLocation(10,300);
		headline.setSize(150,20);
		headline.setVisible(true);
		controlPanel.add(headline);
		
		JTextField vertexName = new JTextField(3);
		vertexName.setLocation(160,300);
		vertexName.setSize(40,20);
		vertexName.setVisible(true);
		controlPanel.add(vertexName);
		
		JLabel headline1 = new JLabel("Наименование вершины конец:");
		headline1.setLocation(10,320);
		headline1.setSize(150,20);
		headline1.setVisible(true);
		controlPanel.add(headline1);
		
		JTextField vertexName1 = new JTextField(3);
		vertexName1.setLocation(160,320);
		vertexName1.setSize(40,20);
		vertexName1.setVisible(true);
		controlPanel.add(vertexName1);
		
		JButton search = new JButton("Поиск");
		search.setLocation(250,300);
		search.setSize(70,20);
		search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	BFS bfs = new BFS();
            	String resultWay = bfs.search(sgv.graph, Integer.parseInt(vertexName.getText()),Integer.parseInt(vertexName1.getText()), level);
                JOptionPane.showMessageDialog(null, resultWay, "Кратчайший путь:", JOptionPane.PLAIN_MESSAGE);
            
            }
        });
		search.setVisible(true);
		controlPanel.add(search);
		
		/*JButton createNewGraph = new JButton("Создать новый граф");
		createNewGraph.setLocation(100,100);
		createNewGraph.setSize(70,20);
		createNewGraph.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	search.setVisible(true);
            	createNewGraph.setVisible(false);
            }
        });
		controlPanel.add(createNewGraph);*/
		
		controlPanel.setOpaque(true);
		return controlPanel;
	}

}
