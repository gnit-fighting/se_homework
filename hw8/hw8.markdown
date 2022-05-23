# 第8次作业  
## 作业要求：   
使用 Github Action 或其他CI 服务，对你的仓库进行简单的构建、测试。 
***
## 一、准备操作
在Github仓库里面新建一个 **.github/workflows** 目录，再新建一个 **demo.yml** 文件（使用的是老师提供的demo.yml文件）。   
因为使用hw2/InsertSort案例测试，故修改demo.yml的run路径为：
```
run: cd ${{ github.workspace }}/hw2/InsertSort
```
**demo.yml**文件内容：
```
name: GitHub Actions Demo
on: [push]
jobs:
  Explore-GitHub-Actions:
    runs-on: ubuntu-latest
    steps:
      - run: echo "🎉 The job was automatically triggered by a ${{ github.event_name }} event."
      - run: echo "🐧 This job is now running on a ${{ runner.os }} server hosted by GitHub!"
      - run: echo "🔎 The name of your branch is ${{ github.ref }} and your repository is ${{ github.repository }}."
      - name: Check out repository code
        uses: actions/checkout@v3
      - run: echo "💡 The ${{ github.repository }} repository has been cloned to the runner."
      - run: echo "🖥️ The workflow is now ready to test your code on the runner."
      - name: List files in the repository
        run: |
          ls ${{ github.workspace }}
      - run: echo "🍏 This job's status is ${{ job.status }}."
  Mocking-Test:
     runs-on: ubuntu-latest
     steps:
       - name: Check out repository code
         uses: actions/checkout@v3
       - name: Set up JDK 11
         uses: actions/setup-java@v1
         with:
           java-version: 11
       - name: test
         run: cd ${{ github.workspace }}/hw2/InsertSort
```
## 二、hw2/InsertSort代码结构
![代码结构图](code.png)
## 三、运行展示
![allWorkFlows](allWorkFlows.png)

![demoJobs.png](demoJobs.png)

![job1](job1.png)

![job2](job2.png)

![test](test.png)





　