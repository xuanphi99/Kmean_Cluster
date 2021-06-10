import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String args[]) throws IOException {

		
	
		// TODO Auto-generated method stub
		
		Map<String, Integer> hashMap = new HashMap<>();
		  
        hashMap.put("A", 1);
        hashMap.put("B", 2);
        hashMap.put("C", 3);
Map<String, Integer> second_map = new HashMap<>();
second_map.putAll(hashMap);
        System.out.println(second_map);
        System.out.println(second_map.equals(hashMap));
        
        
        for (int i = 0; i <10; i++) {
			
		
        hashMap.put("C", 111);
        System.out.println(hashMap);
       
        System.out.println(second_map);
        
        
        if (second_map.equals(hashMap) ==true) {
        	System.out.println("dung "+i);
			break;
		}
        second_map.putAll(hashMap);
        
		}
	}
}
