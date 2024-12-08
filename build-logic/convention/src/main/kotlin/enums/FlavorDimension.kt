package enums

internal enum class FlavorDimension(val flavors: List<Flavor>) {
    ENVIRONMENT(listOf(Flavor.DEVELOP, Flavor.STAGING, Flavor.PRODUCTION)),
    SOURCE(listOf(Flavor.BBC_NEWS, Flavor.BBC_SPORT));

    override fun toString() = name.lowercase()

    companion object {
        val allDimensions get() = values().map { it.toString() }
    }
}