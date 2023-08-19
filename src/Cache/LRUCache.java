package Cache;

import java.util.HashMap;
import java.util.LinkedList;

/**
 Generic LRU cache with key as integer and value can be any object
 */
public class LRUCache<T> extends Cache<T> {

    /**
      Node List with left containing most recently accessed node and right with least recentyl acceessed
     */
    LinkedList<Node> nodeList;

    /**
     HashMap of key to Node for quick access of values for get operation
     */
    HashMap<Integer,Node> mapFromKeyToNode;
    public LRUCache(int maxCapacity){
        this.nodeList = new LinkedList<>();
        this.mapFromKeyToNode = new HashMap<>();
        this.currentCapacity = 0;
        this.MAX_CAPACITY = maxCapacity;
    }

    @Override
    public void put(int key, T value) {
//        Key is already present
        if(mapFromKeyToNode.containsKey(key)){
            mapFromKeyToNode.get(key).setVal(value);
            updateAccessToNode(mapFromKeyToNode.get(key));
            return ;
        }
//        2 cases -> 1.Capacity Full 2.Capcity not full
        if(currentCapacity>=MAX_CAPACITY)removeNode();
        else currentCapacity++;
        Node<T> newN = new Node<T>(key,value);
        nodeList.addFirst(newN);
        mapFromKeyToNode.put(key,newN);


    }

    private void updateAccessToNode(Node node){
        nodeList.remove(node);
        nodeList.addFirst(node);
    }
    private void removeNode(){
        mapFromKeyToNode.remove(nodeList.removeLast().getKey());
    }


    @Override
    public T get(int key) {

        if(!mapFromKeyToNode.containsKey(key)) return null;
        updateAccessToNode(mapFromKeyToNode.get(key));
        return (T) mapFromKeyToNode.get(key).getVal();

    }
}
