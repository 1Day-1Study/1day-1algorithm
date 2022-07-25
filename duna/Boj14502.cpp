#include <iostream>
#include <vector>
#include <queue>
#include<algorithm>

using namespace std;

struct rc{
  int r;
  int c;
};

int n,m,ans=0;
int arr[8][8];
int temp[8][8];
vector <rc> pos;
queue <rc> q;

int drs[4]={-1,1,0,0};
int dcs[4]={0,0,-1,1};

bool in_range(int r, int c){
  return r>=0 && r<n && c>=0 && c<m; 
}

bool can_go(int r,int c){
  return in_range(r,c) && temp[r][c]==0;
}

void copy(){
  for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
        temp[i][j]=arr[i][j];
    }
  }
}

void bfs(){
  while(!q.empty()){
    rc curr=q.front();
    q.pop();
    for(int i=0;i<4;i++){
      int nr=drs[i]+curr.r;
      int nc=dcs[i]+curr.c;
      if(can_go(nr,nc)){
        temp[nr][nc]=2;
        q.push({nr,nc});
      }
    }
    
  }
  return;
}

void init(){
  for(int i=0;i<pos.size();i++){
    q.push({pos[i].r,pos[i].c});
  }
  copy();
  bfs();
  return;
}

void dfs(int depth){
  if(depth==3){
    init();
    //printf("%d",depth);
    int cnt=0;
    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
        if(temp[i][j]==0){
          cnt+=1;
          }
        }
      }
    ans=max(cnt,ans);
    return;
  }
   for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
      if(arr[i][j]==0){
        arr[i][j]=1;
        dfs(depth+1);
        arr[i][j]=0;
      }
    }
  }
}

int main() {
  scanf("%d %d",&n,&m);
  for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
      scanf("%d",&arr[i][j]);
      if(arr[i][j]==2){
        pos.push_back({i,j});
      }
    }
  }
  
  dfs(0);

  printf("%d",ans);
  return 0;
}