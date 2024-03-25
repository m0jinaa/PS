#include <iostream>
#include<string>
#include<vector>

using namespace std;

int main()
{
	string A, B;

	cin >> A >> B;

	int n = A.length()-1;
	int m = B.length()-1;

	vector<int> q;

	int digit;
	int carry = 0;

	while (n >= 0 || m >= 0) {
		digit = carry;

		if (n >= 0) {
			digit += (A[n--] - '0');
		}
		if (m >= 0) {
			digit += (B[m--] - '0');
		}

		carry = digit / 10;

		q.push_back(digit % 10);
	}

	if (carry != 0) {
		q.push_back(carry);
	}

	int t = q.size()-1;

	while (t >= 0) {
		cout << q[t--];
	}

	return 0;
}