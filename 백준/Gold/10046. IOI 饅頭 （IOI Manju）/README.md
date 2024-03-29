# [Gold II] IOI 饅頭 (IOI Manju) - 10046 

[문제 링크](https://www.acmicpc.net/problem/10046) 

### 성능 요약

메모리: 15740 KB, 시간: 200 ms

### 분류

다이나믹 프로그래밍, 배낭 문제, 누적 합, 정렬

### 제출 일자

2023년 10월 13일 17:01:07

### 문제 설명

<p>Incredible Okashi Inc. は「途方もなくおいしいお菓子 (incredible okashi)」を製作している会社である．ここでは略して IOI 社と呼ぶ．IOI 社は特製の IOI 饅頭を作ったので，それを販売することになった．IOI 社は M 種類の饅頭を 1 個ずつ作った．作られた M 個の饅頭はすべて同じ大きさであるが，ひとつひとつ異なる味なので価格は様々であり，i 番目 (1 ≤ i ≤ M) の饅頭の価格は P<sub>i</sub> 円である．</p>

<p>ところで，あなたは Just Odd Inventions 社を知っているだろうか？ この会社の業務は「ただ奇妙な発明(just odd inventions)」をすることである．ここでは略して JOI 社と呼ぶ．IOI 社は，饅頭を詰めるための高級な箱を JOI 社に発注することになった．JOI 社の製作する饅頭用の箱は N 種類あり，j 番目 (1 ≤ j ≤ N)の箱は最大で C<sub>j</sub> 個の饅頭を詰められる大きさであり，販売価格は E<sub>j</sub> 円である．これらの N 種類の箱のうちの何種類か (0 種類以上 N 種類以下) を 1 個ずつ発注し，饅頭をそれらの箱に詰め分けてセットで販売することになった．各饅頭セットの価格は，それに含まれる饅頭の価格の合計である．</p>

<p>すべての饅頭セットが売れるとした場合，IOI 社が得ることができる利益の最大値はいくらだろうか．ここで利益とは，販売した饅頭セットの価格の合計から，発注した箱の価格の合計を引いた値である．なお，箱に詰めなかった饅頭については，IOI 社のスタッフがおいしくいただくため，利益には影響しないものとする．</p>

<p>各饅頭の価格と，各箱の大きさと価格が与えられたとき，IOI 社が得ることができる利益の最大値を求めるプログラムを作成せよ．</p>

### 입력 

 <p>標準入力から以下のデータを読み込め．</p>

<ul>
	<li>1 行目には，整数 M, N が空白を区切りとして書かれており，饅頭が M 個，箱が N 種類あることを表す．</li>
	<li>続く M 行のうちの i 行目 (1 ≤ i ≤ M) には，整数 P<sub>i</sub> が書かれており，i 番目の饅頭の価格が P<sub>i</sub> 円であることを表す．</li>
	<li>続く N 行のうちの j 行目 (1 ≤ j ≤ N) には，整数 C<sub>j</sub>, E<sub>j</sub> が空白を区切りとして書かれており，j 番目の箱は最大で C<sub>j</sub> 個の饅頭を詰められる大きさであり，価格が E<sub>j</sub> 円であることを表す．</li>
</ul>

### 출력 

 <p>標準出力に，IOI 社が得られる利益の最大値を円単位で表す整数を 1 行で出力せよ．</p>

