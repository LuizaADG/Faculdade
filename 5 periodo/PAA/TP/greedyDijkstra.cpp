#include <limits.h>
#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

const int numVertices = 5;

// Returns the next vertice dijkstra will try, based on the smallest distance
int minDistance(int dist[], bool searched[]) {
   int min = INT_MAX;
   int index;
   
   for (int i = 0; i < numVertices; i++)
     if (searched[i] == false && dist[i] <= min)
         min = dist[i], index = i;
   
   return index;
}

// Auxiliar procedure to print the distances   
void printDistances(int dist[], int n) {
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
void dijkstra(int graph[numVertices][numVertices], int src, int dest) {
    int dist[numVertices];
    int previous[numVertices];
    bool searched[numVertices];
    
    // Initialize distances with infinity (except source)
    for (int i = 0; i < numVertices; i++)
        dist[i] = INT_MAX, searched[i] = false, previous[i] = -1;
    dist[src] = 0;
    
    for (int i = 0; i < numVertices-1; i++) {
        // Get next vertex to search
        int j = minDistance(dist, searched);
        searched[j] = true;
        
        // Update distances and way
        for (int k = 0; k < numVertices; k++)
            if (!searched[k] && graph[j][k] != -1 && dist[j] != INT_MAX && dist[j]+graph[j][k] < dist[k])
                dist[k] = dist[j] + graph[j][k], previous[k] = j;
    }
    
    printWay(previous, src, dest);
}

// This version of the algorithm prints the distances from a source to all other vertices
void dijkstra(int graph[numVertices][numVertices], int src) {
    int dist[numVertices];
    bool searched[numVertices];
    
    // Initialize distances with infinity (except source)
    for (int i = 0; i < numVertices; i++)
        dist[i] = INT_MAX, searched[i] = false;
    dist[src] = 0;
    
    for (int i = 0; i < numVertices-1; i++) {
        // Get next vertex to search
        int j = minDistance(dist, searched);
        searched[j] = true;
        
        // Update distances
        for (int k = 0; k < numVertices; k++)
            if (!searched[k] && graph[j][k] != -1 && dist[j] != INT_MAX && dist[j]+graph[j][k] < dist[k])
                dist[k] = dist[j] + graph[j][k];
    }
    
    printDistances(dist, numVertices);
}

int main() {
    // A symmetric graph
    int graph[numVertices][numVertices] = {{-1,  2, -1, -1,  4},
                                           { 2, -1, 15,  7, -1},
                                           {-1, 15, -1,  7, -1},
                                           {-1,  7,  7, -1,  6},
                                           { 4, -1, -1,  6, -1}};
    
    // An assymetric graph                                     
    int digraph[numVertices][numVertices] = {{-1,  4, -1, -1,  4},
                                             { 2, -1, 15,  5, -1},
                                             {-1, 15, -1,  7, -1},
                                             {-1,  7,  7, -1,  6},
                                             { 4, -1, -1,  10, -1}};
                                             
    // A graph with autoloops
    int loopgraph[numVertices][numVertices] = {{-1,  4, -1, -1,  4},
                                               { 2, -1, 15,  5, -1},
                                               {-1, 15, -1,  7, -1},
                                               {-1,  7,  7, 8,  6},
                                               { 4, -1, -1,  10, -1}};
                                               
    // A graph with edges with weight 0
    int zerograph[numVertices][numVertices] = {{-1,  4, -1, -1,  0},
                                               { 2, -1, 15,  5, -1},
                                               {-1, 15, -1,  7, -1},
                                               {-1,  7,  7, 8,  6},
                                               { 0, -1, -1,  10, -1}};
    
    // Tests with both versions of the algorithm
    cout << "Symmetric graph:" << endl;
    dijkstra(graph, 0);
    dijkstra(graph, 0, 4);
    cout << "\nAsymmetric graph:" << endl;
    dijkstra(digraph, 0);
    dijkstra(digraph, 0, 4);
    cout << "\nAutoloop graph:" << endl;
    dijkstra(loopgraph, 0);
    dijkstra(loopgraph, 0, 4);
    cout << "\nEdge zero graph:" << endl;
    dijkstra(zerograph, 0);
    dijkstra(zerograph, 0, 4);
   
    return 0;
}
