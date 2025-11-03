package us.codezzops.zombii.rosegold

import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.MapColor
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier
import kotlin.reflect.KProperty1

object RoseGoldBlocks {
    private fun keyOfBlock(name: String): RegistryKey<Block> =
        RegistryKey.of(Registries.BLOCK.key, Identifier.of(RoseGold.MOD_ID, name))

    private fun register(
        name: String,
        blockFactory: (AbstractBlock.Settings) -> Block,
        settings: AbstractBlock.Settings = AbstractBlock.Settings.create()
            .mapColor(MapColor.PINK)
            .strength(5.0f, 6.0f)
            .sounds(BlockSoundGroup.METAL),
        registerItem: Boolean = true
    ): Block {
        val blockKey = keyOfBlock(name)
        val id = blockKey.value
        settings.registryKey(blockKey)
        val block = blockFactory(settings)

        Registry.register(Registries.BLOCK, id, block)

        if (registerItem) {
            RoseGoldItems.registerItem(name) { props -> BlockItem(block, props) }
        }

        return block
    }

    val RAW_ROSE_GOLD_BLOCK: Block = register(
        "raw_rose_gold_block",
        { props -> Block(props) }
    )

    val RAW_ROSE_GOLD_IRON_BLOCK: Block = register(
        "raw_rose_gold_iron_block",
        { props -> Block(props) }
    )

    val ROSE_GOLD_BLOCK: Block = register(
        "rose_gold_block",
        { props -> Block(props) }
    )

    val ROSE_GOLD_IRON_BLOCK: Block = register(
        "rose_gold_iron_block",
        { props -> Block(props) }
    )

    val ROSE_GOLD_DIAMOND_BLOCK: Block = register(
        "rose_gold_diamond_block",
        { props -> Block(props) }
    )

    val ROSE_GOLD_NETHERITE_BLOCK: Block = register(
        "rose_gold_netherite_block",
        { props -> Block(props) }
    )

    fun init() {}

    fun addBlocksToGroup(entries: ItemGroup.Entries) {
        this::class.members
            .filter { it.returnType.classifier == Block::class }
            .filterIsInstance<KProperty1<RoseGoldBlocks, Block>>()
            .map { it.get(this) }
            .forEach { block ->
                entries.add(ItemStack(block.asItem()))
            }
    }
}