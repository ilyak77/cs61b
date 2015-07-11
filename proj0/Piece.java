public class Piece{

public boolean isFire1;
public Board b1;
public int x1;
public int y1;
public String type1;
private boolean isKing;

public Piece(boolean isFire, Borad b, int x, int y, String type){
   isFire1=isFire;
   b1=b;
   x1=x;
   y1=y;
   type1=type;

}

public boolean isFire(){
	return isFire1;
}

public int side(){
	if (isFire1==true){
		return 0;
	} else{
		return 1;
	}
}

public boolean isKing(){
	return isKing;	
}

public boolean isBomb(){
	if (type1.equals("Bomb")){
		return true;
	} else{
		return false;
	}
}

public boolean isShield(){
	if (type1.equals("Shield")){
		return true;
	} else{
		return false;
	}
}
/*
public void move(int x, int y){

}
*/


public boolean hasCaptured(){
	if()
}

public void doneCapturing(){

}




}