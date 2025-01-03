package com.example.shrey.watchlist.entity;

import com.example.shrey.watchlist.entity.validation.Priority;
import com.example.shrey.watchlist.entity.validation.Rating;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Please enter the title")
    private String title;

    @Rating(message = "Enter rating Between 5 and 10")
    private float rating;

    @Priority
    private String priority;

    @Size(max = 50, message = "Comment should be maximum 50 characters")
    private String comment;

    @NotBlank(message = "Status cannot be empty")
    private String status = "Unwatched";

    // New field for trailer URL
    @Size(max = 255, message = "Trailer URL should be a maximum of 255 characters")
    private String trailerUrl;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTrailerUrl() { // Getter for trailerUrl
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) { // Setter for trailerUrl
        this.trailerUrl = trailerUrl;
    }
}
