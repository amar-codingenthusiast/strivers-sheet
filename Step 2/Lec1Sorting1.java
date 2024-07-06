public class Lec1Sorting1 {
    public static void selectionSort(int[] nums) {
        // Time = O(n^2), Space = O(1), max swap = n-1 times
        for (int i = 0; i < nums.length - 1; i++) {
            int lowest = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[lowest] > nums[j]) {
                    lowest = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[lowest];
            nums[lowest] = temp;
        }
    }

    public static void bubbleSort1(int[] nums) {
        // Time = O(n^2), Space = O(1), if n = 5, it iterate 4+4+4+4=16 times
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSort2(int[] nums) {
        // Time = O(n^2), Space = O(1), if n = 5 it iterates 4+3+2+1=10 times
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSort3(int[] nums) {
        // Time = O(n^2), Space = O(1), if n = 5 it iterates 4+3+2+1=10 times
        // if array is already sorted it takes O(n) time
        for (int i = 0; i < nums.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    public static void insertionSort1(int[] nums) {
        // Time = O(n^2), Space = O(1), if array is already sorted it takes O(n) time
        for (int i = 1; i < nums.length; i++) {
            int currEle = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > currEle) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = currEle;
        }
    }

    public static void insertionSort2(int[] nums) {
        // Time = O(n^2), Space = O(1), if array is already sorted it takes O(n) time
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            while (j > 0 && nums[j - 1] > nums[j]) {
                int temp = nums[j - 1];
                nums[j - 1] = nums[j];
                nums[j] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 12, -5, 0, 25, -25 };
        // selectionSort(nums);
        // bubbleSort1(nums);
        // bubbleSort2(nums);
        // bubbleSort3(nums);
        // insertionSort1(nums);
        insertionSort2(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }
}
