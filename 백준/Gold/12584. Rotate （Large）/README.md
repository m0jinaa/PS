# [Gold V] Rotate (Large) - 12584 

[문제 링크](https://www.acmicpc.net/problem/12584) 

### 성능 요약

메모리: 15492 KB, 시간: 104 ms

### 분류

브루트포스 알고리즘, 구현, 시뮬레이션

### 제출 일자

2025년 8월 25일 23:53:47

### 문제 설명

<p>In the exciting game of Join-<strong>K</strong>, red and blue pieces are dropped into an <strong>N</strong>-by-<strong>N</strong> table. The table stands up vertically so that pieces drop down to the bottom-most empty slots in their column. For example, consider the following two configurations:</p>

<table style="border-collapse:collapse; border-width:0pt; color:rgb(0, 0, 0); font-family:arial,sans-serif; font-size:small; margin:0px; padding:0px; vertical-align:top">
	<tbody>
		<tr>
			<td style="vertical-align:top">
			<pre>    <strong>- Legal Position -</strong>

          .......
          .......
          .......
          ....R..
          ...RB..
          ..BRB..
          .RBBR..
</pre>
			</td>
			<td style="vertical-align:top">
			<pre>   <strong>- Illegal Position -</strong>

          .......
          .......
          .......
          .......
   Bad -> ..BR...
          ...R...
          .RBBR..
</pre>
			</td>
		</tr>
	</tbody>
</table>

<p>In these pictures, each '.' represents an empty slot, each 'R' represents a slot filled with a red piece, and each 'B' represents a slot filled with a blue piece. The left configuration is legal, but the right one is not. This is because one of the pieces in the third column (marked with the arrow) has not fallen down to the empty slot below it.</p>

<p>A player wins if they can place at least <strong>K</strong> pieces of their color in a row, either horizontally, vertically, or diagonally. The four possible orientations are shown below:</p>

<table style="border-collapse:collapse; border-width:0pt; color:rgb(0, 0, 0); font-family:arial,sans-serif; font-size:small; margin:0px; padding:0px; vertical-align:top">
	<tbody>
		<tr>
			<td style="vertical-align:top">
			<pre>      <strong>- Four in a row -</strong>

     R   RRRR    R   R
     R          R     R
     R         R       R
     R        R         R
</pre>
			</td>
			<td style="vertical-align:top"> </td>
		</tr>
	</tbody>
</table>

<p>In the "Legal Position" diagram at the beginning of the problem statement, both players had lined up two pieces in a row, but not three.</p>

<p>As it turns out, you are right now playing a very exciting game of Join-<strong>K</strong>, and you have a tricky plan to ensure victory! When your opponent is not looking, you are going to rotate the board 90 degrees clockwise onto its side. Gravity will then cause the pieces to fall down into a new position as shown below:</p>

<table style="border-collapse:collapse; border-width:0pt; color:rgb(0, 0, 0); font-family:arial,sans-serif; font-size:small; margin:0px; padding:0px; vertical-align:top">
	<tbody>
		<tr>
			<td style="vertical-align:top">
			<pre>    <strong>- Start -</strong>

     .......
     .......
     .......
     ...R...
     ...RB..
     ..BRB..
     .RBBR..
</pre>
			</td>
			<td style="vertical-align:top">
			<pre>   <strong>- Rotate -</strong>

     .......
     R......
     BB.....
     BRRR...
     RBB....
     .......
     .......
</pre>
			</td>
			<td style="vertical-align:top">
			<pre>   <strong>- Gravity -</strong>

     .......
     .......
     .......
     R......
     BB.....
     BRR....
     RBBR...
</pre>
			</td>
		</tr>
	</tbody>
</table>

<p>Unfortunately, you only have time to rotate once before your opponent will notice.</p>

<p>All that remains is picking the right time to make your move. Given a board position, you should determine which player (or players!) will have <strong>K</strong> pieces in a row after you rotate the board clockwise and gravity takes effect in the new direction.</p>

<h3>Notes</h3>

<ul>
	<li>You can rotate the board only once.</li>
	<li>Assume that gravity only takes effect after the board has been rotated completely.</li>
	<li>Only check for winners after gravity has finished taking effect.</li>
</ul>

### 입력 

 <p>The first line of the input gives the number of test cases, <strong>T</strong>. <strong>T</strong> test cases follow, each beginning with a line containing the integers <strong>N</strong> and <strong>K</strong>. The next <strong>N</strong> lines will each be exactly <strong>N</strong> characters long, showing the initial position of the board, using the same format as the diagrams above.</p>

<p>The initial position in each test case will be a legal position that can occur during a game of Join-<strong>K</strong>. In particular, neither player will have already formed <strong>K</strong> pieces in a row.</p>

<h3>Limits</h3>

<ul>
	<li>1 ≤ <strong>T</strong> ≤ 100.</li>
	<li>3 ≤ <strong>K</strong> ≤ <strong>N</strong>.</li>
	<li>3 ≤ <strong>N</strong> ≤ 50.</li>
</ul>

### 출력 

 <p>For each test case, output one line containing "Case #x: y", where x is the case number (starting from 1), and y is one of "Red", "Blue", "Neither", or "Both". Here, y indicates which player or players will have <strong>K</strong> pieces in a row after you rotate the board.</p>

