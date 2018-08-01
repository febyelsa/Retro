package in.raji.myapplication.retroapi;

import okhttp3.ResponseBody;
import retrofit2.Response;

public interface ResponseListener {
    public void onResponse(Object response);
    public void onFailure(Object error);
}
