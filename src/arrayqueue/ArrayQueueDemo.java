package arrayqueue;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ProjectName: DataStructures
 * @ClassName: ArrayQueueDemo
 * @Author: NoNO
 * @Description:队列
 * @tel: 13408937760  3407137458@qq.com
 * @Date: 2020/6/25 9:33
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
       ArrayQueue arrayQueue = new ArrayQueue(1);
//        boolean b = arrayQueue.QueueEmpty();
//        System.out.println(b);
//        System.out.println(arrayQueue.EnQueue(5));
//        arrayQueue.traverseArrQueue();
//        System.out.println(arrayQueue.DeQueue());
//        arrayQueue.traverseArrQueue();
           char key=' ';
        Scanner scanner =new Scanner(System.in);
        boolean loop =true;
        System.out.println("s(show):显示队列");
        System.out.println("e(exit):退出程序");
        System.out.println("a(add):添加数据到队列");
        System.out.println("g(get):从队列取出数据");
        System.out.println("h(head):查看队列头的数据");
        System.out.println("请输入你想要执行的操作");
        while (loop){
            char c =scanner.next().charAt(0);
            switch (c){
                case 's':arrayQueue.traverseArrQueue();break;
                case 'e':loop=false;break;
                case 'a':
                    System.out.println("请输入你想要添加的数据");
                    int i =scanner.nextInt();
                    arrayQueue.EnQueue(i);
                    ;break;
                case 'g':
                    int j = arrayQueue.DeQueue();
                    System.out.println("取出的数据:"+j);
                    ;break;
                case 'h':
                    int k =arrayQueue.GetHead();
                    System.out.println("头数据:"+k);
                    break;
            }
        }


    }
}

class ArrayQueue {
    private int front; //头指针
    private int rear; //尾指针
    private int[] arr; //数组模拟队列

    public ArrayQueue(int queueSize) {  //初始化队列
        rear = 0;
        front = 0;
        arr = new int[queueSize];
    }

    //判断队列是否为空
    public boolean QueueEmpty() {
        return rear == front;
    }

//    判断法队列是否满 (rear+1)%queueSize==front;

    public boolean QueueFull() {
        return (rear + 1) % arr.length == front;
    }

//    出队列，返回出队列的值

    public int DeQueue() {
//     1.判断队列是否为空
        if (QueueEmpty()) {
            throw new RuntimeException("队列为空，不能删除。。");
        }
        int n=arr[front];
        front=(front+1)%arr.length;
        return n;
    }

    //   入队列
    public boolean EnQueue(int n) { //n  表示插入的数据
        if (QueueFull()) {
            throw new RuntimeException("队列已经满了，不能再添加了。。。");
        }
        arr[rear] = n;
        rear=(rear+1)%arr.length;
        return true;
    }

    public void traverseArrQueue() {
//        遍历有效数据，应该从front开始，遍历有效个元素
        System.out.println(Arrays.toString(arr));

        for (int i=front;i<front+size();i++){
            System.out.println(arr[i%arr.length]);
        }

    }

    public int GetHead(){
        if (QueueEmpty()){
            throw  new RuntimeException("没有数据。。。");
        }
        return arr[front];
    }

    public int size(){
        return (rear+arr.length+front)%arr.length;
    }

}
