package in.raji.myapplication.retroapi;

import in.raji.myapplication.model.DataItem;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIClient {

    @GET("/user/2")
    Call<DataItem> getItem();


}
