package id.gits.soalnews.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
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
public class beritaBaruFragment extends Fragment {

public BeritaBaruAdapter mBaruAdapter;
    private final List<BeritaBaruDao> mList=new ArrayList<>();

    @Bind(R.id.rvBeritaBaru)
    RecyclerView mRecyclerView;

    @Bind(R.id.swipe_me)
    SwipeRefreshLayout mRefreshLayout;


    public beritaBaruFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle bundle){
        View view= inflater.inflate(R.layout.fragment_berita_baru,group,false);
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


        initData();
        return view;

    }
    private MyRespon<BaseDao<List<BeritaBaruDao>>> apilistener=new MyRespon<BaseDao<List<BeritaBaruDao>>>() {
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
       /* mBaruAdapter= new BeritaBaruAdapter(getActivity(), DataBaru.list, new BeritaBaruAdapter.BindingHolder.OnItemClickListener() {
            @Override
            public void onClick(BeritaBaruDao model) {
                Intent intent = new Intent(getActivity(),DetailActivity.class);
                intent.putExtra("title",model.getTitle());
                intent.putExtra("desc",model.getDesc());

                intent.putExtra("gambar",model.getImgUrl());
                intent.putExtra("read",model.getRead());
                startActivity(intent);

            }
        }) ;*/
    }

    private void initData() {


AllBeritaBaru.getAllBeritaBaru(apilistener);






    }
}
