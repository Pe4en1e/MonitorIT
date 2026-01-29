package me.pe4en1e.monitoritbackend.monitor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;

public class MemoryCollector {

    private SystemInfo systemInfo = new SystemInfo();
    private HardwareAbstractionLayer hardware = systemInfo.getHardware();

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    private static class MemoryData {

        private long memoryTotal;
        private long memoryUsed;

    }

    public MemoryData collect() {
        return MemoryData.builder()
                .memoryTotal(hardware.getMemory().getTotal() / 1024 / 1024)
                .memoryUsed((hardware.getMemory().getTotal() - hardware.getMemory().getAvailable()) / 1024 / 1024)
                .build();
    }

}
