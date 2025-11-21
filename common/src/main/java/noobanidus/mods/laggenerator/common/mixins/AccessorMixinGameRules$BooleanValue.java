package noobanidus.mods.laggenerator.common.mixins;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.GameRules;
import org.apache.commons.lang3.NotImplementedException;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.function.BiConsumer;

@Mixin(GameRules.BooleanValue.class)
public interface AccessorMixinGameRules$BooleanValue {
  @Invoker("create")
  static GameRules.Type<GameRules.BooleanValue> LagGenerator$invokeCreate(boolean defaultValue, BiConsumer<MinecraftServer, GameRules.BooleanValue> changeListener) {
    throw new NotImplementedException();
  }
}
