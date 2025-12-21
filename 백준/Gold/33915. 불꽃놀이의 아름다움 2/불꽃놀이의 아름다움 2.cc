#include <iostream>
#include <cstring>
#include<vector>


using namespace std;

vector<vector<int>> connectedTo;
vector<int> depth;
int cycle = 0;

void dfs(int x, int b) {
	depth[x] = depth[b] + 1;

	for (int nx : connectedTo[x]) {
		if (nx == b)
			continue;
		else if (depth[nx] != 0) {
            cycle = depth[x] - depth[nx] + 1;
		}
		else {
            dfs(nx, x);
		}
	}
}

int32_t main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;

	cin >> n;

	connectedTo.assign(n + 1, vector<int>(0, 0));
	depth.assign(n + 1, 0);

	int a, b;

	for (int i = 0; i < n; i++) {
		cin >> a >> b;
		connectedTo[a].push_back(b);
		connectedTo[b].push_back(a);
	}
	
	dfs(1,0);

	int answer = cycle % 2 == 0 ? 2 : 3;

	cout << answer << endl;
}