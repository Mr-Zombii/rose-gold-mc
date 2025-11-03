package us.codezzops.zombii.rosegold

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
import java.util.*

object RoseGoldArmorItems {

    private fun defenseMap(
        boots: Int,
        leggings: Int,
        chestplate: Int,
        helmet: Int,
        body: Int
    ): EnumMap<EquipmentType, Int> =
        EnumMap(
            mapOf(
                EquipmentType.BOOTS to boots,
                EquipmentType.LEGGINGS to leggings,
                EquipmentType.CHESTPLATE to chestplate,
                EquipmentType.HELMET to helmet,
                EquipmentType.BODY to body
            )
        )

    private val EQUIPMENT_REGISTRY: RegistryKey<out Registry<EquipmentAsset>> =
        RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"))

    private fun armorMaterial(
        name: String,
        durability: Int,
        defenses: EnumMap<EquipmentType, Int>,
        toughness: Float,
        knockback: Float
    ): ArmorMaterial = ArmorMaterial(
        durability,
        defenses,
        22,
        SoundEvents.ITEM_ARMOR_EQUIP_IRON,
        toughness,
        knockback,
        TagKey.of(
            RegistryKeys.ITEM,
            Identifier.of(RoseGold.MOD_ID, "repairs_${name}_armor")
        ),
        RegistryKey.of(
            EQUIPMENT_REGISTRY,
            Identifier.of(RoseGold.MOD_ID, "rose_gold")
        )
    )

    val IRON = armorMaterial(
        "rose_gold_iron",
        durability = 30,
        defenses = defenseMap(2, 5, 7, 3, 6),
        toughness = 0.5f,
        knockback = 0.0f
    )

    val DIAMOND = armorMaterial(
        "rose_gold_diamond",
        durability = 35,
        defenses = defenseMap(3, 6, 8, 4, 7),
        toughness = 1.0f,
        knockback = 0.1f
    )

    val NETHERITE = armorMaterial(
        "rose_gold_netherite",
        durability = 40,
        defenses = defenseMap(3, 6, 8, 4, 7),
        toughness = 3.0f,
        knockback = 0.2f
    )

    private val registeredArmorItems = mutableListOf<Item>()

    private fun registerArmorSet(materialName: String, material: ArmorMaterial) {
        val items = listOf(
            registerItem("${materialName}_helmet") { settings -> Item(settings.armor(material, EquipmentType.HELMET)) },
            registerItem("${materialName}_chestplate") { settings ->
                Item(
                    settings.armor(
                        material,
                        EquipmentType.CHESTPLATE
                    )
                )
            },
            registerItem("${materialName}_leggings") { settings ->
                Item(
                    settings.armor(
                        material,
                        EquipmentType.LEGGINGS
                    )
                )
            },
            registerItem("${materialName}_boots") { settings -> Item(settings.armor(material, EquipmentType.BOOTS)) }
        )

        registeredArmorItems.addAll(items.filterNotNull())
    }

    fun init() {
        registerArmorSet("rose_gold_iron", IRON)
        registerArmorSet("rose_gold_diamond", DIAMOND)
        registerArmorSet("rose_gold_netherite", NETHERITE)
    }

    fun addItemsToGroup(entries: ItemGroup.Entries) {
        registeredArmorItems.forEach { item ->
            entries.add(ItemStack(item))
        }
    }
}