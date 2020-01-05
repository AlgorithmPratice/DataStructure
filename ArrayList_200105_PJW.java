
public class ArrayList {
	private int size = 0;
	private Object[] elementData = new Object[100];
	
	public boolean add(Object element) {
		elementData[size] = element;
		size++;
		return true;
	}
	
	public void add(int index, Object element) {
		for(int i=size-1;i>=index;i--) {
			elementData[i+1]=elementData[i];
		}
		elementData[index]=element;
		size++;
	}
	
	public boolean addAll(ArrayList c) {
		Object[] obj = c.toArray();
		int length = obj.length;
		for(int i=0;i<length;i++) {
			elementData[i] = obj[i];
			size++;
		}
		size += length;
		return length != 0;
	}
	
	public boolean addAll(int index, ArrayList c) {
		Object[] obj = c.toArray();
		int length = obj.length;
		for(int i=0;i<length;i++){
			elementData[index+i]=obj[i];
		}
		size = index + length;
		return length != 0;
	}
	
	public void clear() {
		for(int i=0;i<size;i++) {
			elementData[i] = null;
		}
		size = 0;
	}
	
	public Object clone() {
		Object[] obj = new Object[size];
		for(int i=0;i<size;i++) {
			obj[i] = elementData[i];
		}
		return obj;
	}
	
	public boolean contains(Object o) {
		return indexOf(o)!=-1;
	}
	
	public int indexOf(Object o) {
		int index = -1;
		for(int i=0;i<size;i++) {
			if(elementData[i].equals(o)) {
				index = i;
			}
		}
		return index;
	}
	
	public Object get(int index) {
		Object obj = elementData[index];
		return obj;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int lastIndexOf(Object o) {
		int index = -1;
		for(int i=size;i>=0;i--) {
			if(elementData[i].equals(o)) {
				index=i;
			}
		}
		return index;
	}
	
	public Object remove(int index) {
		Object obj = elementData[index];
		for(int i=index;i<size-1;i++) {
			elementData[i]=elementData[i+1];
		}
		elementData[size-1]=null;
		size--;
		return obj;
	}
	
	public boolean remove(Object o) {
		int index = indexOf(o);
		if(index != -1) {
			for(int i=index;i<size-1;i++) {
				elementData[i]=elementData[i+1];
			}
			elementData[size-1]=null;
			size--;
		}
		return index != -1;
	}
	
	public Object set(int index, Object element) {
		Object obj = elementData[index];
		elementData[index] = element;
		return obj;
	}
	
	public int size() {
		return size;
	}
	
	public ArrayList subList(int fromIndex, int toIndex) {
		ArrayList list = new ArrayList();
		for(int i=fromIndex;i<=toIndex;i++) {
			list.add(elementData[i]);
		}
		return list;
	}
	
	public Object[] toArray() {
		Object[] objArr = new Object[size];
		for(int i=0;i<size;i++) {
			objArr[i] = elementData[i];
		}
		return objArr;
	}
	
	public Object[] toArray(Object[] a) {
		Object[] obj = new Object[size];
		for(int i=0;i<size;i++) {
			obj[i] = elementData[i];
		}
		return obj;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("<");
		for(int i=0;i<size;i++) {
			str.append(elementData[i]);
			if(i==size-1) break;
			str.append(", ");
		}
		str.append(">");
		return str.toString();
	}
}
