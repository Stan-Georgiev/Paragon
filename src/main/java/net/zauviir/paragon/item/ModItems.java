package net.zauviir.paragon.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zauviir.paragon.FirstMod;
import net.zauviir.paragon.item.custom.GeodeItem;
import net.zauviir.paragon.item.custom.HugeGeodeItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FirstMod.MOD_ID);

    public static final RegistryObject<Item> GEODE = ITEMS.register("geode",
            () -> new GeodeItem(new Item.Properties()));

    public static final RegistryObject<Item> HUGE_GEODE = ITEMS.register("huge_geode",
            () -> new HugeGeodeItem(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
