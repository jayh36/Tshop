package Tshop;

import Tshop.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PolicyHandler{
    @Autowired ProductRepository productRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationCanceled_QuantityChange(@Payload ReservationCanceled reservationCanceled){

        if(reservationCanceled.isMe()){
            System.out.println("##### listener QuantityChange : " + reservationCanceled.toJson());
            // 취소이벤트 전달받아 재고 원복작업
            Optional<Product> optionalProduct = productRepository.findById(reservationCanceled.getProductId());
            Product product = optionalProduct.orElseGet(Product::new);
            product.setQuantity(product.getQuantity()+1);
            productRepository.save(product);
        }
    }

}
