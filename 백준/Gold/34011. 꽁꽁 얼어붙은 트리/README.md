# [Gold IV] 꽁꽁 얼어붙은 트리 - 34011 

[문제 링크](https://www.acmicpc.net/problem/34011) 

### 성능 요약

메모리: 157796 KB, 시간: 484 ms

### 분류

수학, 그래프 이론, 그래프 탐색, 트리, 정수론, 너비 우선 탐색, 소수 판정, 조화수

### 제출 일자

2025년 6월 26일 16:13:11

### 문제 설명

<p>노드가 $N$개인 꽁꽁 얼어붙은 트리 위로 고양이가 걸어 다니려고 한다. 루트 노드는 $1$번 노드이며, 트리를 이루는 모든 간선의 거리는 $1$이다.</p>

<p>$N-1$마리의 고양이가 $1$번 노드에 멈춰있고, 다른 노드로 걸어 다니기 위해 준비하고 있다. 하지만 이 트리는 꽁꽁 얼어붙어서, 각 고양이가 갖고 있는 고유한 제동지수에 따라 노드를 미끄러지면서 이동해야 한다. $N-1$마리 고양이의 제동지수 $d$는 각각 $2, 3, \cdots, N$이다.</p>

<p>고양이는 1회 이동 시 부모 방향(루트 방향) 혹은 자식 방향 중 하나를 선택하고, 그 방향으로만 간선을 따라 정확히 제동지수 $d$만큼 미끄러진 후 도착한 노드에 멈춰있을 수 있다. 즉, $1$ 이상 $d$ 미만으로 미끄러졌으나 루트 혹은 리프노드에 도착하도록 이동할 수 없다.</p>

<p>$N-1$마리의 고양이는 부모 방향 혹은 자식 방향으로 원하는 횟수만큼 이동할 수 있다. 각 고양이가 $1$번 노드를 포함해 멈춰있을 수 있는 노드의 개수를 구했을 때, 이 값들 중 가장 큰 값을 구해주자.</p>

### 입력 

 <p>첫째 줄에 꽁꽁 얼어붙은 트리의 노드 개수 $N$이 주어진다. $(2 \leq N \leq 10^6)$</p>

<p>둘째 줄에 $P_1, P_2, \cdots, P_{N-1}$이 공백으로 구분되어 주어진다. $i$번째 수는 $i+1$번 노드의 부모 노드 번호를 의미한다. $(1 \leq P_i \leq N)$</p>

<p>입력은 항상 트리임이 보장된다.</p>

### 출력 

 <p>$N-1$마리 고양이들이 $1$번 노드를 포함해 멈춰있을 수 있는 노드의 개수를 구했을 때, 이 값들 중 가장 큰 값을 하나의 정수로 출력한다.</p>

