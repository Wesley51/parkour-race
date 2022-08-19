package me.WesleyH21.parkourrace.game.map;

import net.minecraft.server.MinecraftServer;
import net.minecraft.text.LiteralText;
import xyz.nucleoid.map_templates.MapTemplate;
import net.minecraft.util.math.BlockPos;
import xyz.nucleoid.map_templates.MapTemplateSerializer;
import xyz.nucleoid.plasmid.game.GameOpenException;

import java.io.IOException;
import java.util.stream.Collectors;

public class ParkourRaceMapGenerator {

    private final ParkourRaceMapConfig config;

    public ParkourRaceMapGenerator(ParkourRaceMapConfig config) {
        this.config = config;
    }

    public ParkourRaceMap build(MinecraftServer server) throws GameOpenException {
        try {
            var template = MapTemplateSerializer.loadFromResource(server, this.config.id());
            ParkourRaceMap map = new ParkourRaceMap(template, this.config);
            map.waitingSpawns = template.getMetadata().getRegionBounds("waiting_spawn").collect(Collectors.toList());
            map.checkpoints = template.getMetadata().getRegionBounds("checkpoint").collect(Collectors.toList());

            return map;
        }catch (IOException e){
            throw new GameOpenException(new LiteralText("Failed to load map"));
        }

    }

}
