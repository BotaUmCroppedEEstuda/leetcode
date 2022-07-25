package shift2dgrid;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Shift2DGridSolutionKaren {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        List<List<Integer>> newGrid = new ArrayList<>();

        Deque<Integer> auxQueue = new LinkedList<>();
        for (int[] line : grid) {
            for (int element : line) {
                auxQueue.add(element);
            }
        }
        while (k != 0) {
            if (k < 0) {
                auxQueue.addLast(auxQueue.pollFirst());
                k++;
            } else {
                auxQueue.addFirst(auxQueue.pollLast());
                k--;
            }
        }
        for (int line = 0; line < grid.length; line++) {
            List<Integer> returnLines = new ArrayList<>();
            for (int column = 0; column < grid[line].length; column++) {
                returnLines.add(auxQueue.pollFirst());
            }
            newGrid.add(returnLines);
        }
        return newGrid;
    }
}
