import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int CAPACITY;
    private LRUNode head;
    private LRUNode tail;
    Map<Integer,LRUNode> mapper;
    public LRUCache(int CAPACITY) {
        this.CAPACITY = CAPACITY;
        this.head = new LRUNode(-1,-1);
        this.tail = new LRUNode(-1,-1);
        head.nextNode = tail;
        tail.prevNode=head;
        mapper = new HashMap<>();
    }


    public int get(int key){
        if(mapper.containsKey(key)){
            LRUNode node = mapper.get(key);
            removeNode(node);
            moveToHead(node);
            return node.getValue();
        }
        return -1;

    }

    public void put(int key,int value){
        if(mapper.containsKey(key)){
            LRUNode node = mapper.get(key);
            node.setValue(value);
            removeNode(node);
            moveToHead(node);
        }else{
            LRUNode newNode = new LRUNode(key,value);
            if(mapper.size()<CAPACITY){
                mapper.put(key,newNode);
                moveToHead(mapper.get(key));
            }else{
                mapper.put(key,newNode);
                mapper.remove(tail.prevNode.getKey());// remove from Map
                removeNode(tail.prevNode);
                moveToHead(newNode);
                //moveToHead(mapper.get(key));
            }

        }
    }



    private void moveToHead(LRUNode node) {

        node.nextNode = head.nextNode;
        node.prevNode = head;
        head.nextNode = node;
        node.nextNode.prevNode=node;


    }

    private void removeNode(LRUNode node) {
        node.nextNode.prevNode = node.prevNode;
        node.prevNode.nextNode = node.nextNode;
    }





}




class LRUNode{

    private  int key;
    private int value;


    LRUNode nextNode;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    LRUNode prevNode;
    public LRUNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
