# [Gold IV] Kutije - 23688 

[문제 링크](https://www.acmicpc.net/problem/23688) 

### 성능 요약

메모리: 188664 KB, 시간: 780 ms

### 분류

자료 구조, 분리 집합

### 제출 일자

2023년 11월 28일 22:06:55

### 문제 설명

<p><img alt="" src="https://upload.acmicpc.net/6aab80a7-7a1b-49b1-8c79-9c6bed40f836/-/preview/" style="width: 124px; height: 119px; float: right;">Martin has n boxes labeled with positive integers from 1 to n. Each box contains a toy. The toys are also labeled with positive integers from 1 to n and in such a way that initially the toy with label i is contained in the box with label i.</p>

<p>From time to time, Martin calls one of his m friends to come over and hang out. Once they meet up, his friend takes the toys out of the boxes and starts having fun with them. In the meantime, Martin is more interested in the boxes. Once they become bored, his friend puts the toys back into the boxes. However, he doesn’t necessarily put every toy in the box it was taken from.</p>

<p>Martin has noticed that each of his m friends scrambles the toys in the same way each time. More precisely, each of his friends has his own array of n positive integers p<sub>1</sub>, ..., p<sub>n</sub> which determines the way he will put the toys back into the boxes. Every positive integer from 1 to n appears exactly once in this array. His friend scrambles the toys in such a way that at the end of their meeting the box with label i contains the toy that was in the box with label p<sub>i</sub> at the start of their meeting. Notice that, because every positive integer from 1 to n appears exactly once in the array, after all the toys are back in the boxes, each box will again have exactly one toy in it.</p>

<p>Martin is now interested in answering questions of the following form: he is wondering whether it is possible that the toy with label a (which is initially in box with label a) can end up in the box with label b via a sequence of meetups with his friends. A sequence of meetups means that Martin can call whichever friends he wants and in any order. He can call a friend multiple times, or not at all. Martin is interested in answering q such questions.</p>

### 입력 

 <p>The first line contains positive integers n, m and q - the number of boxes (also toys), the number of Martin’s friends and the number of questions, respectively.</p>

<p>The k-th of the following m lines contains an array of positive integers p<sub>1</sub>, ..., p<sub>n</sub> that is used by Martin’s k-th friend for putting the toys back into the boxes. Each positive integer from 1 to n appears exactly once in the array.</p>

<p>Each of the following q lines contains two positive integers a and b (1 ≤ a, b ≤ n) which represent a question.</p>

### 출력 

 <p>In q lines print the answer to the given qustions, in order: <code>DA</code> if it is possible to get the toy in question to the desired box, and <code>NE</code> otherwise.</p>

