package com.plass.traveling.domain.az;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ChatGPTService {


    // 지피티 요청 주소
    @Value("${open.ai.api.url}")
    private String apiUrl;

    // api key (지피티)
    @Value("${open.ai.api.subscriptionKey}")
    private String subscriptionKey;

    private final RestTemplate restTemplate;

    public Object createData(String chat) throws JsonProcessingException {
        String responseBody = "";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("api-key", subscriptionKey);

        HttpEntity<String> requestEntity = new HttpEntity<>(postGPT(chat), headers);
        //System.out.println(requestBody);  //로그 찍기
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);
        responseBody = responseEntity.getBody();


        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(responseBody);
        System.out.println(jsonNode);
        String textValue = jsonNode.get("choices").get(0).get("message").get("content").asText();

        Map<String, String> map = new HashMap<>();
        map.put("massage" , textValue);

        return map;
    }

    public String postGPT(String chat) {
        String jsonInput = "";

        jsonInput = "{\n" +
                "  \"messages\": [\n" +
                "    {\n" +
                "      \"role\": \"system\",\n" +
                "      \"content\": [\n" +
                "        {\n" +
                "          \"type\": \"text\",\n" +
                "          \"text\": \"너는 여행 전문가야 사용자가 대한민국 지역에 관한 여행정보를 너한테 물어보면 너는 답해줘야하는 챗봇이야. 사용자가 대구 수성구는 에는 뭐가 할개있어 라고 물어보면 너는 대구 수성구에는 수성못이 있고 또한 다른 여러 놀거리등이 있습니다를 너가 찾아보고 추측해서 답해줘야하. 너는 여행 지도사인거야. 너는 착하게 답해줘야하고 네 알겠습니다와 같은 맥락을 말하지마. 너는 챗봇이야.\\n\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"role\": \"user\",\n" +
                "      \"content\": [\n" +
                "        {\n" +
                "          \"type\": \"text\",\n" +
                "          \"text\": \" " + chat + "\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ],\n" +
                "  \"temperature\": 0.7, \n" +
                "  \"top_p\": 0.95, \n" +
                "  \"max_tokens\": 3000" +
                "}";

        //System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++"+massageRequest.massage());
        //System.out.printf(jsonInput+"+++++++++++++++++++++++++++++++++");
        return jsonInput;
    }
}