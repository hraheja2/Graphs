public class vertex<T>{
	public T data;
	public vertex(T data){
		if (data==null){
			throw new IllegalArgumentException("No Null data");
		}
		this.data=data;
	}
	public int hashCode(){
		return data.hashCode();
	}
	public static void main(String args[]){
        	vertex<Integer> a = new vertex<>(5);
        	System.out.println(a.hashCode());
	}
}

