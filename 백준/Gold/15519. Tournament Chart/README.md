# [Gold IV] Tournament Chart - 15519 

[문제 링크](https://www.acmicpc.net/problem/15519) 

### 성능 요약

메모리: 11568 KB, 시간: 80 ms

### 분류

자료 구조, 분할 정복, 그리디 알고리즘, 파싱, 재귀, 스택, 문자열

### 제출 일자

2023년 12월 30일 00:46:06

### 문제 설명

<p>In 21XX, an annual programming contest, Japan Algorithmist GrandPrix (JAG) has become one of the most popular mind sports events.</p>

<p>JAG is conducted as a knockout tournament. This year, contestants will compete in JAG. A tournament chart is represented as a string. '<code>[[a-b]-[c-d]]</code>' is an easy example. In this case, there are 4 contestants named a, b, c, and d, and all matches are described as follows:</p>

<ul>
	<li>Match 1 is the match between a and b.</li>
	<li>Match 2 is the match between c and d.</li>
	<li>Match 3 is the match between [the winner of match 1] and [the winner of match 2].</li>
</ul>

<p>More precisely, the tournament chart satisfies the following BNF:</p>

<ul>
	<li><code><winner> ::= <person> | "[" <winner> "-" <winner> "]"</code></li>
	<li><code><person> ::= "a" | "b" | "c" | ... | "z"</code></li>
</ul>

<p>You, the chairperson of JAG, are planning to announce the results of this year's JAG competition. However, you made a mistake and lost the results of all the matches. Fortunately, you found the tournament chart that was printed before all of the matches of the tournament. Of course, it does not contains results at all. Therefore, you asked every contestant for the number of wins in the tournament, and got <em>N</em> pieces of information in the form of "The contestant <em>a<sub>i</sub></em> won <em>v<sub>i</sub></em> times".</p>

<p>Now, your job is to determine whether all of these replies can be true.</p>

### 입력 

 <p>The input consists of a single test case in the format below.</p>

<pre>S
a<sub>1</sub> v<sub>1</sub>
.
.
.
a<sub>N</sub> v<sub>N</sub></pre>

<p><em>S</em> represents the tournament chart. <em>S</em> satisfies the above BNF. The following <em>N</em> lines represent the information of the number of wins. The (<em>i</em>+1)-th line consists of a lowercase letter <em>a<sub>i</sub></em> and a non-negative integer <em>v<sub>i</sub></em> (<em>v<sub>i</sub></em> ≤ 26) separated by a space, and this means that the contestant <em>a<sub>i</sub></em> won <em>v<sub>i</sub></em> times. Note that <em>N</em> (2 ≤ <em>N</em> ≤ 26) means that the number of contestants and it can be identified by string <em>S</em>. You can assume that each letter <em>a<sub>i</sub></em> is distinct. It is guaranteed that <em>S</em> contains each <em>a<sub>i</sub></em> exactly once and doesn't contain any other lowercase letters.</p>

### 출력 

 <p>Print '<code>Yes</code>' in one line if replies are all valid for the tournament chart. Otherwise, print '<code>No</code>' in one line.</p>

