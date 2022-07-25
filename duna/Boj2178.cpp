#include <iostream>
#include <queue>

using namespace std;

struct rc{
  int r;
  int c;
};

int dr[4]={-1,1,0,0};
int dc[4]={0,0,-1,1};

queue <rc> q;
int n,m;
int arr[101][101];
int visited[101][101];


bool in_range(int r, int c){
  return r>=0 && r<n && c>=0 && c<m;
}

bool can_go(int r, int c){
  return in_range(r,c) && arr[r][c]==1;
}

void bfs(){
  while(!q.empty()){
    rc curr =q.front();
    q.pop();

    for(int i=0;i<4;i++){
      int nr=dr[i]+curr.r;
      int nc=dc[i]+curr.c;
      if(can_go(nr,nc)){
        visited[nr][nc]=visited[curr.r][curr.c]+1;
        arr[nr][nc]=0;
        q.push({nr,nc});
      }
    }
    
  }
}

int main() {
  char c[100];
  scanf("%d %d",&n,&m);
  for(int i=0;i<n;i++){
    scanf("%s",c);
    for(int j=0;j<m;j++){
      arr[i][j]=c[j]-'0';
      visited[i][j]=0;
      //printf("%d",arr[i][j]);
    }

  }
    q.push({0,0});
    visited[0][0]=1;
    arr[0][0]=0;
    bfs();
    
    printf("%d",visited[n-1][m-1]); 
}