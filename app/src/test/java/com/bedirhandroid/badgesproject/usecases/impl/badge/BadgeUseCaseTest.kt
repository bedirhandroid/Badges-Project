package com.bedirhandroid.badgesproject.usecases.impl.badge

import app.cash.turbine.test
import com.bedirhandroid.badgesproject.base.BaseUseCaseTest
import com.bedirhandroid.badgesproject.base.Repository
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.time.ExperimentalTime


class BadgeUseCaseTest :BaseUseCaseTest<BadgeUseCase>() {
    @MockK
    private lateinit var repository : Repository

    override fun beforeSetup() {
        useCase = BadgeUseCase(repository = repository)
    }

    @ExperimentalTime
    @Test
    fun `getBadges return BadgeList`() = runBlocking {
        val response = BadgeFixtures.getBadgeResponse()

        coEvery { repository.getBadges() } coAnswers { flow { emit(response) } }

        useCase(Unit).test {
            val item = expectItem()
            val parsedIcon = response.value?.first()?.parseBadgeIcon()

            Truth.assertThat(item.value?.first()?.title).isEqualTo(response.value?.first()?.title)
            Truth.assertThat(item.value?.first()?.icon).isEqualTo(parsedIcon)
            expectComplete()
        }
    }

}