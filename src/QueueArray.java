public class QueueArray {
    Object[] arr=new Object[10];
    int front=0;
    int rear=0;
    public boolean enqueue(Object obj){
        if((rear+1)%arr.length==front){
            return false;
        }
        arr[rear]=obj;
        rear=(rear+1)%arr.length;
        return true;
    }
    public Object dequeue(){
        if (rear==front){
            return null;
        }
        Object obj=arr[front];
        front=(front+1)%arr.length;
        return obj;
    }
    public static void main(String[] args){
        QueueArray q=new QueueArray();
        System.out.println(q.enqueue("北京"));
        System.out.println(q.enqueue("上海"));
        System.out.println(q.enqueue("广东"));
        System.out.println(q.enqueue("深圳"));
        for(int i=0;i<4;i++){
            System.out.println(q.dequeue());
        }
    }
}
