package arch.project.arch;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ShopitemAdapter extends ArrayAdapter<Shopitem> {

    List<Shopitem> mItems;

    public ShopitemAdapter(Context context, int resourceId, List<Shopitem> objects){
        super(context, resourceId, objects);

        mItems = objects;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Shopitem getItem(int position) {
        return mItems.get(position);
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        final ViewHolder viewHolder;
        if (convertView == null){
            //articleレイアウト複製
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.shopitem, null);
            //viewHolderを用意
            viewHolder = new ViewHolder(convertView);
            //viewHolderをViewにタグ付け
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //記事のデータをレイアウトにセットしていく
        final Shopitem item=getItem(position);

        if(item !=null){
            //set data
            viewHolder.itemname.setText(item.itemname);
            String Scost = String.valueOf(item.cost);
            viewHolder.cost.setText(Scost);


            viewHolder.item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
            if(item.isChosen == true) {
                viewHolder.itemname.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorChosen));
                viewHolder.itemname.setTextColor(ContextCompat.getColor(getContext(), android.R.color.white));
                item.isChosen = false;
            }
            else{
                viewHolder.itemname.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorNotChosen));
                viewHolder.itemname.setTextColor(ContextCompat.getColor(getContext(), android.R.color.darker_gray));
                item.isChosen = true;
            }
                }
            });
        }

        return convertView;
    }

    public static class ViewHolder{
        TextView itemname;
        TextView cost;
        LinearLayout item;

        public ViewHolder(View view){

            itemname = (TextView)view.findViewById(R.id.itemname);
            cost = (TextView)view.findViewById(R.id.cost);
            item = (LinearLayout) view.findViewById(R.id.item);


        }

    }

}
