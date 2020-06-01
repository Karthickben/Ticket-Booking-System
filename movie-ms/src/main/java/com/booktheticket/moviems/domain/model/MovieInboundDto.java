package com.booktheticket.moviems.domain.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class MovieInboundDto{
	
	@NotNull @NotEmpty @Size(min=1,max=100)
	private String movieName;
	@NotNull @NotEmpty @Size(min=1,max=50)
	private String language;
	@NotNull @NotEmpty @Size(min=1,max=1000)
	private String description;
	@NotNull @NotEmpty @Size(min=1,max=50)
	private String genre;
	@NotNull @NotEmpty @Size(min=1,max=500)
	private String cast;
	@NotNull @NotEmpty @Size(min=1,max=100)
	private String director;
	@NotNull @NotEmpty @Size(min=1,max=100)
	private String musicDirector;
	private String duration;
	@NotNull @NotEmpty
	private String censorCertificate;
	@NotNull @NotEmpty
	private String adminId;
	
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
	
	@Override
	public String toString() {
		return "MovieInboundDto [movieName=" + movieName + ", language=" + language + ", description=" + description
				+ ", genre=" + genre + ", cast=" + cast + ", director=" + director + "\r\n musicDirector=" + musicDirector
				+ ",\r\n duration=" + duration
				+ ", censorCertificate=" + censorCertificate + ", adminId=" + adminId + "]";
	}
	

}
