public class CircularLinkedList {

    private Node head;

    public CircularLinkedList() {
        this.head = null;
    }

    public class Node {
        private String data;
        public Node link;

        public Node() {
            this.data = null;
            this.link = null;
        }

        public Node(String data) {
            this.data = data;
        }

        public Node(String data, Node link) {
            this.data = data;
            this.link = link;
        }

        public String getData() {
            return this.data;
        }
    }

    public void printList() {
        if (head == null) {
            System.out.println("길이가 0인 리스트");
            return;
        }
        Node temp = head;
        int idx = 1;
        if (temp.link == temp) {
            System.out.println("index : " + idx + "data : " + temp.getData());
        } else {
            while (temp.link != head) {
                System.out.println("index : " + idx + " data : " + temp.getData());
                temp = temp.link;
                idx++;
            }
            System.out.println("index : " + idx + " data : " + temp.getData());
        }
    }

    public void FirstNodeInsert(String data) {
        Node insertNode = new Node(data);
        if (this.head == null) {
            head = insertNode;
            insertNode.link = insertNode;
        } else {
            Node temp = head;
            insertNode.link = head;
            while (temp.link != head) {
                temp = temp.link;
            }
            temp.link = insertNode;
            head = insertNode;
        }
    }

    public Node searchNode(String data) {

        Node searchNode = new Node();
        searchNode = head;

        while (searchNode.link != head) {
            if (searchNode.getData().equals(data)) {
                return searchNode;
            } else {
                searchNode = searchNode.link;
            }
        }

        if (searchNode.getData().equals(data)) {
            return searchNode;
        } else {
            System.out.println("찾는 데이터 없음");
            return null;
        }
    }

    public void middleNodeInsert(String data, Node pre) {
        Node insertNode = new Node(data);
        if (head == null) {
            head = insertNode;
            insertNode.link = insertNode;
        } else {
            Node temp = head;
            while (temp.link != head) {
                if (pre == temp) {
                    insertNode.link = pre.link;
                    pre.link = insertNode;
                    return;
                } else {
                    temp = temp.link;
                }
            }

            if (temp == pre) {
                insertNode.link = pre.link;
                pre.link = insertNode;
                return;
            } else {
                System.out.println("pre 노드가 존재하지 않습니다.");
            }
        }
    }

    public void deleteNode(Node targetNode) {
        Node temp = head;
        if (temp == targetNode) {
            Node headNode = head;
            head = headNode.link;
            while (temp.link != headNode) {
                temp = temp.link;
            }
            temp.link = head;
        } else {
            Node preNode = temp;
            while (temp.link != head) {
                if (temp.link == targetNode) {
                    temp.link = targetNode.link;
                    targetNode.link = null;
                    return;
                } else {
                    preNode = temp;
                    temp = temp.link;
                }
            }
            if (temp == targetNode) {
                preNode.link = head;
                targetNode.link = null;
            } else {
                System.out.println("해당 노드가 없음");
                return;
            }
        }
    }

    public void reverseList() {
        Node pre = null;
        Node current = null;
        Node next = head;
        Node headNode = head;

        if (next.link == head) {
            System.out.println("리스트의 길이가 1입니다. reverse 불가");
            return;
        } else if (head == null) {
            System.out.println("리스트의 길이가 0입니다. reverse 불가");
            return;
        }

        while (next.link != head) {
            pre = current;
            current = next;
            next = next.link;
            current.link = pre;
        }

        pre = current;
        current = next;
        current.link = pre;
        headNode.link = current;
        head = current;
    }
}

