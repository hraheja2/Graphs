import java.util.*;
class ObjectComp implements Comparator<Object[]>{
	public int compare(Object[] a1, Object[] a2){
        	Double a11= ((Double)(a1[1]));
        	Double a21= (Double)(a2[1]);
        		if(a21==a11){
        			return 0;
        		}
        		else if(a21>a11){
        			return -1;
        		}
        		else if(a21<a11){
        			return 1;
        		}
			else{
				return 0;
			}
        }
}

