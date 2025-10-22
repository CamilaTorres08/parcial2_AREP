package edu.eci.arep.math.Service;

public class MathService {

    public int binarySearch(int value, String[] list, int a, int b){
        if(a>b){
            return -1;
        }
        int medium = a + (b-a)/2;
        int current = Integer.parseInt(list[medium]);
        if(current == value){
            return medium;
        }
        else if(current > value){
            return binarySearch(value,list,a,medium-1);
        }
        else{
            return binarySearch(value,list,medium+1,b);
        }
    }

    public int linearSearch(int value, String[] list){
        int j = -1;
        for(int i = 0; i<list.length; i++){
            if(Integer.parseInt(list[i]) == value){
                j = i;
                break;
            }
        }
        return j;
    }
}
