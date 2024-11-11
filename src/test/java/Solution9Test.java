import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Solution9Test {

    @Test
    public void testPossibleBipartition_Example1() {
        Solution9 solution = new Solution9();
        int n = 4;
        int[][] dislikes = {{1, 2}, {3, 4}, {2, 3}};
        boolean result = solution.possibleBipartition(n, dislikes);
        assertTrue(result);
    }

    @Test
    public void testPossibleBipartition_Example2() {
        Solution9 solution = new Solution9();
        int n = 3;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 3}};
        boolean result = solution.possibleBipartition(n, dislikes);
        assertTrue(result);
    }

    @Test
    public void testPossibleBipartition_EmptyDislikes() {
        Solution9 solution = new Solution9();
        int n = 5;
        int[][] dislikes = {};
        boolean result = solution.possibleBipartition(n, dislikes);
        assertTrue(result);
    }

    @Test
    public void testPossibleBipartition_SingleNode() {
        Solution9 solution = new Solution9();
        int n = 1;
        int[][] dislikes = {};
        boolean result = solution.possibleBipartition(n, dislikes);
        assertTrue(result);
    }

    @Test
    public void testPossibleBipartition_DisconnectedGraph() {
        Solution9 solution = new Solution9();
        int n = 6;
        int[][] dislikes = {{1, 2}, {3, 4}, {5, 6}};
        boolean result = solution.possibleBipartition(n, dislikes);
        assertTrue(result);
    }

    @Test
    public void testPossibleBipartition_ComplexGraph() {
        Solution9 solution = new Solution9();
        int n = 8;
        int[][] dislikes = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 8}, {1, 4}, {2, 5}, {3, 6}};
        boolean result = solution.possibleBipartition(n, dislikes);
        assertTrue(result);
    }
}