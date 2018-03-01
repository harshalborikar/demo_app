package harshal.com.demoapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class MovieModel {

    @SerializedName("Title")
    private String title;
    @SerializedName("Director")
    private String director;
    @SerializedName("Poster")
    private String poster;
    @SerializedName("Year")
    private String year;
    @SerializedName("Language")
    private String language;
    @SerializedName("Rated")
    private String rated;
    @SerializedName("Runtime")
    private String runTime;
    @SerializedName("Released")
    private String released;
    @SerializedName("Actors")
    private String actors;
    @SerializedName("Awards")
    private String awards;
    @SerializedName("Country")
    private String country;
    @SerializedName("Writer")
    private String writers;
    @SerializedName("Genre")
    private String genre;
    @SerializedName("Plot")
    private String plot;
    @SerializedName("Ratings")
    private ArrayList<MovieModel> ratings;
    @SerializedName("Source")
    private String source;
    @SerializedName("Value")
    private String value;
    @SerializedName("imdbID")
    private String imdbID;
    @SerializedName("imdbRating")
    private String imdbRating;
    @SerializedName("imdbVotes")
    private String imdbVotes;
    @SerializedName("DVD")
    private String dvd;
    @SerializedName("Type")
    private String type;
    @SerializedName("BoxOffice")
    private String boxOffice;
    @SerializedName("Production")
    private String production;
    @SerializedName("Metascore")
    private String metascore;
    @SerializedName("Website")
    private String website;


    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getPoster() {
        return poster;
    }

    public String getYear() {
        return year;
    }

    public String getLanguage() {
        return language;
    }

    public String getRated() {
        return rated;
    }

    public String getRunTime() {
        return runTime;
    }

    public String getReleased() {
        return released;
    }

    public String getActors() {
        return actors;
    }

    public String getAwards() {
        return awards;
    }

    public String getCountry() {
        return country;
    }

    public String getWriters() {
        return writers;
    }

    public String getGenre() {
        return genre;
    }

    public String getPlot() {
        return plot;
    }

    public ArrayList<MovieModel> getRatings() {
        return ratings;
    }

    public String getSource() {
        return source;
    }

    public String getValue() {
        return value;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public String getDvd() {
        return dvd;
    }

    public String getType() {
        return type;
    }

    public String getBoxOffice() {
        return boxOffice;
    }

    public String getProduction() {
        return production;
    }

    public String getMetascore() {
        return metascore;
    }

    public String getWebsite() {
        return website;
    }
}
