package Cache;

import java.util.HashMap;
import java.util.LinkedList;

public class LFUCache<T> extends Cache<T> {
    HashMap<Integer, LinkedList<Node>> mapFromFrequencyToNodes;

    HashMap<Integer, Node> mapFromKeyToNode;
    private int minFrequency;

    public LFUCache(int maxCapacity) {
        this.MAX_CAPACITY = maxCapacity;
        this.currentCapacity = 0;
        this.minFrequency = 1;
        mapFromKeyToNode = new HashMap<>();
        mapFromFrequencyToNodes = new HashMap<>();
    }

    @Override
    public void put(int key, T value) {

//        If the key is already present
        if (mapFromKeyToNode.containsKey(key)) {
            updateValue(mapFromKeyToNode.get(key), value);
            return;

        }

//        If key is absent


//         Capacity overflow
        if (currentCapacity >= MAX_CAPACITY) {
            System.out.println("Here");
            Node removed = remove();
            System.out.println(removed.getKey()+" "+removed.getFrequncy());

        } else currentCapacity++;
        minFrequency = 1;
//        Capacity fine
        Node<T> newN = new Node<T>(key, value);
        mapFromKeyToNode.put(key, newN);
        mapFromFrequencyToNodes.computeIfAbsent(newN.getFrequncy(), k -> new LinkedList<>());
        mapFromFrequencyToNodes.get(newN.getFrequncy()).addFirst(newN);

    }

    private Node remove() {
        Node removed = mapFromFrequencyToNodes.get(minFrequency).removeLast();
        if (mapFromFrequencyToNodes.get(minFrequency).size() == 0) minFrequency++;
        mapFromKeyToNode.remove(removed.getKey());
        return removed;


    }

    private void updateFrequency(Node node) {

        mapFromFrequencyToNodes.get(node.getFrequncy()).remove(node);
        if (node.getFrequncy() == minFrequency && mapFromFrequencyToNodes.get(node.getFrequncy()).size() == 0)
            minFrequency= node.getFrequncy()+1;
        node.setFrequncy(node.getFrequncy() + 1);
        mapFromFrequencyToNodes.computeIfAbsent(node.getFrequncy(), k -> new LinkedList<>());
        mapFromFrequencyToNodes.get(node.getFrequncy()).addFirst(node);
    }
    private void updateValue(Node node,T value){

        node.setVal(value);
        updateFrequency(node);
    }



    @Override
    public T get(int key) {
//        Search for node for the key
        if (!mapFromKeyToNode.containsKey(key)) return null;
        updateFrequency(mapFromKeyToNode.get(key));
        return (T) mapFromKeyToNode.get(key).getVal();
    }
}
