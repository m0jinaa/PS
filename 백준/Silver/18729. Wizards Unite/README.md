# [Silver III] Wizards Unite - 18729 

[문제 링크](https://www.acmicpc.net/problem/18729) 

### 성능 요약

메모리: 164168 KB, 시간: 1028 ms

### 분류

그리디 알고리즘, 정렬

### 제출 일자

2024년 5월 14일 15:48:00

### 문제 설명

<p>Greetings, Young Wizard! Your adventure begins here. But before you start, you have to prove that you are worthy. Shall you pass the test?</p>

<p>You have a bunch of old chests, each likely containing magical wonders of the wizarding world. You’d like to open them all by using keys that you have at your disposal.</p>

<p>In your key cabinet you have one gold key and k silver keys. Any key can open any chest, but each silver key can only be used once, while the gold key can be used multiple times. For each chest, you know how long it takes you to open it. You cannot use a single key to open several chests simultaneously. If you start opening a chest with some key, you have to wait till the chest is opened to reuse the key (of course, the key can be reused only if it’s the gold one). On the other hand, you can use different keys simultaneously to open different chests, so it’s possible that you are opening several chests at the same time (the described mechanics of opening chests with gold and silver keys actually exists in the game “Wizards Unite”. It is allowed to use the insights gained by solving this problem when playing the game).</p>

<p>What is the minimum time needed to open all the chests?</p>

### 입력 

 <p>The first line of input contains the number of test cases z. The descriptions of the test cases follow.</p>

<p>The first line of each test case contains two integers n and k (0 ≤ k < n ≤ 10<sup>5</sup>) – the number of chests and the number of silver keys.</p>

<p>The second line of each test case contains n integers t<sub>i</sub> (0 ≤ t<sub>i</sub> ≤ 10<sup>9</sup>). Each t<sub>i</sub> is the time needed to open the i-th chest.</p>

<p>The total number of chests in all test cases does not exceed 10<sup>6</sup>.</p>

### 출력 

 <p>For each test case, output a single line which contains a single integer – the minimum time you need to open all the chests.</p>

