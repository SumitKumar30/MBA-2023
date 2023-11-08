package com.ncu.restclient.dtos;


import java.io.Serializable;
import java.util.Objects;


public class IdeaDTO implements Serializable {

  private int id ;
  private String ideaTitle ;
  private String ideaDescription ;
  private String author ;

  public IdeaDTO(int id, String ideaTitle, String ideaDescription, String author) {
    this.id = id;
    this.ideaTitle = ideaTitle;
    this.ideaDescription = ideaDescription;
    this.author = author;
  }

  public IdeaDTO(){}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getIdeaTitle() {
    return ideaTitle;
  }

  public void setIdeaTitle(String ideaTitle) {
    this.ideaTitle = ideaTitle;
  }

  public String getIdeaDescription() {
    return ideaDescription;
  }

  public void setIdeaDescription(String ideaDescription) {
    this.ideaDescription = ideaDescription;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  @Override
  public String toString() {
    return "IdeaDTO{" + "id=" + id + ", ideaTitle='" + ideaTitle + '\'' + ", ideaDescription='" + ideaDescription + '\''
        + ", author='" + author + '\'' + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdeaDTO ideaDTO = (IdeaDTO) o;
    return id == ideaDTO.id && Objects.equals(ideaTitle, ideaDTO.ideaTitle) && Objects.equals(ideaDescription,
        ideaDTO.ideaDescription) && Objects.equals(author, ideaDTO.author);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, ideaTitle, ideaDescription, author);
  }
}

