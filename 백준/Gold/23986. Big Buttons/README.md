# [Gold IV] Big Buttons - 23986 

[문제 링크](https://www.acmicpc.net/problem/23986) 

### 성능 요약

메모리: 21336 KB, 시간: 128 ms

### 분류

조합론, 자료 구조, 수학, 문자열, 트리, 트라이

### 제출 일자

2024년 12월 4일 21:32:53

### 문제 설명

<p>You are a contestant on a popular new game show and are playing for the grand prize!</p>

<p>There are two big buttons, a red one and a black one. You will make a sequence of exactly <b>N</b> button presses.</p>

<p>There are lots of different sequences of presses you could make, but there are <b>P</b> forbidden prefixes, each of length no greater than <b>N</b>. If you make a sequence of presses which begins with <i>any</i> of the forbidden sequences, you will not win the grand prize. It is fine for your sequence to contain one or more forbidden prefixes as long as they do not appear at the start of your sequence.</p>

<p>A <i>winning</i> sequence must consist of exactly <b>N</b> button presses and must not begin with one of the forbidden prefixes. How many different winning sequences are there?</p>

### 입력 

 <p>The first line of the input gives the number of test cases, <b>T</b>. <b>T</b> test cases follow. Each test case starts with a line containing two integers <b>N</b> and <b>P</b>, as described above. Then, there are <b>P</b> more lines, each of which contains a string of between 1 and <b>N</b> characters, inclusive, describing one of the forbidden sequences of presses. An <code>R</code> represents pressing the red button, whereas a <code>B</code> represents pressing the black button.</p>

### 출력 

 <p>For each test case, output one line containing <code>Case #x: y</code>, where <code>x</code> is the test case number (starting from 1) and <code>y</code> is the number of winning sequences, as desribed above.</p>

