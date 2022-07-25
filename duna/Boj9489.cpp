#include <iostream>

using namespace std;

int parent[1001];
int node[1001];

int main() {
  int n,k,check=0;
  while(1){
    scanf("%d %d",&n,&k);
    if(n==0 && k==0){
      break;
    }
    for(int i=1;i<=n;i++){
      scanf("%d",&node[i]);
      if(node[i]==k){
        check=i;
      }
    }

    parent[0]=-1;
    parent[1]=0;

    int p=0;
    for(int i=2;i<=n;i++){
      if(node[i]!=node[i-1]+1){
        p+=1;
      }
      parent[i]=p;
    }

    int cnt=0;
    for(int i=1;i<=n;i++){
      if (parent[parent[check]]==parent[parent[i]] && parent[check]!=parent[i]){
        cnt+=1;
      }
    }
    printf("%d\n",cnt);
  }
}