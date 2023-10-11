# [Gold III] Investment - 7382 

[문제 링크](https://www.acmicpc.net/problem/7382) 

### 성능 요약

메모리: 13160 KB, 시간: 104 ms

### 분류

다이나믹 프로그래밍, 배낭 문제

### 제출 일자

2023년 10월 11일 15:45:33

### 문제 설명

<p>John never knew he had a grand-uncle, until he received the notary‘s letter. He learned that his late grand-uncle had gathered a lot of money, somewhere in South-America, and that John was the only inheritor.</p>

<p>John did not need that much money for the moment. But he realized that it would be a good idea to store this capital in a safe place, and have it grow until he decided to retire. The bank convinced him that a certain kind of bond was interesting for him.</p>

<p>This kind of bond has a fixed value, and gives a fixed amount of yearly interest, payed to the owner at the end of each year. The bond has no fixed term. Bonds are available in different sizes. The larger ones usually give a better interest. Soon John realized that the optimal set of bonds to buy was not trivial to figure out. Moreover, after a few years his capital would have grown, and the schedule had to be re-evaluated.</p>

<p>Assume the following bonds are available:</p>

<table class="table table-bordered" style="width:30%">
	<thead>
		<tr>
			<th>Value</th>
			<th>Annual interest</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>4000</td>
			<td>400</td>
		</tr>
		<tr>
			<td>3000</td>
			<td>250</td>
		</tr>
	</tbody>
</table>

<p>With a capital of e 10 000 one could buy two bonds of e 4 000, giving a yearly interest of e 800. Buying two bonds of e 3 000, and one of e 4 000 is a better idea, as it gives a yearly interest of e 900. After two years the capital has grown to e 11 800, and it makes sense to sell a e 3 000 one and buy a e 4 000 one, so the annual interest grows to e 1 050. This is where this story grows unlikely: the bank does not charge for buying and selling bonds. Next year the total sum is e 12 850, which allows for three times e 4 000, giving a yearly interest of e 1 200.</p>

<p>Here is your problem: given an amount to begin with, a number of years, and a set of bonds with their values and interests, find out how big the amount may grow in the given period, using the best schedule for buying and selling bonds.</p>

### 입력 

 <p>The first line contains a single positive integer N which is the number of test cases. The test cases follow.</p>

<p>The first line of a test case contains two positive integers: the amount to start with (at most e 1 000 000), and the number of years the capital may grow (at most 40).</p>

<p>The following line contains a single number: the number d (1 ≤ d ≤ 10) of available bonds.</p>

<p>The next d lines each contain the description of a bond. The description of a bond consists of two positive integers: the value of the bond, and the yearly interest for that bond. The value of a bond is always a multiple of e 1 000. The interest of a bond is never more than 10% of its value.</p>

### 출력 

 <p>For each test case, output – on a separate line – the capital at the end of the period, after an optimal schedule of buying and selling.</p>

