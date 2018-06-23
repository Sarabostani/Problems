
public class ValidNumber {
    public static void run() {
        System.out.println(isNumber(""));
        System.out.println(isNumber("+0"));
        System.out.println(isNumber(".e1"));
        System.out.println(isNumber("-1.e1"));
        System.out.println(isNumber(". "));
        System.out.println(isNumber("e9"));
        System.out.println(isNumber(" 0.1 "));
        System.out.println(isNumber("abc"));
        System.out.println(isNumber("1 a"));
        System.out.println(isNumber("2e10"));
        System.out.println(isNumber("--+"));
        System.out.println(isNumber("-"));
        System.out.println(isNumber(" -."));
    }

    private static boolean isNumber(String s) {

        String num = s.trim();

        if (num.isEmpty() || num.contains(" ") || num.equals(".") || num.equals("e")) {
            return false;
        }

        if (isWholeNumber(num) || isFloatingPointNumber(num)) {
            return true;
        }

        else if (num.contains("e")) {
            return isFloatingPointNumber(num.substring(0, num.indexOf("e")))
                    && isWholeNumber(num.substring(num.indexOf("e") + 1));
        }

        return false;

    }

    private static boolean isWholeNumber(String s) {
        if (s.isEmpty() || s.contains(" ") || s.equals(".") || s.equals("e")) {
            return false;
        }
        char[] num = s.toCharArray();
        if (num.length == 1 && !isNumber(num[0])) {
            return false;
        }
        for (int i = 0; i < num.length; i++) {
            if (!isNumber(num[i])) {
                return false;
            }

            if (i == 0 && (num[i] == '-' || num[i] == '+')) {
                continue;
            }
        }
        return true;
    }

    private static boolean isFloatingPointNumber(String s) {
        if (s.isEmpty() || s.contains(" ") || s.equals(".") || s.equals("e")) {
            return false;
        }
        boolean decimal = false;
        char[] num = s.toCharArray();
        if (num.length == 1 && !isNumber(num[0])) {
            return false;
        }
        for (int i = 0; i < num.length; i++) {
            if (i == 0 && (num[i] == '-' || num[i] == '+')) {
                continue;
            }

            if (num[i] != '.' && !isNumber(num[i])) {
                return false;
            }
            if (num[i] == '.') {
                if (decimal) {
                    return false;
                }
                decimal = true;
            }
        }

        return true;
    }

    private static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
}
