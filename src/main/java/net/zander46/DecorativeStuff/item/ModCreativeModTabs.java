package net.zander46.DecorativeStuff.item;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.zander46.DecorativeStuff.DecorativeStuffMod;
import net.zander46.DecorativeStuff.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DecorativeStuffMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DECORATIVE_STUFF_MOD_TAB = CREATIVE_MODE_TABS.register("decorative_stuff_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SPEAR.get()))
                    .title(Component.translatable("creativetab.decorative_stuff_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SPEAR.get());
                        output.accept(ModBlocks.PACKED_TERRACOTTA.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
