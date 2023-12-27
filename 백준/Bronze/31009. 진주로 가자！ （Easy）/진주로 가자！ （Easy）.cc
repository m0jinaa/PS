#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n; cin >> n;

	string dest;
	int cost;
	
	int count[1001] = { 0, };

	int cnt = 0;
	string target = "jinju";
	int limit = 0;

	for (int i = 0; i < n; i++) {
		cin >> dest >> cost;

		count[cost]++;

		if (target.compare(dest) == 0) {
			limit = cost;
		}
	}

	for (int i = limit+1; i <= 1000; i++) {
		cnt += count[i];
	}

	cout << limit << "\n" << cnt << "\n";
}