package us.codezzops.zombii.rosegold

import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import net.minecraft.world.gen.GenerationStep

object RoseGoldWorldGen {
    private val ORES = listOf(
        "sapphire_ore_placed",
        "amethyst_ore_placed",
        "topaz_ore_placed",
        "ruby_ore_placed"
    )

    fun register() {
        val overworld = BiomeSelectors.foundInOverworld()
        val step = GenerationStep.Feature.UNDERGROUND_ORES

        ORES.forEach { oreName ->
            val oreKey = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of("rose_gold", oreName))
            BiomeModifications.addFeature(overworld, step, oreKey)
        }
    }
}