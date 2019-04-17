package com.example.kanishk.virtualtype;
import java.util.*;
/* Trie Node 
    #Constructor
    get a given key
    add value to the integer list as well as get values from it
    check if node has children or not
    if yes then able to get and add the children..

*/
class TrieNode{
    private Character key;
    private Map<Character,TrieNode> childrenMap;
    private List<Integer> idList;
//Constructor.
    TrieNode(Character key){
        this.key = key;
        this.childrenMap = new HashMap<Character,TrieNode>();
        idList = new ArrayList<Integer>();
    }

    public Character getKey(){
        return key;
    }

    public void addValue(Integer value){
        this.idList.add(value);
    }

    public List<Integer> getValues(){
        return this.idList;
    }
    
    public boolean hasChildren(){
        return this.childrenMap.size()>0;
    }


    public Map<Character,TrieNode> getChildren(){
        return this.childrenMap;      
    }

    public void addChild(TrieNode child){
        this.childrenMap.put(child.getKey(),child);
    }

}