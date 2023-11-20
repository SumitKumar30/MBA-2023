package com.ncu.restclient.webclienttemplates;

import org.springframework.web.reactive.function.client.WebClient;

import com.ncu.restclient.dtos.IdeaDTO;

import reactor.core.publisher.Mono;
import java.util.List;


public class WebClientDemo {

  public static void main(String[] args) {

    /**
     * Need to define a webclient
     */

    WebClient webClient = WebClient.create("http://localhost:8080");

    /**
     * CRUD operations
     *
     * CREATE  - POST
     * GET - GET
     * Get All  - GET
     * Update  - PUT
     * Delete  - DELETE
     *
     */

    /**
     * POST call
     */

    IdeaDTO ideaDTO = new IdeaDTO(2, "New Idea", "New Idea Description", "John Wick");
//    Mono<IdeaDTO> savedIdeaDetails = webClient.post().uri("/demo_app/v1/ideas").bodyValue(ideaDTO).retrieve().bodyToMono(IdeaDTO.class);
//    System.out.println("Createing the idea");
//    System.out.println(savedIdeaDetails.block());

    /**
     * Fetch all the idea present - GET
     */
//     Mono<List> ideasList = webClient.get().uri("/demo_app/v1/ideas").retrieve().bodyToMono(List.class);
//
//    System.out.println(ideasList.block());

    /**
     * Fetch the idea based on a particular id
     */
//    System.out.println("Details of idea with id 2 before updation");
//    Mono<IdeaDTO> searchedIdea = webClient.get().uri("/demo_app/v1/ideas/2").retrieve().bodyToMono(IdeaDTO.class);
//
//    System.out.println(searchedIdea.block());

    /**
     * Update the idea
     */

//    System.out.println("Details of idea with id 2 after updation");
//    ideaDTO.setIdeaTitle(ideaDTO.getIdeaTitle()+" UPDATED");
//    ideaDTO.setIdeaDescription(ideaDTO.getIdeaDescription()+" UPDATED");
//    Mono<IdeaDTO> updatedIdea = webClient.put().uri("/demo_app/v1/ideas/2").bodyValue(ideaDTO).retrieve().bodyToMono(IdeaDTO.class);
//
//    System.out.println(updatedIdea.block());

    /**
     * Delete an idea
     */
    Mono<IdeaDTO> deletedIdea = webClient.delete().uri("/demo_app/v1/ideas/2").retrieve().bodyToMono(IdeaDTO.class);

    System.out.println(deletedIdea.block());
  }

}
