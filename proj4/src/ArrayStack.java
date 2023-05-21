public class ArrayStack implements Stack {
    protected int capacity;
    public static final int CAPACITY = 1000;

    protected String [] S;
    protected int size;
    protected int top; //the array index that points to the top item

    public ArrayStack(){
        this(CAPACITY);
    }
    public ArrayStack(final int capacity){
        this.capacity = capacity;
        S = new String [this.capacity];
        this.size = 0;
        this.top = -1;
    }

    public int size(){ return this.size; }

    public String top(){
        if (top == -1)
            return null;
        return this.S[this.top];
    }

    public void push(String item){
        if (item == null)
            return;
        if (top == this.capacity -1)
            return;

        this.top++;
        this.S[this.top] = item;
        this.size++;

    }

    public String pop(){
        if(this.top == -1)
            return null;

        String lastItem = this.S[this.top];
        this.S[top] = null;

        this.top--;
        this.size--;
        return lastItem;
    }




}
