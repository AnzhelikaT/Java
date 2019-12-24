package BreadthFirstSearch;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.collections15.Factory;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.io.PajekNetReader;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

public class Download {
	 public Graph graph = new UndirectedSparseGraph();
	    public  Download() {
	    	 JFileChooser chooser = new JFileChooser();
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("Choose graph ","net");
		        chooser.setFileFilter(filter);
		        int returnVal= chooser.showOpenDialog(null);
		        if (returnVal == JFileChooser.APPROVE_OPTION){
		            System.out.println("You choose to open this file: "+ chooser.getSelectedFile());

		        }
		        String nameFile = chooser.getSelectedFile().getAbsolutePath();
	    	Factory eFactory = new Factory() {
	            int i;
	            @Override
	            public Object create() {
	                return i++;
	            }
	        };
	        PajekNetReader pnr = new PajekNetReader(eFactory);
	        
	        try {
	            graph = pnr.load(nameFile, graph);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	       // return graph;
	    }

	    /*public static String getNameFile(){
	       JFileChooser chooser = new JFileChooser();
	        FileNameExtensionFilter filter = new FileNameExtensionFilter("Choose graph ","net");
	        chooser.setFileFilter(filter);
	        int returnVal= chooser.showOpenDialog(null);
	        if (returnVal == JFileChooser.APPROVE_OPTION){
	            System.out.println("You choose to open this file: "+ chooser.getSelectedFile());

	        }
	      return chooser.getSelectedFile().getAbsolutePath();
	       return "F:\\02. Универ\\4 курс\\Разработка программных приложений\\florence2.net";
	    }*/
}
