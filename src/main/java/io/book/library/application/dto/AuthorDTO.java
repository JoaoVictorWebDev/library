package io.book.library.application.dto;

import io.book.library.application.dto.Abstraction.AbstractDTO;

import java.time.LocalDateTime;

public class AuthorDTO extends AbstractDTO {

    private String authorName;
    private String nationality;
    private String biography;
    private String photoUrl;

    public AuthorDTO() {
        super();
    }

    public AuthorDTO(Long id, String authorName, String nationality,
                     String biography, String photoUrl,
                     LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(id, createdAt, updatedAt);
        this.authorName = authorName;
        this.nationality = nationality;
        this.biography = biography;
        this.photoUrl = photoUrl;
    }


    public String getAuthorName() {
        return authorName.trim();
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getNationality() {
        return nationality.trim();
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBiography() {
        return biography.trim();
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPhotoUrl() {
        return photoUrl.trim();
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}

