package us.codezzops.zombii.rosegold

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import us.codezzops.zombii.rosegold.RoseGoldItems.ROSE_GOLD_IRON_INGOT

object RoseGold : ModInitializer {
    const val MOD_ID = "rose_gold";

	override fun onInitialize() {
        RoseGoldItems.init()
        RoseGoldArmorItems.init()
        RoseGoldBlocks.init()
        RoseGoldLootTables.registerLoot()
        registerItemGroups()
	}

    private val ROSE_GOLD_GROUP_KEY: RegistryKey<ItemGroup> = RegistryKey.of(
        RegistryKeys.ITEM_GROUP,
        Identifier.of(MOD_ID, "rose_gold_group")
    )

    val ROSE_GOLD_GROUP: ItemGroup = FabricItemGroup.builder()
        .icon { ItemStack(ROSE_GOLD_IRON_INGOT) }
        .displayName(Text.translatable("itemGroup.rose_gold.rose_gold_group"))
        .entries { context, entries ->
            RoseGoldItems.addItemsToGroup(entries)
            RoseGoldBlocks.addBlocksToGroup(entries)
            RoseGoldArmorItems.addItemsToGroup(entries)
        }
        .build()

    fun registerItemGroups() {
        Registry.register(
            Registries.ITEM_GROUP,
            ROSE_GOLD_GROUP_KEY,
            ROSE_GOLD_GROUP
        )
    }
}
