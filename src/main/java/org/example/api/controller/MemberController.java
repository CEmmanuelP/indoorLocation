package org.example.api.controller;

import lombok.RequiredArgsConstructor;
import org.example.api.domain.member.Member;
import org.example.api.dto.MessageDto;
import org.example.api.service.MemberService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/getToken/{uname}")
    public String getToken(@PathVariable String uname){
        return memberService.getToken(uname);
    }

    @GetMapping("/api/mypage/{phoneNumber}")
    public Member myPage(@PathVariable String phoneNumber){
        return memberService.myPage(phoneNumber);
    }

    @PostMapping("/api/register")
    public ResponseEntity<Member> save(@RequestBody Member member){
        return new ResponseEntity<Member>(memberService.save(member), HttpStatus.OK);
    }
    //@PostMapping("/api/registerck")
    @PostMapping("/api/registerck")
    public String findByPhoneNumber(@RequestBody Member member){
        String phoneNumber = member.getPhoneNumber();
        String name = memberService.findByPhoneNumber(phoneNumber).getName();
        return name;
    }

    @PostMapping("/api/sendMessage")
    public String callApi(@ModelAttribute(value = "MessageDto") MessageDto message){

        String name = message.getTo();
        String token = memberService.getToken(name);


        String url = "https://fcm.googleapis.com/fcm/send";
        String key = "AAAANfOmnEk:APA91bHNTrI4Js_CReSGDi4SNjVt4lYho8bU_zyZz2GQNK0vErKeS0vdrAQ-Ynoucp1NopAmj70DhuTETG8fwl51_4-YjOA85suuqmcuLPFF7kmjYTrw0gNvZEoIlYeGDGNHTI2pRd83";

        //create an instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        //create headers
        HttpHeaders headers = new HttpHeaders();
        //set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "key="+ key);

        //request body parameters
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();

        map2.put("title", message.getTitle());
        map2.put("body", message.getBody());

        map.put("to", token);
        map.put("notification", map2);

        //build the request
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

        //send POST request
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

        //check response
        if(response.getStatusCode() == HttpStatus.OK){
            System.out.println("request Successful");
            System.out.println(entity);
            System.out.println(response.getBody());

        }else{
            System.out.println("request Failed");
            System.out.println(response.getStatusCode());
        }

        return response.getBody();
    }
}
