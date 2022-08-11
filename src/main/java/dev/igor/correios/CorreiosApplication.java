package dev.igor.correios;

import dev.igor.correios.service.CorreiosService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CorreiosApplication {

    public static void main(String[] args) {
        var applicationContext = SpringApplication.run(CorreiosApplication.class, args);
        var correiosService = applicationContext.getBean(CorreiosService.class);

        correiosService.consultarCepAsync("13568812").whenComplete((endereco, exception) -> {
            if (exception != null) System.err.println(exception.getMessage());
            System.out.println(endereco.getCidade());
        });
    }

}
