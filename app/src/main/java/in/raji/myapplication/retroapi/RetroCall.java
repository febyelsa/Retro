package in.raji.myapplication.retroapi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetroCall {

    public static void makeRequest(Call request, final ResponseListener listener){
        request.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {

                int statusCode = response.code();
                if(statusCode == Config.RESP_OK) {
                    listener.onResponse(response);
                } else {
                    listener.onFailure("On Failure - " + statusCode);
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                listener.onFailure(t.getMessage());

            }
        });
    }
}
