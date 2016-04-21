package id.gits.soalnews;

import java.util.List;

import id.gits.soalnews.api.BeritaApi;
import id.gits.soalnews.api.MyCallBack;
import id.gits.soalnews.api.MyRespon;
import id.gits.soalnews.dao.BaseDao;
import id.gits.soalnews.dao.BeritaBaruDao;
import retrofit2.Call;

/**
 * Created by yogi on 20/04/16.
 */
public class AllBeritaBaru {

    public static Call<BaseDao<List<BeritaBaruDao>>> mCall;

    public static void getAllBeritaBaru(MyRespon<BaseDao<List<BeritaBaruDao>>> apicall) {
        mCall = BeritaApi.getApiBerita().getBeritaService().getAllBerita();
        mCall.enqueue(new MyCallBack(apicall));
    }

    public static void getAllBeritaPopuler(MyRespon<BaseDao<List<BeritaBaruDao>>> apicall) {
        mCall = BeritaApi.getApiBerita().getBeritaService().getPopulerBerita();
        mCall.enqueue(new MyCallBack(apicall));

    }

    public static void getAllBeritaHot(MyRespon<BaseDao<List<BeritaBaruDao>>> apicall) {
        mCall = BeritaApi.getApiBerita().getBeritaService().getHotBerita();
        mCall.enqueue(new MyCallBack(apicall));
    }
}
