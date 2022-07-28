#include <iostream>

using namespace std;

typedef long long int ll;

ll arr[1002][10];
int main() {
  ll sum;
  int n;

  for(int i=0;i<10;i++){
    arr[2][i]=i+1;
  }
  
  for(int i=3;i<=1001;i++){
    arr[i][0]=arr[i-1][0];
    for(int j=1;j<10;j++){
      arr[i][j]=(arr[i][j-1]+arr[i-1][j])%10007;
    }
  }

  scanf("%d",&n);
  printf("%lld\n",arr[n+1][9]%10007);
}