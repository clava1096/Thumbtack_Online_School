package net.thumbtack.school.matrix;

import java.util.*;

public class MatrixNonSimilarRows {

    int[][] matrix;

    public MatrixNonSimilarRows(int[][] matrix){
        this.matrix = matrix;
    }

    public List<int[]> getNonSimilarRows() {
        Map<Set<Integer>, int[]> NonSimilarRows = new HashMap<>();
        for (int[] ints : matrix) {
            Set<Integer> set = new HashSet<>();
            for (int anInt : ints) {
                set.add(anInt);
            }
            NonSimilarRows.put(set,ints);
        }
        return new ArrayList<>(NonSimilarRows.values());
    }
}