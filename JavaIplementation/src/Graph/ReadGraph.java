package Graph;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadGraph {

	private Scanner myScanner;

	public ReadGraph(Graph graph, String fileName){

		readFile(fileName);

		try{
			int V = myScanner.nextInt();
			if (V < 0)
				throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
			assert V == graph.V();

			int E = myScanner.nextInt();
			if (E < 0)
				throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");

			for (int i = 0; i < E; i++) {
				int v = myScanner.nextInt();
				int w = myScanner.nextInt();
				assert v >= 0 && v < V;
				assert w >= 0 && w < V;
				graph.addEdge(v, w);
			}
		}catch (InputMismatchException e){
			String token = myScanner.next();
			throw new InputMismatchException("attempts to read an 'int' value from input stream, but the next token is \"" + token + "\"");
		}
		catch (NoSuchElementException e) {
			throw new NoSuchElementException("attemps to read an 'int' value from input stream, but there are no more tokens available");
		}
	}


	private void readFile(String fileName){
		assert fileName != null;

		try{

			File file = new File(fileName);
			if(file.exists()){
				FileInputStream fis = new FileInputStream(file);
				myScanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
				myScanner.useLocale(Locale.ENGLISH);

			}else {
				throw new IllegalArgumentException(fileName + "doesn't exist");
			}

		}catch (IOException ioe){
			throw new IllegalArgumentException( "cannot open " + fileName);
		}
	}


	public static void main(String[] args) {
		String filename = "testG1.txt";
		SparseGraph g1 = new SparseGraph(13, false);
		ReadGraph readGraph1 = new ReadGraph(g1, filename);
		System.out.println("test G1 in Sparse Graph:");
		g1.show();

		System.out.println();

		DenseGraph g2 = new DenseGraph(13, false);
		ReadGraph readGraph2 = new ReadGraph(g2 , filename );
		System.out.println("test G1 in Dense Graph:");
		g2.show();

		System.out.println();

		// 使用两种图的存储方式读取testG2.txt文件
		filename = "testG2.txt";
		SparseGraph g3 = new SparseGraph(6, false);
		ReadGraph readGraph3 = new ReadGraph(g3, filename);
		System.out.println("test G2 in Sparse Graph:");
		g3.show();

		System.out.println();

		DenseGraph g4 = new DenseGraph(6, false);
		ReadGraph readGraph4 = new ReadGraph(g4, filename);
		System.out.println("test G2 in Dense Graph:");
		g4.show();
	}

}
