package us.codeoppz.zombii.rosegold

import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object RoseGold : ModInitializer {
    const val MOD_ID = "rose_gold";

    private val logger = LoggerFactory.getLogger("rose_gold")

	override fun onInitialize() {
		logger.info("Hello Fabric world!")

        RoseGoldItems.init()
        RoseGoldArmorItems.init()
        RoseGoldBlocks.init()
	}

}
