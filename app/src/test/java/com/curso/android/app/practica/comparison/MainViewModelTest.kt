package com.curso.android.app.practica.comparison

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.practica.comparison.viewmodel.MainViewModel
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val viewModel = MainViewModel()

    @Test
    fun compareTexts_sameTexts_resultIsEqual() {
        viewModel.compareTexts("test", "test")
        assertEquals("Los textos son iguales", viewModel.result.value)
    }

    @Test
    fun compareTexts_differentTexts_resultIsDifferent() {
        viewModel.compareTexts("test1", "test2")
        assertEquals("Los textos son diferentes", viewModel.result.value)
    }
}