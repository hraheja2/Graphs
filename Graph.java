import java.util.*;
import java.util.Queue;
import java.util.LinkedList;
public class Graph <T> implements Comparable<Edge<? super T>> {
	private Set<vertex<T>> vertices;
	private Set<Edge<T>> edges;
	private Map<vertex<T>,List <Edge<T>>> adjList;
	public Boolean[] array;
	public Double[] dista;
	public Graph(Set<vertex<T>> vertices,Set<Edge<T>> edges) {
		if (vertices ==null ||edges==null){
			throw new IllegalArgumentException("No null arguments");
		}
		this.vertices = new HashSet<>(vertices);
		this.edges=new HashSet<>(edges);
		adjList=new HashMap<>();
		array=new Boolean[this.vertices.size()];
		Arrays.fill(array,Boolean.FALSE);
		this.dista = new Double[array.length];
		int kl=0;
		for(kl=0;kl<array.length;kl++){
			this.dista[kl]=0.0;
		}
	}
	public void nodes(){
		System.out.println("The vertices are:"+ " "+(this.vertices));
		System.out.println("The edges start from"+ " "+ ((Edge<Integer>)(this.edges.toArray()[0])).u);
		System.out.println("The edges end at"+ " "+((Edge<Integer>)(this.edges.toArray()[0])).v);
	}
	public int compareTo(Edge<? super T> a){
		
		return 1;
	}
	public void DFS(Graph<T> a, vertex<T> u){
		ArrayList<Object> vj=new ArrayList(Arrays.asList(a.edges.toArray()));
		ArrayList<Object> values = new ArrayList(Arrays.asList(a.vertices.toArray())); 
		T[] array1 = ((T[])new Object[a.vertices.size()]);
		int i=0;
		for(i=0;i<a.vertices.size();i++){
			array1[i]=((vertex<T>)(values.get(i))).data;
		}
		System.out.println(a.array[Arrays.binarySearch(array1,u.data)]);
		System.out.println(Arrays.toString(array1));
		a.array[Arrays.binarySearch(array1,u.data)]=true;
		System.out.println(Arrays.toString(a.array));
		int j=0;
		for (j=0;j<a.edges.size();j++){
			System.out.println(j);
			System.out.println(String.valueOf(((Edge<T>)vj.get(j)).u.data));
			if (((Edge<T>)(vj.get(j))).u.data==u.data){
				vertex<T> y=((Edge <T>)(vj.get(j))).v;
				System.out.println(y.data);
				if (a.array[Arrays.binarySearch(array1,y.data)]!=true){
					System.out.println(y.data);
					DFS(a, y);
				}
				else {
					continue;
				}
			}
		}
	}
	public void BFS(Graph<T> a, vertex<T> u){
		ArrayList<Object> values = new ArrayList(Arrays.asList(a.vertices.toArray()));
		ArrayList<Object> vj=new ArrayList(Arrays.asList(a.edges.toArray()));
		Queue<vertex<T>> queue= new LinkedList<>();
		T[] array1 = ((T[])new Object[a.vertices.size()]);
		int k=0;
		for(k=0;k<a.vertices.size();k++){
			array1[k]= ((vertex<T>)(values.get(k))).data;
		}
		array[Arrays.binarySearch(array1,u.data)]=true;
		System.out.println(Arrays.toString(a.array));
		queue.add(u);
		while(!queue.isEmpty()){
			T c=queue.peek().data;
			queue.remove();
			int w=0;
			for(w=0;w<a.edges.size();w++){
				vertex<T> y=((Edge<T>)(vj.get(w))).v;
				if(((Integer)(((Edge<T>)(vj.get(w))).u.data))==((Integer)c)){
					if (a.array[Arrays.binarySearch(array1,y.data)]!=true){
						a.array[Arrays.binarySearch(array1,y.data)]=true;
						System.out.println(Arrays.toString(a.array));
						queue.add(y);
					}
				}
			}
		}
	}
	
