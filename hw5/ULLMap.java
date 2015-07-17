import java.util.Set; 
import java.util.NoSuchElementException;
import java.util.Iterator;
import java.util.HashSet;

public class ULLMap<K,V> implements  Map61B<K,V> , Iterable<K>{ 
   
    private Entry front;
    private int N;

    public Iterator<K> iterator(){
        return new ULLMapIter();
    }

    private class ULLMapIter implements Iterator<K>{
      //  front=new()
        private Entry e=front;

        public boolean hasNext(){
            return (e.next!=null);
        }

        public K next(){
            
            if(e==null) return null;
            
            K key=e.key; 
            e=e.next;
            
            return key;
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    private class Entry {
    
        private K key; 
        private V val; 
        private Entry next;
        
        public Entry(K k,V v, Entry n) { 
            key = k;
            val = v;
            next = n;
        }

        public Entry get(K k) { 
            if(this.key.equals(k)) return this;
            return null; 
        }

        public K getKey(){
            return this.key;
        }

        public V getValue(){
            return this.val;
        }

    }

    @Override
    public V get(K key) {
        for(Entry e=front; e!=null; e=e.next){
            if(key.equals(e.key)) return e.val;
        }
        return null; 
    }

    @Override
    public void put(K key, V val) { 
        for(Entry e=front; e!=null; e=e.next){
            if(key.equals(e.key)){
                e.val=val;
                return;
            }
        }
        front =new Entry(key,val,front);

        //front.next=new Entry(key,val,null);
        N++;
    }


    @Override
    public boolean containsKey(K key) {
        return get(key) !=null;
    }

    @Override
    public int size() {
        return N; 
    }

    @Override
    public void clear() {
       for(Entry e=front; e!=null; e=e.next){
            e=null;
        }
    
    }


 
    /* Methods below are all challenge problems. Will not be graded in any way. 
     * Autograder will not test these. */
    @Override
    public V remove(K key) { //FIX ME SO I COMPILE
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) { //FIX ME SO I COMPILE
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<K> keySet() { //FIX ME SO I COMPILE
        //throw new UnsupportedOperationException();
        Set<K> keyset=new HashSet<K>();
        for(Entry e=front; e!=null; e=e.next){
            keyset.add(e.key);
        }
        return keyset;
    }

   
    public static <V,K> ULLMap<V,K> InvertMap(ULLMap<K,V> map){

        ULLMap<V,K> invertMap=new ULLMap<V,K>();

        for(K key:map.keySet()){
            V val=map.get(key);
            invertMap.put(val,key);
        }
        return invertMap;
    }

}



















