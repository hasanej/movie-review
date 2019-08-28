package id.co.hasaneljabir.moviereview.feature.tvShow;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import id.co.hasaneljabir.moviereview.R;
import id.co.hasaneljabir.moviereview.adapter.TvShowAdapter;
import id.co.hasaneljabir.moviereview.model.tvShow.TvShow;
import id.co.hasaneljabir.moviereview.model.tvShow.TvShowData;

public class TvShowListFragment extends Fragment {
    private RecyclerView rvTvShow;
    private ArrayList<TvShow> tvShowList = new ArrayList<>();
    private TvShowAdapter tvShowAdapter;

    public TvShowListFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tv_show_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        rvTvShow = view.findViewById(R.id.rv_tv_show);
        rvTvShow.setHasFixedSize(true);

        tvShowList.addAll(TvShowData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvTvShow.setLayoutManager(new LinearLayoutManager(getContext()));
        tvShowAdapter = new TvShowAdapter(tvShowList);
        rvTvShow.setAdapter(tvShowAdapter);

        tvShowAdapter.setOnItemClickCallback(new TvShowAdapter.OnItemClickCallback() {
            public void onItemClicked(TvShow tvShow) {
                Intent tvShowDetail = new Intent(getContext(), TvShowDetailActivity.class);
                tvShowDetail.putExtra(TvShowDetailActivity.TV_SHOW, tvShow);
                startActivity(tvShowDetail);
            }
        });
    }
}
