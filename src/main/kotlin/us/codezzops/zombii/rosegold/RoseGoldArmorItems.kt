package us.codezzops.zombii.rosegold

import com.google.common.collect.Maps
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.equipment.ArmorMaterial
import net.minecraft.item.equipment.EquipmentAsset
import net.minecraft.item.equipment.EquipmentType
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey
import net.minecraft.sound.SoundEvents
import net.minecraft.util.Identifier
import us.codezzops.zombii.rosegold.RoseGoldItems.registerItem
import java.util.Map
import kotlin.reflect.KProperty1

object RoseGoldArmorItems {

    private fun createDefenseMap(
        bootsDefense: Int,
        leggingsDefense: Int,
        chestplateDefense: Int,
        helmetDefense: Int,
        bodyDefense: Int
    ): MutableMap<EquipmentType?, Int?> {
        return Maps.newEnumMap<EquipmentType?, Int?>(
            Map.of<EquipmentType?, Int?>(
                EquipmentType.BOOTS,
                bootsDefense,
                EquipmentType.LEGGINGS,
                leggingsDefense,
                EquipmentType.CHESTPLATE,
                chestplateDefense,
                EquipmentType.HELMET,
                helmetDefense,
                EquipmentType.BODY,
                bodyDefense
            )
        )
    }

    val REGISTRY_KEY: RegistryKey<out Registry<EquipmentAsset?>?> = RegistryKey.ofRegistry<EquipmentAsset?>(Identifier.ofVanilla("equipment_asset"))
    val ROSE_GOLD_IRON_ARMOR_MATERIAL: ArmorMaterial = ArmorMaterial(
        30, // durability
        createDefenseMap(
            2,
            5,
            7,
            3,
            6
        ),
        22, // enchantmentValue
        SoundEvents.ITEM_ARMOR_EQUIP_IRON,
        0.5f, // toughness
        0.0f, // knockbackResistance
        TagKey.of(
            RegistryKeys.ITEM,
            Identifier.of(RoseGold.MOD_ID, "repairs_rose_gold_iron_armor")
        ),
        RegistryKey.of(
            REGISTRY_KEY,
            Identifier.of(RoseGold.MOD_ID, "rose_gold")
        )
    )

    val ROSE_GOLD_DIAMOND_ARMOR_MATERIAL: ArmorMaterial = ArmorMaterial(
        40, // durability
        createDefenseMap(
            3,
            6,
            8,
            4,
            7
        ),
        22, // enchantmentValue
        SoundEvents.ITEM_ARMOR_EQUIP_IRON,
        1.0f, // toughness
        0.1f, // knockbackResistance
        TagKey.of(
            RegistryKeys.ITEM,
            Identifier.of(RoseGold.MOD_ID, "repairs_rose_gold_diamond_armor")
        ),
        RegistryKey.of(
            REGISTRY_KEY,
            Identifier.of(RoseGold.MOD_ID, "rose_gold")
        )
    )

    val ROSE_GOLD_NETHERITE_ARMOR_MATERIAL: ArmorMaterial = ArmorMaterial(
        50, // durability
        createDefenseMap(
            3,
            6,
            8,
            4,
            7
        ),
        22, // enchantmentValue
        SoundEvents.ITEM_ARMOR_EQUIP_IRON,
        3.0f, // toughness
        0.2f, // knockbackResistance
        TagKey.of(
            RegistryKeys.ITEM,
            Identifier.of(RoseGold.MOD_ID, "repairs_rose_gold_diamond_armor")
        ),
        RegistryKey.of(
            REGISTRY_KEY,
            Identifier.of(RoseGold.MOD_ID, "rose_gold")
        )
    )

    val ROSE_GOLD_HORSE_ARMOR = registerItem(
        "rose_gold_horse_armor"
    ) { properties ->
        Item(properties.horseArmor(ROSE_GOLD_IRON_ARMOR_MATERIAL))
    }

