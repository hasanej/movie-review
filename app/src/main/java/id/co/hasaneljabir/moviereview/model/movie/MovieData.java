package id.co.hasaneljabir.moviereview.model.movie;

import java.util.ArrayList;

import id.co.hasaneljabir.moviereview.R;

public class MovieData {
    public static String[][] data = new String[][]{
            {
                    String.valueOf(R.drawable.poster_aquaman),
                    "Aquaman",
                    "68",
                    "December 7, 2018",
                    "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orms half-human, half-Atlantean brother and true heir to the throne.\n"
            },
            {
                    String.valueOf(R.drawable.poster_avengerinfinity),
                    "Avengers: Infinity War",
                    "83",
                    "April 25, 2018",
                    "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.\n"
            },
            {
                    String.valueOf(R.drawable.poster_birdbox),
                    "Bird Box",
                    "70",
                    "December 13, 2018",
                    "Five years after an ominous unseen presence drives most of society to suicide, a survivor and her two children make a desperate bid to reach safety.\n"
            },
            {
                    String.valueOf(R.drawable.poster_bumblebee),
                    "Bumblebee",
                    "65",
                    "December 15, 2018",
                    "On the run in the year 1987, Bumblebee finds refuge in a junkyard in a small Californian beach town. Charlie, on the cusp of turning 18 and trying to find her place in the world, discovers Bumblebee, battle-scarred and broken. When Charlie revives him, she quickly learns this is no ordinary yellow VW bug."
            },
            {
                    String.valueOf(R.drawable.poster_dragon),
                    "How to Train Your Dragon: The Hidden World",
                    "77",
                    "January 3, 2019",
                    "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind."
            },
            {
                    String.valueOf(R.drawable.poster_glass),
                    "Glass",
                    "65",
                    "January 16, 2019",
                    "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men."
            },
            {
                    String.valueOf(R.drawable.poster_mortalengine),
                    "Mortal Engines",
                    "60",
                    "November 27, 2018",
                    "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever."
            },
            {
                    String.valueOf(R.drawable.poster_robinhood),
                    "Robin Hood",
                    "58",
                    "November 21, 2018",
                    "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown."
            },
            {
                    String.valueOf(R.drawable.poster_spiderman),
                    "Spider-Man: Into the Spider-Verse",
                    "84",
                    "December 6, 2018",
                    "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension."
            },
            {
                    String.valueOf(R.drawable.poster_venom),
                    "Venom",
                    "66",
                    "September 28, 2018",
                    "Investigative journalist Eddie Brock attempts a comeback following a scandal, but accidentally becomes the host of Venom, a violent, super powerful alien symbiote. Soon, he must rely on his newfound powers to protect the world from a shadowy organization looking for a symbiote of their own."
            }
    };

    public static ArrayList<Movie> getListData() {
        ArrayList<Movie> listMovie = new ArrayList<>();

        for (String[] movieData : data) {
            Movie movie = new Movie();
            movie.setPoster(Integer.parseInt(movieData[0]));
            movie.setTitle(movieData[1]);
            movie.setRating(movieData[2]);
            movie.setReleaseDate(movieData[3]);
            movie.setSynopsis(movieData[4]);
            listMovie.add(movie);
        }

        return listMovie;
    }
}
