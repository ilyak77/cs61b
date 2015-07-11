package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
       synthesizer.ArrayRingBuffer arb = new synthesizer.ArrayRingBuffer(5);
       arb.enqueue(1);
       assertEquals(1,arb.peak(),0);
        
       arb.enqueue(3);
       assertEquals(1,arb.peak(),0);
       
       arb.dequeue();
       assertEquals(3,arb.peak(),0);

    }
   
    /** Calls tests for ArrayRingBuffer. */
  public static void main(String[] args) {
      jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
 
} 