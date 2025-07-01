# [Gold III] Rabbit House - 23001 

[문제 링크](https://www.acmicpc.net/problem/23001) 

### 성능 요약

메모리: 324460 KB, 시간: 4016 ms

### 분류

너비 우선 탐색, 자료 구조, 그래프 이론, 그래프 탐색, 그리디 알고리즘, 우선순위 큐

### 제출 일자

2025년 7월 1일 16:59:52

### 문제 설명

<p>Barbara got really good grades in school last year, so her parents decided to gift her with a pet rabbit. She was so excited that she built a house for the rabbit, which can be seen as a 2D grid with R rows and C columns.</p>

<p>Rabbits love to jump, so Barbara stacked several boxes on several cells of the grid. Each box is a cube with equal dimensions, which match exactly the dimensions of a cell of the grid.</p>

<p>However, Barbara soon realizes that it may be dangerous for the rabbit to make jumps of height greater than 1 box, so she decides to avoid that by making some adjustments to the house. For every pair of adjacent cells, Barbara would like that their absolute difference in height be at most 1 box. Two cells are considered adjacent if they share a common side.</p>

<p>As all the boxes are superglued, Barbara cannot remove any boxes that are there initially, however she can add boxes on top of them. She can add as many boxes as she wants, to as many cells as she wants (which may be zero). Help hew determine what is the minimum total number of boxes to be added so that the rabbit's house is safe.</p>

### 입력 

 <p>The first line of the input gives the number of test cases, T. T test cases follow.</p>

<p>Each test case begins with a line containing two integers R and C.</p>

<p>Then, R lines follow, each with C integers. The j-th integer on i-th line, Gi,j, represents how many boxes are there initially on the cell located at the i-th row and j-th column of the grid.</p>

### 출력 

 <p>For each test case, output one line containing <code>Case #x: y</code>, where x is the test case number (starting from 1) and y is the minimum number of boxes to be added so that the rabbit's house is safe.</p>

