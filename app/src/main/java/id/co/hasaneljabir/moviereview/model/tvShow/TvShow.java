package id.co.hasaneljabir.moviereview.model.tvShow;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShow implements Parcelable {
    private int poster;
    private String title;
    private String releaseDate;
    private String synopsis;
    private String rating;

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.poster);
        dest.writeString(this.title);
        dest.writeString(this.releaseDate);
        dest.writeString(this.synopsis);
        dest.writeString(this.rating);
    }

    public TvShow() {
    }

    protected TvShow(Parcel tvShowParcel) {
        this.poster = tvShowParcel.readInt();
        this.title = tvShowParcel.readString();
        this.releaseDate = tvShowParcel.readString();
        this.synopsis = tvShowParcel.readString();
        this.rating = tvShowParcel.readString();
    }

    public static final Creator<TvShow> CREATOR = new Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel source) {
            return new TvShow(source);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };
}
