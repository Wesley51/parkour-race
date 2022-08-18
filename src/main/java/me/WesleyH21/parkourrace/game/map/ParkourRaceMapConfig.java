package me.WesleyH21.parkourrace.game.map;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;

public class ParkourRaceMapConfig {
    public static final Codec<ParkourRaceMapConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            BlockState.CODEC.fieldOf("spawn_block").forGetter(map -> map.spawnBlock)
    ).apply(instance, ParkourRaceMapConfig::new));

    public final BlockState spawnBlock;

    public ParkourRaceMapConfig(BlockState spawnBlock) {
        this.spawnBlock = spawnBlock;
    }
}
