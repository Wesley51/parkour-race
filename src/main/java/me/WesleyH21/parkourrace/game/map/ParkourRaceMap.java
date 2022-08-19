package me.WesleyH21.parkourrace.game.map;

import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import xyz.nucleoid.map_templates.BlockBounds;
import xyz.nucleoid.map_templates.MapTemplate;
import xyz.nucleoid.plasmid.game.world.generator.TemplateChunkGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParkourRaceMap {
    private final MapTemplate template;
    private final ParkourRaceMapConfig config;
    public List<BlockBounds> checkpoints = new ArrayList<>();
    public List<BlockBounds> waitingSpawns;

    public ParkourRaceMap(MapTemplate template, ParkourRaceMapConfig config) {
        this.template = template;
        this.config = config;
    }

    public ChunkGenerator asGenerator(MinecraftServer server) {
        return new TemplateChunkGenerator(server, this.template);
    }
    public BlockBounds getSpawn(Random random) {
        return waitingSpawns.get(random.nextInt(waitingSpawns.size()));
    }
}
