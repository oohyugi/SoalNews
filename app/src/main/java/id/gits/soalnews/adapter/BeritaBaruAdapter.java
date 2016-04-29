package id.gits.soalnews.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import id.gits.soalnews.BR;
import id.gits.soalnews.R;
import id.gits.soalnews.dao.BeritaBaruDao;
import id.gits.soalnews.databinding.RowBeritaBaruBinding;
import id.gits.soalnews.vm.NewsRowVm;

/**
 * Created by yogi on 19/04/16.
 */
public class BeritaBaruAdapter extends RecyclerView.Adapter<BeritaBaruAdapter.BindingHolder> {

    private BindingHolder.OnItemClickListener mOnItemClickListener;
    private List<BeritaBaruDao>dataBeritaBaru =new ArrayList<>();
    private Context context;
private  int mPreviousPosition=0;

    public BeritaBaruAdapter(Context context, List<BeritaBaruDao> beritaBaruDaos, BindingHolder.OnItemClickListener onItemClickListener) {
      this.context=context;
        this.dataBeritaBaru=beritaBaruDaos;
        this.mOnItemClickListener=onItemClickListener;

    }

    @Override
    public BeritaBaruAdapter.BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        context=parent.getContext();
        RowBeritaBaruBinding binding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.row_berita_baru,parent,false);

        return new BindingHolder(binding);
    }

    @Override
    public void onBindViewHolder(BeritaBaruAdapter.BindingHolder holder, final int position) {
        final BeritaBaruDao dao= dataBeritaBaru.get(position);
        NewsRowVm vieRowVm= new NewsRowVm(context,dao);
        holder.getBinding().setVariable(BR.vm,vieRowVm);
        holder.getBinding().executePendingBindings();
        holder.getBinding().getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.onItemClick(dao, position);

            }
        });


    }

    @Override
    public int getItemCount() {
        return dataBeritaBaru.size();
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {
        private RowBeritaBaruBinding binding;
        public BindingHolder(RowBeritaBaruBinding binding){
            super(binding.getRoot());
            this.binding=binding;

        }
        public ViewDataBinding getBinding(){
            return binding;
        }


    public interface OnItemClickListener {
        public void onItemClick(BeritaBaruDao beritaBaruDao,int position);
    }
    }
    }


