package BreadthFirstSearch;

import java.util.ArrayList;

import edu.uci.ics.jung.graph.Graph;

public class BFS {
	int lastElement = -1;
	String resultWay;// ������������ �������� ����������� ����
	String way = "";// ���������� ��� �������� ���� �� ��������� ����� �� ��������
	int countVertexInWay = 0;// ���������� ��� �������� ����� �� ��������� ����� �� ��������
	ArrayList<String> allResultWays = new ArrayList<>();// ������ ��� ��������� ���� �� ��������� ����� �� ��������
	ArrayList<Integer> lengthAllResultWays = new ArrayList<>();// ������ ����� ���� ��������� ����� �� ��������� �����
																// �� ��������
	ArrayList<Integer> vertexWay = new ArrayList<>();
	public void search(Graph<Integer, String> g, int numberVertexStart, int numberVertexEnd) {
		Object[] mass = g.getNeighbors(numberVertexStart).toArray();
		for (Object object : mass) {
			if (vertexWay.contains((Integer) object) != true) {
				if ((Integer) object == numberVertexEnd) {
					way = way + "-" + object.toString();
					countVertexInWay = countVertexInWay + 1;
					allResultWays.add(way);
					lengthAllResultWays.add(countVertexInWay);
					System.out.println(way);
					way = "";
					countVertexInWay = 0;
				}
				//���� �� ����� ��������� �������� � �� ����� ������ ������� ����� ��������
				else if(((Integer) object != numberVertexEnd) && g.getNeighbors((Integer) object).size() <= 1 )  {
					vertexWay.clear();
					way = "";
					countVertexInWay = 0;
					
			}
				else  {
					vertexWay.add((Integer) object);
					//lastElement = (Integer) object;
					way = way + "-" + object.toString();
					countVertexInWay = countVertexInWay + 1;
					search(g, (Integer) object, numberVertexEnd);
					
			}
			}

		}
		// System.out.println();
		// return resultWay;
		/*if ((Integer) object != (Integer) lastElement) {
				if ((Integer) object == numberVertexEnd) {
					way = way + "-" + object.toString();
					countVertexInWay = countVertexInWay + 1;
					allResultWays.add(way);
					lengthAllResultWays.add(countVertexInWay);
					System.out.println(way);
					way = "";
					countVertexInWay = 0;
				} else if (g.getNeighbors((Integer) object).size() > 1) {
					lastElement = (Integer) object;
					way = way + "-" + object.toString();
					countVertexInWay = countVertexInWay + 1;
					search(g, (Integer) object, numberVertexEnd);
				}
			}*/
	}

}
