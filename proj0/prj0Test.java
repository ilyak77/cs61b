import org.junit.Test;
import static org.junit.Assert.*;
public class prj0Test {
    

    @Test
    public void testMethod(){
        Piece p=new Piece(true,1,1,"Bomb");
        assertTrue(p.isFire());
        assertEquals(0,p.side());
        assertTrue(p.isBomb());

        p.type1="Shield";
        assertTrue(p.isShield());
    }

public static void main(String... args) {
    jh61b.junit.textui.runClasses(prj0Test.class);
}

}
