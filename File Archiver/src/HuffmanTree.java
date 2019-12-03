import java.util.*;

public class HuffmanTree {

	public Character chars;
	public Integer freq;
	HuffmanTree(Character chars, Integer freq) {

		this.chars = chars;
		this.freq = freq;

	}

	HuffmanTree(Integer freq) {
		this.chars = null;
		this.freq = freq;
	}
    
	public Integer getFreq() { 
	    return this.freq ; 
	}
	
	public Character getChars() {
		return this.chars;
	}
	public void increase_freq() {

		if (this.freq == null)
			this.freq = 0;
		else
			this.freq = this.freq + 1;

	}

	public static void main(String[] args) {

		PriorityQueue<HuffmanTree> obj= new PriorityQueue<HuffmanTree>(30, new HuffmanTreeComparator());
		
	    obj.add(new HuffmanTree('a',15));
	    obj.add(new HuffmanTree('b',10));
	    obj.add(new HuffmanTree('c',5));
	    
	    while(obj.isEmpty() == false) {
	    	  
	    	  System.out.print(obj.peek().getFreq());
	    	  System.out.print(" ");
	    	  System.out.println(obj.peek().getChars());
	    	  
	    	  obj.remove();
	    }
	    

	}

}

class HuffmanTreeComparator implements Comparator<HuffmanTree> {

	public int compare(HuffmanTree obj1 , HuffmanTree obj2) {
           
          if(obj1.getFreq()  >  obj2.getFreq()) {
         
             return 1; 
         
          }
          if(obj1.getFreq()  <  obj2.getFreq())  {
            
             return -1;
             
          }
         
          return 0;
     
    }
}
