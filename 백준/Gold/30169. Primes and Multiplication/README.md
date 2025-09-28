# [Gold I] Primes and Multiplication - 30169 

[문제 링크](https://www.acmicpc.net/problem/30169) 

### 성능 요약

메모리: 11516 KB, 시간: 72 ms

### 분류

분할 정복을 이용한 거듭제곱, 수학, 정수론, 소수 판정

### 제출 일자

2025년 9월 28일 22:59:09

### 문제 설명

<p>Let's introduce some definitions that will be needed later.</p>

<p>Let $prime(x)$ be the set of prime divisors of $x$. For example, $prime(140) = \{ 2, 5, 7 \}$, $prime(169) = \{ 13 \}$.</p>

<p>Let $g(x, p)$ be the maximum possible integer $p^k$ where $k$ is an integer such that $x$ is divisible by $p^k$. For example:</p>

<ul>
	<li>$g(45, 3) = 9$ ($45$ is divisible by $3^2=9$ but not divisible by $3^3=27$),</li>
	<li>$g(63, 7) = 7$ ($63$ is divisible by $7^1=7$ but not divisible by $7^2=49$).</li>
</ul>

<p>Let $f(x, y)$ be the product of $g(y, p)$ for all $p$ in $prime(x)$. For example:</p>

<ul>
	<li>$f(30, 70) = g(70, 2) \cdot g(70, 3) \cdot g(70, 5) = 2^1 \cdot 3^0 \cdot 5^1 = 10$,</li>
	<li>$f(525, 63) = g(63, 3) \cdot g(63, 5) \cdot g(63, 7) = 3^2 \cdot 5^0 \cdot 7^1 = 63$.</li>
</ul>

<p>You have integers $x$ and $n$. Calculate $f(x, 1) \cdot f(x, 2) \cdot \ldots \cdot f(x, n) \bmod{(10^{9} + 7)}$.</p>

### 입력 

 <p>The only line contains integers $x$ and $n$ ($2 \le x \le 10^{9}$, $1 \le n \le 10^{18}$) --- the numbers used in formula.</p>

### 출력 

 <p>Print the answer.</p>

