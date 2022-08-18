package me.WesleyH21.parkourrace.game.map;

import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import xyz.nucleoid.map_templates.MapTemplate;
import xyz.nucleoid.plasmid.game.world.generator.TemplateChunkGenerator;

public class ParkourRaceMap {
    private final MapTemplate template;
    private final ParkourRaceMapConfig config;
    public BlockPos spawn;

    public ParkourRaceMap(MapTemplate template, ParkourRaceMapConfig config) {
        this.template = template;
        this.config = config;
    }

    public ChunkGenerator asGenerator(MinecraftServer server) {
        return new TemplateChunkGenerator(server, this.template);
    }
}
