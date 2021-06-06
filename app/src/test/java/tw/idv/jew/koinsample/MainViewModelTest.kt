package tw.idv.jew.koinsample

import io.mockk.every
import io.mockk.mockkClass
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.get
import org.koin.test.mock.MockProviderRule
import org.koin.test.mock.declare
import org.koin.test.mock.declareMock

class MainViewModelTest : KoinTest {
    @get:Rule
    val koinTestRule = KoinTestRule.create {
        modules(myModule)
    }

    @get:Rule
    val mockProvider = MockProviderRule.create { clazz ->
        mockkClass(clazz)
    }

    @Test
    fun testSomething() {
        val viewModel = MainViewModel()
        val result = viewModel.doSomething()
        println(result)
    }

    @Test
    fun testSomethingOverride() {
        declare<HoneyLemonade> { TestHoneyLemonade(get(), get()) }
        val viewModel = MainViewModel()
        val result = viewModel.doSomething()
        println(result)
    }

    @Test
    fun testSomethingMock() {
        val mockHoneyLemonade = declareMock<HoneyLemonade>()
        every { mockHoneyLemonade.toString() }.returns("I'm MockHoneyLemonade")
        val viewModel = MainViewModel()
        val result = viewModel.doSomething()
        println(result)
    }
}

class TestHoneyLemonade(honey: Honey, lemon: Lemon) : HoneyLemonade(honey, lemon) {
    override fun toString(): String {
        return "I'm TestHoneyLemonade"
    }
}