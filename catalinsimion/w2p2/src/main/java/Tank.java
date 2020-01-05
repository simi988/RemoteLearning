import java.util.Scanner;

public class Tank {



    public static int POSITION = 0;
    public static int MAX=10;
    int stack[] = new int[MAX];
    int top = POSITION;


    public void push(int data) {
        stack[top] = data;
        top++;
        System.out.println(data);
    }

    public int pop() {
        int data;
        top--;
        data = stack[top];
        stack[top] = 0;
        System.out.println(data);
        return data;
    }
    @Override
    protected void finalize() throws Throwable{
        if(stack.length==0){
            System.out.println("Is Empty"+this);
        }


    }
}


