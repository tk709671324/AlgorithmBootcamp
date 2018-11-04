package Graph;

import java.util.Vector;

public class DenseGraph implements Graph {

	private int n;    //the number of the vertex
	private int m;    //the number of the edge
	private boolean directed;    // if the graph is directed

	private boolean[][] g;    //adjacent matrix the describe the graph


	public DenseGraph(){
		this(0, false);
	}

	public DenseGraph(int n, boolean directed){

		this.n = n;
		this.directed = directed;
		this.m = 0;
		g = new boolean[n][n];
	}

	public int V(){
		//get the number of the vertex
		return this.n;
	}

	public int E(){
		//get the number of the edge
		return this.m;
	}

	public boolean hasEdge(int v, int w){
		if(v > n || v < 0){
			throw new IllegalArgumentException("Invalid vertex argument");
		}
		if(w > n || w < 0){
			throw new IllegalArgumentException("Invalid vertex argument");
		}

		return this.g[v][w];
	}

	public void addEdge(int v, int w){
		if(v > n || v < 0){
			throw new IllegalArgumentException("Invalid vertex argument");
		}
		if(w > n || w < 0){
			throw new IllegalArgumentException("Invalid vertex argument");
		}

		if(!hasEdge(v,w)){
			this.g[v][w] = true;
			m++;

			if(!directed){
				this.g[w][v] = true;
			}
		}
	}

	public void show(){

		for( int i = 0 ; i < n ; i ++ ){
			for( int j = 0 ; j < n ; j ++ )
				System.out.print(g[i][j]+"\t");
			System.out.println();
		}
	}

	public Iterable<Integer> adj(int v){
		//return all the adjacent edge(s) of vertex v
		assert v >= 0 && v < n;

		Vector<Integer> adjV = new Vector<>();

		for (int i = 0; i < n; i++){
			if( g[v][i] ){
				adjV.add(i);
			}
		}

		return adjV;
	}

}
