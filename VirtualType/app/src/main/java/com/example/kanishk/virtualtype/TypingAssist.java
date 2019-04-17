package com.example.kanishk.virtualtype;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.widget.Toast;

import java.util.*;
import java.io.*;

public class TypingAssist {
    //t9 mapping
    public static Map <Character,Integer> t9Map;
    //list of words after decoding 
    private List<String> wordList;
    //trie
    private Trie t9trie;
    
    public TypingAssist(){//default constructor
        t9trie = new Trie();
        wordList = new ArrayList<String>();
        t9Map = new HashMap<Character,Integer>();
        //allocate keys to alphabets
        t9Map.put('a', 2);
        t9Map.put('b', 2);
        t9Map.put('c', 2);
        t9Map.put('d', 3);
        t9Map.put('e', 3);
        t9Map.put('f', 3);
        t9Map.put('g', 4);
        t9Map.put('h', 4);
        t9Map.put('i', 4);
        t9Map.put('j', 5);
        t9Map.put('k', 5);
        t9Map.put('l', 5);
        t9Map.put('m', 6);
        t9Map.put('n', 6);
        t9Map.put('o', 6);
        t9Map.put('p', 7);
        t9Map.put('q', 7);
        t9Map.put('r', 7);
        t9Map.put('s', 7);
        t9Map.put('t', 8);
        t9Map.put('u', 8);
        t9Map.put('v', 8);
        t9Map.put('w', 9);
        t9Map.put('x', 9);
        t9Map.put('y', 9);
        t9Map.put('z', 9);

    }

    public void buildTrie(InputStream file){

        Scanner sc;
        try{

            sc = new Scanner(file);
            int wID = 0;
            while (sc.hasNextLine()){
		String word = sc.nextLine().trim();
		this.wordList.add(word);
		String t9EncodingStr = this.getT9Encoding(word);
		t9trie.insert(t9EncodingStr, wID++);
			}
			sc.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    // return the T9 style numeral encoding for a word
    public String getT9Encoding(String word){
        StringBuffer buf = new StringBuffer();
        //wordify it
        for(char c: word.toCharArray()){
            char lc = Character.toLowerCase(c);
            //if map contains the key then fetch the number
            if(t9Map.containsKey(lc)){
                buf.append(t9Map.get(lc));
            }
        }
        return buf.toString();
    }

    public List<String> getWordList(String t9encoding, int nResults){
        List<Integer> wIDList = t9trie.getResults(t9encoding, nResults);
        List <String> wList  = new ArrayList<String>();
        for(Integer i:wIDList){
            String word = this.wordList.get(i);
            wList.add(word);
        }
        return wList;
    }


    //public static void main(String[] args)throws IOException
     public static List<String> mains(String st,InputStream is)throws IOException{
      TypingAssist t = new TypingAssist();
         List<String> list = null;
      //*********dictionary will go here for ANDROID APP***************************************************
         //String path = "android.resource://com.example.kanishk.virtualtype/raw/t9dictionary.txt";

         t.buildTrie(is);
      try{
     //***************Input will go here for the ANDROID APP********************************************************
          BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));


        //  while(true){
             // System.out.println("Enter the T9 Input:");
             // String input = ob.readLine();
              String input=st;
              list = t.getWordList(input,5);
             // list.add("kanishk");
             // return(list);
             /* if(list.size()==0){
                  System.out.println("No Suggestions!");

              }
              else{
                  for(String r: list){
                      System.out.println(r);

                  }
              }*/
          //}

      }
      catch(Exception e){
         System.out.println(e);
      }
         return(list);
    }
}