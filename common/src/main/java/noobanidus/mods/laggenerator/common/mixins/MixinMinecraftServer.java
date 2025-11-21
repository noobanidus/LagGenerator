package noobanidus.mods.laggenerator.common.mixins;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ServerTickRateManager;
import net.minecraft.util.profiling.ProfilerFiller;
import noobanidus.mods.laggenerator.common.rules.LagGameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(MinecraftServer.class)
public class MixinMinecraftServer {
  @WrapOperation(method = "tickServer", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/ServerTickRateManager;tick()V"))
  private void LagGenerator$PreServerTickLag(ServerTickRateManager instance, Operation<Void> original) {
    original.call(instance);
    if (!LagGameRules.enabled((MinecraftServer) (Object) this)) {
      return;
    }
    int preTickLag = LagGameRules.getValue((MinecraftServer) (Object) this, LagGameRules.SERVER_PRE_TICK_LAG);
    if (preTickLag > 0) {
      try {
        Thread.sleep(preTickLag);
      } catch (InterruptedException ignore) {
      }
    }
  }

  @WrapOperation(method = "tickServer", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/profiling/ProfilerFiller;pop()V", ordinal = 1))
  private void LagGenerator$PostServerTickLag(ProfilerFiller instance, Operation<Void> original) {
    original.call(instance);
    if (!LagGameRules.enabled((MinecraftServer) (Object) this)) {
      return;
    }
    int postTickLag = LagGameRules.getValue((MinecraftServer) (Object) this, LagGameRules.SERVER_POST_TICK_LAG);
    if (postTickLag > 0) {
      try {
        Thread.sleep(postTickLag);
      } catch (InterruptedException ignore) {
      }
    }
  }
}
