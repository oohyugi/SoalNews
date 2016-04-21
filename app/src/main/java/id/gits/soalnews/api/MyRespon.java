package id.gits.soalnews.api;

/**
 * Created by yogi on 20/04/16.
 */
public interface MyRespon<T> {
    public void onSucces(T result,String e);
    public void onError(String error);
}
