package us.codezzops.zombii.rosegold

import net.fabricmc.fabric.api.loot.v3.LootTableEvents
import net.minecraft.loot.LootPool
import net.minecraft.loot.LootTable
import net.minecraft.loot.condition.RandomChanceLootCondition
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.provider.number.ConstantLootNumberProvider
import net.minecraft.registry.RegistryKey
import net.minecraft.util.Identifier

object RoseGoldLootTables {
    fun registerLoot() {
        val diamondHighChance = listOf(
            Identifier.of("minecraft", "chests/ancient_city"),
            Identifier.of("minecraft", "chests/end_city"),
            Identifier.of("minecraft", "chests/stronghold")
        )

        val diamondLowChance = listOf(
            Identifier.of("minecraft", "chests/desert_pyramid"),
            Identifier.of("minecraft", "chests/jungle_pyramid"),
            Identifier.of("minecraft", "chests/ruined_portal"),
            Identifier.of("minecraft", "chests/shipwreck_treasure")
        )

        val netheriteStructures = listOf(
            Identifier.of("minecraft", "chests/bastion_remnant"),
            Identifier.of("minecraft", "chests/fortress")
        )

        LootTableEvents.MODIFY.register { id: RegistryKey<LootTable>, tableBuilder, source, _ ->
           if (!source.isBuiltin) return@register

            if (diamondHighChance.contains(id.value)) {
                val pool = LootPool.builder()
                    .conditionally(RandomChanceLootCondition.builder(0.10f))
                    .rolls(ConstantLootNumberProvider.create(1f))
                    .with(ItemEntry.builder(RoseGoldItems.DIAMOND_SMITHING_UPGRADE_TEMPLATE))
                    .build()
                tableBuilder.pool(pool)
            }

            if (diamondLowChance.contains(id.value)) {
                val pool = LootPool.builder()
                    .conditionally(RandomChanceLootCondition.builder(0.05f))
                    .rolls(ConstantLootNumberProvider.create(1f))
                    .with(ItemEntry.builder(RoseGoldItems.DIAMOND_SMITHING_UPGRADE_TEMPLATE))
                    .build()
                tableBuilder.pool(pool)
            }

            if (netheriteStructures.contains(id.value)) {
                val pool = LootPool.builder()
                    .conditionally(RandomChanceLootCondition.builder(0.02f))
                    .rolls(ConstantLootNumberProvider.create(1f))
                    .with(ItemEntry.builder(RoseGoldItems.NETHERITE_SMITHING_UPGRADE_TEMPLATE))
                    .build()
                tableBuilder.pool(pool)
            }
        }
    }
}
