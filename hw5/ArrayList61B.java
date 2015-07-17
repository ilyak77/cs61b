import java.util.AbstractList;
import java.util.NoSuchElementException;

public class ArrayList61B extends AbstractList<T>{
 /*This constructor should initialize the size of the internal array to be initialCapacity
  *and throw an IllegalArgumentException if initialCapacity is less than 1.
  */
 public T[] a;
 public int size;
 public int capacity;

 public ArrayList61B(int initialCapacity){
 	capacity=initialCapacity;
 	if(capacity<1){
 		throw new IllegalArgumentException();
 	}

 	T[] a=(T[]) new Object[capacity];
 	size=0;
 } 

/*This constructor should initialize the size of the internal array to be 1.*/ 
public ArrayList61B(){
	capacity=1;
	T[] a=(T[]) new Object[capacity];
	size=0;
}

/*This method should return the ith element in the list. 
 *This method should throw an IllegalArgumentException if i is less than 0 or greater 
 *than or equal to the number of elements in the list.
 */
public E get(int i){
	if((i<0) ||(i>=size)){
		throw new IllegalArgumentException();
	}
	return a[i];

}

/* This method should add item to the end of the list, resizing the internal array if necessary.
 * This method should always return true (if you are curious about this, read the api for
 * AbstractList).
 */
public boolean add(E item){
  if(size==capacity) this.resize();
   
   size=size+1;
   a[size]=item;

}

private void resize(){
  
  	T[] b=(T[]) new Object[2*capacity];
  	for(int i=0;i<size;i++){
      b[i]=a[i];
  	}

  	a=b;
  
}

/*This method should return the number of elements in the list. Note that this is not necessarily the same as the number of elements in the internal array.
*/
public int size(){
  return size;
}


}
