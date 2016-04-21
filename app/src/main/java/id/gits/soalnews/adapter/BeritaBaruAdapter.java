package id.gits.soalnews.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import id.gits.soalnews.BR;
import id.gits.soalnews.R;
import id.gits.soalnews.dao.BeritaBaruDao;

/**
 * Created by yogi on 19/04/16.
 */
public class BeritaBaruAdapter extends RecyclerView.Adapter<BeritaBaruAdapter.BindingHolder> {

    private final BindingHolder.OnItemClickListener mOnItemClickListener;
    private List<BeritaBaruDao>dataBeritaBaru;
    private Context context;
private  int mPreviousPosition=0;
    public BeritaBaruAdapter(Context mcontext,List<BeritaBaruDao> mdataBeritaBaru,BindingHolder.OnItemClickListener onItemClickListener){
        dataBeritaBaru=mdataBeritaBaru;
        mOnItemClickListener= onItemClickListener;
        context=mcontext;
    }

    @Override
    public BeritaBaruAdapter.BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.row_berita_baru, parent, false);

        return new BindingHolder(binding);

    }

    @Override
    public void onBindViewHolder(BeritaBaruAdapter.BindingHolder holder, int position) {
        ViewDataBinding viewDataBinding = BindingHolder.getViewDataBinding();
holder.click(dataBeritaBaru.get(position),mOnItemClickListener);

        viewDataBinding.setVariable(BR.vm, dataBeritaBaru.get(position));
        if (position>mPreviousPosition){
            id.gits.soalnews.anim.AnimationUtils.scaleX(holder);
        }else {
            id.gits.soalnews.anim.AnimationUtils.scaleX(holder);
        }

    }

    @Override
    public int getItemCount() {
        return (null != dataBeritaBaru ? dataBeritaBaru.size() : 0);
    }

  public static class BindingHolder extends RecyclerView.ViewHolder {


      private static ViewDataBinding mViewDataBinding;

      public BindingHolder( ViewDataBinding viewDataBinding) {
          super(viewDataBinding.getRoot());

          mViewDataBinding = viewDataBinding;
          mViewDataBinding.executePendingBindings();
      }

      public static ViewDataBinding getViewDataBinding() {
          return mViewDataBinding;
      }

      public void click(final BeritaBaruDao model,final OnItemClickListener listener){
          itemView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  listener.onClick(model);
              }
          });
      }


      public interface OnItemClickListener {


          void onClick(BeritaBaruDao model);
      }
  }
}
