# [Silver I] Equal Summed Subsets - 27105 

[문제 링크](https://www.acmicpc.net/problem/27105) 

### 성능 요약

메모리: 11480 KB, 시간: 80 ms

### 분류

다이나믹 프로그래밍, 배낭 문제

### 제출 일자

2023년 10월 15일 12:13:56

### 문제 설명

<p>Given the set of integers {1, 2, 3, ..., N}, determine the total number of ways you can divide the set into two equal-summed subsets A and B of that set. The union of A and B is the set of integers {1,2,...n} and A and B have no integers in common. Do not count answers that are just mirror images of each other, e.g.:</p>

<pre>{1, 4} and {2, 3}
      vs.
{2, 3} and {1, 4}</pre>

<p>counts as a single solution, not two solutions just because the two sets can be ordered the other way.</p>

### 입력 

 <p>A single line with an integer 1 ≤ N ≤ 36 that denotes the size of the set.</p>

### 출력 

 <p>A single line with an integer that tells how many pairs of equal summed subsets can be created.</p>

