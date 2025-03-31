package ru.vsu.cake_service.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cake_service.dto.CakeDTO;
import ru.vsu.cake_service.entity.Cake;
import ru.vsu.cake_service.service.CakeService;

import java.util.List;

@RestController
@AllArgsConstructor
public class CakeController {
    private final CakeService cakeService;

    @PostMapping
    public ResponseEntity<Cake> create (@RequestBody CakeDTO dto) {
        return ResponseEntity.ok(cakeService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<Cake>> readAll () {
        return ResponseEntity.ok(cakeService.readAll());
    }

    @GetMapping
    public ResponseEntity<List<Cake>> findCakesByName(@RequestParam String name) {
        return ResponseEntity.ok(cakeService.findCakesByName(name));
    }

    @GetMapping
    public ResponseEntity<List<Cake>> findCakesByCategory(@RequestParam String name) {
        return ResponseEntity.ok(cakeService.findCakesByCategory(name));
    }

    @PutMapping
    public ResponseEntity<Cake> update(@RequestParam Long id, @RequestBody CakeDTO dto) {
        return ResponseEntity.ok(cakeService.update(id, dto));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        cakeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
