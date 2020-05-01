package arch.project.arch;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ShopFragment extends Fragment {
    ListView linearshop;




    @Nullable
@Override
public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    View view = inflater.inflate(arch.project.arch.R.layout.fragment_shop, null);


        final List<Shop> shop_list = new ArrayList<Shop>();
        shop_list.add(new Shop("McDon", android.R.color.holo_red_light));
        shop_list.add(new Shop("LAWSO", android.R.color.holo_blue_dark));
        shop_list.add(new Shop("SevenTwelve", android.R.color.holo_green_dark));
        shop_list.add(new Shop("UNIzon", android.R.color.holo_red_dark));
        shop_list.add(new Shop("Daydream", android.R.color.holo_purple));
        shop_list.add(new Shop("FamilyMarch", android.R.color.holo_blue_light));

        ShopAdapter shopAdapter = new ShopAdapter(getContext(), R.layout.shop,shop_list);


        linearshop =(ListView) view.findViewById(R.id.linearshop);
        linearshop.setAdapter(shopAdapter);


//        choose = view.findViewById(R.id.mc);
//        choose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                FragmentManager fragmentManager = getFragmentManager();
////                if(fragmentManager != null) {
////                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
////
////                    // BackStackを設定
////                    fragmentTransaction.addToBackStack(null);
////
////                    fragmentTransaction.replace(R.id.container, new PayShowFragment());
////                    fragmentTransaction.commit();
////
//                }
//            }
//
//        });


        // register onClickListener to handle click events on each item
        linearshop.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            // argument position gives the index of item which is clicked
            public void onItemClick(AdapterView arg0, View v,int position, long arg3)
            {
                //saving shop
                Shop shop = shop_list.get(position);

                FragmentManager fragmentManager = getFragmentManager();
                if(fragmentManager != null) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    // BackStackを設定
                    fragmentTransaction.addToBackStack(null);

                    ShopitemFragment payShow = new ShopitemFragment();

                    Bundle args = new Bundle();
                    args.putString("someShop", shop.shopname);
                    payShow.setArguments(args);

                    fragmentTransaction.replace(R.id.container, payShow);

                    fragmentTransaction.commit();
                }
            }

        });

    return view;
}

}