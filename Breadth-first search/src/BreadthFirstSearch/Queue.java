package BreadthFirstSearch;

public class Queue {
	private int[] queue;
    private int maxSize; // максимальное количество элементов в очереди 
    private int nElem;  // текущее количество элементов в очереди 
    private int front;
    private int rear;
 
    public Queue(int maxSize) {
        this.maxSize = maxSize;
        queue = new int[maxSize];
        rear = -1;
        front = 0;
        nElem = 0;
    }
    
    //метод вставки элемента в очередь
    public void insert(int elem) {
        if (rear == maxSize - 1) {  // циклический перенос
            rear = -1;
        }
     
        queue[++rear] = elem;  //увеличение Rear и вставка
        nElem++;  // увеличение количества элементов в очереди
    }
    
    //метод удаления элемента из начала очереди
    public int remove() {
    	int temp = queue[front++]; // получаем первый элемент из очереди
    	 
    	    if (front == maxSize) { // циклический перенос
    	        front = 0;
    	    }
    	    nElem--; // уменьшаем количество элементов в очереди 
    	    return temp;
  
    	    }
    
    //методы проверки очереди на переполнение или пустоту
    public int getFront() {
        return queue[front];
    }
     
    public int getRear() {
        return queue[rear];
    }
     
    public boolean isFull() {
        return (nElem == maxSize - 1);
    }
     
    public boolean isEmpty() {
        return (nElem == 0);
    }
     
    public int getSize() {
        return nElem;
    }
    

}
