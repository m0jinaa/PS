# [Gold V] James’s Birthday Party - 24773 

[문제 링크](https://www.acmicpc.net/problem/24773) 

### 성능 요약

메모리: 35704 KB, 시간: 1840 ms

### 분류

단절점과 단절선, 너비 우선 탐색, 브루트포스 알고리즘, 깊이 우선 탐색, 플러드 필, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 7월 3일 14:59:39

### 문제 설명

<p><img alt="" src="https://upload.acmicpc.net/028b105f-cfa5-4e3c-9bb9-3b5b0c103d9e/-/preview/" style="width: 330px; height: 165px; float: right;">James needs some help figuring out whether he can invite all of his friends to his birthday party. Luckily for James, he doesn't have to invite all of his friends by himself, because his friends will forward invitations to each other.</p>

<p>Consider this example: James has three friends: Lucy, Sue, and Mark. James is friends with all three of them, but unfortunately he doesn't have Mark's phone number so he can't invite him directly. However, Sue has Mark's number (and vice versa) so she can invite Mark to James’s party.</p>

<p>The question that you need to answer is that if anyone lost one of the phone numbers for anyone else, would it be impossible to invite everybody to the party? Continuing the above example, if Sue lost Mark's number (the edge denoted by the red arrow above), then it would not be possible to invite everybody to the party. You should assume that if Sue loses Mark's number, then Mark will also lose Sue's number. Please help James figure out if he is at risk at having someone miss his party if any pair of friends loses contact with each other.</p>

### 입력 

 <p>The input will contain multiple test cases. Each test case contains on a single line two integer numbers p (1 ≤ p ≤ 100) and c (0 ≤ c ≤ 5000). p represents the number of people James wants to invite to the party, including himself. The next c lines represent the connections among James’s friends represented as two integers a (0 ≤ a < p) and b (0 ≤ b < p), where a is not equal to b. This means that friend number a has friend number b’s phone number and vice versa.</p>

<p>The input will be terminated by a line containing 2 zeros.</p>

### 출력 

 <p>For each test case, if a pair could lose each other's numbers and make it so that not everybody can be invited to the party, print "Yes". Otherwise, print "No”.</p>

