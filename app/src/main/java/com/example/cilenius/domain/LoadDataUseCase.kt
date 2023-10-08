package com.example.cilenius.domain

class LoadDataUseCase(
    private val repository: CoinRepository
) {
    operator fun invoke() = repository.loadData()
}