public class Stack {
    private Object[] stackArray;
    private int index;

    public Stack(int size){
        this.stackArray = new Object[size];
        this.index = 0;
    }

    public void push(Object data){
        if(index >= stackArray.length){
            throw new IndexOutOfBoundsException("full");
        }else{
            stackArray[index++] = data;
        }
    }

    public Object peek(){
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }else{
            return stackArray[index-1];
        }
    }

    public Object pop(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }else{
            Object obj = peek();
            stackArray[index] = null;
            return obj;
        }
    }

    public boolean isEmpty(){
        return (index <= 0);
    }
}
