package net.zauviir.paragon.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.zauviir.paragon.FirstMod;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FirstMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PARAGON_TAB = CREATIVE_MODE_TABS.register("paragon_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GEODE.get()))
            .title(Component.translatable("creativetab.paragon_tab"))
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(ModItems.GEODE.get());
                pOutput.accept(ModItems.HUGE_GEODE.get());
            })
            .build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
