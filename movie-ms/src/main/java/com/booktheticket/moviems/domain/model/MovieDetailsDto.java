package com.booktheticket.moviems.domain.model;

public class MovieDetailsDto{
	
	
	private int movieId;
	private String movieName;
	private String language;
	private String description;
	private String genre;
	private String cast;
	private String director;
	private String musicDirector;
	private double rating;
	private int numberOfRatings;
	private String duration;
	private String censorCertificate;
	private String adminId;
	private String lastUpdatedTimestamp;
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getMusicDirector() {
		return musicDirector;
	}
	public void setMusicDirector(String musicDirector) {
		this.musicDirector = musicDirector;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public int getNumberOfRatings() {
		return numberOfRatings;
	}
	public void setNumberOfRatings(int numberOfRatings) {
		this.numberOfRatings = numberOfRatings;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getCensorCertificate() {
		return censorCertificate;
	}
	public void setCensorCertificate(String censorCertificate) {
		this.censorCertificate = censorCertificate;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getLastUpdatedTimestamp() {
		return lastUpdatedTimestamp;
	}
	public void setLastUpdatedTimestamp(String lastUpdatedTimestamp) {
		this.lastUpdatedTimestamp = lastUpdatedTimestamp;
	}
	@Override
	public String toString() {
		return "MovieDetailsDto [movieId=" + movieId + ", movieName=" + movieName + ", language=" + language
				+ ", description=" + description + ", genre=" + genre + ", cast=" + cast + "\r\n director=" + director
				+ ", musicDirector=" + musicDirector + ", rating=" + rating + ", numberOfRatings=" + numberOfRatings
				+ ", duration=" + duration + "\r\n censorCertificate=" + censorCertificate + ", adminId=" + adminId
				+ ", lastUpdatedTimestamp=" + lastUpdatedTimestamp + "]";
	}
	
	
	
	
	
	

}
