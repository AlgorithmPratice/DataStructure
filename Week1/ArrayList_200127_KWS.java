package week1;

public class ArrayList {
	private int size = 0;
	private Object[] elementData = new Object[100];
	
	public void add(Object element)
	{
		elementData[size] = element;
		size++;
	}
	
	public void add(int index, Object element)
	{
		for(int i = size-1; i>=index; i--)
		{
			elementData[i+1] = elementData[i];
		}
		
		elementData[index] = element;
		
		size++;
	}
	
	public void delete(int index)
	{
		for (int i = index+1; i<=size-1; i++)
		{
			elementData[i-1] = elementData[i];
		}
		
		size--;
		
		elementData[size] = null;
	}
	
	public Object indexOf(Object element)
	{
		for(int i = 0; i<size; i++)
		{
			if(element.equals(elementData[i]))
			{
				return i;
			}
		}
		
		return -1;
	}
	
	public Object get(int index)
	{
		return elementData[index];
	}
	public int size()
	{
		return size;
	}
}
