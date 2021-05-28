import java.util.Stack;

/**
 *  手写栈队列
 *  栈是先入后出，队列是先入先出。根据这个思想，
 *  可以用一个栈作为入队，另一个栈作为出队。
 *  只要把第一个栈的栈顶的元素压入第二个栈就好了，出队的时候输出第二个栈的栈顶，
 *  如果第二个栈的空了就需要不断操作从第一个栈的栈顶压入第二个栈，但是如果第一个栈也空了，那就说明所有元素都输出来了。
 * @author zengsong
 * @date 2021/2/25 14:00
 */
public class StackQueue {
    //进队系列
    private Stack<Integer> inQueue=new Stack<>();
    //出队系列
    private Stack<Integer> onQueue=new Stack<>();

    public void push(int node){
        //入队,保证出队为空
        while (!onQueue.isEmpty()){
            //push即,将元素推入栈中,peek时(即，取出栈顶元素，不执行删除)
            // 获取出队栈顶元素把他压到入栈队列
            System.out.println("出队栈顶元素是:"+onQueue.peek());
            inQueue.push(onQueue.peek());
            //pop(即,取出栈顶元素,并将该元素从栈中删除)
            onQueue.pop();
        }
        inQueue.push(node);
        System.out.println("入队元素是:"+inQueue.peek());
    }
    //出队伍
    public int pop(){
        //出队,保证入队为空
        while (!inQueue.isEmpty()){
            //栈顶元素写入栈中
            System.out.println("入栈顶元素："+inQueue.peek());
            onQueue.push(inQueue.peek());
            inQueue.pop();
        }
        System.out.println("出队元素是："+onQueue.peek());
        int temp=onQueue.peek();
        onQueue.pop();

        return temp;
    }
    public static void main(String[] agr0){
        StackQueue sq=new StackQueue();
        sq.push(1);
        sq.push(2);
        sq.push(3);
        sq.pop();
        sq.pop();

        sq.push(4);
        sq.pop();
        sq.push(5);
        sq.pop();
        sq.pop();
    }
}
