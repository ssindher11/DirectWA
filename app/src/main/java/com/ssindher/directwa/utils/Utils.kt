package com.ssindher.directwa.utils

object Utils {
    fun extractPhoneNumber(input: String): Pair<String?, String?> {
        val regex1 = Regex("""^\+(\d{1,3})\s(\d{5})\s(\d{5})$""")
        val matchResult1 = regex1.find(input)
        return if (matchResult1 != null) {
            val (countryCode, part1, part2) = matchResult1.destructured
            val cleanedPhoneNumber = "$part1$part2"
            Pair(countryCode, cleanedPhoneNumber)
        } else {
            val regex2 = Regex("""(?:\+(\d{1,3}))?[\s-]*\(?(\d{3})\)?[\s-]?(\d{3})[\s-]?(\d{4})""")
            val matchResult2 = regex2.find(input)
            if (matchResult2 != null) {
                val (countryCode, areaCode, firstPart, secondPart) = matchResult2.destructured
                val cleanedPhoneNumber = "$areaCode$firstPart$secondPart"
                Pair(countryCode.takeIf { it.isNotEmpty() }, cleanedPhoneNumber)
            } else {
                Pair(null, null)
            }
        }
    }
}