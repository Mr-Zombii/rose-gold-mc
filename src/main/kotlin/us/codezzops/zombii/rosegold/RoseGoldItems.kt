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

    val RAW_ROSE_GOLD_IRON = registerItem(
        "raw_rose_gold_iron"
    ) { properties -> Item(properties) }

    val ROSE_GOLD_APPLE_COMPONENT: FoodComponent = FoodComponent.Builder()
        .nutrition(6)//TODO this ok?
        .saturationModifier(0.5f) //TODO 80% saturation
        .alwaysEdible() //TODO Do we want this?
        .build()

    val ROSE_GOLD_APPLE_CONSUMABLE_COMPONENT: ConsumableComponent = ConsumableComponents.food()
        .consumeEffect(
            ApplyEffectsConsumeEffect(
                StatusEffectInstance(StatusEffects.REGENERATION, 200, 3), //TODO 20 tps * 10 sec, level 3
                1.0f
            )
        )
        .consumeEffect(
            ApplyEffectsConsumeEffect(
                StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 2), //TODO 20 tps * 120 sec, level 3
                1.0f
            )
        )//TODO change these ^^^
        .build()

    val ROSE_GOLD_APPLE = registerItem(
        "rose_gold_apple"
    ) { properties ->
        Item(properties.food(
            ROSE_GOLD_APPLE_COMPONENT,
            ROSE_GOLD_APPLE_CONSUMABLE_COMPONENT))
    }

    val ROSE_GOLD_CARROT_COMPONENT: FoodComponent = FoodComponent.Builder()
        .nutrition(8)//TODO this ok?
        .saturationModifier(0.8f) //TODO 80% saturation
        .alwaysEdible() //TODO Do we want this?
        .build()

    val ROSE_GOLD_CARROT_CONSUMABLE_COMPONENT: ConsumableComponent = ConsumableComponents.food()
        .consumeEffect(
            ApplyEffectsConsumeEffect(
                StatusEffectInstance(StatusEffects.NIGHT_VISION, 200, 0), //TODO 20 tps * 10 sec, level 0
                1.0f
            )
        )
        .build()

    val ROSE_GOLD_CARROT = registerItem(
        "rose_gold_carrot"
    ) { properties ->
        Item(properties.food(
            ROSE_GOLD_CARROT_COMPONENT,
            ROSE_GOLD_CARROT_CONSUMABLE_COMPONENT))
    }

    // PURE ROSE GOLD

    val ROSE_GOLD_INGOT = registerItem(
        "rose_gold_ingot"
    ) { properties -> Item(properties) }

    val ROSE_GOLD_NUGGET = registerItem(
        "rose_gold_nugget"
    ) { properties -> Item(properties) }

    //IRON INFUSED

    val ROSE_GOLD_IRON_INGOT = registerItem(
        "rose_gold_iron_ingot"
    ) { properties -> Item(properties) }

    val ROSE_GOLD_IRON_NUGGET = registerItem(
        "rose_gold_iron_nugget"
    ) { properties -> Item(properties) }

    val ROSE_GOLD_IRON_SWORD = registerItem(
        "rose_gold_iron_sword"
    ) { properties ->
        Item(properties.sword(material, 3.0f, -2.4f))
    }

    val ROSE_GOLD_IRON_AXE = registerItem(
        "rose_gold_iron_axe"
    ) { properties ->
        AxeItem(material, 6.0f, -3.0f, properties)
    }

    val ROSE_GOLD_IRON_PICKAXE = registerItem(
        "rose_gold_iron_pickaxe"
    ) { properties ->
        Item(properties.pickaxe(material, 1.5f, -2.8f))
    }

    val ROSE_GOLD_IRON_SHOVEL = registerItem(
        "rose_gold_iron_shovel"
    ) { properties ->
        ShovelItem(material, -0.5f, -3.0f, properties)
    }

    val ROSE_GOLD_IRON_HOE /* YOU 🫵 */ = registerItem(
        "rose_gold_iron_hoe"
    ) { properties ->
        HoeItem(material, -2.0f, -3.0f, properties)
    }

    //DIAMOND INFUSED

    val ROSE_GOLD_DIAMOND = registerItem(
        "rose_gold_diamond"
    ) { properties -> Item(properties) }

    val ROSE_GOLD_DIAMOND_SWORD = registerItem(
        "rose_gold_diamond_sword"
    ) { properties ->
        Item(properties.sword(material, 3.0f, -2.4f))
    }

    val ROSE_GOLD_DIAMOND_AXE = registerItem(
        "rose_gold_diamond_axe"
    ) { properties ->
        AxeItem(material, 6.0f, -3.0f, properties)
    }

    val ROSE_GOLD_DIAMOND_PICKAXE = registerItem(
        "rose_gold_diamond_pickaxe"
    ) { properties ->
        Item(properties.pickaxe(material, 1.5f, -2.8f))
    }

    val ROSE_GOLD_DIAMOND_SHOVEL = registerItem(
        "rose_gold_diamond_shovel"
    ) { properties ->
        ShovelItem(material, -0.5f, -3.0f, properties)
    }

    val ROSE_GOLD_DIAMOND_HOE = registerItem(
        "rose_gold_diamond_hoe"
    ) { properties ->
        HoeItem(material, -2.0f, -3.0f, properties)
    }

    //NETHERITE INFUSED

    val ROSE_GOLD_NETHERITE_INGOT = registerItem(
        "rose_gold_netherite_ingot"
    ) { properties -> Item(properties) }

    val ROSE_GOLD_NETHERITE_SWORD = registerItem(
        "rose_gold_netherite_sword"
    ) { properties ->
        Item(properties.sword(material, 3.0f, -2.4f))
    }

    val ROSE_GOLD_NETHERITE_AXE = registerItem(
        "rose_gold_netherite_axe"
    ) { properties ->
        AxeItem(material, 6.0f, -3.0f, properties)
    }

    val ROSE_GOLD_NETHERITE_PICKAXE = registerItem(
        "rose_gold_netherite_pickaxe"
    ) { properties ->
        Item(properties.pickaxe(material, 1.5f, -2.8f))
    }

    val ROSE_GOLD_NETHERITE_SHOVEL = registerItem(
        "rose_gold_netherite_shovel"
    ) { properties ->
        ShovelItem(material, -0.5f, -3.0f, properties)
    }

    val ROSE_GOLD_NETHERITE_HOE = registerItem(
        "rose_gold_netherite_hoe"
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

    val ROSE_GOLD_DIAMOND_SMITHING_UPGRADE_TEMPLATE = registerItem(
        "rose_gold_diamond_smithing_upgrade_template"

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

    val ROSE_GOLD_NETHERITE_SMITHING_UPGRADE_TEMPLATE = registerItem(
        "rose_gold_netherite_smithing_upgrade_template"

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
            // Filter only for properties that are of type Item
            .filter { it.returnType.classifier == Item::class }
            .filterIsInstance<KProperty1<RoseGoldItems, Item>>()
            .map { it.get(this) }
            .forEach { item ->
                entries.add(ItemStack(item))
            }
    }

}