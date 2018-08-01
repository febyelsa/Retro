package in.raji.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import in.raji.myapplication.retroapi.APIClient;
import in.raji.myapplication.retroapi.ResponseListener;
import in.raji.myapplication.retroapi.RetroCall;
import in.raji.myapplication.retroapi.RetrofitClientInstance;
import retrofit2.Call;

public class DataItem implements Parcelable {
    private Item data;

    public DataItem() {
        super();
    }

    protected DataItem(Parcel in) {
        data = in.readParcelable(Item.class.getClassLoader());
    }

    public static final Creator<DataItem> CREATOR = new Creator<DataItem>() {
        @Override
        public DataItem createFromParcel(Parcel in) {
            return new DataItem(in);
        }

        @Override
        public DataItem[] newArray(int size) {
            return new DataItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(data, i);
    }

    public void getItemData(final ResponseListener listener) {
        APIClient clientRequest = RetrofitClientInstance.getRetrofitInstance().create(APIClient.class);
        Call<DataItem> request = clientRequest.getItem();
        RetroCall.makeRequest(request, new ResponseListener() {
            @Override
            public void onResponse(Object response) {
                listener.onResponse(response);
            }

            @Override
            public void onFailure(Object error) {

            }
        });
    }
}

   


