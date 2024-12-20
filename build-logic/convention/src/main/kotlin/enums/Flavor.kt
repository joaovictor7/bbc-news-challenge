package enums

internal enum class Flavor {
    DEVELOP, STAGING, PRODUCTION, BBC_NEWS, BBC_SPORT, ALL_NEWS;

    val isDefault get() = this == STAGING

    override fun toString() = name.lowercase()
}