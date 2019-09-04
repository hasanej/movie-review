package id.co.hasaneljabir.moviereview.model.tvShow;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class TvShowItems implements Parcelable {

    private int id;
    private String title;
    private String releaseDate;
    private String voteAverage;
    private String overview;
    private String posterPath;

    TvShowItems(JSONObject object) {

        try {
            int id = object.getInt("id");
            String title = object.getString("name");
            String releaseDate = object.getString("first_air_date");
            String voteAverage = String.valueOf(object.getDouble("vote_average"));
            String overview = object.getString("overview");
            String posterPath = object.getString("poster_path");

            this.id = id;
            this.title = title;
            this.releaseDate = releaseDate;
            this.voteAverage = voteAverage;
            this.overview = overview;
            this.posterPath = posterPath;

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

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
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(releaseDate);
        parcel.writeString(voteAverage);
        parcel.writeString(overview);
        parcel.writeString(posterPath);
    }

    protected TvShowItems(Parcel in) {
        id = in.readInt();
        title = in.readString();
        releaseDate = in.readString();
        voteAverage = in.readString();
        overview = in.readString();
        posterPath = in.readString();
    }

    public static final Creator<TvShowItems> CREATOR = new Creator<TvShowItems>() {
        @Override
        public TvShowItems createFromParcel(Parcel in) {
            return new TvShowItems(in);
        }

        @Override
        public TvShowItems[] newArray(int size) {
            return new TvShowItems[size];
        }
    };
}
