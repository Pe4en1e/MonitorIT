package me.pe4en1e.monitoritbackend.web.endpoint;

import me.pe4en1e.monitoritbackend.monitor.CpuCollector;
import me.pe4en1e.monitoritbackend.monitor.MemoryCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class RootController {

    @GetMapping("/api/root")
    public Object root() {
        return new MemoryCollector().collect();
    }

}
