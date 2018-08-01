package in.raji.myapplication.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import in.raji.myapplication.model.DataItem;
import in.raji.myapplication.model.Item;
import in.raji.myapplication.retroapi.ResponseListener;

public class ItemViewModel extends AndroidViewModel {
    public ItemViewModel(@NonNull Application application) {
        super(application);
    }

    private LiveData<Item> item;

    public LiveData<Item> getItem() {
        return item;
    }

    public void setItem(LiveData<Item> item) {
        this.item = item;
    }



    public void loadData(ResponseListener listener){
        new DataItem().getItemData(listener);
    }

}
