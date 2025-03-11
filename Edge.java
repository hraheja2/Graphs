public class Edge<T> implements Comparable<Edge<? super T>>{
	public vertex<T> u;
	public vertex<T> v;
	public Double weight;
	public Edge (vertex<T> u, vertex<T> v, Double weight){
		if (u==null || v==null){
			throw new IllegalArgumentException("No null vertex");
		}
		this.u=u;
		this.v=v;
		this.weight=weight;
	}
	public String print(){
		return ("Goes from "+ this.u + " to "+ this.v + ", at a speed of "+this.weight);
	}
	public int compareTo(Edge<? super T> a){
		if (this.weight == a.weight){
			return 0;
		}
		else if(this.weight<a.weight){
			return -1;
		}
		else{
			return 1;
		}
	}
	public static void main(String args[]){

		vertex<Integer> a = new vertex<>(5);
		vertex<Integer> b = new vertex<>(8);
		Double f = 10.0;
		Edge<Integer> c = new Edge<>(a,b,f); 
		System.out.println(c.print());
	}

}
