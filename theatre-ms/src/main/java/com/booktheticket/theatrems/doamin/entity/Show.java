package com.booktheticket.theatrems.doamin.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "show")
@Table(name = "Show")
public class Show {

	@Id
	@SequenceGenerator(name = "showid", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "showid", strategy = GenerationType.SEQUENCE)
	@Column(name = "Show_Id", length = 20)
	private int showId;
	@OneToOne
	@JoinColumn(name = "Screen_Id")
	private Screen screen;
	@Column(name = "Effective_Date")
	private LocalDate effectiveDate;
	@Column(name = "Movie_Id", length = 20, nullable = false)
	private int movieId;
	@Column(name = "Last_Updated_Timestamp", nullable = false)
	private LocalDateTime lastUpdatedTimestamp;
	@Column(name = "Admin_Id", nullable = false, length = 50)
	private String adminId;

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public LocalDateTime getLastUpdatedTimestamp() {
		return lastUpdatedTimestamp;
	}

	public void setLastUpdatedTimestamp(LocalDateTime lastUpdatedTimestamp) {
		this.lastUpdatedTimestamp = lastUpdatedTimestamp;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	@Override
	public String toString() {
		return "Show [showId=" + showId + ", screen=" + screen + ", effectiveDate=" + effectiveDate + ", movieId="
				+ movieId + ", lastUpdatedTimestamp=" + lastUpdatedTimestamp + ", adminId=" + adminId + "]";
	}
	
	

}
