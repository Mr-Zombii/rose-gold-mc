package us.codezzops.zombii.rosegold

import kotlinx.atomicfu.TraceBase
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

object RoseGold : ModInitializer {
    const val MOD_ID = "rose_gold"

    private val GROUP_ID = Identifier.of(MOD_ID, "main")
    private val GROUP_KEY = RegistryKey.of(RegistryKeys.ITEM_GROUP, GROUP_ID)

    val ITEM_GROUP: ItemGroup = FabricItemGroup.builder()
        // Todo: Add Icon for creative menu
        .displayName(Text.translatable("itemGroup.$MOD_ID.main"))
        .entries { _, entries ->
            RoseGoldItems.addItemsToGroup(entries)
            RoseGoldBlocks.addBlocksToGroup(entries)
            RoseGoldArmorItems.addItemsToGroup(entries)
        }
        .build()

    override fun onInitialize() {
        RoseGoldItems.init()
        RoseGoldArmorItems.init()
        RoseGoldBlocks.init()
        RoseGoldLootTables.registerLoot()
        RoseGoldWorldGen.register()
        registerItemGroup()
    }

    private fun registerItemGroup() {
        Registry.register(Registries.ITEM_GROUP, GROUP_KEY, ITEM_GROUP)
    }

}