package net.thumbtack.school.matrix;

import java.util.*;

public class MatrixNonSimilarRows {

    int[][] matrix;

    public MatrixNonSimilarRows(int[][] matrix){
        this.matrix = matrix;
    }

    public List<int[]> getNonSimilarRows() {
        List<Set> NonSimilarRows = new ArrayList<>();
        for (int[] ints : matrix) {
            Set<Integer> sets = new HashSet<>();
            for (int anInt : ints) {
                sets.add(anInt);
            }
            NonSimilarRows.add(sets);
        }
        List<int[]> NN1 = new ArrayList<>();
        int[] j = {};
        Set sets;
        for(int i = 0; i < matrix.length; i++){
            sets = NonSimilarRows.get(i);
            for (int g = 0 ; g < NonSimilarRows.size(); g++){
                if (NonSimilarRows.contains(sets)){
                    j = matrix[NonSimilarRows.lastIndexOf(sets)];
                }
            }
            if(!NN1.contains(j))NN1.add(j);
        }
        return NN1;
    }
}