import org.junit.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class DAGSortTest {

    /**
     * test to check the correct output array is returned
     */
    @Test
    public void testSort() throws CycleDetectedException, InvalidNodeException {
        int[][] edges = {{3}, {3, 4}, {4, 7}, {5, 6, 7}, {6}, {}, {}, {}};

        assertTrue(checkValidSolution(DAGSort.sortDAG(edges), edges), "The output array is not correctly sorted or may not contain all the given vertices");
    }

    /**
     * checks  that for every directed edge uv from vertex u to vertex v, u comes before v in the ordering.
     *
     * @param result sorted array
     * @param edges  2d array the sorted result was created from representing the graph
     * @return true if a valid ordering
     */
    private boolean checkValidSolution(int[] result, int[][] edges) {

        boolean valid = true;

        // Checking that that for every directed edge uv from vertex u to vertex v, u comes before v in the ordering.
        for (int i : result) {

            for (int j : result) {

                if (j > i) {

                    List<int[]> list = Collections.singletonList(edges[j]);

                    if (list.contains(i)) {
                        valid = false;
                        break;
                    }
                }
            }
        }

        // Check all vertices are included in the result
        for (int i = 0; i < edges.length; i++) {

            if (!Arrays.toString(result).contains(Integer.toString(i))) {
                valid = false;
                break;
            }
        }

        return valid;
    }

    /**
     * test to check the output array is the correct length (no vertices missed)
     */
    @Test
    public void testSortLength() throws CycleDetectedException, InvalidNodeException {
        int[][] edges = {{3}, {3, 4}, {4, 7}, {5, 6, 7}, {6}, {}, {}, {}};

        assertEquals(8, DAGSort.sortDAG(edges).length, "Check that your DAGSort is not missing vertices in its output");
    }

    /**
     * test to check a CycleDetectedException is thrown when a cycle is given in the parameter
     */
    @Test
    public void testCycle() {
        int[][] edges = {{1}, {0}};
        assertThrows(CycleDetectedException.class, () -> DAGSort.sortDAG(edges), "A CycleDetectedException should have been thrown as the test input contained a cycle");
    }

    /**
     * Test to check a NullPointerException is thrown when null is given as the parameter
     */
    @Test
    public void testNull() {
        assertThrows(NullPointerException.class, () -> DAGSort.sortDAG(null), "A NullPointerException should be thrown when null is given as a parameter");
    }

    /**
     * Test to check a InvalidNodeException is thrown
     */
    @Test
    public void testInvalidNode() {
        int[][] edges = {{5}, {1}};

        assertThrows(InvalidNodeException.class, () -> DAGSort.sortDAG(edges), "A InvalidNodeException should have been given as the input contained an edge not labelled from 0 to (edges.length - 1)");
    }

}
