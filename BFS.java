package graphs.practice;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;


import java.util.TreeSet;

import graphs.practice.Graph;;


// 1: white
// 2:Grey
// 3:black
class Vertexg<E extends Comparable<E>> implements Comparable<Vertexg<E>>{
	
	E data;
	int d;
	Vertexg pi;
	int color;
	
	
	/**
	 * @return the d
	 */
	public int getD() {
		return d;
	}



	/**
	 * @param d the d to set
	 */
	public void setD(int d) {
		this.d = d;
	}



	/**
	 * @return the pi
	 */
	public Vertexg getPi() {
		return pi;
	}



	/**
	 * @param pi the pi to set
	 */
	public void setPi(Vertexg pi) {
		this.pi = pi;
	}



	/**
	 * @return the color
	 */
	public int getColor() {
		return color;
	}



	/**
	 * @param color the color to set
	 */
	public void setColor(int color) {
		this.color = color;
	}



	public Vertexg(int d,int parent,int color){
		
	 this.d=d;
	 this.pi=pi;
	 this.color=color;
		
	}
	
	
	
	public Vertexg(E dt){
		this.d=0;
		this.color=1;
		this.pi=null;
		this.data=dt;
	}
	
	
	public String toString(){
		
		return "[ data:"+this.data+" distance:"+this.d+"color:"+this.color+"]";
				
	}
	
	
	// to compair the objects we need to define hashCode and equals method
	
	public int hashCode(){
		
		final int prime=31;
		int result=1;
		result = prime * result + ((this.data == null) ? 0 : this.data.hashCode());
		
		return result;
		
		
	}
	
	
	public boolean equals(Object obj){
		
		if(this==obj) return true;
		if(obj==null) return false;
		if(this.getClass()!=obj.getClass()) return false;
		Vertexg<E> other =(Vertexg<E>)obj;
		if(this.data==null){
			if(other.data!=null)
				return false;
			else if(!this.data.equals(other.d))
				return false;
				
		}
		
		return true;
		
		
	}



	public int compareTo(Vertexg<E> that) {
		
		int cmp = this.data.compareTo(that.data);
		return cmp;
	}
	
	
	
	
}



public class BFS<E extends Comparable<E>> {
	
	
	private LinkedList<Vertexg<E>> Q;
	public BFS(){
		
		Q=new LinkedList<Vertexg<E>>();
	}
	
	public void BFS(Graph G, Vertexg<E> souce){
		
		// First initialize the graph
		//Get the iterator
		Iterator it=G.iterator();
		while(it.hasNext()){
			
			Map.Entry pair=(Map.Entry) it.next();
			Vertexg<E> v=(Vertexg<E>) pair.getKey();
			
			v.setColor(1);
			v.setD(0);
			v.setPi(null);
			
			
		}
		
		//Set the source color to Grey i.e. 2
		souce.setColor(2);
		Q.add(souce);
		
		//While Q is non Empty 
		while(!Q.isEmpty()){
			
			
			//de queue Q
			Vertexg<E> u=Q.remove();
			
			//Now for all Vertex belongs to Adj[u]
			TreeSet<Vertexg<E>> v=G.adj(u);
			Iterator<Vertexg<E>> adjlist=v.iterator();
			
			while(adjlist.hasNext()){
				
				Vertexg<E> Ver=adjlist.next();
				
				// Check if the color of the vertex is white i.e. Vertex is not visited
				if(Ver.getColor()==1){
					
					Ver.setColor(2);
					Ver.setD(u.getD()+1);
					Ver.setPi(u);
					Q.add(Ver);
					
				}
				
				
				
			}
			
			u.setColor(3);
			
		}
	
	}
	
	
	public void display(Graph x){
		
		Iterator<E> it=x.iterator();
		
		while(it.hasNext())
			System.out.println(it.next());
		
		
		
	}
	
	

	public static void main(String[] argv){
		
		
		BFS<String> bfsalgo=new BFS<String>();
		Vertexg<String> chico=new Vertexg<String>("chico");
		Vertexg<String> sf=new Vertexg<String>("sf");
		Vertexg<String> yuba=new Vertexg<String>("yuba");
		Vertexg<String> la=new Vertexg<String>("la");
		Vertexg<String> NY=new Vertexg<String>("NY");
		
		Graph<Vertexg<String>> G=new Graph<Vertexg<String>>();
		
		G.addEdge(chico, yuba);
		G.addEdge(yuba, sf);
		G.addEdge(sf, la);
		G.addEdge(sf, chico);
		G.addEdge(chico, NY);
		G.addEdge(la, NY);
		G.addEdge(NY, sf);
		
		
		
		// Before running the BFS algo
		bfsalgo.display(G);
		
		bfsalgo.BFS(G, chico);
		System.out.println("===================================");
		bfsalgo.display(G);
	
		
		
		
		
	}
	
	
	
	
	
	

}
