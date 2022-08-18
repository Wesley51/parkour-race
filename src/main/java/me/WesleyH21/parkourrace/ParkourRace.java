package me.WesleyH21.parkourrace;

import net.fabricmc.api.ModInitializer;
import xyz.nucleoid.plasmid.game.GameType;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import me.WesleyH21.parkourrace.game.ParkourRaceConfig;
import me.WesleyH21.parkourrace.game.ParkourRaceWaiting;

public class ParkourRace implements ModInitializer {

    public static final String ID = "parkourrace";
    public static final Logger LOGGER = LogManager.getLogger(ID);

    public static final GameType<ParkourRaceConfig> TYPE = GameType.register(
            new Identifier(ID, "parkourrace"),
            ParkourRaceConfig.CODEC,
            ParkourRaceWaiting::open
    );

    @Override
    public void onInitialize() {}
}
