package com.leposava.frequency.client;

import com.leposava.frequency.entity.RandomText;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class RandomTextClient {

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public RandomText getRandomText(int numbOfParagraphs, int minWords, int maxWords) {

        final String URL_RANDOMTEXT = "http://www.randomtext.me/api/giberish/p-" + numbOfParagraphs + "/" + minWords + "-" + maxWords;

        RandomText randomText = null;
        try {

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<RandomText> entity = new HttpEntity<>(headers);

            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<RandomText> response = restTemplate.exchange(URL_RANDOMTEXT,
                    HttpMethod.GET, entity, RandomText.class);

            HttpStatus statusCode = response.getStatusCode();

            if (statusCode == HttpStatus.OK) {

                randomText = response.getBody();
                return randomText;

            }
        } catch (RestClientException e) {

            e.printStackTrace();
        }

        return null;
    }


}
