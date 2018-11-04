package Graph;

import java.util.LinkedList;
import java.util.Vector;

public class SparseGraph implements Graph {

	private int n;    //the number of the vertex
	private int m;    //the number of the edge
	private boolean direceted;

	private Vector<Integer> [] g;

	public SparseGraph(){}

	public SparseGraph(int n, boolean direceted){
		this.n = n;
		this.direceted = direceted;
		this.m = 0;

		this.g = (Vector<Integer>[]) new Vector[n];
		for(int i = 0; i < n; i++){
			g[i] = new Vector<>();
		}
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

		assert v >= 0 && v < n;
		assert w >= 0 && w < n;

		for(int edgeTo:g[v]){
			if(edgeTo == w){
				return true;
			}
		}

		return false;
	}


	public void addEdge(int v, int w){

		assert v >= 0 && v < n;
		assert w >= 0 && w < n;

		if(!hasEdge(v, w)){
			this.g[v].add(w);

			if(v != w && !direceted){
				this.g[w].add(v);
			}

			m++;
		}
	}

	public void show(){

		for( int i = 0 ; i < n ; i ++ ){
			System.out.print("vertex " + i + ":\t");
			for( int j = 0 ; j < g[i].size() ; j ++ )
				System.out.print(g[i].elementAt(j) + "\t");
			System.out.println();
		}
	}

	public Iterable<Integer> adj(int v){
		//return all the adjacent edge(s) of the vertex v

		assert v >= 0 && v < n;
		return g[v];

	}


}
