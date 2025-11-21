package noobanidus.mods.laggenerator.neoforge;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(value = "laggenerator")
public class LagGenerator {
  public static LagGenerator instance;

  public LagGenerator(ModContainer modContainer, IEventBus modBus) {
    instance = this;
  }
}
