package com.bedirhandroid.badgesproject.usecases.impl.praise

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

class PraiseUseCaseTest : BaseUseCaseTest<PraiseUseCase>() {

    @MockK
    private lateinit var repository: Repository

    override fun beforeSetup() {
        useCase = PraiseUseCase(repository)
    }

    @ExperimentalTime
    @Test
    fun `getPraises return PraiseList`() = runBlocking {

        val response = PraiseFixtures.getPraiseResponse()

        coEvery { repository.getPraises() } coAnswers { flow { emit(response) } }

        useCase(Unit).test {
            val item = expectItem()

            Truth.assertThat(item.row?.first()?.id).isEqualTo(response.row.first().id)
            expectComplete()
        }
    }
}