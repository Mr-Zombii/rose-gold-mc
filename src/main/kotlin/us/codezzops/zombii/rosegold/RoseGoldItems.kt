package us.codezzops.zombii.rosegold

import net.minecraft.component.type.ConsumableComponent
import net.minecraft.component.type.ConsumableComponents
import net.minecraft.component.type.FoodComponent
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.Item
import net.minecraft.item.AxeItem
import net.minecraft.item.ToolMaterial
import net.minecraft.item.Items
import net.minecraft.item.ShovelItem
import net.minecraft.item.HoeItem
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.SmithingTemplateItem
import net.minecraft.item.consume.ApplyEffectsConsumeEffect
import net.minecraft.registry.Registries
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.tag.TagKey
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.util.Identifier
import net.minecraft.util.Util
import java.util.function.Function
import kotlin.reflect.KProperty1

object RoseGoldItems {

    val material = ToolMaterial( //Rose gold Materials
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

    val RAW_IRON = registerItem(
        "raw_iron"
    ) { properties -> Item(properties) }

    val APPLE_COMPONENT: FoodComponent = FoodComponent.Builder()
        .nutrition(6) // Todo: Edit nutrition for apple
        .saturationModifier(0.5f) // Todo: Edit saturation for apple
        .alwaysEdible() // Todo: Edit edibility for apple
        .build()

    val APPLE_CONSUMABLE_COMPONENT: ConsumableComponent = ConsumableComponents.food()
        .consumeEffect(
            ApplyEffectsConsumeEffect(
                StatusEffectInstance(StatusEffects.REGENERATION, 200, 3), // Todo: Edit status effect for apple
                1.0f
            )
        )
        .consumeEffect(
            ApplyEffectsConsumeEffect(
                StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 2), // Todo: Edit status effect for apple
                1.0f
            )
        )
        .build()

    val APPLE = registerItem(
        "apple"
    ) { properties ->
        Item(properties.food(
            APPLE_COMPONENT,
            APPLE_CONSUMABLE_COMPONENT))
    }

    val CARROT_COMPONENT: FoodComponent = FoodComponent.Builder()
        .nutrition(8) // Todo: Edit nutrition for carrot
        .saturationModifier(0.8f) // Todo: Edit saturation for carrot
        .alwaysEdible() // Todo: Edit edibility for carrot
        .build()

    val CARROT_CONSUMABLE_COMPONENT: ConsumableComponent = ConsumableComponents.food()
        .consumeEffect(
            ApplyEffectsConsumeEffect(
                StatusEffectInstance(StatusEffects.NIGHT_VISION, 200, 0), // Todo: Edit status effect for carrot
                1.0f
            )
        )
        .build()

    val CARROT = registerItem(
        "carrot"
    ) { properties ->
        Item(properties.food(
            CARROT_COMPONENT,
            CARROT_CONSUMABLE_COMPONENT))
    }

    val INGOT = registerItem(
        "ingot"
    ) { properties -> Item(properties) }

    val NUGGET = registerItem(
        "nugget"
    ) { properties -> Item(properties) }

    val IRON_INGOT = registerItem(
        "iron_ingot"
    ) { properties -> Item(properties) }

    val IRON_NUGGET = registerItem(
        "iron_nugget"
    ) { properties -> Item(properties) }

    val IRON_SWORD = registerItem(
        "iron_sword"
    ) { properties ->
        Item(properties.sword(material, 3.0f, -2.4f))
    }

    val IRON_AXE = registerItem(
        "iron_axe"
    ) { properties ->
        AxeItem(material, 6.0f, -3.0f, properties)
    }

    val IRON_PICKAXE = registerItem(
        "iron_pickaxe"
    ) { properties ->
        Item(properties.pickaxe(material, 1.5f, -2.8f))
    }

    val IRON_SHOVEL = registerItem(
        "iron_shovel"
    ) { properties ->
        ShovelItem(material, -0.5f, -3.0f, properties)
    }

    val IRON_HOE = registerItem(
        "iron_hoe"
    ) { properties ->
        HoeItem(material, -2.0f, -3.0f, properties)
    }

    val DIAMOND = registerItem(
        "diamond"
    ) { properties -> Item(properties) }

    val DIAMOND_SWORD = registerItem(
        "diamond_sword"
    ) { properties ->
        Item(properties.sword(material, 3.0f, -2.4f))
    }

    val DIAMOND_AXE = registerItem(
        "diamond_axe"
    ) { properties ->
        AxeItem(material, 6.0f, -3.0f, properties)
    }

    val DIAMOND_PICKAXE = registerItem(
        "diamond_pickaxe"
    ) { properties ->
        Item(properties.pickaxe(material, 1.5f, -2.8f))
    }

    val DIAMOND_SHOVEL = registerItem(
        "diamond_shovel"
    ) { properties ->
        ShovelItem(material, -0.5f, -3.0f, properties)
    }

    val DIAMOND_HOE = registerItem(
        "diamond_hoe"
    ) { properties ->
        HoeItem(material, -2.0f, -3.0f, properties)
    }

    val NETHERITE_INGOT = registerItem(
        "netherite_ingot"
    ) { properties -> Item(properties) }

    val NETHERITE_SWORD = registerItem(
        "netherite_sword"
    ) { properties ->
        Item(properties.sword(material, 3.0f, -2.4f))
    }

    val NETHERITE_AXE = registerItem(
        "netherite_axe"
    ) { properties ->
        AxeItem(material, 6.0f, -3.0f, properties)
    }

    val NETHERITE_PICKAXE = registerItem(
        "netherite_pickaxe"
    ) { properties ->
        Item(properties.pickaxe(material, 1.5f, -2.8f))
    }

    val NETHERITE_SHOVEL = registerItem(
        "netherite_shovel"
    ) { properties ->
        ShovelItem(material, -0.5f, -3.0f, properties)
    }

    val NETHERITE_HOE = registerItem(
        "netherite_hoe"
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

    val DIAMOND_SMITHING_UPGRADE_TEMPLATE = registerItem(
        "diamond_smithing_upgrade_template"

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

    val NETHERITE_SMITHING_UPGRADE_TEMPLATE = registerItem(
        "netherite_smithing_upgrade_template"

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

    fun addItemsToGroup(entries: ItemGroup.Entries) {
        this::class.members
            .filter { it.returnType.classifier == Item::class }
            .filterIsInstance<KProperty1<RoseGoldItems, Item>>()
            .map { it.get(this) }
            .forEach { item ->
                entries.add(ItemStack(item))
            }
    }

}