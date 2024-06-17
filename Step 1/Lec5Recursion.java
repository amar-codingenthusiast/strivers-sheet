class Lec5Recursion {
    public static void printNTimes(int n) {
        // Time = O(n), Space = O(n)
        if (n == 0) {
            return;
        }
        printNTimes(n - 1);
        System.out.println(n - 1);
    }

    public static void printName(int n) {
        // Time = O(n), Space = O(n)
        if (n == 0) {
            return;
        }
        System.out.println("Amar Kumar");
        printName(n - 1);
    }

    public static void print1toN(int n) {
        // Time = O(n), Space = O(n)
        if (n == 0) {
            return;
        }
        print1toN(n - 1);
        System.out.println(n);
    }

    public static void printNto1(int n) {
        // Time = O(n), Space = O(n)
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printNto1(n - 1);
    }

    public static void sumOfFirstNNumbers1(int n, int sum) {
        // Time = O(n), Space = O(n)
        if (n == 0) {
            System.out.println(sum);
            return;
        }
        sumOfFirstNNumbers1(n - 1, sum + n);
    }

    public static int sumOfFirstNNumbers2(int n) {
        // Time = O(n), Space = O(n)
        if (n == 0) {
            return 0;
        }
        return n + sumOfFirstNNumbers2(n - 1);
    }

    public static int factorialOfN(int n) {
        // Time = O(n), Space = O(n)
        if (n == 0) {
            return 1;
        }
        return n * factorialOfN(n - 1);
    }

    public static void reverseArray1(int[] arr, int start, int end) {
        // Time = O(n), Space = O(n)
        if (start >= end) {
            return;
        }
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverseArray1(arr, start + 1, end - 1);
    }

    public static void reverseArray2(int[] arr, int i) {
        // Time = O(n), Space = O(n)
        if (i >= arr.length / 2) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[arr.length - i - 1];
        arr[arr.length - i - 1] = temp;
        reverseArray2(arr, i + 1);
    }

    public static boolean isPalindrome(String str, int start, int end) {
        // Time = O(n), Space = O(n)
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void fibonacciTillNthTerm(int a, int b, int n) {
        // Time = O(n), Space = O(n)
        if (n < 0) {
            return;
        }
        System.out.print(a + " ");
        fibonacciTillNthTerm(b, a + b, n - 1);
    }

    public static void fibonacciNthTerm1(int a, int b, int n) {
        // Time = O(n), Space = O(n)
        if (n == 0) {
            System.out.print(a + " ");
            return;
        }
        fibonacciNthTerm1(b, a + b, n - 1);
    }

    public static int fibonacciNthTerm2(int n) {
        // Time = O(2^n), Space = O(n)
        if (n <= 1) {
            return n;
        }
        return fibonacciNthTerm2(n - 1) + fibonacciNthTerm2(n - 2);
    }

    public static void towerOfHanoi(String s, String h, String d, int n) {
        // Time = O(2^n), Space = O(n)
        if (n == 0) {
            return;
        }
        towerOfHanoi(s, d, h, n - 1);
        System.out.println("Transfer disc no " + n + " from " + s + " to " + d);
        towerOfHanoi(h, s, d, n - 1);
    }

    public static void main(String[] args) {
        // printNTimes(5);

        // printName(5);

        // print1toN(10);

        // printNto1(10);

        // sumOfFirstNNumbers1(100, 0);
        // System.out.println(sumOfFirstNNumbers2(50));

        // System.out.println(factorialOfN(5));

        // int[] arr = {1, 2, 3, 4, 5};
        // reverseArray1(arr, 0, arr.length - 1);
        // reverseArray2(arr, 0);
        // for (int i : arr) {
        //     System.out.print(i + " ");
        // }

        // String str = "madam";
        // System.out.println(isPalindrome(str, 0, str.length() - 1));

        // fibonacciTillNthTerm(0, 1, 10);
        // fibonacciNthTerm1(0, 1, 10);
        // System.out.println(fibonacciNthTerm2(10));

        towerOfHanoi("s", "h", "d", 3);
    }
}