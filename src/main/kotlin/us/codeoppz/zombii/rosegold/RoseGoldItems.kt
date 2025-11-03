package us.codeoppz.zombii.rosegold

import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.*
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.tag.TagKey
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.util.Identifier
import net.minecraft.util.Util
import java.util.function.Function

object RoseGoldItems {

    val material = ToolMaterial(
        TagKey.of(
            Registries.BLOCK.key,
            Identifier.of(RoseGold.MOD_ID, "incorrect_for_rose_gold_tool")
        ),
        750, 6.0f, 2.0f, 22, TagKey.of(
            Registries.ITEM.key,
            Identifier.of(RoseGold.MOD_ID, "rose_gold_tool_materials")
        )
    )

    fun registerItem(
        name: String,
        func: Function<Item.Settings, Item>
    ): Item? {
        val resourceKey = RegistryKey.of(
            Registries.ITEM.key,
            Identifier.of(RoseGold.MOD_ID, name)
        )

        return Items.register(resourceKey, func)
    }

    val RAW_ROSE_GOLD = registerItem(
        "raw_rose_gold"
    ) { properties -> Item(properties) }

    val ROSE_GOLD_INGOT = registerItem(
        "rose_gold_ingot"
    ) { properties -> Item(properties) }

    val ROSE_GOLD_NUGGET = registerItem(
        "rose_gold_nugget"
    ) { properties -> Item(properties) }

    val ROSE_GOLD_APPLE = registerItem(
        "rose_gold_apple"
    ) { properties -> Item(properties) }

    val ROSE_GOLD_CARROT = registerItem(
        "rose_gold_carrot"
    ) { properties -> Item(properties) }

    val ROSE_GOLD_SWORD = registerItem(
        "rose_gold_sword"
    ) { properties ->
        Item(properties.sword(material, 3.0f, -2.4f))
    }

    val ROSE_GOLD_AXE = registerItem(
        "rose_gold_axe"
    ) { properties ->
        AxeItem(material, 6.0f, -3.0f, properties)
    }

    val ROSE_GOLD_PICKAXE = registerItem(
        "rose_gold_pickaxe"
    ) { properties ->
        Item(properties.pickaxe(material, 1.5f, -2.8f))
    }

    val ROSE_GOLD_SHOVEL = registerItem(
        "rose_gold_shovel"
    ) { properties ->
        ShovelItem(material, -0.5f, -3.0f, properties)
    }

    val ROSE_GOLD_HOE /* YOU 🫵 */ = registerItem(
        "rose_gold_hoe"
    ) { properties ->
        HoeItem(material, -2.0f, -3.0f, properties)
    }

    var NETHERITE_UPGRADE_APPLIES_TO_TEXT: Text? = Text.translatable(
        Util.createTranslationKey(
            "item",
            Identifier.ofVanilla("smithing_template.netherite_upgrade.applies_to")
        )
    ).formatted(Formatting.BLUE)

    var NETHERITE_UPGRADE_INGREDIENTS_TEXT: Text? = Text.translatable(
        Util.createTranslationKey(
            "item",
            Identifier.ofVanilla("smithing_template.netherite_upgrade.ingredients")
        )
    ).formatted(Formatting.BLUE)

    var NETHERITE_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT: Text? = Text.translatable(
        Util.createTranslationKey(
            "item",
            Identifier.ofVanilla("smithing_template.netherite_upgrade.base_slot_description")
        )
    )

    var NETHERITE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT: Text? = Text.translatable(
        Util.createTranslationKey(
            "item",
            Identifier.ofVanilla("smithing_template.netherite_upgrade.additions_slot_description")
        )
    )

    val ROSE_GOLD_SMITHING_UPGRADE_TEMPLATE = registerItem(
        "rose_gold_smithing_upgrade_template"

    ) { properties ->
        SmithingTemplateItem(
            RoseGoldItems.NETHERITE_UPGRADE_APPLIES_TO_TEXT,
            RoseGoldItems.NETHERITE_UPGRADE_INGREDIENTS_TEXT,
            RoseGoldItems.NETHERITE_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT,
            RoseGoldItems.NETHERITE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT,
            SmithingTemplateItem.getNetheriteUpgradeEmptyBaseSlotTextures(),
            SmithingTemplateItem.getNetheriteUpgradeEmptyAdditionsSlotTextures(),
            properties
        )
    }

    fun init() {}

}