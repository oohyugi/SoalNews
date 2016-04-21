package id.gits.soalnews.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import id.gits.soalnews.AllBeritaBaru;
import id.gits.soalnews.DetailActivity;
import id.gits.soalnews.R;
import id.gits.soalnews.adapter.BeritaBaruAdapter;
import id.gits.soalnews.api.MyRespon;
import id.gits.soalnews.dao.BaseDao;
import id.gits.soalnews.dao.BeritaBaruDao;

/**
 * Created by yogi on 19/04/16.
 */
public class beritaPopulerFragment extends Fragment {

    private BeritaBaruAdapter mBaruAdapter;
    @Bind(R.id.swipe_me)
    SwipeRefreshLayout mRefreshLayout;

    @Bind(R.id.rvBeritapopuler)
    RecyclerView mRecyclerView;

    public beritaPopulerFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_berita_populer,container,false);

        ButterKnife.bind(this,view);
        mRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setRefreshing(true);
                initData();
            }
        });
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mRefreshLayout.setRefreshing(true);
                initData();
            }
        });
        return view;

    }

    private MyRespon<BaseDao<List<BeritaBaruDao>>>apilistener= new MyRespon<BaseDao<List<BeritaBaruDao>>>() {
        @Override
        public void onSucces(BaseDao<List<BeritaBaruDao>> result, String e) {
            configRecycle(result.DATA);
        }

        @Override
        public void onError(String error) {
            mRefreshLayout.setRefreshing(false);
            Toast.makeText(getActivity(), error, Toast.LENGTH_LONG).show();

        }
    };


    private void configRecycle(List<BeritaBaruDao> datalist) {

        mRefreshLayout.setRefreshing(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(true);
        mBaruAdapter=new BeritaBaruAdapter(getActivity(), datalist, new BeritaBaruAdapter.BindingHolder.OnItemClickListener() {
            @Override
            public void onClick(BeritaBaruDao model) {
                Intent intent = new Intent(getActivity(),DetailActivity.class);
                intent.putExtra("title",model.getTitle());
                intent.putExtra("desc",model.getDesc());

                intent.putExtra("imgUrl",model.getImgUrl());
                intent.putExtra("read",model.getRead());
                startActivity(intent);
            }
        });

        mRecyclerView.setAdapter(mBaruAdapter);
        mBaruAdapter.notifyDataSetChanged();
    }

    private void initData() {

        AllBeritaBaru.getAllBeritaPopuler(apilistener);
/*mRefreshLayout.setRefreshing(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(true);


        mBaruAdapter= new BeritaBaruAdapter(getActivity(), DataPopuler.list, new BindingHolder.OnItemClickListener() {
            @Override
            public void onClick(BeritaBaruDao model) {
                Intent intent = new Intent(getActivity(),DetailActivity.class);
                intent.putExtra("title",model.getTitle());
                intent.putExtra("desc",model.getDesc());

                intent.putExtra("gambar",model.getImgUrl());
                intent.putExtra("read",model.getRead());
                startActivity(intent);

            }
        }) ;
        mRecyclerView.setAdapter(mBaruAdapter);*/
    }
}
