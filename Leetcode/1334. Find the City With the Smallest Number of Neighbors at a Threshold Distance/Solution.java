class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int m = edges.length;
        int [][]dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                dist[i][j] = Integer.MAX_VALUE;
        }
        for(int i =0; i<m; i++){
            int from= edges[i][0];
            int to = edges[i][1];
            int wt= edges[i][2];
            dist[from][to]=wt;
            dist[to][from]=wt;
        }
          for (int i = 0; i < n; i++) dist[i][i] = 0;
          for(int k=0; k<n; k++){
              for(int i =0; i<n; i++){
                  for(int j=0; j<n; j++){
                      if(dist[i][k]==Integer.MAX_VALUE || dist[k][j]==Integer.MAX_VALUE ) continue;
                      dist[i][j]= Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                  }
              }
          }

          int cityCount=n;
          int city=-1;
          for(int cty=0; cty<n; cty++){
              int count=0;
              for(int adjCity=0; adjCity<n; adjCity++){
                  if(dist[cty][adjCity]<=distanceThreshold){
                      count++;
                  }
              }
              if(count<=cityCount){
                  cityCount= count;
                  city =cty;
              }
          }

        return city;
    }
}