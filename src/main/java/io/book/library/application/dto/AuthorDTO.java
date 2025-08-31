package io.book.library.application.dto;

import io.book.library.application.dto.Abstraction.AbstractDTO;

import java.time.LocalDateTime;

public class AuthorDTO extends AbstractDTO {

    private String authorName;
    private String nationality;
    private String biography;
    private String photoUrl;

    public AuthorDTO(Long id, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(id, createdAt, updatedAt);
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}

