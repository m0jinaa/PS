# [Gold V] Codejamon Cipher (Small) - 14302 

[문제 링크](https://www.acmicpc.net/problem/14302) 

### 성능 요약

메모리: 15528 KB, 시간: 96 ms

### 분류

브루트포스 알고리즘, 다이나믹 프로그래밍, 문자열

### 제출 일자

2026년 3월 3일 14:55:55

### 문제 설명

<p>The Codejamon monsters talk in enciphered messages. Here is how it works:</p>

<p>Each kind of monster has its own unique vocabulary: a list of V different words consisting only of lowercase English letters. When a monster speaks, it first forms a sentence of words in its vocabulary; the same word may appear multiple times in a sentence. Then, it turns the sentence into an enciphered string, as follows:</p>

<ol>
	<li>Randomly shuffle each word in the sentence.</li>
	<li>Remove all spaces.</li>
</ol>

<p>Understanding the monsters can bring you huge advantages, so you are building a tool to do that. As the first step, you want to be able to take an enciphered string and determine how many possible original sentences could have generated that enciphered string. For example, if a monster's vocabulary is ["this", "is", "a", "monster", "retsnom"], and it speaks the enciphered string "ishtsiarestmon", there are four possible original sentences:</p>

<ul>
	<li>"is this a monster"</li>
	<li>"is this a retsnom"</li>
	<li>"this is a monster"</li>
	<li>"this is a retsnom"</li>
</ul>

<p>You have S enciphered strings from the same monster. For each one, can you figure out the number of possible original sentences?</p>

<p>IMPORTANT: Since the output can be a really big number, we only ask you to output the remainder of dividing the result by the prime 10<sup>9</sup> + 7 (1000000007).</p>

<ul>
</ul>

### 입력 

 <p>The first line of the input gives the number of test cases, T. T test cases follow. Each test case consists of one line with two integers V and S, the size of the monster's vocabulary and the number of enciphered strings. Then, V lines follow; each contains a single string of lowercase English letters, representing a word in the monster's vocabulary. Finally, Slines follow. Each contains a string consisting only of lowercase English letters, representing an enciphered sentence. It is guaranteed that all enciphered sentences are valid; that is, each one has at least one possible original sentence.</p>

### 출력 

 <p>For each test case, output one line containing <code>Case #x: y</code>, where <code>x</code> is the test case number (starting from 1) and <code>y</code> is a space separated list of of S integers: the answers (modulo 10<sup>9</sup> + 7) for each enciphered sentence, in the order given in the input, as described in the problem statement.</p>

