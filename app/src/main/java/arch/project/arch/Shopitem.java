package arch.project.arch;

import android.os.Parcel;
import android.os.Parcelable;

public class Shopitem implements Parcelable {
    public String itemname;
    public int cost;

    public boolean isChosen = false;


public Shopitem(String itemname, int cost){

this.itemname=itemname;
this.cost=cost;
}

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(cost);
        out.writeString(itemname);
    }

    public static final Parcelable.Creator<Shopitem> CREATOR
            = new Parcelable.Creator<Shopitem>() {
        public Shopitem createFromParcel(Parcel in) {
            return new Shopitem(in);
        }

        public Shopitem[] newArray(int size) {
            return new Shopitem[size];
        }
    };

    private Shopitem(Parcel in) {
        cost = in.readInt();
        itemname = in.readString();
    }
}