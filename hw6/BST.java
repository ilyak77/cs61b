class BST<Comparable,V>{
	public Comparable label;
	public V val;
	public BST left, right;
	

	/** A leaf node with given LABEL 
	public BST(K label) { 
		this(label, null,null, null); 
	}*/

		/** A leaf node with given LABEL */
	public BST(Comparable label,V val) { 
		this.label=label;
		this.val=val;
		left=null;
		right=null; 
	}
}
	/*

	/** Fetch the label of this node. 
	public K label(){
		return this.label;
	}

	/** Fetch the left (right) child of this. 
	public BST left(){
		return this.left;
	}

	public BST right(){
		return this.right;
	}

	/** The highest node in T that contains the
    * label L, or null if there is none. 
    public BST find(BST T, K L) {
    	int t=L.comparTo(T.label);
    	if (T == null || t==0)
            return T;
        else if (t<0)
            return find(T.left, L);
        else return find(T.right, L);
    }


    /** True iff label L is in T. 
    public boolean isIn(BST T, K L){ 
    	return find (T, L) != null; 
    }



    public BST insert(BST T, K L){
    	int t=L.comparTo(T.label);
    	if (T == null)
           return new BST(L, null, null,null);
        if (t<0)
          T.left = insert(T.left, L);
        if (t>0)
          T.right = insert(T.right, L);
        return T;
    }

    public BST insert(BST T, K L,V value){
    	int t=L.comparTo(T.label);
    	if (T == null)
           return new BST (L, value, null,null);
        if (t<0)
          T.left = insert(T.left, L);
        if (t>0)
          T.right = insert(T.right, L);
        return T;
    }
*/
/** Delete the instance of label L from T that is closest to
* to the root and return the modified tree. The nodes of
* the original tree may be modified. 
public BST remove(BST T, K L){
	int t=L.comparTo(T.label);
	if (T == null)
       return null;
    if (t<0)
       T.left = remove(T.left, L);
    else if (t>0)
       T.right = remove(T.right, L);
      // Otherwise, we’ve found L
    else if (T.left == null)
      return T.right;
    else if (T.right == null)
      return T.left;
      else
      T.right = swapSmallest(T.right, T);
     return T;

}

 private BST swapSmallest(BST T, BST R) {
   if (T.left == null) {
      R.label = T.label;
      return T.right;
    } else {
      T.left = swapSmallest(T.left, R);
      return T;
    }
  }*/
/* This constructor is private to force all BST creation
* to be done by the insert method. 
 private BST(K label, V value,BST left, BST right) {
    this.label = label;
    this.val=value; 
    this.left = left; 
    this.right = right;
 }

*/

