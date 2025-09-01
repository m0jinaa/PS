# [Gold V] Impressive Beers - 33535 

[문제 링크](https://www.acmicpc.net/problem/33535) 

### 성능 요약

메모리: 12956 KB, 시간: 108 ms

### 분류

다이나믹 프로그래밍, 배낭 문제

### 제출 일자

2025년 9월 1일 23:14:25

### 문제 설명

<p>You and your friends find yourselves in a bar after class. As you are a really big fan of specialty beers you want to drink as many different beers as possible. Only issue of course being that you are still a student, and therefore you do not have enough money to buy every beer in the pub.</p>

<p>But of course, all beers are not created equally! You know of every type of beer the price and how much happiness it will give you. As you want to be as happy as possible, and being a Delft student, you want to find out how much happiness you can buy using an optimal strategy. So you decide to write a program that tells you how much happiness you can buy with a given amount of money. But since you like to drink different beers, you will never order the same beer twice, your program should take this into account.</p>

### 입력 

 <p>One line with two integers: $N, 1 \le N \le 500$ the number of different beers the pub offers, and $M, 1 \le M \le 10000$ the amount of money that you have.</p>

<p>Followed by $N$ lines with on each line a type of beer which is indicated by two integers: $p, 1 \le p \le 1000$, the price of the beer and $h, 1 \le h \le 1000$, the happiness you will gain from this beer.</p>

### 출력 

 <p>A single line with a single integer $H$, the maximal happiness you can gain by buying different kinds of beers, within your budget.</p>

