import java.util.ArrayList;
import java.util.Comparator;

public class Hashmap<K,V> implements MapSet<K,V>{
    private Object[] hashTable;
    private int filled;
    private Comparator<K> comp;
    private int collisions;
    private int tableSize;

    // Hashmap constructor that starts with default size hash table
    public Hashmap(Comparator incomp) {
        this.hashTable = new HashNode[100];
        tableSize = 3;
        filled = 0;
        collisions = 0;
        this.comp = incomp;
    }

    // Hashmap constructor that starts with the suggested capacity hash table
    public Hashmap(Comparator incomp, int capacity ) {
        this.hashTable = new HashNode[capacity];
        tableSize = capacity;
        this.comp = incomp;
        filled = 0;
        collisions = 0;
    }

    public int hash(K key){
        return Math.abs(key.hashCode()) % tableSize;
    }

    @Override
    public V put(K new_key, V new_value) {
        testSize();
        int position = this.hash(new_key);

        HashNode current = (HashNode) hashTable[position];
        if(current == null){
            this.hashTable[position] = new HashNode(new_key, new_value);
            filled++;
        }else{
            while(current.next != null && !(current.valuePair.key.equals(new_key))){
                current = current.next;
            }
            if(current.valuePair.key.equals(new_key)){
                current.valuePair.value = new_value;
            }else{
                current.next = new HashNode(new_key, new_value);
                collisions++;
                filled++;
            }
        }
        return new_value;
    }

    @Override
    public boolean containsKey(K key) {
        int position = this.hash(key);
        HashNode current = (HashNode)hashTable[position];
        while(current != null && !(current.valuePair.key.equals(key))){
            current = current.next;
        }

        if(current.valuePair.key.equals(key)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public V get(K key) {
        int position = hash(key);
        HashNode current = (HashNode)hashTable[position];

        while(current != null && !(current.valuePair.key.equals(key))){
            current = current.next;
        }

        if(current == null){
            return null;
        }

        if(current.valuePair.key.equals(key)){
            return (V) current.valuePair.value;
        }

        return null;
    }

    @Override
    public ArrayList<K> keySet() {
//        for(int i = 0; i < tableSize; i++){
//            keySetRecursive((HashNode)hashTable[i]);
//        }
//        return keys;
//    }
//    ArrayList<K> keys = new ArrayList<>();
//    public ArrayList<K> keySetRecursive(HashNode root){
//        if(root != null){
//            keys.add((K) root.getKey());
//            if(root.next != null){
//                keySetRecursive(root.next);
//            }
//        }
//        return keys;
        ArrayList<K> keys = new ArrayList<>();

        for (int i=0; i < this.tableSize; i++){

            HashNode current = (HashNode)hashTable[i];

            while(current != null){
                keys.add((K) current.valuePair.key);
                current = current.next;
            }
        }
        return keys;
    }

    @Override
    public ArrayList<V> values() {
        ArrayList<V> values = new ArrayList<>();

        for (int i=0; i < this.tableSize; i++){

            HashNode current = (HashNode)hashTable[i];

            while(current != null){
                values.add((V) current.valuePair.value);
                current = current.next;
            }
        }
        return values;

//        for(int i = 0; i < tableSize; i++){
//            valuesRecursive((HashNode)hashTable[i]);
//        }
//        return values;
//    }
//    ArrayList<V> values = new ArrayList<>();
//    public ArrayList<V> valuesRecursive(HashNode root){
//        if(root != null){
//            values.add((V) root.getValue());
//            if(root.next != null){
//                valuesRecursive(root.next);
//            }
//        }
//        return values;
    }

    @Override
    public ArrayList<KeyValuePair<K, V>> entrySet() {
        ArrayList<KeyValuePair<K,V>> pairs = new ArrayList<>();

        for (int i=0; i < this.tableSize; i++){

            HashNode current = (HashNode)hashTable[i];

            while(current != null){
                pairs.add(current.valuePair);
                current = current.next;
            }
        }
        return pairs;
    }

    @Override
    public int size() {
        System.out.println("Collisions: " + collisions);
        return filled;
    }

    @Override
    public void clear() {
        this.hashTable = new HashNode[tableSize];
        filled = 0;
        collisions = 0;
    }

    public void testSize(){
        if(filled > (tableSize / 2)){
            System.out.println("doubled size");
            ArrayList<KeyValuePair<K,V>> data = this.entrySet();

            HashNode[] temp = new HashNode[tableSize * 2];
            this.tableSize = tableSize * 2;
            this.hashTable = temp;
            this.filled = 0;
            this.collisions = 0;

            for(int i = 0; i < data.size(); i++){
                this.put(data.get(i).getKey(), data.get(i).getValue());
            }
        }

    }

    public boolean remove(String key){
        int position = hash((K) key);
        HashNode target = (HashNode)hashTable[position];
        HashNode current = target;
        HashNode previous = null;

        while(current != null && current.valuePair.key != key){
            previous = current;
            current = current.next;
        }

        if (current == null){
            return false;
        }

        if (previous == null){
            this.hashTable[position] = current.next;
        }else{
            previous.next = current.next;
        }

        this.filled--;
        return true;
    }

    public class HashNode<K,V>{
        private KeyValuePair valuePair;
        private HashNode next;

        public HashNode(K key, V value){
            this.next = null;
            valuePair = new KeyValuePair(key,value);
        }

        public HashNode(K key, V value, HashNode next){
            valuePair = new KeyValuePair(key,value);
            this.next = next;
        }

        public K getKey(){
            return (K) this.valuePair.key;
        }

        public V getValue(){
            return (V) this.valuePair.value;
        }

        public void setKey(K key){
            this.valuePair.key = key;
        }

        public void setValue(V value){
            this.valuePair.value = value;
        }

        public HashNode getNext(){
            return this.next;
        }

        public String toString(){
            return this.getKey() + ", " + this.getValue();
        }
    }

    public static void main(String[] args){
        Hashmap<String, Integer> test = new Hashmap<String, Integer>(new AscendingString(), 5);
        test.put( "twenty", 20 );
        test.put("thirty", 30);
        test.put( "ten", 10 );
        test.put( "eleven", 11 );
        test.put( "five", 5 );
        test.put( "six", 4 );
        test.put("six", 6);
        test.put("six", 5);


//        for(String current : test.keySet()){
//            System.out.println(current);
//        }
//
//        for(int current : test.values()){
//            System.out.println(current);
//        }

        for(KeyValuePair current : test.entrySet()){
            System.out.println(current.toString());
        }

//        System.out.println("Should print true: " + test.containsKey("twenty"));
//        System.out.println("Should print false: " + test.containsKey("four"));

//        System.out.println(test.get("twenty"));

        System.out.println(test.size());
        System.out.println(test.collisions);
    }
}
