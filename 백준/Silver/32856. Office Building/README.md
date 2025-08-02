# [Silver V] Office Building - 32856 

[문제 링크](https://www.acmicpc.net/problem/32856) 

### 성능 요약

메모리: 11716 KB, 시간: 76 ms

### 분류

구현, 브루트포스 알고리즘

### 제출 일자

2025년 8월 2일 23:19:24

### 문제 설명

<p>Company Z has purchased a land lot for their new office building. The land is shaped like a rectangular grid with $r$ rows and $c$ columns, in which each cell has a tree. The age of each tree is known.</p>

<p>Because Company Z is at the innovative front of the world, their new office building will not just be rectangular. Instead, it will have some exotic shape and a very special floor plan. The shape can be represented by some connected grid cells. There is no particular facing requirement of the building, and the floor plan can be rotated by $90$ degrees an arbitrary number of times. However, the floor plan cannot be flipped vertically or horizontally.</p>

<p>Company Z wants to choose a building location within their land lot. The trees in those cells that are occupied by the building will have to be cut down. Company Z would like to preserve the trees so that the sum of age of the remaining trees is as large as possible. Could you help them choose the best location for their new office building?</p>

### 입력 

 <p>The first line of input contains two integers $r$ and $c$ ($1 ≤ r, c ≤ 20$), the dimensions of the land lot.</p>

<p>The next $r$ lines each contain $c$ integers between $1$ and $100$ (both inclusive) describing the ages of the trees in the land lot.</p>

<p>The next line contains two integer $s$ and $t$ ($1 ≤ s ≤ r$, $1 ≤ t ≤ c$), the dimensions of the floor plan.</p>

<p>The next $s$ lines each contain $t$ characters that describe the floor plan of the building. A hash (<code>#</code>) denotes a cell occupied by the building and a dot (<code>.</code>) denotes a non-occupied cell. There is at least one hash. It is guaranteed that the hashes form a connected shape. Two hashes are directly connected if their cells share a side, and a shape is connected when all its hashes are either directly or indirectly connected. There is no row or column in the floor plan that is completely empty.</p>

### 출력 

 <p>Output a single integer, the maximum sum of age of the trees that can be preserved.</p>

