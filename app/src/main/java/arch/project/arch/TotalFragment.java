package arch.project.arch;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class TotalFragment extends Fragment {

    Button setting;
    Button help;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    SharedPreferences pref;
    TextView tt;
    TextView donation;



    static TotalFragment newInstance(){
        //呼ばれたものを渡す(返事する)
        return new TotalFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(arch.project.arch.R.layout.fragment_total, null);

        pref = getContext().getSharedPreferences("shared", Context.MODE_PRIVATE);

        tt = view.findViewById(R.id.tt);
        donation = view.findViewById(R.id.donation);

        int total = pref.getInt("used",0);
        float donTotal = pref.getFloat("donation",0);


        tt.setText(String.valueOf(total));
        donation.setText(String.valueOf(donTotal));

        //accountV.setText(name);



        help = view.findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = getFragmentManager();
                if(fragmentManager != null) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    // BackStackを設定
                    fragmentTransaction.addToBackStack(null);

                    fragmentTransaction.replace(R.id.container, new HowToFragment());
                    fragmentTransaction.commit();

                }
            }

        });

        return view;
    }

}
