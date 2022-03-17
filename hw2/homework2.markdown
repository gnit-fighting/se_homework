# 作业二：
**要求：使用java的Profile工具探究插入排序中什么操作最耗时**
***

flamegraph图
![framegraph](flamegraph.png)
![framegraph2](flame.png)

call tree
![calltree](calltree.png)

从Test的flamegraph图中，发现write、flushBuffer、java.io.PrintStream等操作占用CPU资源最多，说明插入排序中在处理内存的读写方面耗时很多。因为在插入排序的实现逻辑中，分为已排序部分和未排序部分，当未排序的数遍历已排序数组并找到其位置时，将其插入将涉及到已排序数组的大幅移动问题。

