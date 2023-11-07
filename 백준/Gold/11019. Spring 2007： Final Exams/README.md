# [Gold IV] Spring 2007: Final Exams - 11019 

[문제 링크](https://www.acmicpc.net/problem/11019) 

### 성능 요약

메모리: 13000 KB, 시간: 112 ms

### 분류

다이나믹 프로그래밍, 배낭 문제

### 제출 일자

2023년 11월 7일 18:20:48

### 문제 설명

<p>In Spring of 2007, we were a little late in scheduling the contest, so that it ended up being on a weekend during study days. To “help” students make up for the time they were wasting at the contest, we called it the “Final Exams” Contest, and had all problems have study and exam themes. One of the problems asked students to figure out optimal ways to allocate study time across different courses.</p>

<p>Given that study time is rather limited, it is crucial to divide it up well for studying for various exams. In the end, you just want to maximize your GPA, so maybe it’s worth to put up with a C in one course (where a better grade would require a lot of studying) to secure A’s (which can be achieved with relatively little studying each) in all other courses. Clearly, this is a crucial optimization problem, and solving it well will probably benefit you tremendously.</p>

### 입력 

 <p>The first line contains a number K ≥ 1, which is the number of input data sets in the file. This is followed by K data sets of the following form:</p>

<p>The first line of a data set contains two numbers n, H, the number of courses you are taking (an integer n between 1 and 10) and the number of hours available for studying (an integer H ≤ 100).</p>

<p>This is followed by n lines, each containing 10 integers. These integers in line i will describe, in the order given, the number of hours you need to study in order to get an A (4.0), A- (3.7), B+ (3.3), B (3.0), B- (2.7), C+ (2.3), C (2.0), C- (1.7), D+ (1.3), D (1.0) in the ith of your courses. The numbers will be non-increasing. The interpretation is that if you study at least that many hours in the particular subject, you will get the given grade. If you don’t even study enough for a D, your grade will be F (0.0).</p>

### 출력 

 <p>For each data set, first output “Data Set x:” on a line by itself, where x is its number. Then, output the maximum possible GPA (rounded to two decimals) you can obtain by dividing your H hours of studying between the subjects.</p>

<p>Each data set should be followed by a blank line.</p>

