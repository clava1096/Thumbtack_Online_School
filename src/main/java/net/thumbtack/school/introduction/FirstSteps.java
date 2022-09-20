package net.thumbtack.school.introduction;

import java.util.Arrays;

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
        return x % y;
    }

    public boolean isEqual(int x, int y) {
        return x == y;
    }


    public boolean isGreater(int x, int y) {
        return x > y;
    }

    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
        return xLeft <= x && x <= xRight && yTop <= y && y <= yBottom;

    }


    public int sum(int[] array) {
        int s = 0;
        for (int elem : array) {
            s += elem;
        }
        return s;

    }

    public int mul(int[] array) {
        int s = 1;
        for (int elem : array) {
            s *= elem;
        }
        if (array.length == 0) {
            return 0;
        }
        return s;
    }


    public int min(int[] array) {
        if (array.length == 0) {
            return Integer.MAX_VALUE;
        }
        Arrays.sort(array);
        return array[0];
    }


    public int max(int[] array) {
        if (array.length == 0) {
            return Integer.MIN_VALUE;
        }
        int max = array[0];
        for (int i : array) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public double average(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        float avrg = 0;
        avrg = sum(array);
        avrg /= array.length;
        return avrg;
    }

    public boolean isSortedDescendant(int[] array) {

        if (array.length == 0 || array.length == 1) {
            return true;
        }
        boolean sort = false;
        for (int j = 1; j < array.length; j++) {
            if (array[j] < array[j - 1]) {
                sort = true;
            } else {
                return false;
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
        for (int elem : array) {
            if (elem == value) {
                sort = true;
                break;
            }
        }
        return sort;
    }

    public void reverse(int[] array) {
        for (int x = 0; x < array.length / 2; x++) {
            int temp = array[x];
            array[x] = array[array.length - 1 - x];
            array[array.length - 1 - x] = temp;
        }
    }

    public boolean isPalindrome(int[] array) {
        int [] arrayreverse = Arrays.copyOf(array, array.length);
        reverse(arrayreverse);
        return Arrays.equals(array, arrayreverse);
    }

    public int sum(int[][] matrix) {
        int sum = 0;
        for (int[] elem : matrix) {
            sum += sum(elem);
        }
        return sum;
    }

    public int max(int[][] matrix) {
        if (matrix.length == 1) {
            return Integer.MIN_VALUE;
        }
        int max = matrix[0][0];
        for (int[] elem : matrix) {
            if (max(elem) > max) {
                max = max(elem);
            }
        }
        return max;
    }

    public int diagonalMax(int[][] matrix) {
        if (matrix.length == 1) {
            return Integer.MIN_VALUE;
        }
        int max = matrix[0][0];
        for (int x = 0; x < matrix.length; x++) {
                if (matrix[x][x] > max) {
                    max = matrix[x][x];
                }
        }
        return max;
    }

    public boolean isSortedDescendant(int[][] matrix) {
        boolean sort = false;
        for (int[] ints : matrix) {
            sort = isSortedDescendant(ints);
            if (!sort) {
                return false;
            }
        }
        return sort;
    }
}