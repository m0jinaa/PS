# [Gold V] 솹씨 몇 도예요? - 34187 

[문제 링크](https://www.acmicpc.net/problem/34187) 

### 성능 요약

메모리: 12092 KB, 시간: 64 ms

### 분류

애드 혹, 이분 탐색

### 제출 일자

2025년 10월 19일 23:37:44

### 문제 설명

<p><strong>이 문제는 인터랙티브 문제입니다.</strong></p>

<p>ICPC Sinchon은 거북이를 한 마리 기르고 있다. 그 이름은 솹북이. 사실 솹북이는 평범한 거북이가 아니다. 어떤 온도에도 적응할 수 있는 슈퍼 변온 동물로, 영어까지 할 수 있다.</p>

<p>동아리원들은 매일 솹북이를 씻길 때 솹북이가 가장 좋아하는 게임인 『SUAPC 몇 도예요?』를 한다. 이는 솹북이를 위해 샤워기의 물 온도를 조절하는 게임으로 규칙은 다음과 같다.</p>

<ul>
	<li>솹북이를 씻길 때 사용하는 샤워기는 물의 어는점을 $-10^9 \,^\circ\mathrm{S}$, 끓는점을 $10^9 \,^\circ\mathrm{S}$로 정의한 솹씨(Suapc, $^\circ\mathrm{S}$)라는 단위를 사용한다.</li>
	<li>$-10^9 \,^\circ\mathrm{S}$ 초과 $10^9 \,^\circ\mathrm{S}$ 미만의 원하는 온도로 샤워기를 튼다.</li>
	<li>솹북이는 샤워기의 온도가 자신의 체온보다 높다면 <span style="color:#e74c3c;"><code>Hot</code></span>, 낮다면 <span style="color:#e74c3c;"><code>Cold</code></span>, 체온과 정확히 일치한다면 <span style="color:#e74c3c;"><code>SUAPC!</code></span>를 외친다. 이때 샤워기의 온도를 $X \,^\circ\mathrm{S}$, 솹북이의 체온을 $T \,^\circ\mathrm{S}$라고 하면 체온에 따른 단어를 외친 이후 솹북이의 체온이 $\lfloor \frac{X+T}{2} \rfloor \,^\circ\mathrm{S}$로 변화한다.</li>
</ul>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/79ad42a0-3cbd-42e1-9a3f-55f743197a85/-/preview/" style="height: 272px; width: 300px;"></p>

<p>솹북이는 현재 $0 \,^\circ\mathrm{S}$ 이상 $2\,025 \,^\circ\mathrm{S}$ 이하의 체온을 유지하고 있으며 샤워기의 물 온도와 자신의 체온이 정확히 일치할 때 안정감을 느낀다. 동아리원들은 솹북이가 스트레스를 받지 않도록 최대 $9$번만에 적정 온도를 찾으려 한다. 오늘도 솹북이의 만족스러운 샤워를 도와주자!</p>

### 입력 

 <p>입력은 없다.</p>

### 출력 

 <p>인터랙터에게 보낼 수 있는 쿼리는 다음과 같다.</p>

<ul>
	<li><span style="color:#e74c3c;"><code>?</code></span> $X$: 샤워기의 물 온도를 $X \,^\circ\mathrm{S}$로 조절하여 튼다. $(-10^9 < X < 10^9)$</li>
</ul>

<p>쿼리의 결과는 한 줄에 주어지는 문자열 $A$를 입력 받아 확인할 수 있다. $A$는 <code><span style="color:#e74c3c;">Hot</span></code>, <code><span style="color:#e74c3c;">Cold</span></code>, <code><span style="color:#e74c3c;">SUAPC!</span></code> 중 하나이다.</p>

<p>솹북이의 현재 체온을 알아냈다면 다음과 같이 출력하고 프로그램을 종료해야 한다. 정답을 출력하는 것은 쿼리에 포함되지 않는다.</p>

<ul>
	<li><code><span style="color:#e74c3c;">!</span></code> $X$: 솹북이의 현재 체온이 $X \,^\circ\mathrm{S}$라면 <span style="color:#16a085;"><strong>맞았습니다!!</strong></span>를 받는다. 그렇지 않으면 <span style="color:#e74c3c;">틀렸습니다</span>를 받는다. $(-10^9 < X < 10^9)$</li>
</ul>

<p>인터랙션에 사용되는 모든 $X$는 정수여야 한다.</p>

<p>모든 출력 이후에는 반드시 표준 출력 버퍼를 flush해야 한다. 언어 별로 표준 출력 버퍼를 flush하는 방법은 다음과 같다.</p>

<ul>
	<li>C: <code>fflush(stdout)</code></li>
	<li>C++: <code>std::cout << std::flush</code></li>
	<li>Java: <code>System.out.flush()</code></li>
	<li>Python: <code>sys.stdout.flush()</code></li>
</ul>

<p>기타 언어의 경우 각 언어의 documentation을 참조하자.</p>

<p>출력 형식을 지키지 않거나 쿼리를 $9$번보다 많이 보낸 경우에는 예상치 못한 채점 결과를 받을 수 있음에 유의하자.</p>

