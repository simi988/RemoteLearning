package w2p2.file;

public class Tank {



    public static int POSITION = 0;
    public static int MAX_STACK=10;
    int stack[] = new int[MAX_STACK];
    int top = POSITION;


    public void push(int data) {
        stack[top] = data;
        top++;
        System.out.println(data);
        for(int i=0;i<stack.length;i++){
            if(stack[i]>stack[MAX_STACK]){
                System.out.println("capacity exceeded");
            }
        }
    }

    public int pop() {
        int data;
        top--;
        data = stack[top];
        stack[top] = 0;
        System.out.println(data);
        if(data<0){
            System.out.println("Stack is Empty");
        }
        return data;
    }
    @Override
    protected void finalize() {
        if(stack.length==0){
            System.out.println("Is Empty"+this);
        }


    }
}


