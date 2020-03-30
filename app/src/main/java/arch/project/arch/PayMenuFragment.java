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
import android.widget.Button;
import android.widget.TextView;

public class PayMenuFragment extends Fragment {

    Button check;
    TextView backed;

//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        super.onCreateView(inflater, container, savedInstanceState);
//        View view = inflater.inflate(arch.project.arch.R.layout.fragment_pay_menu, null);
//
//        check = view.findViewById(R.id.check);
//        check.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                FragmentManager fragmentManager = getFragmentManager();
//                if(fragmentManager != null) {
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//                    // BackStackを設定
//                    fragmentTransaction.addToBackStack(null);
//
//                    fragmentTransaction.replace(R.id.container, new PayShowFragment());
//                    fragmentTransaction.commit();
//
//                }
//            }
//
//        });
//
//        backed = view.findViewById(R.id.backed);
//        backed.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                FragmentManager fragmentManager = getFragmentManager();
//                if(fragmentManager != null) {
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//                    // BackStackを設定
//                    fragmentTransaction.addToBackStack(null);
//
//                    fragmentTransaction.replace(R.id.container, new ShopFragment());
//                    fragmentTransaction.commit();
//
//                }
//            }
//
//        });
//
//        return view;
//    }
//

}