    //IRON

    val ROSE_GOLD_IRON_HELMET = registerItem(
        "rose_gold_iron_helmet"
    ) { properties ->
        Item(properties.armor(ROSE_GOLD_IRON_ARMOR_MATERIAL, EquipmentType.HELMET))
    }

    val ROSE_GOLD_IRON_CHESTPLATE = registerItem(
        "rose_gold_iron_chestplate"
    ) { properties ->
        Item(properties.armor(ROSE_GOLD_IRON_ARMOR_MATERIAL, EquipmentType.CHESTPLATE))
    }

    val ROSE_GOLD_IRON_LEGGINGS = registerItem(
        "rose_gold_iron_leggings"
    ) { properties ->
        Item(properties.armor(ROSE_GOLD_IRON_ARMOR_MATERIAL, EquipmentType.LEGGINGS))
    }

    val ROSE_GOLD_IRON_BOOTS = registerItem(
        "rose_gold_iron_boots"
    ) { properties ->
        Item(properties.armor(ROSE_GOLD_IRON_ARMOR_MATERIAL, EquipmentType.BOOTS))
    }

    //DIAMOND

    val ROSE_GOLD_DIAMOND_HELMET = registerItem(
        "rose_gold_diamond_helmet"
    ) { properties ->
        Item(properties.armor(ROSE_GOLD_DIAMOND_ARMOR_MATERIAL, EquipmentType.HELMET))
    }

    val ROSE_GOLD_DIAMOND_CHESTPLATE = registerItem(
        "rose_gold_diamond_chestplate"
    ) { properties ->
        Item(properties.armor(ROSE_GOLD_DIAMOND_ARMOR_MATERIAL, EquipmentType.CHESTPLATE))
    }

    val ROSE_GOLD_DIAMOND_LEGGINGS = registerItem(
        "rose_gold_diamond_leggings"
    ) { properties ->
        Item(properties.armor(ROSE_GOLD_DIAMOND_ARMOR_MATERIAL, EquipmentType.LEGGINGS))
    }

    val ROSE_GOLD_DIAMOND_BOOTS = registerItem(
        "rose_gold_diamond_boots"
    ) { properties ->
        Item(properties.armor(ROSE_GOLD_DIAMOND_ARMOR_MATERIAL, EquipmentType.BOOTS))
    }

    //NETHERITE

    val ROSE_GOLD_NETHERITE_HELMET = registerItem(
        "rose_gold_netherite_helmet"
    ) { properties ->
        Item(properties.armor(ROSE_GOLD_NETHERITE_ARMOR_MATERIAL, EquipmentType.HELMET))
    }

    val ROSE_GOLD_NETHERITE_CHESTPLATE = registerItem(
        "rose_gold_netherite_chestplate"
    ) { properties ->
        Item(properties.armor(ROSE_GOLD_NETHERITE_ARMOR_MATERIAL, EquipmentType.CHESTPLATE))
    }

    val ROSE_GOLD_NETHERITE_LEGGINGS = registerItem(
        "rose_gold_netherite_leggings"
    ) { properties ->
        Item(properties.armor(ROSE_GOLD_NETHERITE_ARMOR_MATERIAL, EquipmentType.LEGGINGS))
    }

    val ROSE_GOLD_NETHERITE_BOOTS = registerItem(
        "rose_gold_netherite_boots"
    ) { properties ->
        Item(properties.armor(ROSE_GOLD_NETHERITE_ARMOR_MATERIAL, EquipmentType.BOOTS))
    }

    fun init() {}

    fun addItemsToGroup(entries: ItemGroup.Entries) {
        this::class.members
            // Filter only for properties that are of type Item
            .filter { it.returnType.classifier == Item::class }
            .filterIsInstance<KProperty1<RoseGoldArmorItems, Item>>()
            .map { it.get(this) }
            .forEach { item ->
                entries.add(ItemStack(item))
            }
    }

}