#include<bits/stdc++.h>
using namespace std;


int main(){
    int n = 0;
    cout<< "Enetr the size of your array: ";
    cin >> n;

    int array[n];
    for(int i=0; i<n; i++){
        cin >> array[i];
    }

    // Precomute the array elements
    int hash[15] = {0};
    for(int i=0; i<n; i++){
        hash[array[i]] += 1;
    }

    cout<< "The " << array[4] <<" has beed occured: " << hash[4];

    return 0;
}