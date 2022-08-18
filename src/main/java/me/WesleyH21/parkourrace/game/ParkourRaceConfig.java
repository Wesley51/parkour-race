package me.WesleyH21.parkourrace.game;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import me.WesleyH21.parkourrace.game.map.ParkourRaceMapConfig;
import xyz.nucleoid.plasmid.game.common.config.PlayerConfig;

public class ParkourRaceConfig {
    public static final Codec<ParkourRaceConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            PlayerConfig.CODEC.fieldOf("players").forGetter(config -> config.playerConfig),
            ParkourRaceMapConfig.CODEC.fieldOf("map").forGetter(config -> config.mapConfig),
            Codec.INT.fieldOf("time_limit_secs").forGetter(config -> config.timeLimitSecs)
    ).apply(instance, ParkourRaceConfig::new));

    public final PlayerConfig playerConfig;
    public final ParkourRaceMapConfig mapConfig;
    public final int timeLimitSecs;

    public ParkourRaceConfig(PlayerConfig players, ParkourRaceMapConfig mapConfig, int timeLimitSecs) {
        this.playerConfig = players;
        this.mapConfig = mapConfig;
        this.timeLimitSecs = timeLimitSecs;
    }
}
