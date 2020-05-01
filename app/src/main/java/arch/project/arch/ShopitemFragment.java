package arch.project.arch;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ShopitemFragment extends Fragment {
    Button paydone;
    TextView bback;
    TextView name;
    ListView items;
    ImageView logo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(arch.project.arch.R.layout.fragment_shopitem, null);

        name = view.findViewById(R.id.nameofshop);
        logo = view.findViewById(R.id.logo);

        //               getting bundle  getting string inside bundle
        String shopname = getArguments().getString("someShop");
        name.setText(shopname);

        final List<Shopitem> item_list = new ArrayList<>();

        logo.setImageResource (R.drawable.mc);



        switch (shopname){

            case "McDon":
                item_list.add(new Shopitem("Hamburger", 300));
                item_list.add(new Shopitem("Nuggets", 400));
                logo.setImageResource (R.drawable.mc);
                break;

            case "LAWSO":
                item_list.add(new Shopitem("Water", 100));
                item_list.add(new Shopitem("Juice", 150));
                logo.setImageResource (R.drawable.lw);
                break;

            case "SevenTwelve":
                item_list.add(new Shopitem("Sandwich", 200));
                item_list.add(new Shopitem("IceCream", 140));
                item_list.add(new Shopitem("Salad", 250));
                logo.setImageResource (R.drawable.sv);
                break;

            case "UNIzon":
                item_list.add(new Shopitem("T-shirt", 1000));
                item_list.add(new Shopitem("Coat", 2000));
                item_list.add(new Shopitem("Gloves", 700));
                item_list.add(new Shopitem("Cap", 700));
                logo.setImageResource (R.drawable.uz);
                break;

            case "Daydream":
                item_list.add(new Shopitem("Pencil", 100));
                item_list.add(new Shopitem("Folder", 100));
                item_list.add(new Shopitem("RubberBands", 100));
                logo.setImageResource (R.drawable.da);
                break;

            case "FamilyMarch":
                item_list.add(new Shopitem("Doughnut", 130));
                item_list.add(new Shopitem("Water", 100));
                item_list.add(new Shopitem("Gum", 100));
                logo.setImageResource (R.drawable.fa);
                break;


            default:
                break;


        }

        ShopitemAdapter shopitemAdapter = new ShopitemAdapter(getContext(), R.layout.shopitem,item_list);


        items =(ListView) view.findViewById(R.id.items);
        items.setAdapter(shopitemAdapter);

        paydone = view.findViewById(R.id.paydone);
        paydone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = getFragmentManager();
                if(fragmentManager != null) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    // BackStackを設定
                    fragmentTransaction.addToBackStack(null);

                    fragmentTransaction.replace(R.id.container, new PayMenuFragment());
                    fragmentTransaction.commit();

                }
            }

        });

        bback = view.findViewById(R.id.bback);
        bback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = getFragmentManager();
                if(fragmentManager != null) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    // BackStackを設定
                    fragmentTransaction.addToBackStack(null);

                    fragmentTransaction.replace(R.id.container, new ShopFragment());
                    fragmentTransaction.commit();

                }
            }

        });

        return view;
    }

}
