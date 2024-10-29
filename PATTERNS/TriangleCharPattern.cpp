#include <bits/stdc++.h>
using namespace std;

// Method 01: Time complexity of O(N^2).

void printPattern1(int n)
{
    for (int i = 0; i < n; i++)
    {
        for (char c = 'A'; c <= 'A' + i; c++)
        {
            cout << c << " ";
        }
        cout << endl;
    }
}

// Method 02: Time complexity of O(N) only.

void printPattern2(int n)
{
    string line;
    for (int i = 0; i < n; i++)
    {
        line += 'A' + i;
        cout << line << endl;
    }
}

int main()
{
    cout << "Result of method 01: " << endl;
    printPattern1(5);
    cout << "Result of method 02: " << endl;
    printPattern2(7);
    return 0;
}