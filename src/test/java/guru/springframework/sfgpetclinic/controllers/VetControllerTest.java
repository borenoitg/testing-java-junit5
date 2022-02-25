package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.controllers.fauxspring.ModelMapImpl;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("controllers")
class VetControllerTest {

    SpecialtyService specialtyService;
    VetService vetService;
    VetController vetController;

    @BeforeEach
    void setUp() {
        specialtyService = new SpecialityMapService();
        vetService = new VetMapService(specialtyService);
        vetController = new VetController(vetService);

        Vet vet1 = new Vet(1L, "joe", "buck", null);
        Vet vet2 = new Vet(2L, "jimmy", "Smith", null);

        vetService.save(vet1);
        vetService.save(vet2);
    }

    @Test
    void listVets() {
        ModelMapImpl model = new ModelMapImpl();
        String view = vetController.listVets(model);

        assertThat(view).isEqualTo("vets/index");

        Set<Object> modelAttribute = (Set<Object>) model.getMap().get("vets");

        assertThat(modelAttribute).hasSize(2);
    }
}