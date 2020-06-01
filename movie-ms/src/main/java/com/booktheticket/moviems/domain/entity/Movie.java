package com.booktheticket.moviems.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "movie")
@Table(name = "Movie")
public class Movie {

	@Id
	@SequenceGenerator(name = "movieId", initialValue = 10000, allocationSize = 1)
	@GeneratedValue(generator = "movieId", strategy = GenerationType.SEQUENCE)
	@Column(name = "Movie_Id", length = 15)
	private Integer movieId;
	@Column(name = "Movie_Name", nullable = false, length = 100)
	private String movieName;
	@Column(name = "Language", nullable = false, length = 50)
	private String language;
	@Column(name = "Description", nullable = false, length = 1000)
	private String description;
	@Column(name = "Genre", nullable = false, length = 50)
	private String genre;
	@Column(name = "Movie_Cast", nullable = false, length = 500)
	private String cast;
	@Column(name = "Director", nullable = false, length = 100)
	private String director;
	@Column(name = "Music_Director", nullable = false, length = 100)
	private String musicDirector;
	@Column(name = "Rating")
	private Double rating;
	@Column(name = "Number_Of_Ratings")
	private Integer numberOfRatings;
	@Column(name = "Duration", nullable = false)
	private String duration;
	@Column(name = "Censor_Certificate", nullable = false)
	private String censorCertificate;
	@Column(name = "Admin_Id", nullable = false)
	private String adminId;
	@Column(name = "last_Updated_Timestamp", nullable = false)
	private LocalDateTime lastUpdatedTimestamp;

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
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

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Integer getNumberOfRatings() {
		return numberOfRatings;
	}

	public void setNumberOfRatings(Integer numberOfRatings) {
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

	public LocalDateTime getLastUpdatedTimestamp() {
		return lastUpdatedTimestamp;
	}

	public void setLastUpdatedTimestamp(LocalDateTime lastUpdatedTimestamp) {
		this.lastUpdatedTimestamp = lastUpdatedTimestamp;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", language=" + language + ", description="
				+ description + ", genre=" + genre + ", cast=" + cast + ", director=" + director + "\r\n musicDirector="
				+ musicDirector + ", rating=" + rating + ", numberOfRatings=" + numberOfRatings + "\r\\n duration="
				+ duration + ", censorCertificate=" + censorCertificate + ", adminId=" + adminId
				+ ", lastUpdatedTimestamp=" + lastUpdatedTimestamp + "]";
	}

}
