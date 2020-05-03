package arch.project.arch;

import android.content.Context;
import android.content.SharedPreferences;
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
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class PayDoneFragment extends Fragment {


    TextView back;
    TextView doned;
    TextView donation;
    SharedPreferences pref;
    SharedPreferences.Editor editor;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(arch.project.arch.R.layout.fragment_pay_done, null);

        doned = view.findViewById(R.id.doned);
        donation = view.findViewById(R.id.donation);

        int price = getArguments().getInt("Price");
        doned.setText(String.valueOf(price));

        float d = price/100.0f;
        donation.setText(String.valueOf(d));

        pref = getContext().getSharedPreferences("shared", Context.MODE_PRIVATE);
        editor = pref.edit();

        int oldPrice = pref.getInt("used",0);
        float oldDonation = pref.getFloat("donation",0);


        editor.putInt("used",price+ oldPrice);
        editor.putFloat("donation",d+ oldDonation);
        editor.commit();

        back = view.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
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
