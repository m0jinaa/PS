# [Gold V] Family Tree - 22831 

[문제 링크](https://www.acmicpc.net/problem/22831) 

### 성능 요약

메모리: 18064 KB, 시간: 140 ms

### 분류

그래프 이론, 자료 구조, 문자열, 트리, 집합과 맵, 해시를 사용한 집합과 맵, 파싱

### 제출 일자

2025년 8월 23일 18:38:01

### 문제 설명

<p>A professor of anthropology was interested in people living in isolated islands and their history. He collected their family trees to conduct some anthropological experiment. For the experiment, he needed to process the family trees with a computer. For that purpose he translated them into text files. The following is an example of a text file representing a family tree.</p>

<pre>John
 Robert
  Frank
  Andrew
 Nancy
  David</pre>

<p>Each line contains the given name of a person. The name in the first line is the oldest ancestor in this family tree. The family tree contains only the descendants of the oldest ancestor. Their husbands and wives are not shown in the family tree. The children of a person are indented with one more space than the parent. For example, Robert and Nancy are the children of John, and Frank and Andrew are the children of Robert. David is indented with one more space than Robert, but he is not a child of Robert, but of Nancy. To represent a family tree in this way, the professor excluded some people from the family trees so that no one had both parents in a family tree.</p>

<p>For the experiment, the professor also collected documents of the families and extracted the set of statements about relations of two persons in each family tree. The following are some examples of statements about the family above.</p>

<pre>John is the parent of Robert.
Robert is a sibling of Nancy.
David is a descendant of Robert.</pre>

<p>For the experiment, he needs to check whether each statement is true or not. For example, the first two statements above are true and the last statement is false. Since this task is tedious, he would like to check it by a computer program.</p>

### 입력 

 <p>The input contains several data sets. Each data set consists of a family tree and a set of statements. The first line of each data set contains two integers n (0 < n < 1000) and m (0 < m < 1000) which represent the number of names in the family tree and the number of statements, respectively. Each line of the input has less than 70 characters.</p>

<p>As a name, we consider any character string consisting of only alphabetic characters. The names in a family tree have less than 20 characters. The name in the first line of the family tree has no leading spaces. The other names in the family tree are indented with at least one space, i.e., they are descendants of the person in the first line. You can assume that if a name in the family tree is indented with k spaces, the name in the next line is indented with at most k + 1 spaces. This guarantees that each person except the oldest ancestor has his or her parent in the family tree. No name appears twice in the same family tree. Each line of the family tree contains no redundant spaces at the end.</p>

<p>Each statement occupies one line and is written in one of the following formats, where X and Y are different names in the family tree.</p>

<pre>X is a child of Y.
X is the parent of Y.
X is a sibling of Y.
X is a descendant of Y.
X is an ancestor of Y.</pre>

<p>Names not appearing in the family tree are never used in the statements. Consecutive words in a statement are separated by a single space. Each statement contains no redundant spaces at the beginning and at the end of the line.</p>

<p>The end of the input is indicated by two zeros.</p>

### 출력 

 <p>For each statement in a data set, your program should output one line containing <code>True</code> or <code>False</code>. The first letter of <code>True</code> or <code>False</code> in the output must be a capital. The output for each data set should be followed by an empty line.</p>

