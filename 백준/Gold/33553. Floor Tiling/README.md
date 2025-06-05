# [Gold IV] Floor Tiling - 33553 

[문제 링크](https://www.acmicpc.net/problem/33553) 

### 성능 요약

메모리: 12584 KB, 시간: 76 ms

### 분류

임의 정밀도 / 큰 수 연산, 다이나믹 프로그래밍

### 제출 일자

2025년 6월 5일 13:42:03

### 문제 설명

<p>Your friend John has recently moved to the city of Delft. During the decoration of one of the rooms in his house, he decided that he does not like the current floor in the room. He has seen several interesting floor patterns but there's one pattern that has his favor: a floor that is covered domino planks. A domino plank is a special type of plank that has a width of one meter and a height of two meters. The planks can be laid out horizontally or vertically and cannot be sawed into smaller pieces. Now John still has to decided how the floor is going to look like because there are many possibilities to cover the whole floor. For example, if the room of John is 3x8 meters, there are already 153 possible ways of covering the floor!</p>

<p>John would like to know how many possibilities there are for each room in his house. Since he's very smart, he has come up with a program that outputs, given the height and width of the room, the number of ways to cover the floor of the room with domino tiles. He challenges you to do the same, but he made the problem easier: you can assume that the width of the rooms is always 3 meter. Moreover, you can assume that the width of the room is even (otherwise the floor cannot be fully covered with domino planks). Can you solve the challenge of John and tell how many possible coverings there are for a 3 x <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c32"></mjx-c></mjx-mn><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D45B TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>2</mn><mi>n</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$ 2n $</span></mjx-container> floor?</p>

### 입력 

 <p>A single integer n, <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c31"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="4"><mjx-c class="mjx-c1D45B TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="4"><mjx-c class="mjx-c31"></mjx-c><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>1</mn><mo>≤</mo><mi>n</mi><mo>≤</mo><mn>100</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$1 \leq n \leq 100$</span></mjx-container>.</p>

### 출력 

 <p>The number of different ways in which a <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c33"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>3</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$ 3 $</span></mjx-container> x <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c32"></mjx-c></mjx-mn><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D45B TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>2</mn><mi>n</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$ 2n $</span></mjx-container> floor can be tiled with domino planks.</p>

