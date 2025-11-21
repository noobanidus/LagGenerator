package noobanidus.mods.laggenerator.common.rules;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.GameRules;
import noobanidus.mods.laggenerator.common.mixins.AccessorMixinGameRules;
import noobanidus.mods.laggenerator.common.mixins.AccessorMixinGameRules$IntegerValue;

public class LagGameRules {
  public static GameRules.Key<GameRules.IntegerValue> SERVER_PRE_TICK_LAG;
  public static GameRules.Key<GameRules.IntegerValue> SERVER_POST_TICK_LAG;
  public static GameRules.Key<GameRules.IntegerValue> ENTITY_TICK_LAG;

  public static int getValue (MinecraftServer server, GameRules.Key<GameRules.IntegerValue> key) {
    return server.getGameRules().getRule(key).get();
  }

  public static void init () {
    SERVER_PRE_TICK_LAG = AccessorMixinGameRules.LagGenerator$invokeRegister("lag_generator_serverPreTickLag", GameRules.Category.UPDATES, AccessorMixinGameRules$IntegerValue.LagGenerator$invokeCreate(80, 0, Integer.MAX_VALUE, (a, b) -> {}));
    SERVER_POST_TICK_LAG = AccessorMixinGameRules.LagGenerator$invokeRegister("lag_generator_serverPostTickLag", GameRules.Category.UPDATES, AccessorMixinGameRules$IntegerValue.LagGenerator$invokeCreate(80, 0, Integer.MAX_VALUE, (a, b) -> {}));
    ENTITY_TICK_LAG = AccessorMixinGameRules.LagGenerator$invokeRegister("lag_generator_entityTickLag", GameRules.Category.UPDATES, AccessorMixinGameRules$IntegerValue.LagGenerator$invokeCreate(80, 0, Integer.MAX_VALUE, (a, b) -> {}));
  }
}
