import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;

/** ULLMapTest. You should write additional tests.
 *  @author Josh Hug
 */

public class ULLMapTest {
    @Test
    public void testBasic() {
        ULLMap<String, String> um = new ULLMap<String, String>();

        um.put("1", "2");

        assertTrue(um.containsKey("1"));
        assertEquals(um.get("1"), "2");
    }

    
   @Test
    public void testIterator() {
        ULLMap<Integer, String> um = new ULLMap<Integer, String>();
        um.put(0, "zero");
        um.put(1, "one");
        um.put(2, "two");
        Iterator<Integer> umi = um.iterator();
        System.out.println(umi.next());
        System.out.println(umi.next());
        System.out.println(umi.next());

        ULLMap<String, Integer> nm=ULLMap.InvertMap(um);
        Iterator<String> nmi = nm.iterator();
        System.out.println(nmi.next());
        System.out.println(nmi.next());
        System.out.println(nmi.next());
    }
    

    /** Runs tests. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(ULLMapTest.class);
    }
} 