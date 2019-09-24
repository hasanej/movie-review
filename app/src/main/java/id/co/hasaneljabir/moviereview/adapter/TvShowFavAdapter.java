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

import java.util.List;

import id.co.hasaneljabir.moviereview.R;
import id.co.hasaneljabir.moviereview.entity.db.tvShowFavorite.TvShowFavorite;

public class TvShowFavAdapter extends RecyclerView.Adapter<TvShowFavAdapter.ViewHolder> {
    private List<TvShowFavorite> tvShowFavorite;

    public TvShowFavAdapter(List<TvShowFavorite> tvShowFavorite) {
        this.tvShowFavorite = tvShowFavorite;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_favorite, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TvShowFavorite tvShow = tvShowFavorite.get(position);
        Glide.with(holder.itemView.getContext())
                .load("https://image.tmdb.org/t/p/w185" + tvShow.getPosterPath())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.ivPoster);
        holder.tvTitle.setText(tvShow.getTitle());
        holder.tvReleaseDate.setText(tvShow.getReleaseDate());
        holder.tvSynopsis.setText(tvShow.getOverview());
    }

    @Override
    public int getItemCount() {
        return tvShowFavorite.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvReleaseDate, tvSynopsis;
        ImageView ivPoster;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_title);
            tvReleaseDate = itemView.findViewById(R.id.tv_release_date);
            tvSynopsis = itemView.findViewById(R.id.tv_synopsis);
            ivPoster = itemView.findViewById(R.id.iv_poster);
        }
    }
}
