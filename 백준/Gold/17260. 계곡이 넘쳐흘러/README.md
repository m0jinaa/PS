# [Gold II] 계곡이 넘쳐흘러 - 17260 

[문제 링크](https://www.acmicpc.net/problem/17260) 

### 성능 요약

메모리: 117092 KB, 시간: 764 ms

### 분류

깊이 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 5월 29일 16:28:10

### 문제 설명

<p>숭실대학교 깊은 산속 숭실골 계곡에, 4차산업혁명으로 선물 포장 공장이 망해서 계곡에서 백숙을 팔며 연명하는 욱제가 살고 있다. 숭실골에는 N개의 계단식 계곡이 있고, 이 계곡들은 N-1개의 물길을 통해 트리 형태로 연결되어 있다. 즉, 임의의 두 계곡 사이에는 항상 유일한 경로가 존재한다. i번째 계곡은 해발 H<sub>i</sub>에 위치해 있다. 물길을 따라 해발이 더 높은 계곡의 물은 넘쳐흘러 낮은 계곡으로 떨어진다. 해발이 같은 계곡 사이에 물길이 있으면 양방향으로 물이 흐른다.</p>

<p>높이 H<sub>a</sub>에서 H<sub>b</sub>로 떨어진 물은 H<sub>b</sub>로부터 <strong>(H<sub>a</sub>-H<sub>b</sub>)/2</strong>만큼 튀어 오른다. 그러면 물이 해발 <strong>H<sub>b</sub>+(H<sub>a</sub>-H<sub>b</sub>)/2</strong>까지 올라가서, <strong>H<sub>c</sub> ≤ H<sub>b</sub>+(H<sub>a</sub>-H<sub>b</sub>)/2</strong>를 만족하는 c로 이동할 수 있다. 그러면 c에서는 <strong>(b에서 튄 높이 - c의 높이)/2</strong>, 즉 <strong>(H<sub>b</sub>+(H<sub>a</sub>-H<sub>b</sub>)/2 - H<sub>c</sub>)/2</strong>만큼 물이 튀어 오르게 된다. 튀어 오른 물은 물길을 통해서만 이동한다. 여러 계곡에서 한 계곡으로 물이 떨어지거나 한 계곡에서 여러 계곡으로 물이 튈 수 있는데, 이로 인해 계곡의 높이가 변하거나 튀는 물줄기 사이에 간섭이 생기는 일은 없다고 하자.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/47b6063a-61f3-49c5-a600-f8f194de3c18/-/preview/" style="height: 357px; width: 600px;"></p>

<p>(a→b는 a에서 b로 물이 이동함을 나타내며, a와 b는 편의상 두 계곡의 높이라고 하자) <strong>8→2</strong>인 경우 물은 <strong>(8-2)/2=3</strong>만큼 튀어 해발 5까지 올라간다. 그러면 최대 <strong>8→2→5</strong>까지 물이 이동할 수 있다. <strong>8→2→6</strong>, <strong>8→2→7</strong> 등은 불가능하다. <strong>8→2→2</strong>인 경우, <strong>8→2</strong>를 통해 해발 5까지 튄 물이 그 다음 해발 2의 계곡으로 떨어져서, <strong>(5-2)/2=1.5</strong>만큼 튀어 마지막에는 해발 3.5가 된다. 위 예제는 8에서 출발하면 모든 계곡에 도달할 수 있다.  </p>

<p>주방 이모 효빈이는 워터슬라이드처럼 물길을 타고 출근하려고 한다. 효빈이와 함께 욱제네 백숙집이 있는 K번 계곡으로 물이 이동해 올 수 있는 경로가 존재하는지 알아보자!</p>

### 입력 

 <p>첫째 줄에 계곡의 개수 N, 욱제가 있는 계곡의 번호 K가 주어진다. (1 ≤ N ≤ 200,000, 1 ≤ K ≤ N)</p>

<p>둘째 줄에 N개 계곡의 해발 높이 H<sub>i</sub>가 순서대로 주어진다. (1 ≤ H<sub>i</sub> ≤ 1,000,000, H<sub>i</sub>는 자연수)</p>

<p>셋째 줄부터 N-1개의 줄에 걸쳐 물길의 정보 u, v가 주어진다. 이는 u번 계곡과 v번 계곡 사이에 물길이 있다는 뜻이다. (1 ≤ u,v ≤ N, u ≠ v)</p>

### 출력 

 <p>시작점이 K가 아니면서, 조건에 맞게 K로 이동해 올 수 있는 경로가 하나라도 존재하면 1, 아니면 0을 출력한다.</p>

