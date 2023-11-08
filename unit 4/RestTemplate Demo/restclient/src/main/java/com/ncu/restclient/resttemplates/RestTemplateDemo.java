package com.ncu.restclient.resttemplates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ncu.restclient.dtos.IdeaDTO;

import java.util.List ;


@Component
public class RestTemplateDemo {

  @Autowired
  RestTemplate restTemplate ;

  public void fetchTheData(){

    String uri = "http://localhost:8080/demo_app/v1/ideas/" ;

    ResponseEntity<String> ideaResponse = restTemplate.getForEntity(uri, String.class);
    System.out.println("<!------ Response body -----------!>");
    System.out.println(ideaResponse.getBody());

    System.out.println("<!------ Status code -----------!>");
    System.out.println(ideaResponse.getStatusCode());

    System.out.println("<!------ Headers -----------!>");
    System.out.println(ideaResponse.getHeaders());

    List<IdeaDTO> ideaDTO = restTemplate.getForObject(uri,List.class);

    System.out.println(ideaDTO);

  }

  public static void main(String[] args) {

    /**
     * Fetch the data in the form of plain JSON
     */
//    RestTemplate restTemplate = new RestTemplate();
//
//    String uri = "http://localhost:8080/demo_app/v1/ideas/" ;
//
//    ResponseEntity<String> ideaResponse = restTemplate.getForEntity(uri, String.class);
//    System.out.println("<!------ Response body -----------!>");
//    System.out.println(ideaResponse.getBody());
//
//    System.out.println("<!------ Status code -----------!>");
//    System.out.println(ideaResponse.getStatusCode());
//
//    System.out.println("<!------ Headers -----------!>");
//    System.out.println(ideaResponse.getHeaders());
//
//    List<IdeaDTO> ideaDTO = restTemplate.getForObject(uri,List.class);
//
//    System.out.println(ideaDTO);

    /**
     *
     * Understand how the different APIs, PSOT | GET | DELETE and Update can be called
     */

    /**
     * Try making a POST call
     */
//    IdeaDTO ideaDTO = new IdeaDTO(2, "New Idea",
//        "New idea description", "John the author");
//
//    IdeaDTO ideaDTOStored = restTemplate.postForObject(uri,ideaDTO, IdeaDTO.class);
//
//    System.out.println("<!------ Created resource ----- >");
//
//    System.out.println(ideaDTOStored);

    /**
     * Try making use of the put
     */
//    IdeaDTO ideaDTOUpdated = new IdeaDTO(2, "New Idea has been updated again",
//        "New idea description -- UPDATED AGAIN", "John the author");
//
//    HttpEntity<IdeaDTO> updateRequest = new HttpEntity<>(ideaDTOUpdated, null);
//
//    restTemplate.exchange(uri+"/2",HttpMethod.PUT,updateRequest, Void.class);

    /**
     * Calling the DELETE APIs using the Rest template
     */

//    restTemplate.delete(uri+"/2");


  }
}
