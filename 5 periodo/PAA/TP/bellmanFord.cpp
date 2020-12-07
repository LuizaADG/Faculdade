#include <limits.h>
#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

const int N = INT_MAX;
const int numVertices = 5;

// Auxiliar procedure to print the distances
void printDistances(int dist[]) {
   cout << "Vertex   Distance" << endl;
   for (int i = 0; i < numVertices; i++)
      cout << i << " \t\t " << dist[i] << endl;
}

// Auxiliar procedure to print the shortest way
void printWay(int previous[], int src, int dest) {
    string way = "";
    
    int current = dest;
    do {
        way += "," + to_string(current);
        current = previous[current];
    } while (current != src);
    way += "," + to_string(src);
    
    reverse(way.begin(), way.end());
    way.pop_back();
    
    cout << "The shortest way from " << src << " to " << dest << " is: " << way << endl;
}

// This version of the algorithm prints the shortest way between two vertices
void bellmanFord(int graph[numVertices][numVertices], int src, int dest) {
    int dist[numVertices];
    int previous[numVertices];
    
    // Initialize distances with infinity (except source) and previous with null
    for (int i = 0; i < numVertices; i++)
        dist[i] = INT_MAX, previous[i] = -1;
    dist[src] = 0;
    
    // Bellman-ford main iteration
    for (int i = 0; i < numVertices-1; i++)
        for (int j = 0; j < numVertices; j++)
            for (int k = 0; k < numVertices; k++)
               if (graph[j][k] != N && dist[j] + graph[j][k] < dist[k])
                   dist[k] = dist[j] + graph[j][k], previous[k] = j;
                   
    // Check for negative-weight cycles               
    for (int j = 0; j < numVertices; j++)
        for (int k = 0; k < numVertices; k++)
            if (graph[j][k] != N && dist[j] + graph[j][k] < dist[k]) {
                cout << "Graph contains negative-weight cycle\n";
                return;
            }
    
    
    printWay(previous, 0, 4);
}

// This version of the algorithm prints the distances from a source to all other vertices
void bellmanFord(int graph[numVertices][numVertices], int src) {
    int dist[numVertices];
    
    // Initialize distances with infinity (except source)
    for (int i = 0; i < numVertices; i++)
        dist[i] = INT_MAX;
    dist[src] = 0;
    
    // Bellman-ford main iteration
    for (int i = 0; i < numVertices-1; i++)
        for (int j = 0; j < numVertices; j++)
            for (int k = 0; k < numVertices; k++)
               if (graph[j][k] != N && dist[j] + graph[j][k] < dist[k])
                   dist[k] = dist[j] + graph[j][k];
                   
    // Check for negative-weight cycles               
    for (int j = 0; j < numVertices; j++)
        for (int k = 0; k < numVertices; k++)
            if (graph[j][k] != N && dist[j] + graph[j][k] < dist[k]) {
                cout << "Graph contains negative-weight cycle\n";
                return;
            }
    
    printDistances(dist);
}

int main() {
    // A symmetric graph
    int graph[numVertices][numVertices] = {{N, 4, N, N, 3},
                                           {4, N, 9, 5, N},
                                           {N, 9, N, 7, N},
                                           {N, 5, 7, N, 1},
                                           {3, N, N, 1, N}};
    
    // An assymetric graph                                     
    int digraph[numVertices][numVertices] = {{N, -2,  N,  N,  3},
                                             {4,  N,  9,  5,  N},
                                             {8,  9,  N,  7,  N},
                                             {N,  5,  5,  N,  1},
                                             {3,  N, -1,  6,  N}};
                                             
    // A graph with a negative autoloop
    int loopgraph[numVertices][numVertices] = {{N,  4,  N,  N,  4},
                                               {2,  N, 15,  5,  N},
                                               {N, 15,  N,  7,  N},
                                               {N,  7,  7, -1,  6},
                                               {4,  N,  N,  10, N}};
                                               
    // A graph with edges with weight 0
    int zerograph[numVertices][numVertices] = {{N,  4,  N,  N,  0},
                                               {2,  N, 15,  5,  N},
                                               {N, 15,  N,  7,  N},
                                               {N,  7,  7,  8,  6},
                                               {0,  N,  N, 10,  N}};
    
    // A graph with a negative-weight cycle
    int cyclegraph[numVertices][numVertices] = {{N, -4,  2, N, 4},
                                                {2,  N, -1, 7, N},
                                                {2, -1,  N, N, N},
                                                {N,  7,  N, N, 6},
                                                {4,  N,  N, 6, N}};
    
    // Tests with both versions of the algorithm
    cout << "Symmetric graph:" << endl;
    bellmanFord(graph, 0);
    bellmanFord(graph, 0, 4);
    cout << "\nAsymmetric graph:" << endl;
    bellmanFord(digraph, 0);
    bellmanFord(digraph, 0, 4);
    cout << "\nAutoloop graph:" << endl;
    bellmanFord(loopgraph, 0);
    bellmanFord(loopgraph, 0, 4);
    cout << "\nEdge zero graph:" << endl;
    bellmanFord(zerograph, 0);
    bellmanFord(zerograph, 0, 4);
    cout << "\nNegative-weight cycle graph:" << endl;
    bellmanFord(cyclegraph, 0);
    bellmanFord(cyclegraph, 0, 4);
   
    return 0;
}
