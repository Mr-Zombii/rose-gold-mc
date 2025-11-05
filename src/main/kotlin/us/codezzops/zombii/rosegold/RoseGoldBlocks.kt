package us.codezzops.zombii.rosegold

import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.MapColor
import net.minecraft.item.BlockItem
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier

object RoseGoldBlocks {
    private fun defaultSettings(name: String) = AbstractBlock.Settings.create()
        .mapColor(MapColor.PINK)
        .strength(5.0f, 6.0f)
        .sounds(BlockSoundGroup.METAL)
        .registryKey(RegistryKey.of(Registries.BLOCK.key, Identifier.of(RoseGold.MOD_ID, name)))

    private fun register(name: String): Block {
        val id = Identifier.of(RoseGold.MOD_ID, name)
        val block = Block(defaultSettings(name))
        Registry.register(Registries.BLOCK, id, block)
        RoseGoldItems.registerItem(name) { BlockItem(block, it) }
        return block
    }

    val RUBY_ORE = register("ruby_ore")
    val SAPPHIRE_ORE = register("sapphire_ore")
    val TOPAZ_ORE = register("topaz_ore")
    val AMETHYST_ORE = register("amethyst_ore")
    val RAW_BLOCK = register("raw_block")
    val RAW_IRON_BLOCK = register("raw_iron_block")
    val BLOCK = register("block")
    val IRON_BLOCK = register("iron_block")
    val DIAMOND_BLOCK = register("diamond_block")
    val NETHERITE_BLOCK = register("netherite_block")

    fun init() {}

    fun addBlocksToGroup(entries: ItemGroup.Entries) {
        listOf(
            RUBY_ORE,
            SAPPHIRE_ORE,
            TOPAZ_ORE,
            AMETHYST_ORE,
            RAW_BLOCK,
            RAW_IRON_BLOCK,
            BLOCK,
            IRON_BLOCK,
            DIAMOND_BLOCK,
            NETHERITE_BLOCK
        ).forEach { entries.add(ItemStack(it.asItem())) }
    }
}