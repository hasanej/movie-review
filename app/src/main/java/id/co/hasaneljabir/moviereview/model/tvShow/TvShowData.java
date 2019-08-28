package id.co.hasaneljabir.moviereview.model.tvShow;

import java.util.ArrayList;

import id.co.hasaneljabir.moviereview.R;

public class TvShowData {
    public static String[][] data = new String[][]{
            {
                    String.valueOf(R.drawable.tv_poster_arrow),
                    "Arrow",
                    "58",
                    "October 10, 2012",
                    "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            },
            {
                    String.valueOf(R.drawable.tv_poster_dragon_ball),
                    "Dragon Ball",
                    "70",
                    "February 26, 1986",
                    "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the dragon balls brought her to Goku's home. Together, they set off to find all seven dragon balls in an adventure.",
            },
            {
                    String.valueOf(R.drawable.tv_poster_fairytail),
                    "Fairy Tail",
                    "64",
                    "October 12, 2009",
                    "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
            },
            {
                    String.valueOf(R.drawable.tv_poster_family_guy),
                    "Family Guy",
                    "65",
                    "January 31, 1999",
                    "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
            },
            {
                    String.valueOf(R.drawable.tv_poster_flash),
                    "The Flash",
                    "66",
                    "October 7, 2014",
                    "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            },
            {
                    String.valueOf(R.drawable.tv_poster_got),
                    "Game of Thrones",
                    "81",
                    "April 17, 2011",
                    "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
            },
            {
                    String.valueOf(R.drawable.tv_poster_iron_fist),
                    "Marvel's Iron Fist",
                    "61",
                    "March 17, 2017",
                    "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
            },
            {
                    String.valueOf(R.drawable.tv_poster_naruto_shipudden),
                    "Naruto Shippuden",
                    "76",
                    "February 15, 2007",
                    "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
            },
            {
                    String.valueOf(R.drawable.tv_poster_supergirl),
                    "Supergirl",
                    "58",
                    "October 26, 2015",
                    "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
            },
            {
                    String.valueOf(R.drawable.tv_poster_the_walking_dead),
                    "The Walking Dead",
                    "73",
                    "October 31, 2010",
                    "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
            }
    };

    public static ArrayList<TvShow> getListData() {
        ArrayList<TvShow> listTvShow = new ArrayList<>();

        for (String[] tvShowData : data) {
            TvShow tvShow = new TvShow();
            tvShow.setPoster(Integer.parseInt(tvShowData[0]));
            tvShow.setTitle(tvShowData[1]);
            tvShow.setRating(tvShowData[2]);
            tvShow.setReleaseDate(tvShowData[3]);
            tvShow.setSynopsis(tvShowData[4]);
            listTvShow.add(tvShow);
        }

        return listTvShow;
    }
}
