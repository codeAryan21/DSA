package StacksAndQueues.Implementation;

import java.util.*;

public class LRUCache {
    Map<Integer,Node> map = new HashMap<>();
    int capacity;
    Node head = new Node(0,0);
    Node tail = new Node(0,0);

    public LRUCache(int capacity){
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        if(map.containsKey(key)){
            Node node = map.get(key);
            deleteNode(node);
            insertAfterHead(node);
            return node.value;
        }else {
            return -1;
        }
    }

    public void put(int key,int value){
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            insertAfterHead(node);
        }else {
            if(map.size() == capacity){
                Node node = tail.prev;
                map.remove(node.key);
                deleteNode(node);
            }
            Node node = new Node(key,value);
            map.put(key,node);
            insertAfterHead(node);
        }
    }

    public void insertAfterHead(Node node){
        map.put(node.key,node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void deleteNode(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    class Node {
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key,int val){
            this.key = key;
            this.value = val;
        }
    }
}
