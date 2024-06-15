import java.util.*;

class Lec4BasicMaths {

    public static int countDigits(int n) {
        // Solution 1: Time = O(log10(n)) or O(digits), Space = O(1)
        // int count = 0;
        // while (n > 0) {
        //     n /= 10;
        //     count++;
        // }
        // return count;

        // Solution 2: Time = O(log10(n)) or O(digits), Space = O(1)
        // return String.valueOf(n).length();
        
        // Solution 3: Time = O(1), Space = O(1)
        return (int) (Math.log10(n) + 1);
    }
    
    public static int reverseANumber(int n) {
        // Time = O(digits), Space = O(1)
        int reversedNumber = 0;
        while (n > 0) {
            reversedNumber = reversedNumber * 10 + n % 10;
            n /= 10;
        }
        return reversedNumber;
    }

    public static boolean isPalindrome(int n) {
        // Solution 1: Time = O(digits), Space = O(digits)
        // String str = String.valueOf(n);
        // int start = 0;
        // int end = str.length() - 1;
        // while(start < end) {
        //     if(str.charAt(start) != str.charAt(end)) {
        //         return false;
        //     }
        //     start++;
        //     end--;
        // }
        // return true;

        // Solution 2: Time = O(digits), Space = O(1)
        // int copyN = n;
        // int reversedN = 0;
        // while (copyN > 0) {
        //     reversedN = reversedN * 10 + copyN % 10;
        //     copyN /= 10;
        // }
        // return n == reversedN;
        
        // Solution 3: Time = O(digits/2), Space = O(1)
        if(n < 0 || (n != 0 && n % 10 == 0)) {
            return false;
        }
        int reversedN = 0;
        while (n > reversedN) {
            reversedN = (reversedN * 10) + (n % 10);
            n /= 10;
        }
        return (n == reversedN) || (n == reversedN / 10);
    }
    
    public static int GCD(int a, int b) {
        // Solution 1: Brute Force, Time = O(min(a, b)), Space = O(1)
        // int i = Math.min(Math.min(a, b), Math.abs(a - b));
        // while (i > 1) {
        //     if (a % i == 0 && b % i == 0) {
        //         return i;
        //     }
        //     i--;
        // }
        // return 1;
        
        // Solution 2: Euclidean Algorithm Time = O(log(min(a, b))), Space = O(1)
        while (a > 0 && b > 0) {
            if(a > b) {
                a %= b;
            } else {
                b %= a;
            }
        }
        return a == 0 ? b : a;
    }
    
    public static boolean isArmstrongNumber(int n) {
        // Time = O(digits), Space = O(1)
        int digits = (int) (Math.log10(n) + 1);
        int copyN = n;
        int sum = 0;
        while (copyN > 0) {
            sum += Math.pow(copyN % 10, digits);
            copyN /= 10;
        }
        return n == sum;
    }
    
    public static List<Integer> allDivisors(int n) {
        // Solution 1: Time = O(n), Space = O(m), where m = no of divisors
        // List<Integer> divisors = new ArrayList<>();
        // for (int i = 1; i <= n; i++) {
        //     if (n % i == 0) {
        //         divisors.add(i);
        //     }
        // }
        // return divisors;
        
        // Solution 2: Time = O(sqrt of n + mlogm), Space = O(m), where m = no of divisors
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if(n / i != i) {
                    divisors.add(n / i);
                }
            }
        }
        Collections.sort(divisors);
        return divisors;
    }
    
    public static boolean isPrime(int n) {
        // Time = O(sqrt of n), Space = O(1)
        boolean flag = true;
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        // System.out.println(countDigits(12345));
        // System.out.println(countDigits(123456789));
        // System.out.println(reverseANumber(12345));
        // System.out.println(reverseANumber(123000));
        // System.out.println(isPalindrome(12321));
        // System.out.println(isPalindrome(12320));
        // System.out.println(GCD(9, 12));
        // System.out.println(GCD(41, 500));
        // System.out.println(isArmstrongNumber(153));
        // System.out.println(isArmstrongNumber(152));
        // System.out.println(allDivisors(36));
        // System.out.println(allDivisors(15));
        System.out.println(isPrime(25));
        System.out.println(isPrime(5));
    }
}