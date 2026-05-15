class DynamicArray {
private int[] arr; // Array to store the elements of the dynamic array
    private int length; // Current number of elements in the dynamic array
    private int capacity; // Current capacity of the dynamic array

    // Constructor to initialize the dynamic array with a given capacity
    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.arr = new int[this.capacity];
    }
    //get method to retrieve the element at a specific index
    public int get(int i) {
        if(i < 0 || i >= this.length){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return this.arr[i];
    }
    //insert method to set the value at a specific index
    public void set(int i, int n) {
        if(i < 0 || i >= this.length){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        this.arr[i] = n;

    }
//pushback method to add an element at the end of the dynamic array
    public void pushback(int n) {
        if(this.length >= this.capacity){
            resize();
        }
        this.arr[this.length] = n;
        this.length++;
    }
//Remove the last element from the dynamic array and return it
    public int popback() {
        if(this.length == 0){
            throw new IndexOutOfBoundsException("Dynamic array is empty");
        }
        int lastElement = this.arr[this.length - 1];
        this.length--;
        return lastElement;
    }

    private void resize() {
        this.capacity *= 2;
        int[] newArr = new int[this.capacity];
        for(int i = 0; i < length; i++){
            newArr[i] = this.arr[i];
        }
        this.arr = newArr;

    }

    public int getSize() {
        return this.length;
    }


    public int getCapacity() {
        return this.capacity;
    }
}
