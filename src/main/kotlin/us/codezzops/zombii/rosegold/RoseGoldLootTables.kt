package us.codezzops.zombii.rosegold

import net.fabricmc.fabric.api.loot.v3.LootTableEvents
import net.minecraft.loot.LootPool
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.provider.number.ConstantLootNumberProvider
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryWrapper
import net.minecraft.loot.LootTable
import net.minecraft.loot.condition.RandomChanceLootCondition
import net.minecraft.util.Identifier

object RoseGoldLootTables {
    fun registerLoot() {
        val ironStructures = listOf(
            Identifier.of("minecraft", "chests/desert_pyramid"),
            Identifier.of("minecraft", "chests/shipwreck_treasure"),
            Identifier.of("minecraft", "chests/jungle_pyramid")
            // We need to fun stuff for nether or overworld ruined portals
            // Identifier.of("minecraft", "chests/ruined_portal")
        )

        val diamondStructures = listOf(
            Identifier.of("minecraft", "chests/ancient_city"),
            Identifier.of("minecraft", "chests/end_city")
        )

        val netheriteStructures = listOf(
            Identifier.of("minecraft", "chests/bastion_remnant")
        )

        LootTableEvents.MODIFY.register { id: RegistryKey<LootTable>, tableBuilder, source, registryLookup: RegistryWrapper.WrapperLookup ->
           if (!source.isBuiltin) return@register

           if (ironStructures.contains(id.value)) {
               val pool = LootPool.builder()
                   .conditionally(RandomChanceLootCondition.builder(0.10f))
                   .rolls(ConstantLootNumberProvider.create(1f))
                   .with(ItemEntry.builder(RoseGoldItems.ROSE_GOLD_SMITHING_UPGRADE_TEMPLATE))
                   .build()
               tableBuilder.pool(pool)
           }

            if (diamondStructures.contains(id.value)) {
                val pool = LootPool.builder()
                    .conditionally(RandomChanceLootCondition.builder(0.05f))
                    .rolls(ConstantLootNumberProvider.create(1f))
                    // Replace when we have Diamond smithing upgrade
                    .with(ItemEntry.builder(RoseGoldItems.ROSE_GOLD_SMITHING_UPGRADE_TEMPLATE))
                    .build()
                tableBuilder.pool(pool)
            }

            if (netheriteStructures.contains(id.value)) {
                val pool = LootPool.builder()
                    .conditionally(RandomChanceLootCondition.builder(0.02f))
                    .rolls(ConstantLootNumberProvider.create(1f))
                    // Replace when we have Netherite smithing upgrade
                    .with(ItemEntry.builder(RoseGoldItems.ROSE_GOLD_SMITHING_UPGRADE_TEMPLATE))
                    .build()
                tableBuilder.pool(pool)
            }
        }
    }
}
