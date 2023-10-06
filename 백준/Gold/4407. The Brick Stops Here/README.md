# [Gold IV] The Brick Stops Here - 4407 

[문제 링크](https://www.acmicpc.net/problem/4407) 

### 성능 요약

메모리: 13880 KB, 시간: 264 ms

### 분류

다이나믹 프로그래밍, 배낭 문제

### 문제 설명

<p>You have been hired by several clients of a factory that manufactures brass bricks. Brass is an alloy of copper and zinc; each brick weighs 1000 grams, and the copper content of a brick can range from 1 to 999 grams. (Note that brass with less than 55% or more than 62% of copper is practically useless; however, this is irrelevant for this question) The factory manufactures, through various processes, different types of brick, each of which has a different copper concentration and price. It distributes a catalog of these types to its customers.</p>

<p>Your clients desire to buy a certain number (M) of bricks, which for, uh, religious reasons must be of different types. They will be melted together, and the resultant mixture must have a concentration of at least CMin and at most CMax grams of copper per kilogram. Their goal is to pick the M types of brick so that the mixture has the correct concentration and the price of the collection is minimized. You must figure out how to do this. M, CMin, and CMax will vary depending on the client.</p>

### 입력 

 <p>The first part of input consists of a line containing a number N (1 <= N <= 200), the number of brick types, and then N lines containing the copper concentration (between 1 and 999) and price (in cents) of each brick type. No brick costs more than 10 dollars.</p>

<p>The second part consists of a line containing a number C (1 <= C <= 100), the number of clients you are serving, followed by C lines containing M (1 <= M <= 20), CMin (1 <= CMin <= 999), and CMax (1 <= CMax <= 999) for each client.</p>

<p>All input numbers will be positive integers.</p>

### 출력 

 <p>Output consists of a line for each client containing the minimum possible price for which they can purchase bricks to meet their demands. If there is no way to match their specifications, output "impossible".</p>

