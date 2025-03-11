public class Container<T>{
	private T t;
	public void set(T t){
		this.t=t;
	}
	public T get(){
		return t;
	}
public static void main(String args[]){
		Container<String> gaga=new Container();
		gaga.set("Hello World");
		System.out.println(gaga.get());
	}
}
