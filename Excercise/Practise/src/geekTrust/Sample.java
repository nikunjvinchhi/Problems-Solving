package geekTrust;

public class Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkList p = null;
		LinkList head = null;
		LinkList t = null;
		//create a link list
		for(int i=1; i<=10; i++) {
			if(head == null) {
				t = new LinkList(i);
				head = t;
				head.next = null;
			} else {
				t = head;
				p = new LinkList(i);
				while(t.next != null) {
					t = t.next;
				}
				t.next = p;
			}
		}
		
		p = head;
		while(p != null) {
			System.out.print(p.val + " ");
			p = p.next;
		}
		System.out.println();
		//reverse Link list
		p = reverse(head);
		
		while(p != null) {
			System.out.print(p.val + " ");
			p = p.next;
		}
		System.out.println();
	}

	//1->2->3->4->5->6
	private static LinkList reverse(LinkList head) {
		LinkList t = head;
		LinkList prev = null;
		while(t != null) {
			LinkList temp = t.next;
			t.next = prev;
			prev = t;
			t = temp;
		}
		return prev;
	}


	static class LinkList{
		int val;
		LinkList next;
		
		public LinkList(int val){
			this.val = val;
		}
	}
}
