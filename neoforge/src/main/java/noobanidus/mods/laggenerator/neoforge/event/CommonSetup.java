package noobanidus.mods.laggenerator.neoforge.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import noobanidus.mods.laggenerator.common.rules.LagGameRules;

@EventBusSubscriber(modid = "laggenerator", bus= EventBusSubscriber.Bus.MOD)
public class CommonSetup {
  @SubscribeEvent
  public static void onCommonSetup(FMLCommonSetupEvent event) {
    event.enqueueWork(LagGameRules::init);
  }
}
