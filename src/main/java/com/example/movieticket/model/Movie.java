package com.example.movieticket.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Movie")
public class Movie {
	private static Movie obj;
	private Movie() {
	}
	// Only one thread can execute this at a time
	public static synchronized Movie getInstance() {
		if (obj == null)
			obj = new Movie();
		return obj;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String MovieName;
	private String DirectorName;
	private String DistributerName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMovieName() {
		return MovieName;
	}

	public void setMovieName(String MovieName) {
		this.MovieName = MovieName;
	}

	public String getDirectorName() {
		return DirectorName;
	}

	public void setDirectorName(String DirectorName) {
		this.DirectorName = DirectorName;
	}

	public String getDistributerName() {
		return DistributerName;
	}

	public void setDistributerName(String DistributerName) {
		this.DistributerName = DistributerName;
	}
}