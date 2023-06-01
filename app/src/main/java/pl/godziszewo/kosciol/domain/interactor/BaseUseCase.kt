package pl.godziszewo.kosciol.domain.interactor

interface BaseUseCase<in Parameter, out Result> {
    suspend operator fun invoke(params: Parameter): Result
}
