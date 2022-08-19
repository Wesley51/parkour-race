package me.WesleyH21.parkourrace.game;

import net.minecraft.util.math.Vec3d;
import xyz.nucleoid.map_templates.BlockBounds;
import xyz.nucleoid.plasmid.game.GameSpace;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.GameMode;
import me.WesleyH21.parkourrace.ParkourRace;
import me.WesleyH21.parkourrace.game.map.ParkourRaceMap;

import java.util.Random;

public class ParkourRaceSpawnLogic {
    private final GameSpace gameSpace;
    private final ParkourRaceMap map;
    private final ServerWorld world;

    public ParkourRaceSpawnLogic(GameSpace gameSpace, ServerWorld world, ParkourRaceMap map) {
        this.gameSpace = gameSpace;
        this.map = map;
        this.world = world;
    }

    public void resetPlayer(ServerPlayerEntity player, GameMode gameMode) {
        player.changeGameMode(gameMode);
        player.setVelocity(Vec3d.ZERO);
        player.fallDistance = 0.0f;

        player.addStatusEffect(new StatusEffectInstance(
                StatusEffects.NIGHT_VISION,
                20 * 60 * 60,
                1,
                true,
                false
        ));
    }

    public void spawnPlayer(ServerPlayerEntity player, ServerWorld world) {
        spawnPlayer(player, getRandomSpawnPos(player.getRandom()), world);
    }

    public void spawnPlayer(ServerPlayerEntity player, Vec3d pos, ServerWorld world) {
        player.teleport(world, pos.getX(), pos.getY(), pos.getZ(), 0.0F, 0.0F);
        player.setOnGround(true);
    }
    public Vec3d getRandomSpawnPos(Random random) {
        return choosePos(random, map.getSpawn(random), 0);
    }

    public static Vec3d choosePos(Random random, BlockBounds bounds, float aboveGround) {
        BlockPos min = bounds.min();
        BlockPos max = bounds.max();

        double x = MathHelper.nextDouble(random, min.getX(), max.getX());
        double z = MathHelper.nextDouble(random, min.getZ(), max.getZ());
        double y = min.getY() + aboveGround;

        return new Vec3d(x + 0.5, y, z + 0.5);
    }
}
