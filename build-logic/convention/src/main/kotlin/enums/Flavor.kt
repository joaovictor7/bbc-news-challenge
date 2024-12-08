package enums

internal enum class Flavor {
    DEVELOP, STAGING, PRODUCTION, BBC_NEWS, BBC_SPORT;

    val isDefault get() = this == BBC_NEWS

    override fun toString() = name.lowercase()
}