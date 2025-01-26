package grupo_nueve.buscahipotecas.Demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/buscahipotecas/v1")
@RequiredArgsConstructor
public class DemoController {

    @GetMapping(value = "/demo")
    public String wellcome() {
        return "Bienvenido a buscahipotecas";
    }
    
}
