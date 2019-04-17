package com.example.kanishk.virtualtype;
import java.util.*;


public class Trie{

    private TrieNode root;

    Trie(){
        root = new TrieNode(' ');
    }
    /*word to be inserted in
    T9 numeral form
    eg 456. and the word id to this 
    Numeral form*/

    public void insert(String key, Integer wID){
        //Set starting Point
        TrieNode n = root;
        //String to char array.
        for(char c:key.toCharArray()){
            //Grab root ke bacche..
            Map<Character,TrieNode> childrenMap = n.getChildren();
            //if children dont contain given character then put it there
            //otherwise find the position of the word and proceed
            if(!childrenMap.containsKey(c)){
                //make a new node and put it
                TrieNode cNode = new TrieNode(c);
                childrenMap.put(c,cNode);
                n = cNode;
            }
            else{
                n = childrenMap.get(c);
            }
            n.addValue(wID);
        }
    }

    //Perform DFS.. for children
    private void getChildrenValues(TrieNode n,List<Integer> resultList){
        Map<Character, TrieNode> childrenMap = n.getChildren();
        if(!childrenMap.isEmpty()){
            //if chidren are present then iterate recursively and save all at the end
            Iterator <TrieNode> it = childrenMap.values().iterator();
            while(it.hasNext()){
                getChildrenValues(it.next(), resultList);
            }
        }
        resultList.addAll(n.getValues());
    }

    //Now we need a method to get all the matches and then sort
    // Can be achieved by using a list. t9 number input and no. of matches returned.

    public List<Integer> getResults(String input, int nResults){
        List <Integer> resultList = new ArrayList<Integer>();
        TrieNode n = root;
        for(Character c:input.toCharArray()){
            Map<Character,TrieNode> childMap = n.getChildren();

            if(!childMap.containsKey(c)){
                return resultList;
            }
            else{
                n = childMap.get(c);
            }
        }
    getChildrenValues(n, resultList);
    Collections.sort(resultList);
    if(resultList.size()<nResults){
        return resultList;
    }
    else{
        return resultList.subList(0, nResults);
    }
    }
}