package net.thumbtack.school.introduction;

import java.nio.IntBuffer;

public class FirstSteps {
    public int sum(int a, int b) {
        return a + b;
    }

    public int mul(int x, int y) {
        return x * y;
    }

    public int div(int x, int y) {
        return x / y;

    }


    public int mod(int x, int y) {
        int c = x % y;
        return c;
    }

    public boolean isEqual(int x, int y) {
        if (x == y) {
            return true;
        } else {
            return false;
        }

    }


    public boolean isGreater(int x, int y) {
        if (x > y) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
        if (xLeft <= x && x <= xRight && yTop <= y && y <= yBottom) {
            return true;
        } else {
            return false;
        }

    }


    public int sum(int[] array) {
        int s = 0;
        for (int x = 0; x < array.length; x++) {
            s += array[x];
        }
        return s;

    }

    public int mul(int[] array) {
        int s = 1;
        for (int x = 0; x < array.length; x++) {
            s *= array[x];
        }
        if (array.length == 0) {
            return 0;
        }
        return s;
    }


    public int min(int[] array) {
        if (array.length == 0) {
            return Integer.MAX_VALUE;
        } else {
            int min = array[0];
            for (int x = 0; x < array.length; x++) {
                if (array[x] < min) {
                    min = array[x];
                }
            }
            return min;
        }
    }


    public int max(int[] array) {
        if (array.length == 0) {
            return Integer.MIN_VALUE;
        }
        int max = array[0];
        for (int x = 0; x < array.length; x++) {
            if (array[x] > max) {
                max = array[x];
            }
        }
        return max;
    }

    public double average(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        float avgr = 0;
        for (int x = 0; x < array.length; x++) {
            avgr += array[x];

        }
        avgr /= array.length;
        return avgr;
    }

    public boolean isSortedDescendant(int[] array) {

        if (array.length == 0 || array.length == 1) {
            return true;
        }
        int a = array[0];
        boolean sort = false;
        for (int x = 0; x < array.length; x++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j] < array[j - 1]) {
                    sort = true;
                } else {
                    sort = false;
                }

            }
        }
        return sort;
    }

    public void cube(int[] array) {
        for (int x = 0; x < array.length; x++) {
            array[x] *= array[x] * array[x];
        }
    }


    public boolean find(int[] array, int value) {
        boolean sort = false;
        for (int x = 1; x < array.length; x++) {
            if (array[x] == value) {
                sort = true;
            }
        }
        return sort;
    }

    public void reverse(int[] array) {
        int[] arrayResult1 = array;
        for (int x = 0; x < array.length / 2; x++) {
            int temp = array[x];
            array[x] = array[array.length - 1 - x];
            array[array.length - 1 - x] = temp;
        }
    }

    public boolean isPalindrome(int[] array) {
        int[] arrayResult1 = array;
        boolean sort = false;
        if (array.length == 0 || array.length == 1) {
            return true;
        }
        for (int x = 0; x < array.length / 2; x++) {
            int temp = array[x];
            array[x] = array[array.length - 1 - x];
            array[array.length - 1 - x] = temp;
            if (temp == array[x]) {
                sort = true;
            } else {
                sort = false;
                break;
            }
        }
        return sort;
    }

    public int sum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public int max(int[][] matrix) {
        if (matrix.length == 1) {
            return Integer.MIN_VALUE;
        }
        int max = matrix[0][0];
        for (int x = 0; x < matrix.length; x++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[x][j] > max) {
                    max = matrix[x][j];
                }
            }
        }
        return max;
    }

    public int diagonalMax(int[][] matrix) {
        if (matrix.length == 1) {
            return Integer.MIN_VALUE;
        }
        int max = matrix[0][0];
        int j = 0;
        for (int x = 0; x < matrix.length; x++) {
            j=x;
                if (matrix[x][j] > max) {
                    max = matrix[x][j];
                }
        }
        return max;
    }

    public boolean isSortedDescendant(int[][] matrix) {
        boolean sort = false;

        for (int i =0; i <matrix.length; i++) {
            sort = isSortedDescendant(matrix[i]);
            if (sort == false) {
                break;
            }
        }
        return sort;
    }
}