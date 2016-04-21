package id.gits.soalnews.dao;

/**
 * Created by yogi on 20/04/16.
 */
public class BaseDao<T> {
    private boolean STATUS;
    private int STATUS_CODE;
   public MESSAGE MESSAGE;
    public T DATA;


        public class MESSAGE{
            public String PROD;
            public String DEVEl;
        }


}
