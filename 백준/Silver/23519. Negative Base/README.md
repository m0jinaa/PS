# [Silver II] Negative Base - 23519 

[문제 링크](https://www.acmicpc.net/problem/23519) 

### 성능 요약

메모리: 11484 KB, 시간: 64 ms

### 분류

수학

### 제출 일자

2025년 11월 15일 14:51:03

### 문제 설명

<p>It is known that the binary positional numeral system works as follows: denoting a nonnegative integer $x$ as a string "$x_k \ldots x_2 x_1 x_0$" of zeroes and ones means that $x = x_k \cdot 2^k + \ldots + x_2 \cdot 2^2 + x_1 \cdot 2^1 + x_0 \cdot 2^0$. The leading zeroes are omitted, so $x_k = 1$, except the case when $x = 0$ which is denoted as "$0$".</p>

<p>The <em>negabinary</em> notation works in a similar way: denoting an number $x$ as a string "$x_k \ldots x_2 x_1 x_0$" of zeroes and ones means that $x = x_k \cdot (-2)^k + \ldots + x_2 \cdot (-2)^2 + x_1 \cdot (-2)^1 + x_0 \cdot (-2)^0$. The leading zeroes are also omitted, so $x_k = 1$, except the case when $x = 0$ which is denoted as "$0$". It turns out that this notation has a unique representation for every integer (as opposed to only nonnegative integers).</p>

<p>Negabinary notation of numbers from $-7$ to $8$:</p>

<table class="table table-bordered table-center-30">
	<tbody>
		<tr>
			<th>$-7$</th>
			<td>$1001$</td>
			<th>$1$</th>
			<td>$1$</td>
		</tr>
		<tr>
			<th>$-6$</th>
			<td>$1110$</td>
			<th>$2$</th>
			<td>$110$</td>
		</tr>
		<tr>
			<th>$-5$</th>
			<td>$1111$</td>
			<th>$3$</th>
			<td>$111$</td>
		</tr>
		<tr>
			<th>$-4$</th>
			<td>$1100$</td>
			<th>$4$</th>
			<td>$100$</td>
		</tr>
		<tr>
			<th>$-3$</th>
			<td>$1101$</td>
			<th>$5$</th>
			<td>$101$</td>
		</tr>
		<tr>
			<th>$-2$</th>
			<td>$10$</td>
			<th>$6$</th>
			<td>$11010$</td>
		</tr>
		<tr>
			<th>$-1$</th>
			<td>$11$</td>
			<th>$7$</th>
			<td>$11011$</td>
		</tr>
		<tr>
			<th>$0$</th>
			<td>$0$</td>
			<th>$8$</th>
			<td>$11000$</td>
		</tr>
	</tbody>
</table>

<p>Given an integer $k$, find a number which has at least $k$ consecutive zeroes in its negabinary representation. Of all such numbers, find the one which has the least absolute value. If there are still several answers, pick the one with the shortest negabinary representation.</p>

### 입력 

 <p>The first line of input contains an integer $k$ ($1 \le k \le 30$).</p>

### 출력 

 <p>Print one integer: the answer to the problem.</p>

