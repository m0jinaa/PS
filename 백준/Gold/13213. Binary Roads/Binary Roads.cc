#include <iostream>
#include <vector>
#include <queue>
using namespace std;

vector<int> canGo[200001][2];
bool v[200001][2];

int bfs(int n) {
	queue<pair<pair<int,int>,int>> q;

	q.push(make_pair(make_pair(0, 0), 0));
	q.push(make_pair(make_pair(0, 1), 0));

	v[0][0] = true;
	v[0][1] = true;
	int x, y, d;

	int answer = -1;

	while (q.size()) {
		x = q.front().first.first;
		y = q.front().first.second;
		d = q.front().second;
		
		q.pop();

		if(x==n-1){
			answer = d;
			break;
		}

		for (int i = 0; i < canGo[x][y].size(); i++) {
			int nx = canGo[x][y][i];

			if (v[nx][1 - y])
				continue;
            
			v[nx][1 - y] = true;
			q.push(make_pair(make_pair(nx, 1 - y), d + 1));
		}
	}
		return answer;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL), cout.tie(NULL);

	int n, e;
	
	cin >> n >> e;

	int a, b, c;

	for (int i = 0; i < e; i++) {
		cin >> a >> b >> c;
		canGo[a][c].push_back(b);
		canGo[b][c].push_back(a);
	}

	int answer = bfs(n);

	cout << answer << "\n";

	return 0;
}