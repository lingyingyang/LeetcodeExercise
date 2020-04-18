package leetcode.sort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class SortSolution {

    private static final int QUICK_SORTS_HOLD = 50;
    private static final int MERGE_SORTS_HOLD = 300;

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }

        if (nums.length < QUICK_SORTS_HOLD) {
            bubbleSort(nums);
        } else if (nums.length < MERGE_SORTS_HOLD) {
            quickSort(nums);
        } else {
            mergeSort(nums);
        }
        return nums;
    }

    public void bubbleSort(int[] nums) {
        log.info("use bubbleSort()");
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
    }

    public void quickSort(int[] nums) {
        log.info("use quickSort()");
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low >= high)
            return;
        int pivot = partition(nums, low, high);
        quickSort(nums, low, pivot - 1);
        quickSort(nums, pivot + 1, high);
    }

    private int partition(int[] nums, int low, int high) {
        int q = low + (int) (Math.random() * (high - low + 1));
        swap(nums, low, q);

        int index = low + 1;
        for (int i = low + 1; i <= high; i++) {
            if (nums[i] < nums[low]) {
                swap(nums, i, index++);
            }
        }
        swap(nums, low, --index);
        return index;
    }

    public void mergeSort(int[] nums) {
        log.info("use mergeSort()");
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int low, int high) {
        if (low >= high)
            return;
        int mid = (low + high) >>> 1;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, mid + 1, high);
    }

    private void merge(int[] nums, int preLow, int preHigh, int endLow, int endHigh) {
        if (preLow == endHigh) return;
        int low = preLow;
        int high = endHigh;

        int[] newArr = new int[preHigh - preLow + 1 + endHigh - endLow + 1];
        int index = 0;
        while (preLow <= preHigh && endLow <= endHigh) {
            newArr[index++] = (nums[preLow] < nums[endLow]) ? nums[preLow++] : nums[endLow++];
        }
        while (preLow <= preHigh) {
            newArr[index++] = nums[preLow++];
        }
        while (endLow <= endHigh) {
            newArr[index++] = nums[endLow++];
        }

        index = 0;
        while (low <= high) {
            nums[low++] = newArr[index++];
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j)
            return;
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

}
