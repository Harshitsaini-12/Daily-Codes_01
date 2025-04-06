/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode mergeSort(ListNode s1,ListNode s2){
        if(s1==null)return s2;
        if(s2==null)return s1;

        ListNode dummy=new ListNode(-1);
        ListNode prev=dummy;
        ListNode c1=s1;
        ListNode c2=s2;

        while(c1!=null && c2!=null){
            if(c1.val<c2.val){
                prev.next=c1;
                c1=c1.next;
            }else{
                prev.next=c2;
                c2=c2.next;
            }
            prev=prev.next;
        }

        prev.next=c1!=null?c1:c2;
        return dummy.next;
    }

    public ListNode Ksort(ListNode[] lists,int si,int ei){
        if(si==ei)return lists[si];

        int mid=(si+ei)/2;

        ListNode s1=Ksort(lists,si,mid);
        ListNode s2=Ksort(lists,mid+1,ei);

        return mergeSort(s1,s2);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        return Ksort(lists,0,lists.length-1);
    }
}