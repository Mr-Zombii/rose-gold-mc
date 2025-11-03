package us.codezzops.zombii.rosegold

import net.fabricmc.api.ModInitializer

object RoseGold : ModInitializer {
    const val MOD_ID = "rose_gold";

	override fun onInitialize() {
        RoseGoldItems.init()
        RoseGoldArmorItems.init()
        RoseGoldBlocks.init()
	}

}
