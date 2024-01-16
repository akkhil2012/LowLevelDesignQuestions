package org.example;

import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;

public class Cache {


    Map<Integer, LNode> map;

    int capacity;

    LNode head;
    LNode tail;

    public Cache(int cap) {
        this.map = new HashMap<>();
        capacity = cap;
        head = new LNode(-1,-1);
        tail = new LNode(-1,-1);
        head.next = tail;
        tail.prev = head;
    }



    public void put(int key,int value){
         if(map.containsKey(key)){
             LNode nodeToUpdate = map.get(key);
             nodeToUpdate.value = value;
             //
             removeNodeFromList(nodeToUpdate);
             // move the key node to front
             moveNodeToFront(nodeToUpdate);
         }else{
             LNode newNode = new LNode(key,value);
             if(map.size()>=capacity){
                 //moveNodeToFront(newNode);
                 map.remove(tail.prev.key);
                 removeNodeFromList(tail.prev);
             }
             moveNodeToFront(newNode);
             map.put(key,newNode);
             /*if(map.size()<capacity){
                 moveNodeToFront(newNode);

             }else{
                 map.remove(tail.prev.key);
                 removeNodeFromList(tail.prev);
                 moveNodeToFront(newNode);
             }
             map.put(key,newNode);*/


         }
    }



    public int get(int key){
        if(map.containsKey(key)){
            LNode nodeVisited = map.get(key);
            // remove node from list
            removeNodeFromList(nodeVisited);
            // move the key node to front
            moveNodeToFront(nodeVisited);
            return nodeVisited.value;
        }
        return -1;
    }

    // 1 2 3

    private void moveNodeToFront(LNode nodeToAdd){
        LNode temp = head.next;

        nodeToAdd.prev = head;
        nodeToAdd.next = temp;

        head.next = nodeToAdd;
        temp.prev = nodeToAdd;

    }

    private void removeNodeFromList(LNode nodeToRemove){

        nodeToRemove.next.prev = nodeToRemove.prev;
        nodeToRemove.prev.next= nodeToRemove.next;


    }








}



class LNode{

    int key,value;
    LNode prev=null,next = null;

    public LNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
