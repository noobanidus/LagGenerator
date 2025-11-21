package noobanidus.mods.laggenerator.neoforge;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(value = "laggenerator")
public class LagGenerator {
  public static LagGenerator instance;

  public LagGenerator(ModContainer modContainer, IEventBus modBus) {
    instance = this;
  }
}
