package noobanidus.mods.laggenerator.fabric;

import net.fabricmc.api.ModInitializer;
import noobanidus.mods.laggenerator.common.rules.LagGameRules;

public class LagGenerator implements ModInitializer {
  @Override
  public void onInitialize() {
    LagGameRules.init();
  }
}
