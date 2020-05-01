package arch.project.arch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
        final ShopitemAdapter.ViewHolder viewHolder;
        if (convertView == null){
            //articleレイアウト複製
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.shopitem, null);
            //viewHolderを用意
            viewHolder = new ShopitemAdapter.ViewHolder(convertView);
            //viewHolderをViewにタグ付け
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ShopitemAdapter.ViewHolder) convertView.getTag();
        }
        //記事のデータをレイアウトにセットしていく
        final Shopitem item=getItem(position);

        if(item !=null){
            //set data
            viewHolder.itemname.setText(item.itemname);
            String Scost = String.valueOf(item.cost);
            viewHolder.cost.setText(Scost);
        }

        return convertView;
    }

    public static class ViewHolder{

        TextView itemname;
        TextView cost;

        public ViewHolder(View view){

            itemname = (TextView)view.findViewById(R.id.itemname);
            cost = (TextView)view.findViewById(R.id.cost);


        }

    }

}
