#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
const int MAX = 10001;
const int INF =  1000000001;

int n, m;
int dp[101][MAX];

struct ticket {
	int b,c,d;
};
vector<vector<ticket>> canGo;

int getMin(int x, int c) {
	int& ans = dp[x][c];

	if (ans != -1)
		return ans;
	if (x == n-1)
		return ans = 0;

	ans = INF;

	for (auto& now : canGo[x]) {
		if (c >= now.c) {
			ans = min(ans, getMin(now.b, c-now.c) + now.d);
		}
	}

	return ans;

}
int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int tc;
	cin >> tc;

	int k;
	int a, b, c, d;

	while (tc-- > 0) {
		cin >> n >> m >> k;

		canGo.clear();
		canGo.resize(n+1);

		while (k-- > 0) {
			cin >> a >> b >> c >> d;
			canGo[--a].push_back({ --b, c, d });
		}

		fill(&dp[0][0], &dp[100][MAX-1], -1);

		int answer = getMin(0, m);

		if (answer == INF) {
			cout << "Poor KCM\n";
		}
		else {
			cout << answer << "\n";
		}
	}
}