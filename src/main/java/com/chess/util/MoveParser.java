package com.chess.util;

import com.chess.models.Location;

import java.util.HashMap;

public class MoveParser {

    static HashMap<Character,Integer> colMap = new HashMap<>();
    static HashMap<Character,Integer> rowMap = new HashMap<>();
    static {
        colMap.put('A',0);
        colMap.put('B',1);
        colMap.put('C',2);
        colMap.put('D',3);
        colMap.put('E',4);
        colMap.put('F',5);
        colMap.put('G',6);
        colMap.put('H',7);
    }

    static {
        rowMap.put('1',0);
        rowMap.put('2',1);
        rowMap.put('3',2);
        rowMap.put('4',3);
        rowMap.put('5',4);
        rowMap.put('6',5);
        rowMap.put('7',6);
        rowMap.put('8',7);
    }

    public static  Location[] parseMove(String moves) {
        String[] move = moves.split(" ");

        if(!isValidMoveString(move)) return null;

        String source = move[0];
        String destination = move[1];

        //Get source location
        int sourceY =  colMap.get(source.charAt(0));
        int sourceX = rowMap.get(source.charAt(1));
        Location sorceLocation = new Location(sourceX, sourceY);

        //Get destination location
        int destinationY =  colMap.get(destination.charAt(0));
        int destinationX =  rowMap.get(destination.charAt(1));
        Location destinationLocation = new Location(destinationX, destinationY);

        //Return location
        return new Location[]{sorceLocation, destinationLocation};



    }

    public  static  boolean isValidMoveString(String[] move){

        if(move.length != 2) return false;

        String source = move[0];
        String destination = move[1];

        System.out.println(source.length());
        System.out.println(destination.length());

        if(source.length() != 2) return false;
        if(destination.length() != 2) return false;

        if(!colMap.containsKey(source.charAt(0))) return false;
        if(!rowMap.containsKey(source.charAt(1))) return false;

        if(!colMap.containsKey(destination.charAt(0))) return false;
        if(!rowMap.containsKey(destination.charAt(1))) return false;



        return true;


    }
}
