package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeRemove() {
        AListNoResizing<Integer> NList = new AListNoResizing<>();
        BuggyAList<Integer> BList = new BuggyAList<>();

        NList.addLast(4);
        NList.addLast(5);
        NList.addLast(6);

        BList.addLast(4);
        BList.addLast(5);
        BList.addLast(6);

        assertEquals(NList.size(), BList.size());
        assertEquals(NList.removeLast(), BList.removeLast());
        assertEquals(NList.removeLast(), BList.removeLast());
        assertEquals(NList.removeLast(), BList.removeLast());
    }

    @Test
    public void randomizedTestOne() {
        AListNoResizing<Integer> L = new AListNoResizing<>();

        int N = 500;
        for (int i = 0; i < N; i++) {
            int operationNumber = StdRandom.uniform(0, 2);
            if (operationNumber == 0) {
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                int size = L.size();
                System.out.println("size: " + size);
            }
        }
    }

    @Test
    public void randomizedTestTwo() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i++) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                int randVal = StdRandom.uniform(0, 100);
                correct.addLast(randVal);
                broken.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                if (correct.size() == 0) {
                    System.out.println("Empty correct list!!!");
                    continue;
                }
                if (broken.size() == 0) {
                    System.out.println("Empty broken list!!!");
                    continue;
                }
                int move1 = correct.removeLast();
                int move2 = broken.removeLast();
                assertEquals(move1, move2);
                System.out.println("The number " + move1 + " and " + move2
                        + " in " + "correct and broken" + " removed");
            } else if (operationNumber == 2) {
                assertEquals(correct.size(), broken.size());
            System.out.println("size: " + correct.size());
            } else System.out.println("Empty list!!!");
        }
    }
}
