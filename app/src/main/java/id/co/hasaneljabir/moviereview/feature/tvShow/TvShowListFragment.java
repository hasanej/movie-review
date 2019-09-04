package id.co.hasaneljabir.moviereview.feature.tvShow;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;

import id.co.hasaneljabir.moviereview.R;
import id.co.hasaneljabir.moviereview.adapter.TvShowAdapter;
import id.co.hasaneljabir.moviereview.model.tvShow.TvShowItems;
import id.co.hasaneljabir.moviereview.model.tvShow.TvShowViewModel;

public class TvShowListFragment extends Fragment {
    private ProgressBar progressBar;

    private ArrayList<TvShowItems> tvShowItems = new ArrayList<>();
    private TvShowAdapter tvShowAdapter;

    public TvShowListFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tv_show_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        RecyclerView rvTvShow = view.findViewById(R.id.rv_tv_show);
        progressBar = view.findViewById(R.id.progress_bar);

        TvShowViewModel tvShowViewModel = ViewModelProviders.of(this).get(TvShowViewModel.class);
        tvShowViewModel.getTvShows().observe(this, getTvShow);

        tvShowAdapter = new TvShowAdapter(tvShowItems);
        tvShowAdapter.notifyDataSetChanged();

        rvTvShow.setLayoutManager(new LinearLayoutManager(getContext()));
        rvTvShow.setAdapter(tvShowAdapter);

        tvShowViewModel.setTvShow();
        showLoading(true);

        tvShowAdapter.setOnItemClickCallback(new TvShowAdapter.OnItemClickCallback() {
            public void onItemClicked(TvShowItems tvShowItems) {
                Intent tvShowDetail = new Intent(getContext(), TvShowDetailActivity.class);
                tvShowDetail.putExtra(TvShowDetailActivity.TV_SHOW, tvShowItems);
                startActivity(tvShowDetail);
            }
        });
    }

    private Observer<ArrayList<TvShowItems>> getTvShow = new Observer<ArrayList<TvShowItems>>() {
        @Override
        public void onChanged(ArrayList<TvShowItems> tvShowItems) {
            showLoading(true);

            if (tvShowItems != null) {
                tvShowAdapter.setData(tvShowItems);
                showLoading(false);
            }
        }
    };

    private void showLoading(Boolean state) {
        if (state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
}
