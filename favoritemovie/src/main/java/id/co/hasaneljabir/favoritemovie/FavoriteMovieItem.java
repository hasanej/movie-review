package id.co.hasaneljabir.favoritemovie;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import static android.provider.BaseColumns._ID;
import static id.co.hasaneljabir.favoritemovie.DatabaseContract.getColumnInt;
import static id.co.hasaneljabir.favoritemovie.DatabaseContract.getColumnString;

public class FavoriteMovieItem implements Parcelable {
    private int id;
    private String title;
    private String releaseDate;
    private String voteAverage;
    private String overview;
    private String posterPath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(String voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.title);
        dest.writeString(this.releaseDate);
        dest.writeString(this.voteAverage);
        dest.writeString(this.overview);
        dest.writeString(this.posterPath);
    }

    public FavoriteMovieItem(int id, String title, String releaseDate, String voteAverage, String overview, String posterPath) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.voteAverage = voteAverage;
        this.overview = overview;
        this.posterPath = posterPath;
    }

    public FavoriteMovieItem(Cursor cursor) {
        this.id = getColumnInt(cursor, _ID);
        this.title = getColumnString(cursor, DatabaseContract.FavoriteMovieColumns.TITLE);
        this.releaseDate = getColumnString(cursor, DatabaseContract.FavoriteMovieColumns.RELEASE_DATE);
        this.voteAverage = getColumnString(cursor, DatabaseContract.FavoriteMovieColumns.VOTE_AVERAGE);
        this.overview = getColumnString(cursor, DatabaseContract.FavoriteMovieColumns.OVERVIEW);
        this.posterPath = getColumnString(cursor, DatabaseContract.FavoriteMovieColumns.POSTER_PATH);
    }

    private FavoriteMovieItem(Parcel in) {
        this.id = in.readInt();
        this.title = in.readString();
        this.releaseDate = in.readString();
        this.voteAverage = in.readString();
        this.overview = in.readString();
        this.posterPath = in.readString();
    }

    public static final Creator<FavoriteMovieItem> CREATOR = new Creator<FavoriteMovieItem>() {
        @Override
        public FavoriteMovieItem createFromParcel(Parcel source) {
            return new FavoriteMovieItem(source);
        }


        @Override
        public FavoriteMovieItem[] newArray(int size) {
            return new FavoriteMovieItem[size];
        }
    };
}