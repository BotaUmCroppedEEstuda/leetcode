package palindromenumber;

public class PalindromeNumberSolutionLeticia {
    public boolean isPalindrome(int x) {
        String number = String.valueOf(x);
        String numberInvertido = new StringBuilder(number).reverse().toString();

        return number.equals(numberInvertido);
    }
}
