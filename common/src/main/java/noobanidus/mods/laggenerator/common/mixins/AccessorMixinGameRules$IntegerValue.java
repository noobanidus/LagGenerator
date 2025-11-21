package noobanidus.mods.laggenerator.common.mixins;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.GameRules;
import org.apache.commons.lang3.NotImplementedException;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.function.BiConsumer;

@Mixin(GameRules.IntegerValue.class)
public interface AccessorMixinGameRules$IntegerValue {
  @Invoker("create")
  static GameRules.Type<GameRules.IntegerValue> LagGenerator$invokeCreate(
      int defaultValue, int min, int max, BiConsumer<MinecraftServer, GameRules.IntegerValue> changeListener
  ) {
    throw new NotImplementedException();
  }
}
