# [Gold IV] 커넥티드 카 실험 - 25395 

[문제 링크](https://www.acmicpc.net/problem/25395) 

### 성능 요약

메모리: 332384 KB, 시간: 1248 ms

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색, 두 포인터

### 문제 설명

<p>정보통신기술(ICT)의 발달에 힘입어, 미래형 자동차로 여겨졌던 인터넷 연결을 통해 운전자에게 다양한 서비스를 제공하는 커넥티드 카(connected car)가 현실로 다가왔다. 현대오토에버는 이에 발맞춰 클라우드와 사물 인터넷을 비롯한 최신 ICT를 적용한 차세대 커넥티드 카 서비스 플랫폼을 구축하고, 최고의 커넥티드 카를 완성하기 위한 핵심 소프트웨어 기술을 축적하고 있다.</p>

<p>현대오토에버의 엔지니어 현오는 새로운 서비스를 생각하던 중, 커넥티드 카의 핵심 기술인 사물 인터넷과 위치 기반 기술을 접목한 실험을 해 보기로 했다. 현오가 개발한 실험용 프로그램은 다음과 같은 기능을 가지고 있다.</p>

<ul>
	<li>현오는 사물 인터넷에 연결된 커넥티드 카를 원격 조종할 수 있다.</li>
	<li>사물 인터넷에 연결된 커넥티드 카가 그렇지 않은 커넥티드 카와 같은 위치에 있게 되면, 그 커넥티드 카를 사물 인터넷에 연결시킬 수 있다. 이후 두 커넥티드 카가 다시 서로 멀어지더라도 연결은 그대로 유지된다.</li>
</ul>

<p>현오는 실험을 위해 $1$부터 $N$까지 번호가 매겨진 $N$대의 커넥티드 카를 일렬로 배치했다. $i$번 커넥티드 카의 초기 위치는 $x_i$이고, 연료량은 $h_i$이다. 모든 커넥티드 카는 $1$만큼의 연료를 소비해서 $1$의 거리만큼 이동할 수 있으며, 연료를 모두 소비하면 더 이상 움직일 수 없다.</p>

<p>처음에 커넥티드 카들은 모두 사물 인터넷에 연결되지 않은 상태이다. 현오는 먼저 $S$번 커넥티드 카를 사물 인터넷에 연결시키고, 프로그램의 기능을 적절히 사용해 다른 커넥티드 카들에 사물 인터넷을 전파하려고 한다.</p>

<p>현오가 커넥티드 카들을 어떻게 다루느냐에 따라 실험에서 사물 인터넷에 연결되는 커넥티드 카들의 조합은 달라질 수 있다. 현오가 다양한 방법으로 여러 번 실험을 진행할 때, 사물 인터넷에 연결될 가능성이 있는 커넥티드 카를 전부 구해 보자.</p>

### 입력 

 <p>첫 번째 줄에 $N$과 $S$가 주어진다. $(1\leq N\leq 1\, 000\, 000;$ $1\leq S\leq N)$</p>

<p>두 번째 줄에 각 커넥티드 카의 초기 위치 $x_1,x_2,\cdots ,x_N$이 공백으로 구분되어 차례로 주어진다. $(0\leq x_i\leq 10^9;$ $x_i\leq x_{i+1})$</p>

<p>세 번째 줄에 각 커넥티드 카의 연료량 $h_1,h_2,\cdots ,h_N$이 공백으로 구분되어 차례로 주어진다. $(1\leq h_i\leq 10^9)$</p>

### 출력 

 <p>첫 번째 줄에 사물 인터넷에 연결될 가능성이 있는 모든 커넥티드 카의 번호를 오름차순으로 정렬하여 출력한다.</p>

