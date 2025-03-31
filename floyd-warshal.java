
public class FloydWarshall {
    static final int INF = 99999;

    public static int[][] floydWarshall(int[][] graph) {
        int n = graph.length;
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) 
        {
            for (int j=0; j < n; j++) 
            {
                if (i == j) {
                    dist[i][j] = 0;
                } 
                else if (graph[i][j] != 0) {
                    dist[i][j] = graph[i][j];
                } 
                else {
                    dist[i][j] = INF;
                }
            }
        }

        for (int k = 0; k < n; k++) {  
            for (int i = 0; i < n; i++) { 
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        return dist; =
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%-5s", (matrix[i][j] == INF ? "INF" : matrix[i][j]));
            }
            System.out.println();
        }
    }
    

    public static void main(String[] args) {
        int[][] graph = {
            {0, 3, INF, 7},
            {8, 0, 2, INF},
            {5, INF, 0, 1},
            {2, INF, INF, 0}
        };

        System.out.println("Initial Graph:");
        printMatrix(graph);

        int[][] shortestPaths = floydWarshall(graph);

        System.out.println("\nShortest Paths Matrix:");
        printMatrix(shortestPaths);
    }
}
