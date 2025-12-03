# [Gold V] Printer's Head - 18900 

[문제 링크](https://www.acmicpc.net/problem/18900) 

### 성능 요약

메모리: 120020 KB, 시간: 384 ms

### 분류

그리디 알고리즘

### 제출 일자

2025년 12월 3일 23:12:47

### 문제 설명

<p>Johnny bought a 3D printer. He wants to test it on a simple task: print $n$ cuboids with equal square bases and heights $1, 2, \ldots, n$ in the given order. The printer works in left-to-right and right-to-left sweeps, the sweeps can be mixed arbitrarily, i.e. two left-to-right sweeps can be executed one after another, similarly right-to-left. In one sweep the printer can stop over an arbitrary number of fields and print a cuboid on each of them; the first printed cuboid is of a given height and each next one is $1$ lower (the head of the printer cools down). The printer cannot print on fields on which something was printed already.</p>

<p>Sweeps cost money. Help Johnny minimise the number of sweeps utilised for the task.</p>

### 입력 

 <p>Firest line of the input a single positive integer $n$ ($1 \le n \le 10^6$), this is the number of cuboids to be printed. The second and last line contains a sequence of $n$ pairwise distinct positive integers from the set $a_i$ ($1 \le a_i \le n$). These are the heights of the consecutive cuboids to be printed.</p>

### 출력 

 <p>You should print a single positive integer: the minimal number of sweeps needed to print the given sequence of cuboids.</p>

