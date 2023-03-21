package client;

import com.example.orderservice.tmp.Sleep;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class ClientRunner {
    public static void main(String[] args) {
        for (int i = 0; i < 22; i++) {
            int finalI = i;
            new Thread(() -> ClientRunner.callTheRest(finalI)).start();
        }
        Sleep.sleepMe(50_000);
    }


    public static void callTheRest(int i) {
        try {
            Object forObject = new RestTemplate().getForObject("http://localhost:8083/bulkhead/" + i, Object.class);
            System.out.println("response:" + forObject);
        } catch (RestClientException e) {
            System.err.println(e.getMessage());
        }
    }
}
