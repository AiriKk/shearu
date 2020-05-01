package arch.project.arch;

import java.util.List;

public class Cart {
    List<Shopitem> contents;


    public void addItem(Shopitem item){
        contents.add(item);

    }

    public int gettotal() {

        int total = 0;

        for(int i=0;i<contents.size();i++){

        //total += contents.get(i).cost;
        }

        return total;
    }



}
