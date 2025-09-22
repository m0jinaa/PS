# [Gold V] Folding - 20247 

[문제 링크](https://www.acmicpc.net/problem/20247) 

### 성능 요약

메모리: 28328 KB, 시간: 276 ms

### 분류

구현

### 제출 일자

2025년 9월 22일 18:16:43

### 문제 설명

<p>There is a transparent tape. Its length is exact one meter (10<sup>9</sup> nanometers). In this problem, all numbers are integers, and we use a number to denote a position on the tape. The number p denote the position of the point has a distance p nanometers from the head of the tape.</p>

<p>Bob is a master dyer, so he can color the tape precisely in nanometer scale. He colors two sectors [p<sub>1</sub>, q<sub>1</sub>] and [p<sub>2</sub>, q<sub>2</sub>] into red. The color of the tape within the range between p<sub>1</sub> and q<sub>1</sub> is red. The color of the tape within the range between p<sub>2</sub> and q<sub>2</sub> is also red. And the rest parts of the tape remain transparent.</p>

<p>To verify Bob’s skill, we ask Ben, the tape folding master, to help us. Ben can fold the tape perfectly at any position. If Ben fold the tape at x, then the new position of a certain point p will be one of the following cases.</p>

<ul>
	<li>If p = x, then it becomes the new head of the tape, i.e, it becomes 0.</li>
	<li>If p > x, then it becomes p − x.</li>
	<li>If p < x, then it becomes x − p.</li>
</ul>

<p>After Ben folds the tape, we measure the total length of the red part of the new tape. If the red part has the expected length, then we will believe Bob and Ben are both masters in their skills. Obviously, the color of some position of the new tape is determined by the colors of the corresponding positions of the old tape. A position of the new tape is colored in red if one of the corresponding positions in the old tape is colored in red.</p>

<p>Bob has already colored the tape, and Ben has proposed the positions to be folded. Please write a program to compute the expected lengths colored in red.</p>

### 입력 

 <p>The first line contains four space-separated integers p<sub>1</sub>, q<sub>1</sub>, p<sub>2</sub> and q<sub>2</sub>. Bob has colored the sectors [p<sub>1</sub>, q<sub>1</sub>] and [p<sub>2</sub>, q<sub>2</sub>]. The second line contains an integer q indicating that Ben has made q proposals. Each of the remaining q lines contains an integer x indicating the positions to be folded by Ben. Note that the q proposals are independent to each other. There is only one folding point in one proposal.</p>

### 출력 

 <p>For each position, output the expected total length of the new tape that are colored in red.</p>

