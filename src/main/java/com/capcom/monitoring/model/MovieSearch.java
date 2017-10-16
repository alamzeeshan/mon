package com.capcom.monitoring.model;

import java.util.List;

public class MovieSearch 
{
	private String poster_path;
	private Boolean adult;
	private String overview;
	private String release_date;
	private List<Integer> genre_ids;
	private Integer id;
	private String original_title;
	private  String original_language;
	private String title;
	private String backdrop_path;	
	private Double popularity;
	private Integer vote_count;
	private Boolean video;
	private Double vote_average;
	
	
	public String getPoster_path() {
		return "https://image.tmdb.org/t/p/w185_and_h278_bestv2"+poster_path;
	}
	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}
	public Boolean getAdult() {
		return adult;
	}
	public void setAdult(Boolean adult) {
		this.adult = adult;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public List<Integer> getGenre_ids() {
		return genre_ids;
	}
	public void setGenre_ids(List<Integer> genre_ids) {
		this.genre_ids = genre_ids;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOriginal_title() {
		return original_title;
	}
	public void setOriginal_title(String original_title) {
		this.original_title = original_title;
	}
	public String getOriginal_language() {
		return original_language;
	}
	public void setOriginal_language(String original_language) {
		this.original_language = original_language;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBackdrop_path() {
		return "https://image.tmdb.org/t/p/w185_and_h278_bestv2"+backdrop_path;
	}
	public void setBackdrop_path(String backdrop_path) {
		this.backdrop_path = backdrop_path;
	}
	public Double getPopularity() {
		return popularity;
	}
	public void setPopularity(Double popularity) {
		this.popularity = popularity;
	}
	public Integer getVote_count() {
		return vote_count;
	}
	public void setVote_count(Integer vote_count) {
		this.vote_count = vote_count;
	}
	public Boolean getVideo() {
		return video;
	}
	public void setVideo(Boolean video) {
		this.video = video;
	}
	public Double getVote_average() {
		return vote_average;
	}
	public void setVote_average(Double vote_average) {
		this.vote_average = vote_average;
	}
	@Override
	public String toString() {
		return "MovieSearch [poster_path=" + poster_path + ", adult=" + adult + ", overview=" + overview
				+ ", release_date=" + release_date + ", genre_ids=" + genre_ids + ", id=" + id + ", original_title="
				+ original_title + ", original_language=" + original_language + ", title=" + title + ", backdrop_path="
				+ backdrop_path + ", popularity=" + popularity + ", vote_count=" + vote_count + ", video=" + video
				+ ", vote_average=" + vote_average + "]";
	}
	
	
	/*
	 * for TV shows
	 * 
	 * private String media_type;
	private String first_air_date;	
	private List<String> origin_country;	
	private String name;
    private String original_name;*/
    
    
    
    
	
}


