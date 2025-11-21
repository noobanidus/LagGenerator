package noobanidus.mods.laggenerator.common.mixins;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import noobanidus.mods.laggenerator.common.rules.LagGameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Entity.class)
public class MixinEntity {
  @WrapOperation(method="baseTick", at=@At(value="INVOKE", target="Lnet/minecraft/util/profiling/ProfilerFiller;push(Ljava/lang/String;)V"))
  private void LagGenerator$EntityTickLag(ProfilerFiller instance, String section, Operation<Void> original) {
    original.call(instance, section);
    Level level = ((Entity) (Object) this).level();
    if (level == null || level.isClientSide() || level.getServer() == null) {
      return;
    }
    int entityTickLag = LagGameRules.getValue(level.getServer(), LagGameRules.ENTITY_TICK_LAG);
    if (entityTickLag > 0) {
      try {
        Thread.sleep(entityTickLag);
      } catch (InterruptedException ignore) {
      }
    }
  }
}
