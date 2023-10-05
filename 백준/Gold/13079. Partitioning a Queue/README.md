# [Gold V] Partitioning a Queue - 13079 

[문제 링크](https://www.acmicpc.net/problem/13079) 

### 성능 요약

메모리: 11592 KB, 시간: 80 ms

### 분류

다이나믹 프로그래밍, 배낭 문제

### 문제 설명

<p>There are n passengers in a single queue, waiting to enter the airplane. To avoid congestion, the queue should be partitioned into smaller parts. There are several ways to partition the queue. For instance, a queue of size 3 can be partitioned into1+2, 2+1, 1+1+1 or 3. It is easy to prove that there are 2<sup>n−1</sup> ways to partition a queue of size n.</p>

<p>The problem becomes a little complicated, when we are not allowed to use parts whose sizes are in some given set S. For instance, if S is the set of even numbers, a queue of size 4 can be partitioned in 3 ways, namely 1+1+1+1, 1+3 and 3+1. You’re task is to count the number of ways to partition a queue of size n, with an additional condition that the size of no part should be in a given arithmetic sequence {m + ik|i = 0, 1, … } for the given m, k.</p>

### 입력 

 <p>The first line of the input includes the number of test cases 1 ≤ t ≤ 10000. Each test case consists of three space separated integers n, m, k ( 1 ≤ n ≤ 30, 0 ≤ m < k < 30).</p>

### 출력 

 <p>For each test case, print one line containing the answer to the question</p>

