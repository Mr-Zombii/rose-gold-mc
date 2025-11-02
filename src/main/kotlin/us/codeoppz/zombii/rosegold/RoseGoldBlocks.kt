package us.codeoppz.zombii.rosegold

import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.material.MapColor

object RoseGoldBlocks {
    private const val MOD_ID = "rose_gold"

    private fun keyOfBlock(name: String): ResourceKey<Block> =
        ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MOD_ID, name))

    private fun register(
        name: String,
        blockFactory: (BlockBehaviour.Properties) -> Block,
        settings: BlockBehaviour.Properties = BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_PINK)
            .strength(5.0f, 6.0f)
            .sound(SoundType.METAL),
        registerItem: Boolean = true
    ): Block {
        val blockKey = keyOfBlock(name)
        val id = blockKey.location()
        settings.setId(blockKey)
        val block = blockFactory(settings)

        Registry.register(BuiltInRegistries.BLOCK, id, block)

        if (registerItem) {
            RoseGoldItems.registerItem(id) { props -> BlockItem(block, props) }
        }

        return block
    }

    val ROSE_GOLD_BLOCK: Block = register(
        "rose_gold_block",
        { props -> Block(props) }
    )

    fun init() {}
}