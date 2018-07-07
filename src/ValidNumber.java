public class ValidNumber {
    public static void run() {
        System.out.println(isNumber("") == false);
        System.out.println(isNumber("+0") == true);
        System.out.println(isNumber(".e1") == false);
        System.out.println(isNumber("-1.e1") == true);
        System.out.println(isNumber("-2.e-3") == true);
        System.out.println(isNumber(". ") == false);
        System.out.println(isNumber("e9") == false);
        System.out.println(isNumber(" 0.1 ") == true);
        System.out.println(isNumber("abc") == false);
        System.out.println(isNumber("1 a") == false);
        System.out.println(isNumber("2e10") == true);
        System.out.println(isNumber("--+") == false);
        System.out.println(isNumber("-") == false);
        System.out.println(isNumber(" -.") == false);
        System.out.println(isNumber(".2") == true);
        System.out.println(isNumber("te1") == false);
        System.out.println(isNumber(".-4") == false);
        System.out.println(isNumber("+.8") == true);
        System.out.println(isNumber("2e-") == false);
        System.out.println(isNumber("e0") == false);
    }

    private static boolean isNumber(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return false;
        }
        
        char[] num = s.toCharArray();
        
        boolean dec = false, exp = false, digit = false;
        
        int indexOfE = -1;
        
        for (int i = 0; i < num.length; i++) {
            // skip the sign at the beginning
            if ((i == 0 || i == indexOfE + 1 ) && (num[i] == '-' || num[i] == '+')){
                continue;
            }
            
            // return false for anything but digits, e, and '.'
            if (!Character.isDigit(num[i]) && num[i] != 'e' && num[i] != '.') {
                return false;
            }
            
            if (Character.isDigit(num[i])) {
                digit = true;
                continue;
            }
            
            if (num[i] == '.') {
                if (dec || exp) {
                    return false;
                }
                dec = true;
                continue;
            }
            
            if (num[i] == 'e') {
                if (exp || !digit) {
                    return false;
                }
                exp = true;
                digit = false;
                indexOfE = i;
                continue;
            }
            
            
        }
        
        if ( (dec && !digit) || (exp && !digit) || !digit) {
            return false;
        }
        
        return true;
    }

}
