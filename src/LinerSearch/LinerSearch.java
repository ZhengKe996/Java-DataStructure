package LinerSearch;

/*
* 线性查找法
* */
public class LinerSearch{
    private LinerSearch(){
    }

    public static <T> int search(T[] data,T target){
        for(int i = 0;i < data.length;i++){
            if(data[i].equals(target)) return i;
        }
        return -1;
    }
}