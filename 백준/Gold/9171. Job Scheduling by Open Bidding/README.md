# [Gold V] Job Scheduling by Open Bidding - 9171 

[문제 링크](https://www.acmicpc.net/problem/9171) 

### 성능 요약

메모리: 12756 KB, 시간: 116 ms

### 분류

다이나믹 프로그래밍, 배낭 문제

### 제출 일자

2023년 10월 12일 16:05:39

### 문제 설명

<p>Your team is setting up a computing resource devoted to batch processing of compute-bound jobs. In addition, you have decided to use static scheduling for each period of time. Naturally, you wish to maximize the income for each set of jobs run, and you have been given the responsibility of finding an optimal mix of jobs for each set of candidate jobs. The jobs are submitted by an open bid process: clients will specify the amount of processor time they wish to reserve and the dollar amount that they wish to pay. If a job finishes early, the client will still pay the full amount, and if a job exceeds the requested time, it will be terminated and (of course) the client will still pay the full amount. For purposes of scheduling, your team assumes that each job will in fact use its entire scheduled time slot. In the interests of good customer relations, though, you are not to include a bid in the schedule if there is not sufficient time available to satisfy it — we’re not going to over-book like the airlines do, and then hope someone doesn’t use the full allotment!</p>

### 입력 

 <p>The input file begins with a line containing a single integer (no white space) specifying the number of problem sets in the file.</p>

<p>Each problem set consists of (n+2) lines (no white space except as specified):</p>

<ul>
	<li>a single integer n (n ≤ 500) specifying the number of candidate jobs to be scheduled</li>
	<li>n lines giving the bid as an integer specifying the number of seconds followed by a single space and then a dollar amount given in decimal form (always showing two digits to the right of the decimal point)</li>
	<li>a single integer t (t ≤ 2000) specifying the amount of time to be scheduled with these jobs</li>
</ul>

### 출력 

 <p>Each problem set will be numbered (beginning at one) and will generate a single line:</p>

<p>Problem <k>: <t> seconds scheduled for <span>$</span>abc.de</p>

<p>where <k> is replaced by the problem set number, <t> is replaced with the total time actually scheduled (possibly not the full input time), and $abc.de is replaced by the dollar amount, given always with the leading currency symbol and with two digits to the right of the decimal point. There will be no blank lines, and the final line will end with the new-line character.</p>

