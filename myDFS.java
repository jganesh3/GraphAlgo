package graphs.practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

class myDFSVertex implements Comparable<myDFSVertex>{
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "myDFSVertex [color=" + color + ", start_time=" + start_time
				+ ", finish_time=" + finish_time + ", city=" + city + "]";
	}
	int color;
	myDFSVertex pi;
	int start_time;
	int finish_time;
	String city;
	
	
	public myDFSVertex(String city){
		this.city=city;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		myDFSVertex other = (myDFSVertex) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		return true;
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
	/**
	 * @return the pi
	 */
	public myDFSVertex getPi() {
		return pi;
	}
	/**
	 * @param pi the pi to set
	 */
	public void setPi(myDFSVertex pi) {
		this.pi = pi;
	}
	/**
	 * @return the start_time
	 */
	public int getStart_time() {
		return start_time;
	}
	/**
	 * @param start_time the start_time to set
	 */
	public void setStart_time(int start_time) {
		this.start_time = start_time;
	}
	/**
	 * @return the finish_time
	 */
	public int getFinish_time() {
		return finish_time;
	}
	/**
	 * @param finish_time the finish_time to set
	 */
	public void setFinish_time(int finish_time) {
		this.finish_time = finish_time;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}


	public int compareTo(myDFSVertex o) {
		// TODO Auto-generated method stub
		return this.city.compareTo(o.city);
	}
	
	
	
	
	
	
	
}

public class myDFS {
	
	
	//Graph<myDFSVertex> graph;
	int time;
	public myDFS(){
		//graph=new Graph<myDFSVertex>();
		
	}
	
	
	public void DFS(Graph g){
		
	
		
		
		Iterator<Vertex>it=g.iterator();
		time=0;
		while(it.hasNext()){
			//Vertex temp=it.next();
			Map.Entry pair =(Map.Entry)it.next();
			myDFSVertex temp=(myDFSVertex)pair.getKey();
		if(temp.getColor()==0)
			DFSVISIT(g,temp);
			
		}
		
		
		
	}
	
	public void DFSVISIT(Graph G,myDFSVertex u){
		
		time = time+1;
		u.setStart_time(time);
		u.setColor(1);
		myDFSVertex v;
		// Now for each vertex Adj to vertex u, if the color is white call DFS vist
		TreeSet<myDFSVertex> adjListItDfsVertexs= G.adj(u);
		Iterator<myDFSVertex>it=adjListItDfsVertexs.iterator();
		while(it.hasNext()){
			v=it.next();
			if(v.getColor()==0){
				v.setPi(u);
				DFSVISIT(G, v);
			}
			
		}
		
		u.setColor(2);
		time=time+1;
		u.setFinish_time(time);
		
	}

	
	public static void main(String[] args) {
		
		myDFSVertex chico=new myDFSVertex("chico");
		myDFSVertex LA=new myDFSVertex("LA");
		myDFSVertex SF=new myDFSVertex("SF");
		myDFSVertex yuba=new myDFSVertex("yuba");
		myDFSVertex sac=new myDFSVertex("sac");
		
		Graph<myDFSVertex> G= new Graph<myDFSVertex>();
		
		G.addEdge(chico, yuba);
		G.addEdge(SF, LA);
		G.addEdge(chico, SF);
		G.addEdge(yuba,sac);
		G.addEdge(yuba, LA);
		
		
		
		System.out.println(G.toString());
		myDFS dfs=new myDFS();
		dfs.DFS(G);
		System.out.println("==========================");
		System.out.println(G.toString());
		
		
		
	}
	
	
	
	

}
