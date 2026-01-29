package me.pe4en1e.monitoritbackend.monitor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;

public class CpuCollector {

    private SystemInfo systemInfo = new SystemInfo();
    private HardwareAbstractionLayer hardware = systemInfo.getHardware();

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    private static class CpuData {

        private String cpuName;
        private int cpuCores;

    }

    public CpuData collect() {
        return CpuData.builder()
                .cpuName(hardware.getProcessor().getProcessorIdentifier().getName().toString())
                .cpuCores(hardware.getProcessor().getPhysicalProcessorCount())
                .build();
    }

}
