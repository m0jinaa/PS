# [Gold III] Plates - 23896 

[문제 링크](https://www.acmicpc.net/problem/23896) 

### 성능 요약

메모리: 19108 KB, 시간: 276 ms

### 분류

다이나믹 프로그래밍, 배낭 문제

### 문제 설명

<p>Dr. Patel has <b>N</b> stacks of plates. Each stack contains <b>K</b> plates. Each plate has a positive <i>beauty value</i>, describing how beautiful it looks.</p>

<p>Dr. Patel would like to take exactly <b>P</b> plates to use for dinner tonight. If he would like to take a plate in a stack, he must also take all of the plates above it in that stack as well.</p>

<p>Help Dr. Patel pick the <b>P</b> plates that would maximize the total sum of beauty values.</p>

### 입력 

 <p>The first line of the input gives the number of test cases, <b>T</b>. <b>T</b> test cases follow. Each test case begins with a line containing the three integers <b>N</b>, <b>K</b> and <b>P</b>. Then, <b>N</b> lines follow. The i-th line contains <b>K</b> integers, describing the beauty values of each stack of plates from top to bottom.</p>

### 출력 

 <p>For each test case, output one line containing <code>Case #x: y</code>, where <code>x</code> is the test case number (starting from 1) and <code>y</code> is the maximum total sum of beauty values that Dr. Patel could pick.</p>

