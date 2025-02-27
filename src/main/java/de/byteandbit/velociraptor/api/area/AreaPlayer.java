package de.byteandbit.velociraptor.api.area;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AreaPlayer {
    private String playerName;
    private String playerUUID;
}
