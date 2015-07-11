public class Board{
   
   public static void main(String[] args) {
     
      	StdDrawPlus.setXscale(0, N);
        StdDrawPlus.setYscale(0, N);

   	
   }
   private Piece p[][]=new Piece[N][N];
   private String s;
   private boolean isFire;
   private int N=8;
   private Piece Selection=null;

   public Board(boolean shouldBeEmpty){
   	  
      if(shouldBeEmpty ==false){
        createBoard();
      } else{
        createEmpty();
      }
    }

   private void createBoard(){
      for (int i=0; i<N; i++){
        for(int j=0; j<N; j++){
          if((i+j) %2 ==0){
            StdDrawPlus.setPenColor(StdDrawPlus.GRAY);
            StdDrawPlus.filledSquare(i +.5, j+ .5, .5);
            switch(j){
              case 0: 
                StdDrawPlus.picture(i+ .5, j+.5, "img/pawn-fire.png",1,1);
                s="Pawn";
                isFire=true;
                p[i][j]=new Piece(isFire,this,i,j,s);
                break;
              case 1:
                StdDrawPlus.picture(i+ .5, j+.5, "img/shield-fire.png",1,1);
                s="Shield";
                isFire=true;
                p[i][j]=new Piece(isFire,this,i,j,s);
                break;
              case 2:
                StdDrawPlus.picture(i+ .5, j+.5, "img/bomb-fire.png",1,1);
                s="Bomb";
                isFire=true;
                p[i][j]=new Piece(isFire,this,i,j,s);
                break;
              case 5:
                StdDrawPlus.picture(i+ .5, j+.5, "img/bomb-water.png",1,1);
                s="Bomb";
                isFire=false;
                p[i][j]=new Piece(isFire,this,i,j,s);
                break;
              case 6:
                StdDrawPlus.picture(i+ .5, j+.5, "img/shield-water.png",1,1);
                s="Shield";
                isFire=false;
                p[i][j]=new Piece(isFire,this,i,j,s);
                break;
              case 7:
                StdDrawPlus.picture(i+ .5, j+.5, "img/pawn-water.png",1,1);
                s="Pawn";
                isFire=false;
                p[i][j]=new Piece(isFire,this,i,j,s);
                break;
              default:
                p[i][j]=null;
                break;
            }
          }else{
            StdDrawPlus.setPenColor(StdDrawPlus.RED);
            StdDrawPlus.filledSquare(i +.5, j+ .5, .5);
            p[i][j]=null;
          }
            
          StdDrawPlus.setPenColor(StdDrawPlus.WHITE);
        }
      }
    }

   private void createEmpty(){
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
          if ((i + j) % 2 == 0) StdDrawPlus.setPenColor(StdDrawPlus.GRAY);
          else                  StdDrawPlus.setPenColor(StdDrawPlus.RED);
          StdDrawPlus.filledSquare(i + .5, j + .5, .5);
          tdDrawPlus.setPenColor(StdDrawPlus.WHITE);
      }
    }
  }
 

   public Piece PieceAt(int x,int y){
     for(int i=0;i<N;i++){
      for(int j=0;j<N;j++){
     	 return p[i][j];
     	}
     }
   }
   

   public boolean canSelect(int x,int y){
    if (PieceAt(x,y)!=null){
   	 if(Selection==null || hasMove()==false){
      return true;
     }
    } else{
      if(Selection!=null && hasMove()==false){
        if((x==Selection.x-1 || x==Selection.x+1)||(y==Selection.y-1 || y==Selection.y+1)){
          return true;
        }
      }
    }
      
   }

   private boolean hasMove(){
     if(Selection!=null)
   }

   public void select(int x, int y){
    while(canSelect(x,y) == true){
      if()
    }

   }

   public void place(Piece p, int x, int y){
    if(outBound(x,y)|| p==null){
      return;
    } else{
      changeColor(x,y);
      StdDrawPlus.picture(x+ .5, y+.5, LinkName(p),1,1);
      p[x][y]=p;
    }

  }
   

   private String LinkName(Piece p){
    String link;
    if(p.isFire){
      if(p.type.equals(Pawn)){
        link="img/pawn-fire.png";
      } else if (p.type.equals(Shield)){
        link="img/shield-fire.png";
      } else if (p.type.equals(Bomb)){
        link="img/bomb-fire.png";

      }
    }else{
      if(p.type.equals(Pawn)){
        link="img/pawn-water.png";
      } else if (p.type.equals(Shield)){
        link="img/shield-water.png";
      } else if (p.type.equals(Bomb)){
        link="img/bomb-water.png";

      }

    }

    return link;
   }

   private boolean isGray(int x, int y){
    if((x+y) %2 ==0){
      return true;
    } else{
      return false;
    }
   }

   private void changeColor(int x, int y){
     if(isGray(x,y)){
      StdDrawPlus.setPenColor(StdDrawPlus.GRAY);
      StdDrawPlus.filledSquare(i +.5, j+ .5, .5);
    } else{
      StdDrawPlus.setPenColor(StdDrawPlus.RED);
        StdDrawPlus.filledSquare(i +.5, j+ .5, .5);
    }

   }

   public Piece remove(int x,int y){
     if(outBound){
      System.out.println("The position is out of bound.");
      return null;
     } else if(PieceAt(x,y)==null){
      System.out.println("No piece to remove, choose a new one.");
      return null;
     } else{
      changeColor(x,y);
      return PieceAt(x,y);
     }
   }

  private boolean outBound(int x,int y){
    if (x>7 || x<0 ||y>7 ||y<0){
      return true;
    } else{
      return false;
    }
  }

   public boolean canEndTurn(){
     if(hasMove()||Selection.hasCaptured()){
      return true;
     }
     return false;
   }

   public void endTurn(){
    if(canEndTurn){
      Selection=null;
      hasMove()=false;

    }

   }

   public String winner(){}

*/
}