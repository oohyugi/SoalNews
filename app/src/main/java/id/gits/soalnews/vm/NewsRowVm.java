package id.gits.soalnews.vm;

import android.content.Context;

import id.gits.soalnews.dao.BeritaBaruDao;

/**
 * Created by yogi on 23/04/16.
 */
public class NewsRowVm  {

    public String title;
    public String read;
    public String imgUrl;
    public String desc;

    public NewsRowVm(Context context, BeritaBaruDao beritaBaruDao){
        this.title=beritaBaruDao.getTitle();
        this.read=beritaBaruDao.getRead();
        this.imgUrl=beritaBaruDao.getImgUrl();
        this.desc=beritaBaruDao.getDesc();


    }
}
