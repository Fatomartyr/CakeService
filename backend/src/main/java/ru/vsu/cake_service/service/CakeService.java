package ru.vsu.cake_service.service;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsu.cake_service.dto.CakeDTO;
import ru.vsu.cake_service.entity.Cake;
import ru.vsu.cake_service.exception.cake_exceptions.CakeNotFoundException;
import ru.vsu.cake_service.repository.CakeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CakeService {
    private final CakeRepository cakeRepository;


    public Cake create(@Valid CakeDTO dto) {
        Cake cake = Cake.builder()
                .name(dto.name())
                .description(dto.description())
                .price(dto.price())
                .weight(dto.weight())
                .topping(dto.topping())
                .filling(dto.filling())
                .image(dto.image())
                .build();
        return cakeRepository.save(cake);
    }

    public List<Cake> readAll() {
        return cakeRepository.findAll();
    }

    public List<Cake> findCakesByName(String name) {
        return cakeRepository.findCakesByName(name);
    }

    public List<Cake> findCakesByCategory(String name) {
        return cakeRepository.findCakesByCategory(name);
    }

    public Cake update(Long id, @Valid CakeDTO dto) {
        return cakeRepository.findById(id)
                .map(cake -> cake
                        .name(dto.name())
                        .description(dto.description())
                        .price(dto.price())
                        .weight(dto.weight())
                        .topping(dto.topping())
                        .filling(dto.filling())
                        .image(dto.image()))
                .map(cakeRepository::save)
                .orElseThrow(() -> new CakeNotFoundException("Cake not found with id: " + id));
    }

    public void delete(Long id) {
        Cake cake = cakeRepository.findById(id)
                .orElseThrow(() -> new CakeNotFoundException("Cake not found with id: " + id));
        cakeRepository.delete(cake);
    }

}
