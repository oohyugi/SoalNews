package id.gits.soalnews.service;

import java.util.List;

import id.gits.soalnews.dao.BaseDao;
import id.gits.soalnews.dao.BeritaBaruDao;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by yogi on 20/04/16.
 */
public interface BeritaService {

    @GET ("/news/berita")
    Call<BaseDao<List<BeritaBaruDao>>> getAllBerita();

    @GET ("/news/populer")
    Call<BaseDao<List<BeritaBaruDao>>> getPopulerBerita();

    @GET ("/news/hot")
    Call<BaseDao<List<BeritaBaruDao>>> getHotBerita();
}
