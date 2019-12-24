package BreadthFirstSearch;

import java.util.ArrayList;

import edu.uci.ics.jung.graph.Graph;

import static java.lang.System.exit;

public class BFS {
    int lastElement = -1;
    String resultWay;// возвращаемое значение кратчайшего пути
    String way = "";// переменная для хранения пути от начальной точки до конечной
    int countVertexInWay = 0;// переменная для хранения длины от начальной точки до конечной
    ArrayList<Integer> allResultWays = new ArrayList<>();// хранит все возможные пути от начальной точки до конечной
    ArrayList<Integer> lengthAllResultWays = new ArrayList<>();// хранит длины всех возможных путей от начальной точки
    // до конечной
    ArrayList<Integer> vertexWay = new ArrayList<>();

    boolean exitFromRec = false;
    int firstElementQueue;// текущий элемент вершины
    int level = 1;// уровень на котором находится вершина
    // int vertexUsed = 0;//использовалась ли вершина при обходе
    int maxSizeQueue;// максимальный размер очереди
    int levelEndVertex;
    // int actualLevel = 1;//текущий уровень
    int[] propertiesVertex = new int[2];// хранит номер точки и уровень
    ArrayList<int[]> propertiesAllVertex = new ArrayList<>();
    ArrayList<Integer> vertexUsed = new ArrayList<>();// хранит использованные вершины

    public String search(Graph<Integer, String> g, int numberVertexStart, int numberVertexEnd, int actualLevel) {

		/* while (!queue.isEmpty()) { */
        /*
		 * firstElementQueue = numberVertexStart;
		 * propertiesVertex.add(firstElementQueue); propertiesVertex.add(actualLevel);
		 * propertiesAllVertex.add(propertiesVertex); propertiesVertex.clear();
		 * vertexUsed.add(firstElementQueue); Object[] mass =
		 * g.getNeighbors(firstElementQueue).toArray(); for (Object object : mass) {
		 * if(!vertexUsed.contains((Integer)object)) { search(g, (Integer)object,
		 * numberVertexEnd,actualLevel+1); } actualLevel = actualLevel-1;
		 * 
		 * }
		 */
        // System.out.println(propertiesAllVertex.get(0));
        // цикл до тех пор пока очередь не будет пуста
        int numberVertex;// название вершины
        maxSizeQueue = g.getVertices().size() * 2;//так как в очереди хранится и номер уровня
        Queue queue = new Queue(maxSizeQueue);// очередь для хранения вершин графа
        queue.insert(numberVertexStart);
        queue.insert(level);
        propertiesVertex[0] = numberVertexStart;
        propertiesVertex[1] = level;
        propertiesAllVertex.add(propertiesVertex);

        while (queue != null) {
            firstElementQueue = queue.remove();
            actualLevel = queue.remove();
            vertexUsed.add(firstElementQueue);
            Object[] mass = g.getNeighbors(firstElementQueue).toArray();
            if (firstElementQueue == numberVertexEnd) {
                allResultWays.add(firstElementQueue);
                recursion(g, firstElementQueue, actualLevel, numberVertexStart);
                queue = null;
                break;
            }
            for (Object object : mass) {
                if (!vertexUsed.contains((int) object)) {
                    queue.insert((Integer) object);// вставляем номер вершины
                    queue.insert(actualLevel + 1);// вставляем ее уровень
                    int[] propertiesVertex = new int[2];
                    propertiesVertex[0] = (Integer) object;
                    propertiesVertex[1] = actualLevel + 1;
                    propertiesAllVertex.add(propertiesVertex);
                    propertiesVertex = null;
                    // вот тут помечать
                }
            }
        }
        for (int i = allResultWays.size() - 1; i >= 0; i--) {
            way = way + " " + allResultWays.get(i);
        }
		/*
		 * for (int i = 0; i < propertiesAllVertex.size(); i++) { propertiesVertex =
		 * propertiesAllVertex.get(i); if ((Integer) propertiesAllVertex.get(i)[0] ==
		 * numberVertexEnd) { levelEndVertex = (Integer) propertiesAllVertex.get(i)[1];
		 * numberVertex = numberVertexEnd; break; }
		 */
        return way;

		/*
		 * Object[] mass = g.getNeighbors(numberVertexStart).toArray(); for (Object
		 * object : mass) {
		 * 
		 * 
		 * }
		 */

        // System.out.println();
        // return resultWay;
		/*
		 * if ((Integer) object != (Integer) lastElement) { if ((Integer) object ==
		 * numberVertexEnd) { way = way + "-" + object.toString(); countVertexInWay =
		 * countVertexInWay + 1; allResultWays.add(way);
		 * lengthAllResultWays.add(countVertexInWay); System.out.println(way); way = "";
		 * countVertexInWay = 0; } else if (g.getNeighbors((Integer) object).size() > 1)
		 * { lastElement = (Integer) object; way = way + "-" + object.toString();
		 * countVertexInWay = countVertexInWay + 1; search(g, (Integer) object,
		 * numberVertexEnd); } }
		 */
    }

    public void recursion(Graph<Integer, String> g, int numberVertex, int levelEndVertex, int numberVertexStart) {
        //System.out.println(numberVertex);

        Object[] mass = g.getNeighbors(numberVertex).toArray();

        for (Object object : mass) {

            for (int i = 0; i < (Integer) propertiesAllVertex.size(); i++) {
                propertiesVertex = null;
                int[] propertiesVertex = propertiesAllVertex.get(i);
                if (propertiesVertex[0] == (int) object) {
                    ///	System.out.println(object);
                    if (propertiesAllVertex.get(i)[1] == (levelEndVertex - 1)) {
                        if(levelEndVertex > 1){
                        numberVertex = propertiesAllVertex.get(i)[0];
                        levelEndVertex = levelEndVertex - 1;
                        allResultWays.add(numberVertex);
                            recursion(g, numberVertex, levelEndVertex, numberVertexStart);
                        }
                        else{
                            return;
                        }
                    }
                }
            }
        }
    }


}
