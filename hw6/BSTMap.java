

public class BSTMap<K,V> implements Map61B<K,V>{
	public int size=0;
	private BST root;

	private class BST<K,V>{
	  public K label;
	  public V val;
	  public BST left, right;
	
	  public BST(Comparable label,V val) { 
		this.label=(K)label;
		this.val=val;
		left=null;
		right=null; 
	  }
	}
    
	public void clear(){
      size=0;
      root=null;
	}

  
    public boolean containsKey(K key){
    	return get(key)!=null;
    }

   
    public V get(K key){
    	return get((Comparable)key,root);
    }

   
    public int size(){
    	return size;
    }

   
    public void put(K key, V value){
       root=put((Comparable)key,value,root);
    }

    public void printInOrder(BST node){
    	if(node==null) return;
    	else{
    		printInOrder(node.left);
    		System.out.print(node.label);
    		System.out.println(node.val);
    		printInOrder(node.right);
    	}
    }  

    private V get(Comparable key, BST node) {
    if (node == null)
      return null;
    else if (key.compareTo(node.label) < 0)
      return get(key, node.left);
    else if (key.compareTo(node.label) > 0)
      return get(key, node.right);
    //else 
      return (V)node.val;
  }

  private BST put(Comparable key, V value, BST node) {
    if (node == null)
      return new BST(key, value);
    else if (key.compareTo(node.label) < 0)
      node.left = put(key, value, node.left);
    else if (key.compareTo(node.label) > 0)
      node.right = put(key, value, node.right);
    else {
      node.label = key;
      node.val = value;
    }
    
    return node;
  }
  


}
