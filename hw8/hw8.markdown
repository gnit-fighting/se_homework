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
![代码结构图](https://github.com/gnit-fighting/se_homework/blob/d823014772b89eaf721019da07074b1de4dc8ce8/hw8/img/code.png)
## 三、运行展示   
点击Actions：有一个workflow：Update demo.yml
![allWorkFlows](https://github.com/gnit-fighting/se_homework/blob/d823014772b89eaf721019da07074b1de4dc8ce8/hw8/img/allWorkFlows.png)

点击查看Update demoyml,有两个Jobs：Explore-GitHub-Actions和Mocking-Test
![demoJobs.png](https://github.com/gnit-fighting/se_homework/blob/d823014772b89eaf721019da07074b1de4dc8ce8/hw8/img/demoJobs.png)

点击查看Explore-GitHub-Actions：下图展示了细节的steps
![job1](https://github.com/gnit-fighting/se_homework/blob/d823014772b89eaf721019da07074b1de4dc8ce8/hw8/img/job1.png)

点击查看Mocking-Test ：下图展示里细节的steps
![job2](https://github.com/gnit-fighting/se_homework/blob/d823014772b89eaf721019da07074b1de4dc8ce8/hw8/img/job2.png)

点击查看Mocking-Test的test：发现的确运行测试了hw2/InsertSort中的Java代码
![test](https://github.com/gnit-fighting/se_homework/blob/d823014772b89eaf721019da07074b1de4dc8ce8/hw8/img/test.png)





　