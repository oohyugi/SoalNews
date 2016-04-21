package id.gits.soalnews.api;

import id.gits.soalnews.service.BeritaService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yogi on 20/04/16.
 */
public class BeritaApi {

    private static final String BASE_URL="http://10.42.0.1";
    private static BeritaApi beritaApi;
    public BeritaService beritaService;
    public Retrofit retrofit;

    public static BeritaApi getApiBerita(){
        if (beritaApi==null){
            beritaApi=new BeritaApi();
            beritaApi.init();

        }
        return beritaApi;
    }

    private void init() {
        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
    public BeritaService getBeritaService(){
        if (beritaService==null){
            beritaService=retrofit.create(BeritaService.class);

        }
        return beritaService;
    }
}
