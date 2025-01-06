package com.cargocompare.CargoCompare_api.tariffs;


import jakarta.persistence.*;
import lombok.*;

@Getter
public enum TariffType {
    TRUCK,
    KG_SIZE,
    M3_SIZE,
    KG_ZONE,


}
