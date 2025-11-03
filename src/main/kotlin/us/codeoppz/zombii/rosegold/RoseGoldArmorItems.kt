package us.codeoppz.zombii.rosegold

import com.google.common.collect.Maps
import net.minecraft.item.Item
import net.minecraft.item.equipment.ArmorMaterial
import net.minecraft.item.equipment.EquipmentAsset
import net.minecraft.item.equipment.EquipmentType
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey
import net.minecraft.sound.SoundEvents
import net.minecraft.util.Identifier
import us.codeoppz.zombii.rosegold.RoseGoldItems.registerItem
import java.util.Map

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
    val ROSE_GOLD_ARMOR_MATERIAL: ArmorMaterial = ArmorMaterial(
        20, // durability
        createDefenseMap(
            2,
            5,
            6,
            2,
            5
        ),
        22, // enchantmentValue
        SoundEvents.ITEM_ARMOR_EQUIP_IRON,
        0.5f, // toughness
        0.0f, // knockbackResistance
        TagKey.of(
            RegistryKeys.ITEM,
            Identifier.of(RoseGold.MOD_ID, "repairs_rose_gold_armor")
        ),
        RegistryKey.of(
            REGISTRY_KEY,
            Identifier.of(RoseGold.MOD_ID, "rose_gold")
        )
    )

    val ROSE_GOLD_HELMET = registerItem(
        "rose_gold_helmet"
    ) { properties ->
        Item(properties.armor(ROSE_GOLD_ARMOR_MATERIAL, EquipmentType.HELMET))
    }

    val ROSE_GOLD_CHESTPLATE = registerItem(
        "rose_gold_chestplate"
    ) { properties ->
        Item(properties.armor(ROSE_GOLD_ARMOR_MATERIAL, EquipmentType.CHESTPLATE))
    }

    val ROSE_GOLD_LEGGINGS = registerItem(
        "rose_gold_leggings"
    ) { properties ->
        Item(properties.armor(ROSE_GOLD_ARMOR_MATERIAL, EquipmentType.LEGGINGS))
    }

    val ROSE_GOLD_BOOTS = registerItem(
        "rose_gold_boots"
    ) { properties ->
        Item(properties.armor(ROSE_GOLD_ARMOR_MATERIAL, EquipmentType.BOOTS))
    }

    fun init() {}

}