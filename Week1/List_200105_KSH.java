package datastructure;

public class List {
	//첫번째 링크드노드를 가리키는 필드
	private ListNode head;
	private ListNode tail;
	
	//첫번째 이중연결리스트를 가리키는 필드
	private DLLNode dllhead;
	private DLLNode dlltail;
	
	//배열리스트 객체
	private int ALSize=0;
	private Object[] ALData = new Object[100];

	//단순연결 리스트 노드
	private class ListNode{
		private Object data;
		private ListNode next;
		public ListNode(Object data) { 
			this.data=data; 
			this.next=null;
		}
	}
	
	//이중연결리스트 노드
	static class DLLNode{
		private Object data;
		private DLLNode next;
		private DLLNode previous;
		public DLLNode(Object data) { 
			this.data=data;
			this.next=null;
			this.previous=null;
		}
	}
  
	//배열리스트 노드 추가
	public boolean ALAdd(int position, Object AList) {
		for(int i=ALSize-1;i>=position;i--) ALData[i+1]=ALData[i];
		ALData[position]=AList;
		ALSize++;
		return true;
	}
  
	//배열리스트노드 삭제
	public Object ALRemove(int position) {
		Object removed = ALData[position];
		for(int i=position+1;i<=ALSize-1;i++) ALData[i-1]=ALData[i];
		ALSize--;
		ALData[ALSize]=null;
		return removed;
	}
	
	//링크드리스트노드 추가
	public void LLadd(int position, Object list){
		if(position == 0){ 
			ListNode newNode = new ListNode(list);
			newNode.next=head;
			head=newNode;
			if(head.next==null) { tail=head; }
		} 
		else {
			//노드 이동
			ListNode node = head;
			for(int i=0;i<position-1;i++) node=node.next;

		    ListNode temp1 = node;
		    ListNode temp2 = temp1.next;
		    ListNode newNode = new ListNode(list);
		    temp1.next = newNode;
		    newNode.next = temp2;

		    if(newNode.next == null) tail = newNode;
		}
   	}
    
	//링크드 리스트 노드삭제
	public Object LLremove(int position){
		if(position == 0) {
			ListNode temp = head;
		    	head = temp.next;
		    	Object returnData = temp.data;
		    	temp = null;
		    	return returnData;
		}
		ListNode node = head;
		for(int i=0;i<position-1;i++) node=node.next;

		ListNode todoDeleted = node.next;
		node.next = node.next.next;
		Object returnData = todoDeleted.data; 
		if(todoDeleted == tail){
		    	tail = node;
		}
		todoDeleted = null; 
		return returnData;
	}

	//이중연결리스트 추가
	public void DLLadd(int position, Object list){
		if(position == 0){ 
			DLLNode newNode = new DLLNode(list);
			newNode.next=dllhead;
			if(dllhead!=null) dllhead.previous=newNode;
			dllhead=newNode;
			if(dllhead.next==null) { dlltail=dllhead; }
		} 
		else {
			//노드 이동
			DLLNode node = dllhead;
			for(int i=0;i<position-1;i++) node=node.next;

			DLLNode temp1 = node;
			DLLNode temp2 = temp1.next;
			DLLNode newNode = new DLLNode(list);
		    	temp1.next = newNode;
		    	newNode.next = temp2;
		    	if(temp2!=null) temp2.previous=newNode;
		    	newNode.previous=temp1;
		    	if(newNode.next == null) dlltail = newNode;
		}
	}

	//이중연결 리스트 노드삭제
	public Object DLLremove(int position){
		if(position == 0) {
			DLLNode temp = dllhead;
			dllhead = temp.next;
		    	Object returnData = temp.data;
		    	temp = null;
		    	if(dllhead!=null) dllhead.previous=null;
		    	return returnData;
		}
		DLLNode node = dllhead;
		for(int i=0;i<position-1;i++) node=node.next;

		DLLNode todoDeleted = node.next;
		node.next = node.next.next;

		if(node.next!=null) node.next.previous=node;

		Object returnData = todoDeleted.data; 

		if(todoDeleted == dlltail){
		    dlltail = node;
		}
		todoDeleted = null; 
		return returnData;
	}
}
