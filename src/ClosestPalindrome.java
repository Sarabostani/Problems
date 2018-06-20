
public class ClosestPalindrome {
    public static void Run() {
        var input = "807045053224792883";
        System.out.println(String.format("Is '%s' palindrome: %s", input, isPalindrome(input)));
        System.out.println(String.format("Closes palindrome to '%s' is: %s", input, closestPalindrome(input)));
    }

    private static String closestPalindrome(String input) {

        Long value = Long.parseLong(input);
        int boundary = 1;
        String candidate = input;

        while (boundary <= value) {
            candidate = String.valueOf(value - boundary);
            if (isPalindrome(candidate)) {
                break;
            }
            candidate = String.valueOf(value + boundary);
            if (isPalindrome(candidate)) {
                break;
            }
            boundary++;
        }

        return candidate;
    }

    private static boolean isPalindrome(String input) {
        for (int i = 0, j = input.length() - 1; i < input.length() / 2; i++, j--) {
            if (input.charAt(i) != input.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
