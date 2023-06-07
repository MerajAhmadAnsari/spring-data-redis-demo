package com.example.SpringDataRedis;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class UserController {

    private static final String STRING_KEY_PREFIX = "redis.test";

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("Ponged at : " + LocalDateTime.now().toString());
    }

    @PostMapping("/string")
    public ResponseEntity<Map.Entry<String, String>> setString(@RequestBody Map.Entry<String, String> kvp) {
        return ResponseEntity.ok(kvp);
    }

}
