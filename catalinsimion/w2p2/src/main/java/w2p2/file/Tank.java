package w2p2.file;

public class Tank {

    private static int POSITION = 0;
    private static int MAX_STACK = 10;
    private static final int NUMBER_MIN = 0;
    private static int stack[] = new int[MAX_STACK];
    private static int top = POSITION;


    public void push(int data) {
        if (top < stack.length) {

            stack[top] = data;
            top++;
            System.out.println(data);

        } else {
            System.out.println("capacity exceeded");
        }
    }

    public int pop() {

        top--;
        if (top >= NUMBER_MIN) {
            int data = stack[top];
            stack[top] = 0;
            System.out.println(data);
            return data;
        } else {
            System.out.println("Stack is Empty");
        }
        return Integer.MAX_VALUE;
    }

    @Override
    public void finalize() {
        if (top == 0) {
            System.out.println("Is Empty" + this);
        }


    }
}


