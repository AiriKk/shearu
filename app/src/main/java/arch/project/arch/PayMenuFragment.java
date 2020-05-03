package arch.project.arch;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
//import arch.project.arch.R;

public class PayMenuFragment extends Fragment {

    Button check;
    TextView backed;
    TextView finalTotal;
    ListView items;
    int totally;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(arch.project.arch.R.layout.fragment_pay_menu, null);

        ArrayList<Shopitem> chosen_list = getArguments().getParcelableArrayList("ChosenItems");


        ShopitemAdapter shopitemAdapter = new ShopitemAdapter(getContext(), R.layout.shopitem,chosen_list);

        int position = 0;

        finalTotal = view.findViewById(R.id.totally);
        totally=0;

        int size = chosen_list.size();
        for( int i = 0; i < size; i++ )
        {
            Shopitem shopitem = chosen_list.get(i);
            totally += + (shopitem.cost);
        }

        finalTotal.setText(String.valueOf(totally));


        items =(ListView) view.findViewById(R.id.chosenList);
        items.setAdapter(shopitemAdapter);

        check = view.findViewById(R.id.check);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = getFragmentManager();
                if(fragmentManager != null) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    // BackStackを設定
                    fragmentTransaction.addToBackStack(null);

                    PayDoneFragment payDone = new PayDoneFragment();

                    Bundle args = new Bundle();
                    args.putInt("Price", totally);
                    payDone.setArguments(args);

                    fragmentTransaction.replace(R.id.container,payDone );
                    fragmentTransaction.commit();

                }
            }

        });

        backed = view.findViewById(R.id.backed);
        backed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = getFragmentManager();

                fragmentManager.popBackStackImmediate();
//                if(fragmentManager != null) {
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//                    // BackStackを設定
//                    fragmentTransaction.addToBackStack(null);
//
//                    fragmentTransaction.replace(R.id.container, new ShopitemFragment());
//                    fragmentTransaction.commit();
//
//
//                }
            }

        });

        return view;
    }


}
