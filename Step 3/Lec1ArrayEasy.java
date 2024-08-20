import java.util.*;

public class Lec1ArrayEasy {
    public static void largestElement(int[] nums) {
        // Time = O(n), Space = O(1)
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            if (max < i) {
                max = i;
            }
        }
        System.out.println(max);
    }

    public static void secondLargestAndSmallestElement(int[] nums) {
        // Time = O(n), Space = O(1)
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int i : nums) {
            if (max < i) {
                secondMax = max;
                max = i;
            } else if (secondMax < i && max > i) {
                secondMax = i;
            }
            if (min > i) {
                secondMin = min;
                min = i;
            } else if (secondMin > i && min < i) {
                secondMin = i;
            }
        }
        System.out.println(secondMax == Integer.MIN_VALUE ? -1 : secondMax);
        System.out.println(secondMin == Integer.MAX_VALUE ? -1 : secondMin);
    }

    public static void isSorted(int[] nums) {
        // Time = O(n), Space = O(1)
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }

    public static void removeDuplicates(int[] nums) {
        // Time = O(n), Space = O(1)
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[k] != nums[i]) {
                nums[++k] = nums[i];
            }
        }
        System.out.println(++k);
    }

    public static void print(int[] nums) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void rotateBy1inD(int[] nums, String d) {
        // Time = O(n), Space = O(1)
        int n = nums.length;
        if (d.equals("left")) {
            int temp = nums[0];
            for (int i = 1; i < n; i++) {
                nums[i - 1] = nums[i];
            }
            nums[n - 1] = temp;
        } else if (d.equals("right")) {
            int temp = nums[n - 1];
            for (int i = n - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
        } else {
            System.out.println("Invalid direction.");
            return;
        }
        print(nums);
    }

    public static void rotateByKinD1(int[] nums, int k, String d) {
        // Time = O(n), Space = O(n)
        int n = nums.length;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            if (d.equals("left")) {
                temp[i] = nums[(i + k) % n];
            } else if (d.equals("right")) {
                temp[(i + k) % n] = nums[i];
            } else {
                System.out.println("Invalid direction.");
                return;
            }
        }
        print(temp);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public static void rotateByKinD2(int[] nums, int k, String d) {
        // Time = O(n), Space = O(1)
        int n = nums.length;
        k %= n;
        if (d.equals("left")) {
            reverse(nums, 0, k - 1);
            reverse(nums, k, n - 1);
        } else if (d.equals("right")) {
            reverse(nums, 0, n - 1 - k);
            reverse(nums, n - k, n - 1);
        } else {
            System.out.println("Invalid direction.");
            return;
        }
        reverse(nums, 0, n - 1);
        print(nums);
    }

    public static void move0toEnd1(int[] nums) {
        // Time = O(n), Space = O(1), it iterates n + freq(0) times
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
        print(nums);
    }

    public static void move0toEnd2(int[] nums) {
        // Time = O(n), Space = O(1), it iterates n times
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[k];
                nums[k++] = nums[i];
                nums[i] = temp;
            }
        }
        print(nums);
    }

    public static void linearSearch(int[] nums, int k) {
        // Time = O(n), Space = O(1)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }

    public static void unionOf2SortedArrays1(int[] nums1, int[] nums2) {
        // Time = O((n1 + n2) log (n1 + n2)), Space = O(n1 + n2)
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            set.add(i);
        }
        ArrayList<Integer> al = new ArrayList<>(set);
        Collections.sort(al);
        for (int i : al) {
            System.out.print(i + " ");
        }
    }

    public static void addIfNotDuplicate(ArrayList<Integer> al, int num) {
        if (al.isEmpty() || al.get(al.size() - 1) != num) {
            al.add(num);
        }
    }

    public static void unionOf2SortedArrays2(int[] nums1, int[] nums2) {
        // Time = O(n1 + n2), Space = O(n1 + n2)
        ArrayList<Integer> al = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                addIfNotDuplicate(al, nums1[i]);
                i++;
            } else if (nums1[i] > nums2[j]) {
                addIfNotDuplicate(al, nums2[j]);
                j++;
            } else {
                addIfNotDuplicate(al, nums1[i]);
                i++;
                j++;
            }
        }
        while (i < nums1.length) {
            addIfNotDuplicate(al, nums1[i]);
            i++;
        }
        while (j < nums2.length) {
            addIfNotDuplicate(al, nums2[j]);
            j++;
        }
        for (int e : al) {
            System.out.print(e + " ");
        }
    }

    public static void intersectionOf2SortedArrays1(int[] nums1, int[] nums2) {
        // Time = O(Math.min(n1, n2)), Space = O(Math.min(n1, n2))
        ArrayList<Integer> al = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                al.add(nums1[i]);
                i++;
                j++;
            }
        }
        for (int e : al) {
            System.out.print(e + " ");
        }
    }

    public static void intersectionOf2SortedArrays2(int[] nums1, int[] nums2) {
        // Time = O(Math.min(n1, n2)), Space = O(Math.min(n1, n2))
        ArrayList<Integer> al = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                if (al.isEmpty() || al.get(al.size() - 1) != nums1[i]) {
                    al.add(nums1[i]);
                }
                i++;
                j++;
            }
        }
        for (int e : al) {
            System.out.print(e + " ");
        }
    }

    public static void missingNumber1(int[] nums, int n) {
        // Time = O(n), Space = O(1)
        int total = n * (n + 1) / 2;
        for (int num : nums) {
            total -= num;
        }
        System.out.println(total);
    }

    public static void missingNumber2(int[] nums, int n) {
        // Time = O(n), Space = O(1)
        int xor1 = 0;
        int xor2 = 0;
        for (int i = 0; i < n - 1; i++) {
            xor1 ^= i + 1;
            xor2 ^= nums[i];
        }
        xor1 ^= n;
        System.out.println(xor1 ^ xor2);
    }

    public static void maxConsecutive1(int[] nums) {
        // Time = O(n), Space = O(1)
        int count = 0;
        int max = 0;
        for (int num : nums) {
            if (num == 0) {
                count = 0;
            } else {
                count++;
                max = Math.max(max, count);
            }
        }
        System.out.println(max);
    }

    public static void getSingleElement(int[] nums) {
        // Time = O(n), Space = O(1)
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        System.out.println(xor);
    }

    public static void longestSubarrayWithSumK1(int[] nums, int k) {
        // Time = O(n^2), Space = O(1), Brute Force approach
        int n = nums.length;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        System.out.println(maxLen);
    }

    public static void longestSubarrayWithSumK2(int[] nums, int k) {
        // Time = O(n), Space = O(n), Prefix Sum with HashMap approach, exact time = nlogn due to HashMap
        int sum = 0;
        int maxLen = 0;
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }
            if (prefixSumMap.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - prefixSumMap.get(sum - k));
            }
            if (!prefixSumMap.containsKey(sum)) {
                prefixSumMap.put(sum, i);
            }
        }
        System.out.println(maxLen);
    }

    public static void longestSubarrayWithSumK3(int[] nums, int k) {
        // Time = O(n), Space = O(1), Sliding Window or Two Pointers approach, exact time = 2*n, Best for non-negative array
        int i = 0;
        int j = 0;
        int sum = 0;
        int maxLen = 0;
        while (j < nums.length) {
            sum += nums[j];
            while (sum > k && i <= j) {
                sum -= nums[i++];
            }
            if (sum == k) {
                maxLen = Math.max(maxLen, j - i + 1);
            }
            j++;
        }
        System.out.println(maxLen);
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 4, 7, 7, 5 };
        // int[] nums2 = { 1, 0, 2, 3, 0, 4, 0, 1 };
        // int[] nums3 = { 1, 2, 3, 3, 4, 5 };
        // int[] nums4 = { 2, 3, 3, 4, 4, 5};
        // int[] nums5 = { 4, 2, 1, 3, 6 };
        // int[] nums6 = { 1, 0, 1, 1, 1, 0, 1, 1 };
        // int[] nums7 = { 4, 1, 2, 1, 2 };
        // int[] nums8 = { 1, 1, -1, 1, -1};
        // largestElement(nums1);
        // secondLargestAndSmallestElement(nums1);
        // isSorted(nums1);
        // removeDuplicates(nums1);
        // rotateBy1inD(nums1, "right");
        // rotateByKinD1(nums1, 2, "right");
        // rotateByKinD2(nums1, 3, "right");
        // move0toEnd1(nums2);
        // move0toEnd2(nums2);
        // linearSearch(nums, 5);
        // unionOf2SortedArrays1(nums3, nums4);
        // unionOf2SortedArrays2(nums3, nums4);
        // intersectionOf2SortedArrays1(nums3, nums4); // duplicate allowed
        // intersectionOf2SortedArrays2(nums3, nums4); // duplicate not allowed
        // missingNumber1(nums5, 6);
        // missingNumber2(nums5, 6);
        // maxConsecutive1(nums6);
        // getSingleElement(nums7);
        // longestSubarrayWithSumK1(nums1, 7); // positive + negative
        // longestSubarrayWithSumK2(nums8, 1); // positive + negative
        longestSubarrayWithSumK3(nums1, 7); // only positive
    }
}
