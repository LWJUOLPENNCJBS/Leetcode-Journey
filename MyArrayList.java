/*
 * I attest that the code in this file is entirely my own except for the starter
 * code provided with the assignment and the following exceptions:
 * <
 * Enter all external resources and collaborations here. Note external code may
 * reduce your score but appropriate citation is required to avoid academic
 * integrity violations. Please see the Course Syllabus as well as the
 * university code of academic integrity:
 *  https://catalog.upenn.edu/pennbook/code-of-academic-integrity/
 * >
 * Signed,
 * Author: WEIJIE LI
 * Penn email: <liweijie@seas.upenn.edu>
 * Date: <2021-09-09>
 */

public class MyArrayList<E> {

    /*
     * Do not change this initial capacity; it is used by our test cases
     */
    private static final int INITIAL_CAPACITY = 4;

    /*
     * These are protected so that test cases can access them. Please do not change
     * the visibility of these fields!
     */
    protected Object[] data;
    protected int size = 0;

    public MyArrayList() {
        data =  new Object[INITIAL_CAPACITY];
    }

    /*
     * Need to implement this in step 5
     */
    public MyArrayList(E[] arr) {
    	if (arr == null || arr.length == 0) {
    		data =  new Object[INITIAL_CAPACITY];
    	}
    	else {
    	this.size = arr.length;
    	this.data =  new Object[this.size];
    	for (int i=0; i<arr.length;i++) {
    		this.data[i] = arr[i];
    	}}
    }

    
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else
            return (E) data[index];
    }

    private void increaseCapacity() {
    	Object[] newData =  new Object[2 * data.length];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    /*
     * This method adds the element to the list. Except for modifying it to use Java
     * Generics, DO NOT OTHERWISE CHANGE THIS METHOD as it is used in testing your
     * code.
     */
    public void add(E value) {
        if (size == data.length) {
            increaseCapacity();
        }
        data[size++] = value;
    }

    public void add(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == data.length) {
            increaseCapacity();
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;
    }

    // private helper function to shrink the list
    private void shrinkCapacity() {
    	Object[] newData =  new Object[data.length/2];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }
    
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E target = (E) data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;
        
        //test if the length is twice as large as the size
        if(size <= (data.length/4) ) {
        	System.out.println("function used");
        	shrinkCapacity();
        }
        
        return target;
    }

    /*
     * Need to implement this in Step 2.
     */
    public boolean remove(E obj) {
    	for (int i=0; i<size;i++) {
    		if(obj == data[i]){
    			//System.out.println(i);
    			for (int j=i; j<size -1;j++) {
    				data[j] = data[j+1]	;
    			}
    		size--;
    	    data[size] = null;
            if(size <= (data.length/4) ) {
            	System.out.println("function used");
            	shrinkCapacity();
            }
    		return true;
    		}
    	}
        return false;
    }

    
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + ": " + data[i]);
        }
    }

    public boolean contains(E obj) {
        for (int i = 0; i < size; i++) {
            if (obj == data[i] || (data[i] != null && data[i].equals(obj)))
                return true;
        }
        return false;
    }

    /*
     * Need to implement this in Step 4
     */
    public E set(int index, E obj) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } 
        
        else {
        	Object hold = data[index];
        	data[index] = obj;
        	return (E) hold;
        }
            
    }
    
    
    
    public static void main(String[] args){
    	System.out.println("\"MyArrayList does not correctly set elements");
    	MyArrayList<String> list = null;
    	String[] arr = {"a", "b", "c", "d", "e"};
    	list = new MyArrayList<>();
    	list.data = arr;
    	list.size = arr.length;	
    	String ret = list.get(2);
    	//list.print();
    	arr[0] = "dkfj";
    	//list.print();
    	int a = 2;
    	System.out.print(ret);

  
    	String[] data = new String[]{"a", "b", "c"};
    	MyArrayList<String> list2 = new MyArrayList<>(data);
    	//list2.print();
    	data[0]="asdfas";
    	//list2.print();

    }

}