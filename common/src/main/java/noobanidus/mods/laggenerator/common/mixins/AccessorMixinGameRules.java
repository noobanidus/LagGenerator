package noobanidus.mods.laggenerator.common.mixins;

import net.minecraft.world.level.GameRules;
import org.apache.commons.lang3.NotImplementedException;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(GameRules.class)
public interface AccessorMixinGameRules {
  @Invoker("register")
  static <T extends GameRules.Value<T>> GameRules.Key<T> LagGenerator$invokeRegister(String name, GameRules.Category category, GameRules.Type<T> p_type) {
    throw new NotImplementedException();
  }
}
