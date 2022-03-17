import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class InsertSortTest {
    public static void main(String[] args) {
        testInsertSort();
    }
    /**
     * 插入排序
     */
    private static void testInsertSort() {
        int size = 10000;
        // 定义数组
        int[] array = new int[size];
        Random random = new Random();

        random.setSeed(10000L);
        for(int i=0;i<10000;i++){
            array[i]=random.nextInt(1000);
        }
        InsertSort insertSort = new InsertSort(array);
        insertSort.sort();
        insertSort.print();
    }
}