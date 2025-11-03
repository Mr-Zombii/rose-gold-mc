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

    val RAW_ROSE_GOLD_BLOCK = register("raw_rose_gold_block")
    val RAW_ROSE_GOLD_IRON_BLOCK = register("raw_rose_gold_iron_block")
    val ROSE_GOLD_BLOCK = register("rose_gold_block")
    val ROSE_GOLD_IRON_BLOCK = register("rose_gold_iron_block")
    val ROSE_GOLD_DIAMOND_BLOCK = register("rose_gold_diamond_block")
    val ROSE_GOLD_NETHERITE_BLOCK = register("rose_gold_netherite_block")

    fun init() {}

    fun addBlocksToGroup(entries: ItemGroup.Entries) {
        listOf(
            RAW_ROSE_GOLD_BLOCK,
            RAW_ROSE_GOLD_IRON_BLOCK,
            ROSE_GOLD_BLOCK,
            ROSE_GOLD_IRON_BLOCK,
            ROSE_GOLD_DIAMOND_BLOCK,
            ROSE_GOLD_NETHERITE_BLOCK
        ).forEach { entries.add(ItemStack(it.asItem())) }
    }
}