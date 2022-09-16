class Queue
{
    private int[] arr;      // array para armazenar elementos da queue
    private int front;      // front aponta para o elemento front na queue
    private int rear;       // traseira aponta para o último elemento da queue
    private int capacity;   // capacidade máxima da queue
    private int count;      // tamanho atual da queue
 
    // Construtor para inicializar uma queue
    Queue(int size)
    {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }
 
    // Função utilitária para desenfileirar o elemento frontal
    public int dequeue()
    {
        // verifica o underflow da queue
        if (isEmpty())
        {
            
            System.exit(-1);
        }
 
        int x = arr[front];
 
       
 
        front = (front + 1) % capacity;
        count--;
 
        return x;
    }
 
    // Função utilitária para adicionar um item à queue
    public void enqueue(int item)
    {
        // verifica se há estouro de queue
        if (isFull())
        {
            
            System.exit(-1);
        }
 
       
 
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        count++;
    }
 
    // Função utilitária para retornar o elemento da frente da queue
    public int peek()
    {
        if (isEmpty())
        {
            
            System.exit(-1);
        }
        return arr[front];
    }
 
    // Função utilitária para retornar o tamanho da queue
    public int size() {
        return count;
    }
 
    // Função utilitária para verificar se a queue está vazia ou não
    public boolean isEmpty() {
        return (size() == 0);
    }
 
    // Função utilitária para verificar se a queue está cheia ou não
    public boolean isFull() {
        return (size() == capacity);
    }
}