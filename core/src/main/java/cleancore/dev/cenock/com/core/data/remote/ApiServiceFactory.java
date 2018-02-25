package cleancore.dev.cenock.com.core.data.remote;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by carlosenock on 2/25/18.
 */

public class ApiServiceFactory {
    public static <T> T build(OkHttpClient client, Class<T> serviceClass, String urlBase) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(urlBase)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(serviceClass);
    }
}
