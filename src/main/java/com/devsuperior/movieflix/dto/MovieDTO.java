package com.devsuperior.movieflix.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;

public class MovieDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@Size(min = 5, max = 60, message = "Deve ter entre 5 e 60 caracteres")
	@NotBlank(message = "Campo requerido")
	private String title;
	
	@Size(min = 5, max = 100, message = "Deve ter entre 5 e 100 caracteres")
	@NotBlank(message = "Campo requerido")
	private String subTitle;
	
	@Size(max = 4, message = "O ano deve ter no máximo 4 caracteres")
	@NotBlank(message = "Campo requerido")
	@Positive(message = "O ano deve ser um valor positivo")
	private Integer year;
	
	@Size(min = 5, max = 200, message = "Deve ter entre 5 e 60 caracteres")
	@NotBlank(message = "Campo requerido")
	private String imgUrl;
	
	@NotBlank(message = "Campo requerido")
	private String synopsis;
	
	private GenreDTO genre;
	
	private ReviewDTO review;
	
	private List<Review> reviews = new ArrayList<>();
	
	public MovieDTO() {
	}

	public MovieDTO(Long id, String title, String subTitle, Integer year, String imgUrl, String synopsis) {
		this.id = id;
		this.title = title;
		this.subTitle = subTitle;
		this.year = year;
		this.imgUrl = imgUrl;
		this.synopsis = synopsis;
	}
	
	public MovieDTO(Movie entity) {
		id = entity.getId();
		title = entity.getTitle();
		subTitle = entity.getSubTitle();
		year = entity.getYear();
		imgUrl = entity.getImgUrl();
		synopsis = entity.getSynopsis();
	}
	
	public MovieDTO(Movie entity, Genre genre) {
		this(entity);
		this.genre = new GenreDTO(genre);
	}
	
	public MovieDTO(Movie entity, Review review) {
		this(entity);
		this.review = new ReviewDTO(review);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public GenreDTO getGenre() {
		return genre;
	}

	public void setGenre(GenreDTO genre) {
		this.genre = genre;
	}
	
	public ReviewDTO getReview() {
		return review;
	}

	public void setReview(ReviewDTO review) {
		this.review = review;
	}

	public List<Review> getReviews() {
		return reviews;
	}
	
}
