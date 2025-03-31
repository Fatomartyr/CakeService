package ru.vsu.cake_service.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsu.cake_service.dto.CakeDTO;
import ru.vsu.cake_service.entity.Cake;
import ru.vsu.cake_service.repository.CakeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CakeService {
    private final CakeRepository cakeRepository;

    public Cake create(CakeDTO dto) {
        Cake cake = Cake.builder()
                .name(dto.name())
                .description(dto.description())
                .price(dto.price())
                .weight(dto.weight())
                .topping(dto.topping())
                .filling(dto.filling())
                .imageUrl(dto.imageUrl())
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

    public Cake update(Long id, CakeDTO dto) {
        return cakeRepository.findById(id)
                .map(cake -> cake
                        .name(dto.name())
                        .description(dto.description())
                        .price(dto.price())
                        .weight(dto.weight())
                        .topping(dto.topping())
                        .filling(dto.filling())
                        .imageUrl(dto.imageUrl()))
                .map(cakeRepository::save)
                .orElseThrow(() -> new EntityNotFoundException("Cake not found with id: " + id));
    }

    public void delete(Long id) {
        Cake cake = cakeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cake not found with id: " + id));
        cakeRepository.delete(cake);
    }

}
