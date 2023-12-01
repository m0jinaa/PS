#include <iostream>
#include <vector>
#include<algorithm>

using namespace std;

vector<int> parent(1000001);

struct road { int s, e, c; };

bool cmp(road x, road y) {
	return x.c < y.c;
}

int find(int x) {
	if (parent[x] == x) return x;
	else return parent[x] = find(parent[x]);
}

int merge(int x, int y) {
	x = find(x);
	y = find(y);

	if (x == y)
		return 0;
	else if (x < y)
		parent[y] = x;
	else
		parent[x] = y;

	return 1;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL), cout.tie(NULL);

	int N, M;

	while (1) {
		cin >> N >> M;
		if (N == 0 && M == 0)
			break;

		parent.resize(N);

		for (int i = 0; i < N; i++)
			parent[i] = i;

		vector<road> roads(M);

		for (int i = 0; i < M; i++)
			cin >> roads[i].s >> roads[i].e >> roads[i].c;

		sort(roads.begin(), roads.end(), cmp);

		int cnt = 0;
		int cost = 0;

		for (int i = 0; i < M; i++) {
			int s = roads[i].s, e = roads[i].e, c = roads[i].c;

			if (merge(s, e) == 1) {
				cost = c;
				cnt++;
			}

			if (cnt == N - 1) {
				break;
			}
		}
		if (cnt == N - 1) {
			cout << cost << "\n";
		}
		else {
			cout << "IMPOSSIBLE\n";
		}
	}

	return 0;
}