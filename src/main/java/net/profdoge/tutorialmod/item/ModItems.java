package net.profdoge.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.profdoge.tutorialmod.TutorialMod;

public class ModItems {

    public static final Item EMERALD_REFINED = registerItem("emerald_refined", new Item.Settings());
    public static final Item EMERALD_REFINED_HELMET = registerItem("emerald_refined_helmet", new Item.Settings());
    public static final Item EMERALD_REFINED_SWORD = registerItem("emerald_refined_sword", new Item.Settings());
    public static final Item EMERALD_REFINED_PICKAXE = registerItem("emerald_refined_pickaxe", new Item.Settings());
    public static final Item EMERALD_REFINED_AXE = registerItem("emerald_refined_axe", new Item.Settings());
    public static final Item EMERALD_REFINED_SHOVEL = registerItem("emerald_refined_shovel", new Item.Settings());
    public static final Item EMERALD_REFINED_HOE = registerItem("emerald_refined_hoe", new Item.Settings());


    private static Item registerItem(String name, Item.Settings itemSettings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TutorialMod.MOD_ID, name));
        Item item = new Item(itemSettings.registryKey(key));
        return Registry.register(Registries.ITEM, key, item);
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(EMERALD_REFINED);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(EMERALD_REFINED_SWORD);
            fabricItemGroupEntries.add(EMERALD_REFINED_AXE);
            fabricItemGroupEntries.add(EMERALD_REFINED_HELMET);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(EMERALD_REFINED_SHOVEL);
            fabricItemGroupEntries.add(EMERALD_REFINED_PICKAXE);
            fabricItemGroupEntries.add(EMERALD_REFINED_AXE);
            fabricItemGroupEntries.add(EMERALD_REFINED_HOE);
        });
    }
}
