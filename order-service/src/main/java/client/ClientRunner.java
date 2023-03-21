package client;

import com.example.orderservice.tmp.Sleep;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class ClientRunner {
    public static void main(String[] args) {
        for (int i = 0; i < 40; i++) {
            new Thread(ClientRunner::callTheRest).start();
        }
        Sleep.sleepMe(50_000);
    }


    public static void callTheRest() {
        try {
            Object forObject = new RestTemplate().getForObject("http://localhost:8080/order-service/cb", Object.class);
            System.out.println("response:" + forObject);
        } catch (RestClientException e) {
            System.err.println(e.getMessage());
        }
    }
}
