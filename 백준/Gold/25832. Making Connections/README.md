# [Gold III] Making Connections - 25832 

[문제 링크](https://www.acmicpc.net/problem/25832) 

### 성능 요약

메모리: 109476 KB, 시간: 712 ms

### 분류

자료 구조, 분리 집합

### 제출 일자

2023년 12월 2일 23:01:08

### 문제 설명

<p>Given that everything is online these days, connectivity is a must. A computer network can be modeled as a graph, where each computer is a vertex and each direct network connection between pairs of computers is an undirected edge.</p>

<p>Consider the process of building a computer network. At the very beginning there will be n computers, with no connections between any of them. Then, as time goes on, pairs of computers are chosen, one pair at a time, and a direct network connection between them is added. In the middle of such a process, we might get the following graph modeling the current connections:</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/e344d1c9-6e4d-44ed-b562-5ead9d7febf7/-/preview/" style="width: 187px; height: 100px;"></p>

<p>This network currently has three groups: the first group has 4 computers that can communicate with each other directly or indirectly, the second group consists of 1 computer by itself, and the third group has 2 computers that can communicate with each other. So, a group is each of the separate components of the graph.</p>

<p>We can define the average connectivity of a network as the sum of the group sizes squared, divided by the number of components. For the example graph shown above, the current connectivity equals (4<sup>2</sup> + 1<sup>2</sup> + 2<sup>2</sup>)/3 = 21/3 = 7.</p>

<p>As a network is being built, the project manager would like to know the average connectivity of the network at that given snapshot of time. Write a program to handle the queries as the network is being constructed.</p>

<p>Given a network of n initially separate computers, along with a sequence of steps, where each step is either a pair of computers being connected or a query about the average connectivity as of that moment, process each step (i.e., connect the two computers or answer the query).</p>

### 입력 

 <p>The first input line contains two space separated integers: n (1 ≤ n ≤ 10<sup>5</sup>), representing the number of computers, and m (1 ≤ m ≤ 3×10<sup>5</sup>), representing the total number of steps (each step being either connect two computers or a query on the average connectivity as of that moment). Assume that the computers are numbered 1 through n, inclusive.</p>

<p>Each of the following m input lines contains information about one operation, in the order that they occur. Each of these lines will start with a single integer, either 1 or 2, providing the step type. If the step type is 1, it means that a pair of computers is being connected with a direct connection. The value of 1 will be followed by u and v (1 ≤ u, v ≤ n, u ≠ v), representing the pair of computers being connected with a direct connection. If the step type is 2, this is a query and no other information will be on that input line.</p>

<p>Note: It’s possible that the input contains multiple direct connections for the same pair of computers; the extra direct connections between the same two computers do not have any effects. It’s also possible that, at the end of the process, not all n computers are connected in the same component, i.e., there may be more than one component even at the end of the process.</p>

### 출력 

 <p>For each query, output the average connectivity of the network at that point in time as a fraction in lowest terms on a line by itself. Specifically, output two integers, x and y, with the character ‘/’ in between, indicating that the average connectivity of the network at the time is x divided by y such that x and y share no common factors, e.g., 21/12 is not correct (should be 7/4).</p>

