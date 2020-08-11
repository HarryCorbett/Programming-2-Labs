import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.recursion.PalindromeChecker;

class KPalindrome implements PalindromeChecker {

    @Override
    public boolean isKPalindrome(String s, int i) {

        if (s.length() <= 1) {
            return true;
        }

        if(s.charAt(0) == s.charAt(s.length() - 1)) {

            return isKPalindrome(s.substring(1, s.length() - 1),i);
        }

        if (i == 0) {
            return false;
        }

        // If the character at the start and end are different try removing each of them (separately)
        return isKPalindrome(s.substring(0, s.length() - 1), i - 1) || isKPalindrome(s.substring(1), i - 1);
    }
}

