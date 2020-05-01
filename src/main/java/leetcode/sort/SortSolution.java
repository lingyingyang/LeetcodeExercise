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
            int minIdx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            swap(nums, i, minIdx);//最小的依次冒泡到区间首
        }
    }

    public void quickSort(int[] nums) {
        log.info("use quickSort()");
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int head, int tail) {
        if (head >= tail) return;

        int pivot = partition(nums, head, tail);
        quickSort(nums, head, pivot - 1);
        quickSort(nums, pivot + 1, tail);
    }

    /**
     * nums[head..tail]闭区间划分出pivot
     *
     * @param nums
     * @param head
     * @param tail
     * @return
     */
    private int partition(int[] nums, int head, int tail) {
        int pivot = head + (int) (Math.random() * (tail - head + 1));
        swap(nums, head, pivot);//把pivot放到区间首

        int idx = head + 1;
        for (int i = head + 1; i <= tail; i++) {//遍历数组
            if (nums[i] < nums[head]) {//如果值小于pivot，依次放到左边
                swap(nums, i, idx++);//双idx
            }
        }
        //把pivot放到中间
        //这样左边的都小于pivot，右边的都大于pivot
        swap(nums, head, --idx);
        return idx;
    }

    public void mergeSort(int[] nums) {
        log.info("use mergeSort()");
        mergeSort(nums, 0, nums.length - 1);
    }

    /**
     * 拆分成nums[left..mid]和nums[mid+1..right]
     *
     * @param nums
     * @param left
     * @param right
     */
    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
//        int mid = (left + right) >>> 1;
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);//nums[left..mid]
        mergeSort(nums, mid + 1, right);//nums[mid+1..right]
        merge(nums, left, mid, mid + 1, right);
    }

    private void merge(int[] nums, int left1, int right1, int left2, int right2) {
        if (left1 == right2) return;
        int leftIdx = left1;
        int rightIdx = right2;

        int[] tmpArr = new int[right1 - left1 + 1 + right2 - left2 + 1];
        int index = 0;
        //2个数组之间比较，以left1和left2作为idx移动
        while (left1 <= right1 && left2 <= right2) {
            tmpArr[index++] = (nums[left1] < nums[left2])
                    ? nums[left1++] : nums[left2++];
        }
        while (left1 <= right1) {//补齐数组1
            tmpArr[index++] = nums[left1++];
        }
        while (left2 <= right2) {//补齐数组2
            tmpArr[index++] = nums[left2++];
        }

        //把tmpArr复制回去
        index = 0;
        while (leftIdx <= rightIdx) {
            nums[leftIdx++] = tmpArr[index++];
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
