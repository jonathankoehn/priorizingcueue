import java.util.ArrayList;

/**
 * Data structure to carry objects. Returns ordered by priority and FIFO.
 * @author Jonathan Koehn
 */
public class PriorizingCueue <T>{
	private ArrayList<ArrayList<T>> listlist;
	private int maxPrio = -1;
	
	public PriorizingCueue(int maxPrio){
		listlist = new ArrayList<>();
		for(int i=0; i <= maxPrio; i++){
			listlist.add(new ArrayList<>());
		}
		if(maxPrio > 0){
			this.maxPrio = maxPrio;
		}else{
			this.maxPrio = 0;
		}
	}// end constructor

	/**
	 * @param entry
	 * @param priority
	 */
	public void addEntry(T entry, int priority) {
		if(priority < 0){
			listlist.get(0).add(entry);
			return;
		}
		if(priority > maxPrio){
			listlist.get(maxPrio).add(entry);
			return;
		}
		listlist.get(priority).add(entry);
	}// end addEntry()
	
	/**
	 * @return First entry available.
	 */
	public T dequeueNext(){
		for(ArrayList<T> l : listlist){
			if(!l.isEmpty()){
				// returning entry
				return l.remove(0);
			}else{
				// empty list, trying next list
			}
		}// end for
		// queue empty
		return null;
	}
	
	/**
	 * @return Sum of entries of all ArrayLists.
	 */
	public int getSize(){
		int size=0;
		for(ArrayList<T> l : listlist){
			size += l.size();
		}
		return size;
	}// end getSize()
}// end class
