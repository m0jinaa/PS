# [Gold III] Candy - 5936 

[문제 링크](https://www.acmicpc.net/problem/5936) 

### 성능 요약

메모리: 12920 KB, 시간: 148 ms

### 분류

깊이 우선 탐색, 그래프 이론, 그래프 탐색, 배낭 문제

### 제출 일자

2023년 10월 10일 15:58:06

### 문제 설명

<p>Farmer John knows that Bessie loves to eat candy. FJ has N (1 <= N <= 40,000) candies that he wants to give Bessie over some number of days. Each day, Farmer John gives Bessie a choice of how many candies she chooses to eat that day by choosing the number from a master list FJ supplies that has Nopt (1 <= Nopt <= 50) different options, C_i (1 <= C_i <= N). She must take exactly C_i candies, no more, no less.</p>

<p>Farmer John has also disclosed F (1 <= F <= 50) of his favorite numbers, FN_i (1 <= FN_i <= N). Whenever the number of candies remaining at the end of the day precisely matches one of these favorite numbers, Bessie has the option to have him add exactly M (1 <= M <= 100) more candies to the candy supply. Bessie might get another option to add M candies several times if adding candies creates another favorite number. In the best circumstances, Bessie can obtain an infinite amount of candy!</p>

<p>When Bessie cannot choose some amount of candy to take (because there is not enough), and the number of candies remaining is not any of FJ's favorite numbers, she cannot have any more candy.</p>

<p>Unfortunately, Bessie cannot think ahead as far as she'd like to, so she needs your help in order to eat as many candies as possible.</p>

<p>By way of example, consider this scenario:</p>

<ul>
	<li>Farmer John's basket initially contains 10 candies</li>
	<li>Bessie can chose to eat either 3 or 5 candies each day</li>
	<li>Farmer John will add 1 candy any time the remaining number of candies is 2 or 4</li>
</ul>

<p>Bessie could use this set of choices to maximize the amount of candy she can eat:</p>

<pre>                  Initial      # Candies   Remaining     Bonus     Final
        Day      # Candies       Eaten      Candies     Candies   Candies

         1          10             3          7            0        7
         2           7             3          4            1        5
         3           5             3          2            1        3
         4           3             3          0            0        0</pre>

<p>Total candies eaten = 3 + 3 + 3 + 3 = 12.</p>

### 입력 

 <ul>
	<li>Line 1: Four space-separated integers: N, Nopt, F, and M</li>
	<li>Lines 2..Nopt+1: Line i+1 contains a single integer: C_i</li>
	<li>Lines Nopt+2..Nopt+F+1: Line i+Nopt+1 contains a single integer: FN_i</li>
</ul>

<p> </p>

### 출력 

 <ul>
	<li>Line 1: A single integer, denoting the maximum amount of candies Bessie can eat, or -1 if  Bessie can eat an infinite amount of candy.</li>
</ul>

<p> </p>

