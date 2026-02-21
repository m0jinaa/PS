# [Gold V] Counting substhreengs - 10397 

[문제 링크](https://www.acmicpc.net/problem/10397) 

### 성능 요약

메모리: 66176 KB, 시간: 248 ms

### 분류

수학, 다이나믹 프로그래밍, 문자열, 누적 합

### 제출 일자

2026년 2월 21일 16:11:11

### 문제 설명

<p>Substrings are strings formed by choosing a subset of contiguous characters from a string. This is well known. A little more obscure is the definition of substhreengs. A substhreeng is a substring which complies to the following additional requirements:</p>

<ol>
	<li>It is non-empty, and composed entirely of base 10 digits.</li>
	<li>Interpreted in base 10 (allowing extra leading zeros), the resulting integer is a multiple of 3.</li>
</ol>

<p>For instance, the string “130a303” contains 9 substhreengs: the substhreeng “3” three times, the substhreengs “30” and “0” twice each, and the substhreengs “303” and “03” once each. The substring “30a3” is not a substhreeng because it is not composed entirely of base 10 digits, while the substring “13” is not a substhreeng because 13 is not a multiple of 3.</p>

<p>Notice that two substhreengs are considered different if they are different in length or start at a different position, even if the selected characters are the same.</p>

<p>Given a string, you are asked to count the number of substhreengs it contains.</p>

### 입력 

 <p>The input consists of a single line that contains a non-empty string S of at most 10<sup>6</sup> characters. Each character of S is either a digit or a lowercase letter.</p>

### 출력 

 <p>Output a line with an integer representing the number of substhreengs contained in S.</p>

