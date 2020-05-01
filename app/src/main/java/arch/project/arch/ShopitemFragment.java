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



        switch (shopname){

            case "McDonalds":
                item_list.add(new Shopitem("Hamburger", 300));
                item_list.add(new Shopitem("Nuggets", 400));

                break;

            case "LAWSON":
                item_list.add(new Shopitem("Water", 100));

                break;

            case "SevenEleven":
                item_list.add(new Shopitem("Sandwich", 200));

                break;

            case "UNIQLO":
                item_list.add(new Shopitem("T-shirt", 1000));

                break;

            case "Daiso":
                item_list.add(new Shopitem("Pencil", 100));

                break;

            case "FamilyMart":
                item_list.add(new Shopitem("Doughnut", 130));

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
