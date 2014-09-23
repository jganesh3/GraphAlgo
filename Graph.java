package graphs.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;



public class Graph<Value1>{
	
	private HashMap<Value1, TreeSet<Value1>>st;
	private int E;

		
	public Graph(){
		st=new HashMap<Value1, TreeSet<Value1>>();
		
	}
	
	public boolean hasEdge(Value1 x,Value1 y){
		
		if(!hasVertex(x)) return false;
		else
			return st.get(x).contains(y);
		
	}
	
	public boolean hasVertex(Value1 x){
		if(st.containsKey(x))return true;
		else
			return false;
	}
	
	
	public Iterator<Map.Entry<Value1, TreeSet<Value1>>> iterator(){
		return st.entrySet().iterator();
	}
	
	public void addEdge(Value1 x,Value1 y){
		if(!hasEdge(x, y))E++;
		if(!hasVertex(x)) st.put(x, new TreeSet<Value1>());
		if(!hasVertex(y))st.put(y, new TreeSet<Value1>());
		st.get(x).add(y);
		//st.get(y).add(x); //Unable this for un directed graph
		
		
	}
	
	
	
	// return the number of verices
		public int V() {
			return st.size();
		}

		public int E(){
			return E;
		}
		
		
		public TreeSet<Value1>adj(Value1 x){
			if(!hasVertex(x)) return new TreeSet<Value1>();
			else
				return st.get(x);
			
		}
	
	
	
	
}