	public void Dijkstra(Graph<T> g, vertex<T> source){
		ArrayList<Object> values = new ArrayList(Arrays.asList(g.vertices.toArray()));
		ArrayList<Object> vj = new ArrayList(Arrays.asList(g.edges.toArray()));
		T[] array1 = ((T [])(new Object[g.vertices.size()]));
		int k=0;
                for(k=0;k<g.vertices.size();k++){
                        array1[k]= (((vertex<T>)(values.get(k))).data);
                }
		int[] ae =new int[g.vertices.size()];
		int bd=0;
		for(bd=0;bd<g.vertices.size();bd++){
			ae[bd]=((int)((((vertex<T>)(values.get(bd))).data)));
			System.out.println("vertex "+bd+" " +String.valueOf(ae[bd]));
		}
		System.out.println(String.valueOf(ae));
		PriorityQueue<Object[]> pq = new PriorityQueue<Object[]>(new ObjectComp());
		HashMap<vertex<T>,Double> dist = new HashMap<vertex<T>,Double>();
		int j=0;
		for (j=0;j<this.array.length;j++){
			ArrayList<Object> vj1 = new ArrayList((Arrays.asList(g.vertices.toArray())));
			vertex<T> ab = ((vertex<T>)(vj1.get(j)));
			if (source.data != ab.data){
				dist.put(ab,Double.POSITIVE_INFINITY);
			}
			else if(source.data ==ab.data){
				dist.put(ab,0.0);
			}
			
		}
		Object[] arr = new Object[2];
		arr[0]=((Object)(source));
		arr[1]=((Object)(0.0));
		pq.add(arr);
		System.out.println(dista);
		while (!pq.isEmpty()&& Arrays.asList(g.array).contains(false)){
			Object[] a= pq.peek();
			System.out.println("Vertex value "+ String.valueOf(((int)(((vertex<T>)a[0]).data))+ " " + String.valueOf(((Double)a[1]))));
			pq.poll();
			if (g.array[Arrays.binarySearch(array1,((vertex<T>)(a[0])).data)]!=true){
				g.array[Arrays.binarySearch(array1,((vertex<T>)(a[0])).data)]= true;
				dist.put(((vertex<T>)(a[0])),((Double) g.dista[Arrays.binarySearch(array1,((vertex<T>)(a[0])).data)]));
				int l=0;
				for (l=0;l<vj.size();l++){
					if(((Edge<T>)(vj.get(l))).u.data==((vertex<T>)(a[0])).data){
						if (g.array[Arrays.binarySearch(array1,((Edge<T>)(vj.get(l))).v.data)]!=true){ 
								if (g.dista[Arrays.binarySearch(array1,((Edge<T>)(vj.get(l))).v.data)]>(((((Edge<T>)(vj.get(l))).weight))+g.dista[Arrays.binarySearch(array1,((Edge<T>)(vj.get(l))).u.data)]) || g.dista[Arrays.binarySearch(array1,((Edge<T>)(vj.get(l))).v.data)]==0){
								g.dista[Arrays.binarySearch(array1,((Edge<T>)(vj.get(l))).v.data)]= ((((Edge<T>)(vj.get(l))).weight))+g.dista[Arrays.binarySearch(array1,((Edge<T>)(vj.get(l))).u.data)];
								System.out.println("Coming from Vertex "+ (((Edge<T>)(vj.get(l))).u.data) + ", and" + " Going to vertex "+" "+ ((Edge<T>)(vj.get(l))).v.data);
								Object[] arr2 = new Object[2];
                						arr2[0]=((Object)((vertex<T>)((Edge<T>)(vj.get(l))).v));
                						arr2[1]=((Object)(g.dista[Arrays.binarySearch(array1,((Edge<T>)(vj.get(l))).v.data)]));
								pq.add(arr2);
							}
						}
						
					}
					 else if(((Edge<T>)(vj.get(l))).v.data==((vertex<T>)(a[0])).data){
                                                if(g.array[Arrays.binarySearch(array1,((Edge<T>)(vj.get(l))).u.data)]!=true){
                                                        if ( g.dista[Arrays.binarySearch(array1,((Edge<T>)(vj.get(l))).u.data)]>(((((Edge<T>)(vj.get(l))).weight))+g.dista[Arrays.binarySearch(array1,((Edge<T>)(vj.get(l))).v.data)]) || g.dista[Arrays.binarySearch(array1,((Edge<T>)(vj.get(l))).u.data)]==0){	
								g.dista[Arrays.binarySearch(array1,((Edge<T>)(vj.get(l))).u.data)]= ((((Edge<T>)(vj.get(l))).weight))+g.dista[Arrays.binarySearch(array1,((Edge<T>)(vj.get(l))).v.data)];
                                                        	Object[] arr1 = new Object[2];
                                                        	arr1[0]=((Object)((vertex<T>)((Edge<T>)(vj.get(l))).u));
                                                        	arr1[1]=((Object)(g.dista[Arrays.binarySearch(array1,((Edge<T>)(vj.get(l))).u.data)]));
                                                        	pq.add(arr1);
                                                        	System.out.println("Coming from Vertex "+ (((Edge<T>)(vj.get(l))).v.data) + ", and" + " Going to vertex "+" "+ (((Edge<T>)(vj.get(l))).u.data));
                                                	}
                                        	}
					}
					else{
						continue;
					}		
				}
			}
			else{
				continue;
			} 
		}		 
		ArrayList<String> gh = new ArrayList(Arrays.asList(dist.keySet()));
		int mn=0;
		System.out.println(dist);
		System.out.println(g.vertices);
	}
	public void prim(Graph<T> g, vertex<T> v){
		Set<Edge<T>> mstedge = new HashSet<>();
		PriorityQueue<Object[]> pq = new PriorityQueue<Object[]>(new ObjectComp());
		ArrayList<Object> arrarr = new ArrayList(Arrays.asList(g.vertices.toArray()));
		int ar=0;
		T[] lish=((T[])new Object[arrarr.size()]);
		for(ar=0;ar<arrarr.size();ar++){
			lish[ar]=((vertex<T>)(arrarr.get(ar))).data;
		}
		ArrayList<Object> a= new ArrayList(Arrays.asList(g.edges.toArray()));
		int op=0;
		for(op=0;op<a.size();op++){
			if ((((Edge<T>)(a.get(op))).u.data)==v.data){
				Object[] arr=new Object[3];
				arr[0] = ((Object)(((((Edge<T>)(a.get(op))).u.data))));
				arr[2] = ((Object)(((((Edge<T>)(a.get(op))).v.data))));
				arr[1] = ((Object)((((((Edge<T>)(a.get(op))).weight)))+0.0));
				pq.add(arr); 
			}
			else if ((((Edge<T>)(a.get(op))).v.data)==v.data){
				Object[] arr=new Object[3];
                                arr[0] = ((Object)(((((Edge<T>)(a.get(op))).v.data))));
                                arr[2] = ((Object)(((((Edge<T>)(a.get(op))).u.data))));
				arr[1]=((Object)((((((Edge<T>)(a.get(op))).weight))+0.0)));
                                pq.add(arr);
			}
		}
		g.array[Arrays.binarySearch(lish,v.data)]=true;
		while(!pq.isEmpty()&& Arrays.asList(g.array).contains(false)){
			Object[] b =pq.peek();
			T c= ((T)(b[2]));
			System.out.println(c+ " Prim");
			System.out.println(pq);
			pq.poll();
			if(g.array[Arrays.binarySearch(lish,c)]!=true){
				g.array[Arrays.binarySearch(lish,c)]=true;
				vertex<T> ww = (new vertex<>((T)b[0]));
				vertex<T> vv = (new vertex<>((T)b[2]));	
				Edge<T> gg= new Edge<>(ww,vv,((Double)(b[1])));
				mstedge.add(gg);
				int qr=0;
				for(qr=0;qr<a.size();qr++){
					if ((((Edge<T>)(a.get(qr))).u.data)==((T)(b[2])) && g.array[Arrays.binarySearch(lish,(((Edge<T>)(a.get(qr))).v.data))]!=true){
                                		Object[] arr1=new Object[3];
                                		arr1[0] = ((Object)(((((Edge<T>)(a.get(qr))).u.data))));
                                		arr1[2] = ((Object)(((((Edge<T>)(a.get(qr))).v.data))));
                                		arr1[1] = ((Object)(((((Edge<T>)(a.get(qr))).weight)+0.0)));
                                		pq.add(arr1);
						//System.out.println("u: "+(((((Edge<T>)(a.get(qr))).u.data))) + " v: " + (((((Edge<T>)(a.get(qr))).v.data))));
                       			}
                        		else if ((((Edge<T>)(a.get(qr))).v.data)==((T)(b[2]))&& g.array[Arrays.binarySearch(lish,(((Edge<T>)(a.get(qr))).u.data))]!=true){
                                		Object[] arr1=new Object[3];
                                		arr1[0] = ((Object)(((((Edge<T>)(a.get(qr))).v.data))));
                                		arr1[2] = ((Object)(((((Edge<T>)(a.get(qr))).u.data))));
                                		arr1[1]=((Object)(((((Edge<T>)(a.get(qr))).weight))+0.0));
                                		pq.add(arr1);
						//System.out.println("u: "+(((((Edge<T>)(a.get(qr))).v.data))) + " v: " + (((((Edge<T>)(a.get(qr))).u.data))));
					}
			
				}
	
			}
			else{
				continue;
			}
		}
		Iterator itr = mstedge.iterator();
		while(itr.hasNext()){
			Edge<T> abcd=((Edge<T>)(itr.next()));
			System.out.println(abcd.u.data+ " u");
			System.out.println((abcd).v.data+ " v");
		}
		System.out.println(Arrays.toString(g.array));
	}		
	public void clear_array(){
		int i1=0;
                for(i1=0;i1<this.array.length;i1++){
                        this.array[i1]=false;
                }
	}	
	public static void main(String args[]){
		vertex<Integer> a1 = new vertex <>(5);
		vertex<Integer> b = new vertex <>(7);
		vertex<Integer> c = new vertex <>(6);
		vertex<Integer> d = new vertex<>(12);
		vertex<Integer> e = new vertex<>(8);
		vertex<Integer> i = new vertex<>(9);
		vertex<Integer> f = new vertex<>(10);
		vertex<Integer> g = new vertex<>(11);
		Edge<Integer> o = new Edge<>(a1,b,1.0);
		Edge<Integer> p = new Edge<>(b,c,1.0);
		Edge<Integer> r = new Edge<>(a1,d,1.0);
		Edge<Integer> q1 = new Edge<>(b,e,5.0);
		Edge<Integer> s = new Edge<>(b,d,4.0);
		Edge<Integer> t = new Edge<>(c,e,5.0);
		Edge<Integer> u = new Edge<>(e,f,5.0);
		Edge<Integer> x= new Edge<>(e,i,5.0);
		Edge<Integer> y = new Edge<>(f,g,5.0);
		Set<vertex<Integer>> v = new HashSet<>();
		v.addAll(Arrays.asList(a1,b,c,d,e,i,f,g));
		Set<Edge<Integer>> w = new HashSet<>();
		w.addAll(Arrays.asList(o,p,r,q1,s,t,u,x,y));
		Graph<Integer> q = new Graph<>(v,w);
		q.nodes();
		q.DFS(q,a1);
		q.clear_array();
		System.out.println(Arrays.toString(q.array));
		q.BFS(q,a1);
		q.clear_array();
		q.Dijkstra(q,a1);
		q.clear_array();
		ArrayList<Object> ll=new ArrayList(Arrays.asList(q.edges.toArray()));
		int bb=0;
		for(bb=0;bb<q.array.length;bb++){
			System.out.println(((Edge<Integer>)(ll.get(bb))).weight);
		}
		q.clear_array();
		q.prim(q,a1);
	}
}

