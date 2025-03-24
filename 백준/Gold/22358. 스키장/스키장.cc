#include <iostream>
#include <cstring>
#include<vector>

using namespace std;

typedef long long ll;

typedef pair<ll, ll> node;
const int MAX_N = 100001;
const ll INF = -1e16;
vector<node> canGo[MAX_N];
ll N, M, K, S, T, dp[MAX_N][11];

ll getMax(ll x, ll y) {
	
	ll& ret = dp[x][y];

	if (ret != -1)
		return ret;

	ret = INF;

	ll res;
	for (auto nx : canGo[x]) {
		if ((nx.second == 0 && y == K )||((res = getMax(nx.first,y+(nx.second == 0?1:0))) == INF))
			continue;
		ret = max(ret, res+nx.second);
	}

	return ret;
}
int main()
{
	cin.tie(0)->sync_with_stdio(0);

	cin >> N >> M >> K >> S >> T;

	ll a, b, c;

	while (M--) {
		cin >> a >> b >> c;

		canGo[a].push_back({ b,c });
		canGo[b].push_back({ a,0 });
	}

	memset(dp, -1, sizeof(dp));

	dp[T][K] = 0;

	ll answer = getMax(S, 0);

	cout << (answer == INF ? -1 : answer)<< "\n";
}