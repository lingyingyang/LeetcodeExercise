package concurrent.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinBucketSort {
    private static final ForkJoinPool FORK_JOIN_POOL = ForkJoinPool.commonPool();
    // 单桶初始化大小
    private static final int MAX_BUCKET_SIZE = 100000;
    // 桶的数量
    private static final int MAX_BUCKET_AMT = 1000;
    private static int[] resources = new int[MAX_BUCKET_AMT * MAX_BUCKET_SIZE];

    static {
        // 随机生成待排序的数组元素
        Random random = new Random();
        int len = MAX_BUCKET_SIZE * MAX_BUCKET_AMT;
        for (int index = 0; index < len; index++) {
            resources[index] = random.nextInt(len);
        }
    }

    public static void main(String[] args) throws Exception {
        /*
         * 操作步骤如下：
         * 1、首先开始分桶
         * 2、然后将这些桶放入fork/join pool中进行归并计算
         * 3、待所有桶的排序完成后，再将这些有序集合，排列成一个新的有序集合
         * */
        // 1、==========
        // 初始化分桶（还是单线程的）
        System.out.println("开始计算===== ");
        long beginTime = System.currentTimeMillis();
        // 桶的大小是固定的，为了避免数组超界，在实际应用中单桶大小应设置一个合理的值
        int[][] bucketArrays = new int[MAX_BUCKET_AMT][MAX_BUCKET_SIZE * 10];
        // 单桶目前已存储的元素个数
        int[] bucketIndexs = new int[MAX_BUCKET_AMT];
        int resourceLen = MAX_BUCKET_AMT * MAX_BUCKET_SIZE;
        for (int index = 0; index < resourceLen; index++) {
            int bucketIndex = resources[index] / MAX_BUCKET_SIZE;
            // 放入相应的桶，并更新这个桶“已存储的元素个数”
            bucketArrays[bucketIndex][bucketIndexs[bucketIndex]++] = resources[index];
        }
        System.out.println("完成分桶===== ");

        // 2、==========
        List<ForkJoinTask<int[]>> results = new ArrayList<>();
        for (int index = 0; index < MAX_BUCKET_AMT; index++) {
            int[] itemBucket = bucketArrays[index];
            BucketSortTask bucketSortTask = new BucketSortTask(itemBucket, 0, bucketIndexs[index] - 1);
            ForkJoinTask<int[]> taskFeature = FORK_JOIN_POOL.submit(bucketSortTask);
            results.add(taskFeature);
        }

        // 3、==========
        // 依次获得每个桶的结果就是一个有序集合了，这个步骤必须要算在时间内
        System.out.println("开始最后排序===== ");
        int[] resultAll = new int[MAX_BUCKET_AMT * MAX_BUCKET_SIZE];
        int destPos = 0;
        for (int index = 0; index < MAX_BUCKET_AMT; index++) {
            int[] bucketResults = results.get(index).get();
            System.arraycopy(bucketResults, 0, resultAll, destPos, bucketIndexs[index]);
            destPos += bucketIndexs[index];
        }
        long endTime = System.currentTimeMillis();
        System.out.println("耗时=" + (endTime - beginTime) + " | ");
        // 开始检查
//        System.out.println("检查结果：" + SortResultCheck.scan(resultAll));
    }

    // 桶排序任务，每个桶中采用快速排序法进行
    static class BucketSortTask extends RecursiveTask<int[]> {
        private int resources[];
        private int startIndex, endIndex;

        public BucketSortTask(int resources[], int startIndex, int endIndex) {
            this.resources = resources;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        @Override
        protected int[] compute() {
            QuickSortTask quickSortTask = new QuickSortTask(resources, this.startIndex, this.endIndex);
            ForkJoinTask<int[]> result = quickSortTask.fork();
            // 等待这个任务
            int[] resultArrays;
            try {
                resultArrays = result.get();
                return resultArrays;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    // 快速排序任务（子任务）
    static class QuickSortTask extends RecursiveTask<int[]> {
        private int[] resources;
        private int beginIndex;
        private int endIndex;

        public QuickSortTask(int[] resources, Integer beginIndex, Integer endIndex) {
            this.resources = resources;
            this.beginIndex = beginIndex;
            this.endIndex = endIndex;
        }

        @Override
        protected int[] compute() {
            this.scan(resources, beginIndex, endIndex);
            return resources;
        }

        private void scan(int[] resources, int startIndexs, int endIndexs) {
            /*
             * 每次扫描的过程为：
             * 0，确定一个base数值，这个数值是扫描数组的第一个元素
             * 1、首先从endIndexs位置标记j，向左开始移动，一旦发现当前元素小于等于base，说明这个元素需要交换
             * 2、然后再从startIndexs位置标记i，向右开始移动，一旦发现当前元素大于base，说明这个元素需要和之前的j位置进行交换
             * 3、如果j的位置和i的位置已经相交，则按照当前j的位置和base的值交换
             * 4、执行3完成后，按照交换后base的位置，分别递归排序左侧和右侧两部分
             * */
            if (endIndexs - startIndexs < 1) {
                return;
            }
            // 以第startIndexs个元素为基准，进行扫描
            int base = resources[startIndexs];
            for (int i = startIndexs, j = endIndexs; ; ) {
                boolean sawpBase = false;
                // 1、=============================
                for (; ; j--) {
                    // 如果条件成立，说明j的位置找到一个比base小或者等于base的值
                    // 那么开始移动i
                    if (resources[j] <= base) {
                        break;
                    }
                }
                // 2、=============================
                if (!sawpBase) {
                    for (; ; i++) {
                        // 如果条件成立，说明i和j已经重合，开始移动基准数到指定位置
                        if (i >= j) {
                            sawpBase = true;
                            break;
                        }
                        // 如果条件成立，说明j的位置找到一个比base大的值
                        if (resources[i] > base) {
                            break;
                        }
                    }
                    // 3、=============================
                    if (i < j) {
                        swap(resources, i, j);
                    }
                }
                // 4、=============================
                if (sawpBase) {
                    swap(resources, startIndexs, j);
                    // 开始进行递归计算，先计算左侧，再计算右侧
                    if (j != endIndexs) {
                        this.scan(resources, startIndexs, j);
                        this.scan(resources, j + 1, endIndexs);
                    } else {
                        this.scan(resources, startIndexs, j - 1);
                    }
                    return;
                }
            }
        }

        // 该方法用于交换
        private void swap(int[] arrays, int i, int j) {
            int temp;
            temp = arrays[i];
            arrays[i] = arrays[j];
            arrays[j] = temp;
        }
    }
}
