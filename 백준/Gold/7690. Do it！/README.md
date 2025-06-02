# [Gold IV] Do it! - 7690 

[문제 링크](https://www.acmicpc.net/problem/7690) 

### 성능 요약

메모리: 11752 KB, 시간: 72 ms

### 분류

브루트포스 알고리즘, 다이나믹 프로그래밍, 그리디 알고리즘, 구현, 수학, 시뮬레이션

### 제출 일자

2025년 6월 2일 16:54:21

### 문제 설명

<p>You are the boss of a small lighting fixture company which has n employees. Inspired by Ben Stiller’s character in Starsky and Hutch, you have recently taken on the habit of telling your employees to “do it!” when you want things done. While n<sub>+</sub> of the n employees respond positively to your “do it!”s, n<sub>−</sub> employees respond negatively and n<sub>0</sub> are neutral to your words.</p>

<p>At time 0, each of your employees begins working alone on building a lighting fixture. Each lighting fixture takes 100 units of labor to finish. Normally, each of your employees contributes r units of labor towards finishing his/her lighting fixture during each time interval (or the amount of labor units remaining for the fixture, whichever is smaller). Thus, an employee would normally take d100/re time intervals to finish his or her lighting fixture. During an interval, however, if you yell “do it!” over the company intercom, employees who respond positively to your command will do r + 2 units of labor during that time interval, whereas employees who respond negatively will do r − 1 units of labor during the time interval.</p>

<p>Assuming that each employee works on only his or her lighting fixture, and assuming that you yell “do it!” at most once during each time interval, your goal is to plan a sequence of “do it!”s so as to ensure that the sum of the times needed to finish all n lighting fixtures is minimized.</p>

### 입력 

 <p>The input test file will contain multiple test cases. Each input test case will be given as a line containing four integers, n<sub>+</sub>, n<sub>−</sub>, n<sub>0</sub>, and r (where 0 ≤ n<sub>+</sub>, n<sub>−</sub>, n<sub>0</sub> ≤ 1000 and 1 ≤ r ≤ 100). The end-of-file is marked by a test case with n<sub>+</sub> = n<sub>−</sub> = n<sub>0</sub> = r = 0 and should not be processed.</p>

### 출력 

 <p>For each input case, the program should print the minimum sum of times needed to finish all n lighting fixtures.</p>

