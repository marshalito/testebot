package com.marshalito.taazerBOT.analytics

import com.marshalito.taazerBOT.amino.AminoRepostTask
import com.marshalito.taazerBOT.threads.NewLivestreamThread
import com.marshalito.taazerBOT.threads.NewRssFeedThread
import com.marshalito.taazerBOT.utils.logger
import com.marshalito.taazerBOT.utils.loritta
import com.marshalito.taazerBOT.utils.lorittaShards
import com.marshalito.taazerBOT.youtube.CreateYouTubeWebhooksTask
import java.util.concurrent.ThreadPoolExecutor

/**
 * Sends internal analytics to the console
 */
class InternalAnalyticSender : Runnable {
	companion object {
		private val logger by logger()
	}

	override fun run() {
		val mb = 1024 * 1024
		val runtime = Runtime.getRuntime()

		logger.debug("Loritta's status...")
		logger.debug("Shards: ${lorittaShards.shards.size}")
		logger.debug("Total Servers: ${lorittaShards.getGuildCount()}")
		logger.debug("Used Memory:"
				+ (runtime.totalMemory() - runtime.freeMemory()) / mb);
		logger.debug("Free Memory:"
				+ runtime.freeMemory() / mb)
		logger.debug("Total Memory:" + runtime.totalMemory() / mb)
		logger.debug("Max Memory:" + runtime.maxMemory() / mb)
		logger.debug("commandManager.commandMap.size: ${loritta.commandManager.commandMap.size}")
		logger.debug("commandManager.defaultCmdOptions.size: ${loritta.commandManager.defaultCmdOptions.size}")
		logger.debug("dummyServerConfig.guildUserData.size: ${loritta.dummyServerConfig.guildUserData.size}")
		logger.debug("messageInteractionCache.size: ${loritta.messageInteractionCache.size}")
		logger.debug("locales.size: ${loritta.locales.size}")
		logger.debug("ignoreIds.size: ${loritta.ignoreIds.size}")
		logger.debug("userCooldown.size: ${loritta.userCooldown.size}")
		logger.debug("southAmericaMemesPageCache.size: ${loritta.southAmericaMemesPageCache.size}")
		logger.debug("musicManagers.size: ${loritta.audioManager.musicManagers.size}")
		logger.debug("Total Track Queue: ${loritta.audioManager.musicManagers.values.sumBy { it.scheduler.queue.size }}")
		logger.debug("songThrottle.size: ${loritta.audioManager.songThrottle.size}")
		logger.debug("youTubeKeys.size: ${loritta.youtubeKeys.size}")
		logger.debug("fanArts.size: ${loritta.fanArts.size}")
		logger.debug("storedLastIds.size: ${AminoRepostTask.storedLastIds.size}")
		logger.debug("gameInfoCache.size: ${NewLivestreamThread.gameInfoCache.size}")
		logger.debug("isLivestreaming.size: ${NewLivestreamThread.isLivestreaming.size}")
		logger.debug("displayNameCache.size: ${NewLivestreamThread.displayNameCache.size}")
		logger.debug("lastItemTime.size: ${NewRssFeedThread.lastItemTime.size}")
		logger.debug("YouTube's Last Notified: ${CreateYouTubeWebhooksTask.lastNotified.size}")
		logger.debug("executor: ${(loritta.executor as ThreadPoolExecutor).activeCount}")
		logger.debug("Total Thread Count: ${Thread.getAllStackTraces().keys.size}")
	}
}
