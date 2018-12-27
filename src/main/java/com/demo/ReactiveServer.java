package com.demo;

import com.demo.model.Event;
import com.demo.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import javax.validation.Valid;
import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
@RestController
public class ReactiveServer {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/events/{id}")
    public Mono<ResponseEntity<Event>> getEventById(@PathVariable(value="id") String id) {
        return eventRepository.findById(id)
                .map(savedEvent -> ResponseEntity.ok(savedEvent))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping("/events")
    public Mono<Event> createEvent(Event event) {
        return eventRepository.save(event);
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE, value = "/stream/events")
    Flux<Event> events() {
        return eventRepository.findAll();
    }

    public static void main(String[] args) {
        SpringApplication.run(ReactiveServer.class, args);
    }
}

