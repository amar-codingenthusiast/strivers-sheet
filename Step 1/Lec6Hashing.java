import java.util.HashMap;

class Lec6Hashing {
    public static void countFreq(int[] nums) {
        // Time = O(n), Space = O(n)
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for (int key : freq.keySet()) {
            System.out.println(key + " => " + freq.get(key));
        }
    }

    public static void highestNLowest(int[] nums) {
        // Time = O(n), Space = O(n)
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int highestNum = 0;
        int highestFreq = Integer.MIN_VALUE;
        int lowestNum = 0;
        int lowestFreq = Integer.MAX_VALUE;
        for (int key : freq.keySet()) {
            int currFreq = freq.get(key);
            if (highestFreq < currFreq) {
                highestNum = key;
                highestFreq = currFreq;
            }
            if (lowestFreq > currFreq) {
                lowestNum = key;
                lowestFreq = currFreq;
            }
        }
        System.out.println("Highest = " + highestNum);
        System.out.println("Lowest = " + lowestNum);
    }

    public static void main(String[] args) {
        int[] nums = { 10, 5, 10, 15, 10, 5 };
        countFreq(nums);
        highestNLowest(nums);
    }
}