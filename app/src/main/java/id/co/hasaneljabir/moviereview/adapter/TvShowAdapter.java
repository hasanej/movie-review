package id.co.hasaneljabir.moviereview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import id.co.hasaneljabir.moviereview.R;
import id.co.hasaneljabir.moviereview.model.tvShow.TvShowItems;
import id.co.hasaneljabir.moviereview.helper.Constant;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder> {
    private ArrayList<TvShowItems> tvShowItems;
    private OnItemClickCallback onItemClickCallback;

    public void setData(ArrayList<TvShowItems> items) {
        tvShowItems.clear();
        tvShowItems.addAll(items);
        notifyDataSetChanged();
    }

    public void setOnItemClickCallback(TvShowAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public TvShowAdapter(ArrayList<TvShowItems> tvShowItems) {
        this.tvShowItems = tvShowItems;
    }

    @NonNull
    @Override
    public TvShowAdapter.TvShowViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tv_show, viewGroup, false);
        return new TvShowAdapter.TvShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TvShowAdapter.TvShowViewHolder holder, int position) {
        TvShowItems tvShow = tvShowItems.get(position);
        Glide.with(holder.itemView.getContext())
                .load(Constant.POSTER_BASE_URL_185 + tvShow.getPosterPath())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.ivPoster);
        holder.tvTitle.setText(tvShow.getTitle());
        holder.tvReleaseDate.setText(tvShow.getReleaseDate());
        holder.tvSynopsis.setText(tvShow.getOverview());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(tvShowItems.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return tvShowItems.size();
    }

    class TvShowViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvReleaseDate, tvSynopsis;
        ImageView ivPoster;

        TvShowViewHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_title);
            tvReleaseDate = itemView.findViewById(R.id.tv_release_date);
            tvSynopsis = itemView.findViewById(R.id.tv_synopsis);
            ivPoster = itemView.findViewById(R.id.iv_poster);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(TvShowItems data);
    }
}
