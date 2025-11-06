package us.codezzops.zombii.rosegold

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.recipe.RecipeExporter
import net.minecraft.data.recipe.RecipeGenerator
import net.minecraft.recipe.book.RecipeCategory
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistryWrapper
import java.util.concurrent.CompletableFuture

class RoseGoldDataGenerator : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(generator: FabricDataGenerator) {
        val pack = generator.createPack()
        pack.addProvider(::RoseGoldRecipeProvider)
    }

    class RoseGoldRecipeProvider(
        output: FabricDataOutput,
        registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>
    ) : FabricRecipeProvider(output, registriesFuture) {

        override fun getRecipeGenerator(
            registryLookup: RegistryWrapper.WrapperLookup,
            exporter: RecipeExporter
        ): RecipeGenerator {
            return object : RecipeGenerator(registryLookup, exporter) {
                override fun generate() {
                    val itemLookup = registries.getOrThrow(RegistryKeys.ITEM)

                    createShapeless(RecipeCategory.BUILDING_BLOCKS, RoseGoldBlocks.DIAMOND_BLOCK.asItem())
                        .input(RoseGoldItems.DIAMOND, 9)
                        .criterion(hasItem(RoseGoldItems.DIAMOND), conditionsFromItem(RoseGoldItems.DIAMOND))
                        .offerTo(exporter);
                }
            }
        }

        override fun getName(): String = "RoseGoldRecipeProvider"
    }

}
