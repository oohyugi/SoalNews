package id.gits.soalnews.dao;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;

import id.gits.soalnews.R;

/**
 * Created by yogi on 19/04/16.
 */
public class BeritaBaruDao implements Serializable {

    public String title;
    public String read;
    public String imgUrl;
    public String desc;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public BeritaBaruDao(String imgUrl,String title,String read,String desc){
        /*BeritaBaruDao itemModel=new BeritaBaruDao();
        itemModel.setImgUrl(imgUrl);
        itemModel.setTitle(title);
        itemModel.setRead(read);
        return itemModel;*/
        setImgUrl(imgUrl);
        setTitle(title);
        setRead(read);
        setDesc(desc);
       /* this.title=title;
        this.imgUrl=imgUrl;
        this.read=read;*/

    }
    @BindingAdapter({"bind:showImage"})
    public static void loadImage(ImageView view, String imgUrl){
        Picasso.with(view.getContext()).load(imgUrl).placeholder(R.drawable.placeholder).resize(600,300).into(view);
    }
}
