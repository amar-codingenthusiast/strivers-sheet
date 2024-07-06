public class Lec2Sorting2 {
    public static void merge(int[] nums, int low, int mid, int high) {
        int[] newArray = new int[high - low + 1];
        int x = 0;
        int a = low;
        int b = mid + 1;
        while (a <= mid && b <= high) {
            if (nums[a] <= nums[b]) {
                newArray[x++] = nums[a++];
            } else {
                newArray[x++] = nums[b++];
            }
        }
        while (a <= mid) {
            newArray[x++] = nums[a++];
        }
        while (b <= high) {
            newArray[x++] = nums[b++];
        }
        for (int i = 0; i < newArray.length; i++) {
            nums[low++] = newArray[i];
        }
    }

    public static void mergeSort(int[] nums, int low, int high) {
        // Time = O(nlogn), Space = O(n)
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    public static int partition1(int[] nums, int low, int high) {
        int pivot = nums[high], temp;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (nums[j] < pivot) {
                i++;
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        i++;
        temp = nums[i];
        nums[i] = nums[high];
        nums[high] = temp;
        return i;
    }

    public static int partition2(int[] nums, int low, int high) {
        int pivot = nums[low], temp;
        int i = low;
        int j = high;
        while (i < j) {
            while (nums[i] <= pivot && i <= high - 1) {
                i++;
            }
            while (nums[j] > pivot && j >= low + 1) {
                j--;
            }
            if (i < j) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        temp = nums[low];
        nums[low] = nums[j];
        nums[j] = temp;
        return j;
    }

    public static void quickSort(int[] nums, int low, int high) {
        // Time = Average = O(nlogn), Worst = O(n^2), Space = O(1)
        if (low < high) {
            // int partitionIndex = partition1(nums, low, high);
            int partitionIndex = partition2(nums, low, high);
            quickSort(nums, low, partitionIndex - 1);
            quickSort(nums, partitionIndex + 1, high);
        }
    }

    public static void recursiveBubbleSort(int[] nums, int n) {
        // Time = O(n^2), Space = O(n)
        if (n == 1) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
            }
        }
        recursiveBubbleSort(nums, n - 1);
    }

    public static void recursiveInsertionSort(int[] nums, int idx, int n) {
        // Time = O(n^2), Space = O(n)
        if (idx == n) {
            return;
        }
        int j = idx;
        while (j > 0 && nums[j - 1] > nums[j]) {
            int temp = nums[j - 1];
            nums[j - 1] = nums[j];
            nums[j] = temp;
            j--;
        }
        recursiveInsertionSort(nums, idx + 1, n);
    }

    public static void main(String[] args) {
        int[] nums = { 12, -5, 0, 25, -25 };
        // mergeSort(nums, 0, nums.length - 1);
        // quickSort(nums, 0, nums.length - 1);
        // recursiveBubbleSort(nums, nums.length);
        recursiveInsertionSort(nums, 0, nums.length);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }
}
