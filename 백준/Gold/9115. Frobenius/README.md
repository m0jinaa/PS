# [Gold V] Frobenius - 9115 

[문제 링크](https://www.acmicpc.net/problem/9115) 

### 성능 요약

메모리: 15868 KB, 시간: 368 ms

### 분류

다이나믹 프로그래밍, 배낭 문제, 수학

### 문제 설명

<p>The Frobenius problem is an old problem in mathematics, named after the German mathematician G. Frobenius (1849–1917).</p>

<p>Let a<sub>1</sub>, a<sub>2</sub>, …, a<sub>n</sub> be integers larger than 1, with greatest common divisor (gcd) 1. Then it is known that there are finitely many integers larger than or equal to 0, that cannot be expressed as a linear combination w<sub>1</sub>a<sub>1</sub> + w<sub>2</sub>a<sub>2</sub> + … + w<sub>n</sub>a<sub>n</sub> using integer coefficients w<sub>i</sub> ≥ 0. The largest of such nonnegative integers is known as the Frobenius number of a<sub>1</sub>, a<sub>2</sub>, …, a<sub>n</sub> (denoted by F(a<sub>1</sub>, a<sub>2</sub>, …, a<sub>n</sub>)). So: F(a<sub>1</sub>, a<sub>2</sub>, …, a<sub>n</sub>) is the largest nonnegative integer that cannot be expressed as a nonnegative integer linear combination of a<sub>1</sub>, a<sub>2</sub>, …, a<sub>n</sub>.</p>

<p>For n = 2 there is a simple formula for F(a<sub>1</sub>, a<sub>2</sub>). However, for n ≥ 3 it is much more complicated. For n = 3 only for some special choices of a<sub>1</sub>, a<sub>2</sub>, a<sub>3</sub> formulas exist. For n > 4 no formulas are known at all.</p>

<p>We will consider here the Frobenius problem for n = 4. In this case our version of the problem can be formulated as follows. Let four integers a, b, c and d be given, with a, b, c, d > 1 and gcd(a, b, c, d) = 1. We want to know two things.</p>

<ul>
	<li>How many nonnegative integers less than or equal to 1,000,000 cannot be expressed as a nonnegative integer linear combination of the values a, b, c and d?</li>
	<li>Is the Frobenius number of a, b, c and d less than or equal to 1,000,000 and if so, what is its value?</li>
</ul>

### 입력 

 <p>The first line of the input file contains a single number: the number of test cases to follow. Each test case has the following format:</p>

<ul>
	<li>One line, containing four integers a, b, c, d (with 1 < a, b, c, d ≤ 10, 000 and gcd(a, b, c, d) = 1), separated by single spaces.</li>
</ul>

### 출력 

 <p>For every test case in the input file, the output should contain two lines.</p>

<ul>
	<li>The first line contains the number of integers between 0 and 1,000,000 (boundaries included) that cannot be expressed as a⋅w + b⋅x + c⋅y + d⋅z, where w, x, y, z are nonnegative (meaning ≥ 0) integers.</li>
	<li>The second line contains the Frobenius number if this is less than or equal to 1,000,000 and otherwise −1, meaning that the Frobenius number of a, b, c and d is larger than 1,000,000.</li>
</ul>

