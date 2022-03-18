# **二分搜索算法**
![二分查找图片](https://gitee.com/htt1103/se_homework/tree/master/img/二分查找图片.png)
***
## **简介**
>**二分搜索**也叫<u>折半搜索</u>或<u>对数搜索</u>，是在一种有序数组中查找特定元素的搜索算法。从中间数开始，如果刚好查找中间数则结束；大于或小于中间元素则在大于或小于中间元素的那一半查找。  
如果在某一步骤数组为空，则表示找不到。这种方法每一次比较都使搜索范围缩小**一半**。
***
## **示例代码**
### 实现思路
>在有序序列中，使用二分查找算法搜索目标元素的核心思想是：不断地缩小搜索区域，降低查找目标元素的难度。

>以在升序序列中查找目标元素为例，二分查找算法的实现思路是：   
>1. 初始状态下，将整个序列作为搜索区域（假设为 [B, E]）；  
>2. 找到搜索区域内的中间元素（假设所在位置为 M），和目标元素进行比对。如果相等，则搜索成功；如果中间元素大于目标元素，表明目标元素位于中间元素的左侧，将 [B, M-1] 作为新的搜素区域；反之，若中间元素小于目标元素，表明目标元素位于中间元素的右侧，将 [M+1, E] 作为新的搜素区域；  
>3. 重复执行第二步，直至找到目标元素。如果搜索区域无法再缩小，且区域内不包含任何元素，表明整个序列中没有目标元素，查找失败。
### C版本
```
int binary_search(const int arr[], int start, int end, int khey)
{
if (start > end)
    return -1;
int mid = start + (end - start) / 2; 
if (arr[mid] > khey)
    return binary_search(arr, start, mid - 1, khey);
else if (arr[mid] < khey)
    return binary_search(arr, mid + 1, end, khey);
else
    return mid;
}  
```
### java版本
```
public static int binarySearch(int[] arr, int start, int end, int hkey){
    if (start > end)
        return -1;
  
    int mid = start + (end - start)/2;    //防止溢位
    if (arr[mid] > hkey)
        return binarySearch(arr, start, mid - 1, hkey);
    if (arr[mid] < hkey)
        return binarySearch(arr, mid + 1, end, hkey);
    return mid;  
}
```
***
***本文参考文章链接***  
[百度百科-二分搜索算法](https://baike.baidu.com/item/%E4%BA%8C%E5%88%86%E6%90%9C%E7%B4%A2%E7%AE%97%E6%B3%95/4081752)  
[C语言中文网-二分搜索算法（折半查找算法）](http://c.biancheng.net/algorithm/binary-search.html)