package ru.mtuci.rbpo_2024_praktika.dto;

import lombok.Data;

import java.time.Duration;
import java.util.Date;

@Data
public class Ticket {
    private Date date;
    private Duration lifetime;
    private Date activation_date;
    private Date expiration_date;
    private long user_id;
    private long device_id;
    private boolean isLicenseBlocked;
    private String sugnature;


}
