package arch.project.arch;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ShopAdapter extends ArrayAdapter<Shop> {

    List<Shop> mShops;

    public ShopAdapter(Context context, int resourceId, List<Shop> objects){
        super(context, resourceId, objects);

        mShops = objects;
    }

    @Override
    public int getCount() {
        return mShops.size();
    }

    @Override
    public Shop getItem(int position) {
        return mShops.get(position);
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        final ViewHolder viewHolder;
        if (convertView == null){
            //articleレイアウト複製
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.shop, null);
            //viewHolderを用意
            viewHolder = new ViewHolder(convertView);
            //viewHolderをViewにタグ付け
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //記事のデータをレイアウトにセットしていく
        final Shop item=getItem(position);

        if(item !=null){
            //set data
            viewHolder.shopname.setText(item.shopname);
            viewHolder.shopname.setBackgroundColor(item.color);
        }

        return convertView;
    }

    public static class ViewHolder{

        TextView shopname;

        public ViewHolder(View view){

            shopname = (TextView)view.findViewById(R.id.shoptext);

        }

    }

}
