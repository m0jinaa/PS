# [Silver V] Golden Landmarks - 34285 

[문제 링크](https://www.acmicpc.net/problem/34285) 

### 성능 요약

메모리: 97128 KB, 시간: 520 ms

### 분류

수학, 구현, 자료 구조, 기하학, 집합과 맵

### 제출 일자

2025년 11월 17일 23:25:24

### 문제 설명

<p>The city of Golden has many landmarks worth visiting. Before arriving in Golden, you made a list of landmarks you want to visit and the order in which you will visit them. To understand where these landmarks are located, you create a map of Golden and mark each landmark on it. You determine the $x$ and $y$ coordinates of each landmark and plot out your journey for the day. Now, you want to determine the total walking distance required to visit all landmarks in the given order. You will start at the first landmark and finish your walk at the last landmark.</p>

<p>Since Golden is laid out on a grid, the walking distance between two landmarks at coordinates $(x_1, y_1)$ and $(x_2, y_2)$ is $|x_1 - x_2| + |y_1 - y_2|$.</p>

### 입력 

 <p>The first line of input contains an integer $n$ ($ 2 \leq n \leq 10^5 $) representing the number of landmarks.  </p>

<p>The next $n$ lines each contain a string $ s $ ($ 1 \leq |s| \leq 25 $), the name of a landmark, followed by two integers $x$ and $y$ ($ -10^4 \leq x, y \leq 10^4 $) representing the landmark's coordinates. Each landmark name consists only of uppercase and lowercase Latin letters and is unique.</p>

<p>The final line contains a space-separated sequence of $n$ landmark names, specifying the exact order in which you will visit them. Each landmark appears exactly once in this sequence.</p>

### 출력 

 <p>Output a single integer, the total walking distance required to visit all landmarks in the specified order.</p>

