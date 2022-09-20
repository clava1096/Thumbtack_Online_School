package net.thumbtack.school.base;

import java.util.StringJoiner;

public class StringOperations {

    public static int getSummaryLength(String[] strings){
        int sum = 0;
        for (String string : strings) {
            sum += string.length();
        }
        return sum;
    }

    public static String getFirstAndLastLetterString(String string){
        return string.toCharArray()[0]+""+string.toCharArray()[string.length()-1];
    }

    public static boolean isSameCharAtPosition(String string1, String string2, int index){
        return (string1.toCharArray()[index]==string2.toCharArray()[index]);
    }

    public static boolean isSameFirstCharPosition(String string1, String string2, char character) {
        return string1.indexOf(character) == string2.indexOf(character);
    }

    public static boolean isSameLastCharPosition(String string1, String string2, char character){
        int len = Math.min(string1.length(), string2.length());
        return string1.lastIndexOf(character) == string2.indexOf(character);
    }

    public static boolean isSameFirstStringPosition(String string1, String string2, String str){
        return string1.indexOf(str) == string2.indexOf(str);
    }

    public static boolean isSameLastStringPosition(String string1, String string2, String str){
        return string1.lastIndexOf(str) == string2.lastIndexOf(str);
    }

    public static boolean isEqual(String string1, String string2){
        return string1.equals(string2);
    }

    public static boolean isEqualIgnoreCase(String string1, String string2){
        return string1.equalsIgnoreCase(string2);
    }

    public static boolean isLess(String string1, String string2){
        return (string1.compareTo(string2) < 0);
    }

    public static boolean isLessIgnoreCase(String string1, String string2){
        return (string1.compareToIgnoreCase(string2) < 0);
    }

    public static String concat(String string1, String string2){
        return string1.concat(string2);
    }

    public static boolean isSamePrefix(String string1, String string2, String prefix){
        return (string1.startsWith(prefix) && string2.startsWith(prefix));
    }

    public static boolean isSameSuffix(String string1, String string2, String suffix){
        return (string1.endsWith(suffix) && string2.endsWith(suffix));
    }

    public static String getCommonPrefix(String string1, String string2) {
        int j = 0;
        StringBuilder prefix= new StringBuilder();
        while(true){
            if (string1.length() > j & string2.length() > j) {
                if (string1.charAt(j) == string2.charAt(j)) {
                    prefix.append(string1.toCharArray()[j]);
                }
                if (j == 0 & string1.charAt(j) != string2.charAt(j)){
                    return prefix.toString();
                }
            }
            else{
                return prefix.toString();
            }
            j++;
        }
    }

    public static String reverse(String str){
        return new StringBuilder(str).reverse().toString();
    }

    public static boolean isPalindrome(String string){
        StringBuilder str = new StringBuilder(new StringBuilder(string).reverse().toString());
        return (str.toString().equals(string));
    }
    public static boolean isPalindromeIgnoreCase(String string){
        return (isPalindrome(string.toLowerCase()));
    }
    public static String getLongestPalindromeIgnoreCase(String[] strings){
        String mx = "";
        for(String elem : strings){
            if(isPalindromeIgnoreCase(elem) && mx.length() < elem.length()) mx=elem;
        }
        return mx;
    }

    public static boolean hasSameSubstring(String string1, String string2, int index, int length){
        if (length+index > string1.length() | length+index > string2.length()) return false;
        String substring1 = string1.substring(index,length+index);
        String substring2 = string2.substring(index,length+index);
        return substring1.equals(substring2);
    }
    public static boolean isEqualAfterReplaceCharacters (String string1, char replaceInStr1, char replaceByInStr1,
                                                         String string2, char replaceInStr2, char replaceByInStr2) {
        return string1.replace(replaceInStr1,replaceByInStr1).equals(string2.replace(replaceInStr2,replaceByInStr2));
    }

    public static boolean isEqualAfterReplaceStrings(String string1, String replaceInStr1, String replaceByInStr1,
                                                     String string2, String replaceInStr2, String replaceByInStr2){

        return string1.replace(replaceInStr1,replaceByInStr1).equals(string2.replace(replaceInStr2,replaceByInStr2));
    }

    public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String string){
        return isPalindromeIgnoreCase(string.replace(" ", ""));
    }

    public static boolean isEqualAfterTrimming(String str1, String str2) {
        return (str1.trim().equals(str2.trim()));
    }

    public static String makeCsvStringFromInts(int[] array){
        StringJoiner joiner = new StringJoiner(",");
        for (int j : array) {
            joiner.add(Integer.toString(j));
        }
        return joiner.toString();
    }

    public static String makeCsvStringFromDoubles(double[] array) {
        StringJoiner joiner = new StringJoiner(",");
        for (double v : array) {
            joiner.add(String.format("%.2f", v));
        }
        return joiner.toString();
    }

    public static StringBuilder makeCsvStringBuilderFromInts(int[] array){
        String str = makeCsvStringFromInts(array);
        return new StringBuilder(str);
    }

    public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array){
        String str = makeCsvStringFromDoubles(array);
        return new StringBuilder(str);
    }

    public static StringBuilder removeCharacters(String string, int[] positions){
        StringBuilder stringBuilder = new StringBuilder();
        int pos = 0;
        for (int i = 0; i <string.length(); i++) {
            if (i!=positions[pos])
                stringBuilder.append(string.toCharArray()[i]);
            else if (pos < positions.length-1) pos++;
        }
        return stringBuilder;
    }

    public static StringBuilder insertCharacters(String string, int[] positions, char[] characters){
        StringBuilder stringBuilder = new StringBuilder(string);
        for (int i = positions.length-1; i >= 0; i--) {
            if(string.toCharArray()[positions[i]] != characters[positions[i]]){
                stringBuilder.insert(positions[i], characters[i]);
            }
        }
        return stringBuilder;
    }

}
