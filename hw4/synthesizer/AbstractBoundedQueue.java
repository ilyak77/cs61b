package synthesizer;


public abstract class AbstractBoundedQueue implements BoundedQueue{
  protected int fillCount;
  protected int capacity;

  @Override
  public int capacity(){
    return capacity;
  }

  @Override
  public int fillCount(){
    return fillCount;
  }

  @Override
  public boolean isEmpty(){
  	if(fillCount==0) return true;
  	return false;
  }

  @Override
  public boolean isFull(){
  	if(fillCount==capacity) return true;
  	return false;
  }

}